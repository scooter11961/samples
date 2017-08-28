/**
 * 
 */
package com.aol.functest.mobileweb.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mapquest.util.Logger;

/**
 * @see {@link com.aol.functest.mobileweb.test.AbstractRedirectionTest}
 * 
 * @author freebeachler
 * 
 */
public class DotcomToMobileRedirectionTest extends AbstractRedirectionTest {

	private static Logger LOGGER = Logger.getLogger(DotcomToMobileRedirectionTest.class);
	protected static final String DEFAULT_DEVICE_DEFINITION_FIXTURE_DATA_FILENAME = "/fixtures/fixture_mobweb_uas.csv";

	/**
	 * Holds the path to the device definitions data fixture.
	 */
	private String fixtureDataFilePath;

	/**
	 * Holds an array of rows from the device definitions fixture data.
	 */
	private ArrayList<DeviceDefinition> fixtureData;
	private String sURL;
	private String sRedirectURL; // This is added for checking the redirectURL

	// value from response.

	/**
	 * @return the deviceDefinitionFixtureDataFilePath
	 */
	public String getFixtureDataFilePath() {
		if (null == fixtureDataFilePath) {
			fixtureDataFilePath = MobileWebRedirectionTest.class.getResource(
					DEFAULT_DEVICE_DEFINITION_FIXTURE_DATA_FILENAME).getPath();
		}
		return fixtureDataFilePath;
	}

	/**
	 * @param deviceDefinitionFixtureDataFilePath
	 *            the deviceDefinitionFixtureDataFilePath to set
	 */
	public void setFixtureDataFilePath(
			String deviceDefinitionFixtureDataFilePath) {
		this.fixtureDataFilePath = deviceDefinitionFixtureDataFilePath;
	}

	/**
	 * @return the deviceDefinitionFixtureData
	 */
	public ArrayList<DeviceDefinition> getFixtureData() {
		return fixtureData;
	}

	@BeforeClass(alwaysRun = true)
	public void setupTest() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config/mobileweb-adv.properties"));
		} catch (FileNotFoundException e) {
			LOGGER.debug(e);
		} catch (IOException e) {
			LOGGER.debug(e);
		}
		sURL = properties.getProperty("url.dotcom");
		sRedirectURL = properties.getProperty("url.dotcom.redirect"); // Reading the redirectUrl from config file.
	}

	@AfterClass(alwaysRun = true)
	public void tearDownTestSuite() {
	}

	@BeforeTest
	public void setup() {
	}

	@AfterTest
	public void tearDown() {
		fixtureData = null;
	}

	@Test(groups = { "groupDotcomtoMobileRedirection" })
	public void TC_testDotcomtoMobileRedirectiontListOfUserAgent() {
		try {
			fixtureData = loadUserAgentFixture(getFixtureDataFilePath());
		} catch (IOException e) {
			LOGGER.debug(new StringBuilder("the user agent fixture {").append(
					getFixtureDataFilePath()).append("} could not be loaded")
					.toString());
			e.printStackTrace();
		}

		executeTestFor30XRedirection(sURL, sRedirectURL);
	}
}
