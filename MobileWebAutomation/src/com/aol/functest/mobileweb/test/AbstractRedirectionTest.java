/**
 * 
 */
package com.aol.functest.mobileweb.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.testng.AssertJUnit;

import au.com.bytecode.opencsv.CSVReader;

import com.mapquest.util.Logger;

/**
 * Base class for tests that use an http connection to test a site with user
 * agents (and assertion hints) defined in a CSV fixture.
 * 
 * Subclasses reference a CSV data fixture present on the classpath {@link
 * this#DEFAULT_DEVICE_DEFINITION_FIXTURE_DATA_FILENAME}. To run {@link this}
 * the fixture must be on the classpath. See
 * http://zarina.office.aol.com:8080/display
 * /mqwiki/Mobile+Web+Redirection+Testing+with+SeleniumRC-TestNG for more
 * instructions on running from Eclipse.
 * 
 * @author freebeachler
 * 
 */
public abstract class AbstractRedirectionTest {

	public static final String HEADER_USER_AGENT = "user-agent";
	protected static final int DEFAULT_HTTP_CLIENT_CONNECTION_TIMEOUT = 5000;
	private static Logger LOGGER = Logger.getLogger(AbstractRedirectionTest.class);

	/**
	 * @return the deviceDefinitionFixtureDataFilePath
	 */
	public abstract String getFixtureDataFilePath();

	/**
	 * @return the deviceDefinitionFixtureData
	 */
	public abstract ArrayList<DeviceDefinition> getFixtureData();

	/**
	 * @param dataFilePath
	 *            path to the CSV fixture
	 * @return data rows from CSV fixture
	 * @throws IOException
	 *             couldn't read file specified by dataFilePath
	 */
	public ArrayList<DeviceDefinition> loadUserAgentFixture(String dataFilePath)
			throws IOException {
		LOGGER.debug(new StringBuilder("dataFilePath = ").append(dataFilePath));
		ArrayList<DeviceDefinition> ret = new ArrayList<DeviceDefinition>();
		// get reader with comma delim, quote spec, and header row
		CSVReader reader = new CSVReader(new FileReader(dataFilePath), ',',
				'\"', 1);
		String[] nextLine = reader.readNext();
		if (null == nextLine) {
			return null;
		}
		do {
			// nextLine[] is array of values from line just read
			DeviceDefinition csvRow = new DeviceDefinition();
			csvRow.deviceAnywhereId = nextLine[0];
			csvRow.wurflId = nextLine[1];
			csvRow.ua = nextLine[2];
			ret.add(csvRow);
		} while (null != (nextLine = reader.readNext()));
		return ret;
	}

	public void executeTestFor30XRedirection(String url, String redirectUrl) {
		ArrayList<DeviceDefinition> fixtureData = getFixtureData();
		if (null == fixtureData) {
			AssertJUnit.fail("user agent fixture is null");
		}
		
		int rowCounter = 1; // start at 1 to account for header row
		StringBuilder assertionMsg = new StringBuilder();
		StringBuilder assertionFailureMsg = new StringBuilder();
		HttpClient client = new HttpClient();
		boolean testFailed = false;

		for (DeviceDefinition csvRow : fixtureData) {
			rowCounter++;
			// open http connection
			client.getHttpConnectionManager().getParams().setConnectionTimeout(
					DEFAULT_HTTP_CLIENT_CONNECTION_TIMEOUT);
			
			// clear any cookies that may have been set (e.g. mobweb's device id cookie)
			client.getState().clearCookies();
			
			// create a method object
			HttpMethod method = new GetMethod(url);
			method.setRequestHeader(HEADER_USER_AGENT, csvRow.ua);
			method.setFollowRedirects(false);
			
			// execute request
			try {
				client.executeMethod(method);
			} catch (HttpException e) {
				AssertJUnit.fail(new StringBuilder(
								"There was an HttpException when trying to open site at ")
								.append(url).toString());
			} catch (IOException e) {
				AssertJUnit.fail(new StringBuilder(
								"There was an IOException when trying to open site at ")
								.append(url).toString());
			}
			// check status code from http response
			int actualResponseCode = method.getStatusCode();
			Header h = method.getResponseHeader("Location");
			String actualRedirectUrl = "";
			if (h != null) {
				actualRedirectUrl = h.getValue();
			}
			
			// actualResponseCode = 302;
			LOGGER.debug(new StringBuilder("requested ").append(url)
					.append("; user agent ").append(csvRow.ua)
					.append("; response code = ").append(method.getStatusCode())
					.toString());
			
			if (301 != actualResponseCode && 302 != actualResponseCode) { 
				// incorrect response code
				testFailed = true;
				assertionFailureMsg.append('\n').append("response code failure on CSV line ")
						.append(rowCounter)
						.append(" :: device-anywhere-id/wurfl-id=").append(csvRow.deviceAnywhereId)
						.append("/").append(csvRow.wurflId)
						.append(" :: user agent = ").append(csvRow.ua)
						.append(" :: http response code=")
						.append(actualResponseCode + "\n").toString();
			} else { 
				// correct response code
				if (actualRedirectUrl == null || !actualRedirectUrl.equals(redirectUrl)) {
					
					// wrong redir host
					testFailed = true;
					assertionFailureMsg.append('\n').append("redir URL failure on CSV line ")
							.append(rowCounter)
							.append(" :: device-anywhere-id/wurfl-id=").append(csvRow.deviceAnywhereId)
							.append("/").append(csvRow.wurflId)
							.append(" :: user agent=").append(csvRow.ua)
							.append(" :: http response code = ")
							.append(actualResponseCode)
							.append(" :: RedirectionUrl = ")
							.append(actualRedirectUrl + "\n").toString();

				} else { 
					// correct redir host
					assertionMsg.append('\n')
						.append(" :: device-anywhere-id/wurfl-id=").append(csvRow.deviceAnywhereId)
						.append("/").append(csvRow.wurflId)
						.append(" :: user agent = ").append(csvRow.ua)
						.append(" :: http response code=")
						.append(actualResponseCode)
						.append(" :: RedirectionUrl = ")
						.append(redirectUrl + "\n").toString();
				}
			}
			method.releaseConnection();
		}
		
		if (StringUtils.isNotBlank(assertionMsg.toString())) {
			LOGGER.debug("successful redirects: "+assertionMsg.toString());
		}
		
		// only output the failed redirects
		AssertJUnit.assertFalse(assertionFailureMsg.toString(), testFailed);
	}

}
