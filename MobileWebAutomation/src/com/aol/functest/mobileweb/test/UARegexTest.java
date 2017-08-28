/**
 * 
 */
package com.aol.functest.mobileweb.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aol.functest.common.util.ArrayListUtil;
import com.mapquest.util.Logger;

/**
 * @see {@link com.aol.functest.mobileweb.test.AbstractRedirectionTest}
 * 
 * @author freebeachler
 * 
 */
public class UARegexTest extends AbstractRedirectionTest
{

   private static Logger LOGGER = Logger.getLogger(UARegexTest.class);

   public static final String HEADER_USER_AGENT = "user-agent";
   protected static final String DEFAULT_MOBWEB_UA_FIXTURE_DATA_FILENAME = "/fixtures/fixture_mobweb_uas.csv";
   protected static final String DEFAULT_INFOGIN_UA_FIXTURE_DATA_FILENAME = "/fixtures/fixture_infogin_wap_uas.csv";
   protected static final String DEFAULT_DESKTOP_UA_FIXTURE_DATA_FILENAME = "/fixtures/fixture_desktop_uas.csv";
   protected static final int DEFAULT_HTTP_CLIENT_CONNECTION_TIMEOUT = 5000;

   /**
    * A list of regex patterns that can be matched against UA strings. These
    * should match the policies on the netscaler which redirect to MobileWeb.
    */
   private static final ArrayList<Pattern> NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB = new ArrayList<Pattern>();

   /**
    * A list of regex patterns that can be matched against UA strings. These
    * should match the policies on Mobileweb (or wherever they live) which 
    * redirect to Infogin.
    */
   private static final ArrayList<Pattern> NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN = new ArrayList<Pattern>();

   /**
    * A list of regex patterns that can be matched against UA strings. These
    * should match the polices on the neetscaler which redirect to Dotcom.
    */
   private static final ArrayList<Pattern> NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP = new ArrayList<Pattern>();
   
   /**
    * Holds an array of rows from the device definitions fixture data.
    */
   private ArrayList<DeviceDefinition> fixtureData;

   /**
    * @return the deviceDefinitionFixtureDataFilePath
    */
   public String getMobWebUAFixtureDataFilePath()
   {
      return UARegexTest.class.getResource(DEFAULT_MOBWEB_UA_FIXTURE_DATA_FILENAME).getPath();
   }

   /**
    * @return the deviceDefinitionFixtureDataFilePath
    */
   public String getInfoginUAFixtureDataFilePath()
   {
      return UARegexTest.class.getResource(DEFAULT_INFOGIN_UA_FIXTURE_DATA_FILENAME).getPath();
   }

   /**
    * @return the deviceDefinitionFixtureDataFilePath
    */
   public String getDesktopUAFixtureDataFilePath()
   {
      return UARegexTest.class.getResource(DEFAULT_DESKTOP_UA_FIXTURE_DATA_FILENAME).getPath();
   }

   /* (non-Javadoc)
    * @see com.aol.functest.mobileweb.test.AbstractRedirectionTest#getFixtureData()
    */
   @Override
   public ArrayList<DeviceDefinition> getFixtureData()
   {
      return fixtureData;
   }

   /* (non-Javadoc)
    * @see com.aol.functest.mobileweb.test.AbstractRedirectionTest#getFixtureDataFilePath()
    */
   @Override
   public String getFixtureDataFilePath()
   {
      throw new IllegalStateException("this method is a noop");
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

   /**
    * 
    * @param input
    * @return empty arraylist if no pattern matches {@link input}, otherwise the
    *         matching patterns
    */
   private ArrayList<Pattern> getMatchingPatterns(String input, Iterator<Pattern> patterns)
   {
      ArrayList<Pattern> ret = new ArrayList<Pattern>();
      Pattern regex;
      if (null == patterns) {
         return null;
      }
      while (patterns.hasNext()) {
         regex = patterns.next();
         Matcher matcher = regex.matcher(input);
         if (matcher.find()) {
            ret.add(regex);
            break;
         }
      }
      return ret;
   }

   @Test(groups = { "groupDeviceRedirection" })
   public void TC_testDesktopRegexPatternsMatchDesktopUAs()
   {
      boolean testFailed = false;

      // check all mobweb fixture UAs matched by regex's
      try {
         fixtureData = loadUserAgentFixture(getDesktopUAFixtureDataFilePath());
      } catch (IOException e) {
         LOGGER.debug(new StringBuilder("the user agent fixtures could not be loaded").toString());
         e.printStackTrace();
      }
      if (null == fixtureData) {
         AssertJUnit.fail("user agent fixture is null");
      }
      int rowCounter = 1; // start at 1 to account for header row
      StringBuilder assertionMsg = new StringBuilder("TC_testDesktopRegexPatternsMatchDesktopUAs::::\n\n");
      for (DeviceDefinition csvRow : fixtureData) {
         rowCounter++;
         ArrayList<Pattern> matchingPatterns = getMatchingPatterns(csvRow.ua, NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP
            .iterator());
         if (0 == matchingPatterns.size()) {
            testFailed = true;
            assertionMsg.append("failure at line ").append(rowCounter).append("; no patterns match UA \"")
               .append(csvRow.ua).append("\"\n");
            continue;
         }
         if (1 != matchingPatterns.size()) {
            assertionMsg.append("WARNING!!! at line ").append(rowCounter).append(";\n\t> 1 pattern matches ua = \"")
               .append(csvRow.ua).append("\"\n");
            assertionMsg.append(";\n\tmatched pattern(s) = ").append(ArrayListUtil.toString(matchingPatterns, ","));
            assertionMsg.append("\"\n");
         }
      }

      AssertJUnit.assertFalse(assertionMsg.toString(), testFailed);
   }


   @Test(groups = { "groupDeviceRedirection" })
   public void TC_testDesktopRegexPatternsDoNotMatchMobWebUAs()
   {
      boolean testFailed = false;

      // check all mobweb fixture UAs matched by regex's
      try {
         fixtureData = loadUserAgentFixture(getMobWebUAFixtureDataFilePath());
      } catch (IOException e) {
         LOGGER.debug(new StringBuilder("the user agent fixtures could not be loaded").toString());
         e.printStackTrace();
      }
      if (null == fixtureData) {
         AssertJUnit.fail("user agent fixture is null");
      }
      int rowCounter = 1; // start at 1 to account for header row
      StringBuilder assertionMsg = new StringBuilder("TC_testDesktopRegexPatternsDoNotMatchMobWebUAs::::\n\n");
      for (DeviceDefinition csvRow : fixtureData) {
         rowCounter++;
         ArrayList<Pattern> matchingPatterns = getMatchingPatterns(csvRow.ua, NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP
            .iterator());
         if (0 != matchingPatterns.size()) {
            testFailed = true;
            assertionMsg.append("failure at line ").append(rowCounter).append("\"")
               .append(";\n\t>= 1 Desktop regex matches MobWeb ua = \"").append(csvRow.ua).append("\"");
            assertionMsg.append(";\n\tmatched pattern(s) = ").append(matchingPatterns.toString()).append("\n");
         }
      }

      AssertJUnit.assertFalse(assertionMsg.toString(), testFailed);
   }


//   @Test(groups = { "groupDeviceRedirection" })
   public void TC_testDesktopRegexPatternsDoNotMatchInfoginUAs()
   {
      boolean testFailed = false;

      // check all mobweb fixture UAs matched by regex's
      try {
         fixtureData = loadUserAgentFixture(getInfoginUAFixtureDataFilePath());
      } catch (IOException e) {
         LOGGER.debug(new StringBuilder("the user agent fixtures could not be loaded").toString());
         e.printStackTrace();
      }
      if (null == fixtureData) {
         AssertJUnit.fail("user agent fixture is null");
      }
      int rowCounter = 1; // start at 1 to account for header row
      StringBuilder assertionMsg = new StringBuilder("TC_testDesktopRegexPatternsMatchDesktopUAs::::\n\n");
      for (DeviceDefinition csvRow : fixtureData) {
         rowCounter++;
         ArrayList<Pattern> matchingPatterns = getMatchingPatterns(csvRow.ua, NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP
            .iterator());
         if (0 != matchingPatterns.size()) {
            testFailed = true;
            assertionMsg.append("failure at line ").append(rowCounter).append("\"")
               .append(";\n\t>= 1 Desktop regex matches InfoGin ua = \"").append(csvRow.ua).append("\"");
            assertionMsg.append(";\n\tmatched pattern(s) = ").append(matchingPatterns.toString()).append("\n");
         }
      }

      AssertJUnit.assertFalse(assertionMsg.toString(), testFailed);
   }

   @Test(groups = { "groupDeviceRedirection" })
   public void TC_testMobileRegexPatternsMatchMobileUAs()
   {
      boolean testFailed = false;

      // check all mobweb fixture UAs matched by regex's
      try {
         fixtureData = loadUserAgentFixture(getMobWebUAFixtureDataFilePath());
      } catch (IOException e) {
         LOGGER.debug(new StringBuilder("the user agent fixtures could not be loaded").toString());
         e.printStackTrace();
      }
      if (null == fixtureData) {
         AssertJUnit.fail("user agent fixture is null");
      }
      int rowCounter = 1; // start at 1 to account for header row
      StringBuilder assertionMsg = new StringBuilder("TC_testMobileRegexPatternsMatchMobileUAs::::\n\n");
      for (DeviceDefinition csvRow : fixtureData) {
         rowCounter++;
         ArrayList<Pattern> matchingPatterns = getMatchingPatterns(csvRow.ua, NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB
            .iterator());
         if (0 == matchingPatterns.size()) {
            testFailed = true;
            assertionMsg.append("failure at line ").append(rowCounter).append("; no patterns match UA \"")
               .append(csvRow.ua).append("\"\n");
            continue;
         }
         if (1 != matchingPatterns.size()) {
            assertionMsg.append("WARNING!!! at line ").append(rowCounter).append(";\n\t> 1 pattern matches ua = \"")
               .append(csvRow.ua).append("\"\n");
            assertionMsg.append(";\n\tmatched pattern(s) = ").append(ArrayListUtil.toString(matchingPatterns, ","));
            assertionMsg.append("\"\n");
         }
      }

      AssertJUnit.assertFalse(assertionMsg.toString(), testFailed);
   }

//   @Test(groups = { "groupDeviceRedirection" })
   public void TC_testInfoginRegexPatternsMatchInfoginUAs()
   {
      boolean testFailed = false;

      // check all mobweb fixture UAs matched by regex's
      try {
         fixtureData = loadUserAgentFixture(getInfoginUAFixtureDataFilePath());
      } catch (IOException e) {
         LOGGER.debug(new StringBuilder("the user agent fixtures could not be loaded").toString());
         e.printStackTrace();
      }
      if (null == fixtureData) {
         AssertJUnit.fail("user agent fixture is null");
      }
      int rowCounter = 1; // start at 1 to account for header row
      StringBuilder assertionMsg = new StringBuilder("TC_testInfoginRegexPatternsMatchInfoginUAs::::\n\n");
      for (DeviceDefinition csvRow : fixtureData) {
         rowCounter++;
         ArrayList<Pattern> matchingPatterns = getMatchingPatterns(csvRow.ua, NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN
            .iterator());
         if (0 == matchingPatterns.size()) {
            testFailed = true;
            assertionMsg.append("failure at line ").append(rowCounter).append("; no patterns match UA \"")
               .append(csvRow.ua).append("\"\n");
            continue;
         }
         if (1 != matchingPatterns.size()) {
            assertionMsg.append("WARNING!!! at line ").append(rowCounter).append(";\n\t> 1 pattern matches ua = \"")
               .append(csvRow.ua).append("\"\n");
            assertionMsg.append(";\n\tmatched pattern(s) = ").append(ArrayListUtil.toString(matchingPatterns, ","));
            assertionMsg.append("\"\n");
         }
      }

      AssertJUnit.assertFalse(assertionMsg.toString(), testFailed);
   }

   @Test(groups = { "groupDeviceRedirection" })
   public void TC_testMobWebRegexPatternsDoNotMatchDesktopUAs()
   {
      boolean testFailed = false;

      // check all mobweb fixture UAs matched by regex's
      try {
         fixtureData = loadUserAgentFixture(getDesktopUAFixtureDataFilePath());
      } catch (IOException e) {
         LOGGER.debug(new StringBuilder("the user agent fixtures could not be loaded").toString());
         e.printStackTrace();
      }
      if (null == fixtureData) {
         AssertJUnit.fail("user agent fixture is null");
      }
      int rowCounter = 1; // start at 1 to account for header row
      StringBuilder assertionMsg = new StringBuilder("TC_testMobWebRegexPatternsDoNotMatchDesktopUAs::::\n\n");
      for (DeviceDefinition csvRow : fixtureData) {
         rowCounter++;
         ArrayList<Pattern> matchingPatterns = getMatchingPatterns(csvRow.ua, NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB
            .iterator());
         if (0 != matchingPatterns.size()) {
            testFailed = true;
            assertionMsg.append("failure at line ").append(rowCounter).append("\"")
               .append(";\n\t>= 1 MobWeb pattern matches Desktop ua = \"").append(csvRow.ua).append("\"");
            assertionMsg.append(";\n\tmatched pattern(s) = ").append(matchingPatterns.toString()).append("\n");
         }
      }

      AssertJUnit.assertFalse(assertionMsg.toString(), testFailed);
   }

   static {

      /**
       * Mobewb patterns.
       */
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("iPhone|iPad|iPod|iTouch|Aspen",
         Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("Android|Magic", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("Nintendo(?=.+Wii)", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("webOS", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("Palm|safari+(?=.+pre)|safari+(?=.+pixi)",
         Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("BlackBerry|rim", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("LGE", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("MIDP", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("MMP", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("BREW", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("Opera(?=.+(mini|mobi))", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("UP\\.Browser", Pattern.CASE_INSENSITIVE)); // DAB:
                                                                                                               // signals
                                                                                                               // BREW
                                                                                                               // as
                                                                                                               // far
                                                                                                               // as
                                                                                                               // I've
                                                                                                               // been
                                                                                                               // able
                                                                                                               // to
                                                                                                               // ascertain
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("POLARIS", Pattern.CASE_INSENSITIVE)); // LG
                                                                                                          // MIDP
                                                                                                          // browser
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("SAMSUNG", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("S[Pcg]H-|sam[aiu]", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern
         .compile("LG|LGE|vx\\d|cu\\d|XV\\d", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("SymbianOS(?!=.+Nokia)", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("Nokia", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("Windows CE|IEMobile", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("Mobile|HTC|Teleca|Novarra-Vision",
         Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_MOBWEB.add(Pattern.compile("MOT|Motorola", Pattern.CASE_INSENSITIVE));

      /**
       * Desktop patterns.
       */
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("MSIE(?!.+(Windows CE|Mobile|Palm|PalmSource|Phone|Smartphone|LG[E]?))", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("Firefox(?=.+(Windows|OS X|OSX|Macintosh|Linux))", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("Firefox(?<=(Windows|OS X|OSX|Macintosh|Linux).+)", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("Chrome", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("Safari(?<!(iPhone|iPad|iPod|iTouch|Aspen|Android|BlackBerry|WebOS|Symbian|BREW|Nokia).+)", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("Googlebot", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("msnbot", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("yacy|yahoo|Yandex", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("Opera(?!.+(Mobile|Wii))", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("Jakarta", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_DESKTOP.add(Pattern.compile("Konqueror", Pattern.CASE_INSENSITIVE));

      /**
       * Infogin patterns.
       */
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN
         .add(Pattern
            .compile("BlackBerry(?=.*(9530|9000|7100|8330|8130|8900|8830|8310|8320|8703|8120|8350i|8100|9000|8700|8703e|8220|8110|8220))",
               Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN
         .add(Pattern
            .compile("LGE?(?=.*(VX9100|VX9900|VX9700|KU990|CU720|CU920|LX600|AX260|LX260|VX9800|VX8560|VX8300|7100|8330|8130|8900|8830))",
               Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("SAMSUNG?(?=.*(T919|A867|SPHM540))",
         Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("SCH(?=.*(R430|R410|R500))",
         Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("SGH(?=.*(I617|A767|A877|T459))",
         Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("SonyEricsson(?=.*(T610))",
         Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("KWC-S", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("MOT(?=.*(-SPARK|-24|-COOL|A-7F|6ZM))",
         Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("TXT8010", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("sam-r450", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("TELECA-/2.0", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("hspr-102", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("SCP-6550", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("MOT-V3s", Pattern.CASE_INSENSITIVE));
      NETSCALER_REGEX_MATCHING_PATTERNS_INFOGIN.add(Pattern.compile("PPC6850", Pattern.CASE_INSENSITIVE));
   };

}
