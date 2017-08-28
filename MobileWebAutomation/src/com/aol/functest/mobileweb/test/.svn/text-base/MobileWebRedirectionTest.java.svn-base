/**
 * 
 */
package com.aol.functest.mobileweb.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.testng.AssertJUnit;
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
public class MobileWebRedirectionTest extends AbstractRedirectionTest
{

   private static Logger LOGGER = Logger.getLogger(MobileWebRedirectionTest.class);

   public static final String HEADER_USER_AGENT = "user-agent";
   protected static final String ANDROID_FIXTURE_DATA_FILENAME = "/fixtures/fixture_android_uas.csv";
   protected static final String DEFAULT_DEVICE_DEFINITION_FIXTURE_DATA_FILENAME = "/fixtures/fixture_mobweb_uas.csv";
   protected static final int DEFAULT_HTTP_CLIENT_CONNECTION_TIMEOUT = 5000;

   /**
    * Holds the path to the device definitions data fixture.
    */
   private String fixtureDataFilePath;

   /**
    * Holds an array of rows from the device definitions fixture data.
    */
   private ArrayList<DeviceDefinition> fixtureData;
   private String sURL;

   /* (non-Javadoc)
    * @see com.aol.functest.mobileweb.test.AbstractRedirectionTest#getFixtureDataFilePath()
    */
   public String getFixtureDataFilePath()
   {
      if (null == fixtureDataFilePath) {
         fixtureDataFilePath = MobileWebRedirectionTest.class
            .getResource(DEFAULT_DEVICE_DEFINITION_FIXTURE_DATA_FILENAME).getPath();
      }
      return fixtureDataFilePath;
   }

   /**
    * @param deviceDefinitionFixtureDataFilePath
    *           the deviceDefinitionFixtureDataFilePath to set
    */
   public void setFixtureDataFilePath(String deviceDefinitionFixtureDataFilePath)
   {
      this.fixtureDataFilePath = deviceDefinitionFixtureDataFilePath;
   }

   /* (non-Javadoc)
    * @see com.aol.functest.mobileweb.test.AbstractRedirectionTest#getFixtureData()
    */
   public ArrayList<DeviceDefinition> getFixtureData()
   {
      return fixtureData;
   }

   @BeforeClass(alwaysRun = true)
   public void setupTest()
   {
      Properties properties = new Properties();
      try {
         properties.load(new FileInputStream("config/mobileweb-adv.properties"));
      } catch (FileNotFoundException e) {
         LOGGER.debug(e);
      } catch (IOException e) {
         LOGGER.debug(e);
      }
      sURL = properties.getProperty("url");
   }

   @AfterClass(alwaysRun = true)
   public void tearDownTestSuite()
   {
   }

   @BeforeTest
   public void setup()
   {
   }

   @AfterTest
   public void tearDown()
   {
      fixtureData = null;
   }

   @Test(groups = { "groupDeviceRedirection" })
   public void TC_testRedirectionAgainstListOfUserAgents()
   {
      try {
         fixtureData = loadUserAgentFixture(getFixtureDataFilePath());
      } catch (IOException e) {
         LOGGER.debug(new StringBuilder("the user agent fixture {").append(getFixtureDataFilePath())
            .append("} could not be loaded").toString());
         e.printStackTrace();
      }
      if (null == fixtureData) {
         AssertJUnit.fail("user agent fixture is null");
      }
      int rowCounter = 1; // start at 1 to account for header row
      StringBuilder assertionMsg = new StringBuilder();
      HttpClient client = new HttpClient();
      boolean testFailed = false;
      for (DeviceDefinition csvRow : fixtureData) {
         rowCounter++;
         // open http connection
         client.getHttpConnectionManager().getParams().setConnectionTimeout(DEFAULT_HTTP_CLIENT_CONNECTION_TIMEOUT);
         
         // clear any cookies that may have been set (e.g. mobweb's device id cookie)
         client.getState().clearCookies();
         
         // create a method object
         HttpMethod method = new GetMethod(sURL);
         method.setRequestHeader(HEADER_USER_AGENT, csvRow.ua);
         method.setFollowRedirects(false);
         // execute request
         try {
            client.executeMethod(method);
         } catch (HttpException e) {
            AssertJUnit.fail(new StringBuilder("There was an HttpException when trying to open site at ").append(sURL)
               .toString());
         } catch (IOException e) {
            AssertJUnit.fail(new StringBuilder("There was an IOException when trying to open site at ").append(sURL)
               .toString());
         }
         // check status code from http response
         int actualResponseCode = method.getStatusCode();
         LOGGER.debug(new StringBuilder("requested ").append(sURL).append("; user agent ").append(csvRow.ua)
            .append("; response code = ").append(method.getStatusCode()).toString());
         if (200 != actualResponseCode) {
            testFailed = true;
            assertionMsg.append('\n').append("failure on CSV line ").append(rowCounter).append(" :: ")
               .append(csvRow.deviceAnywhereId).append("/").append(csvRow.wurflId).append(" :: ").append(csvRow.ua)
               .append(" :: http response code=").append(actualResponseCode).toString();
         }
         method.releaseConnection();
      }
      AssertJUnit.assertFalse(assertionMsg.toString(), testFailed);
   }

}
