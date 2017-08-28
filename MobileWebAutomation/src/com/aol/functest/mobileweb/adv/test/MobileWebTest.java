/**
 *	This class defines testcases
 *	@version 1.0
 *	@author shiladitya
 */

package com.aol.functest.mobileweb.adv.test;

import static com.aol.functest.common.assertsoft.assertEmpty;
import static com.aol.functest.common.assertsoft.verifyAndContinue;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.textfield;
import com.aol.functest.mobileweb.adv.common.MobileWeb;
import com.aol.functest.mobileweb.adv.common.uiobjects.AlongtheRoute;
import com.aol.functest.mobileweb.adv.common.uiobjects.AmbiguityPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.BrandBizSearchPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionTextResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionsBusinessSearchResultsPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionsTextresultwith3points;
import com.aol.functest.mobileweb.adv.common.uiobjects.GeoDiffPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapBusinessSearchResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapTestResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyFormLoginPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceTextResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.NearALocation;
import com.aol.functest.mobileweb.adv.common.uiobjects.RefineSearch;
import com.aol.functest.mobileweb.adv.common.uiobjects.RouteOptionsPopup;
import com.aol.functest.mobileweb.adv.common.uiobjects.SearchFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.SearchTextResult;
import com.mapquest.util.Logger;

/* 
 *  MobileWebTest class has test cases testing functionalities like
 *   a) Verify the content of the Map Search Form Page
 *   b) Verify the content of the Direction Search Form Page
 *   c) Verify the content of the Business Search Form Page
 *   d) Verify the content of the Map Result Page
 *   e) Verify the map of the Map Result Page
 *   f) Verify clicking the ToDirection of the Map Result Page
 *   g) Verify clicking the FormDirection of the Map Result Page
 *  
 */

public class MobileWebTest {

	private static Logger LOGGER = Logger.getLogger(MobileWebTest.class);

	public static String pRoot;
	private browserpage page;

	public MobileWebTest() {
	}

	/**
	 * @return the page
	 */
	public browserpage getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(browserpage page) {
		this.page = page;
	}

	/**
	 * @param n1
	 * @param n2
	 */
	public void validate(String[] n1, String[] n2) {
			
		for (int count = 0; count < n2.length; count++) {
			LOGGER.debug("Verifying n2 Text - " + n2[count]);
			if (n2[count].equals("Text")) {
				LOGGER.debug("Verifying Text - " + n1[count]);
				verifyAndContinue((MobileWeb.getInstance().getPage()
						.isTextPresent(n1[count])), "Verifying\"" + n1[count]
						+ "\" failed");
			} else {
				if (n2[count].equals("")) {
					LOGGER.debug("Verifying XPath - " + n1[count]);
					verifyAndContinue((page
							.isElementPresent(n1[count])), "Verifying\""
							+ n1[count] + "\" failed");
				} else if(n2[count].contains(".gif")|| n2[count].contains(".jpg") ||  n2[count].contains(".png")){
					String actualImageSrc =  page.getAttribute("//div[@id='oa-hdr']/h2/img/@src").trim();
					LOGGER.debug("Verifying Actual image src - " + actualImageSrc);
					Assert.assertTrue(actualImageSrc.contains(n2[count]));
					
				}else {
					LOGGER.debug("Verifying XPath - " + n1[count]);
					verifyAndContinue((page
							.isElementPresent(n1[count])), "Verifying\""
							+ n1[count] + "\"failed");
					LOGGER.debug("Inner Text of the XPath- " + n2[count]);
					verifyAndContinue(page.getText(
							n1[count]).equals(n2[count]), "Verifying\""
							+ n1[count] + "\"" + "text failed");
				}
			}
		}
		assertEmpty();
	}

	/* ** DIRECTION FORM ** */

	/**
	 * verify the UI Element of the directions form page
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyDirectionFormPageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Direction Form Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		DirectionFormPage.getInstance(page).RouteOption.click();
		validate(n1, n2);
	}

	/* ** DIRECTION TEXT RESULT ** */

	/**
	 * verify the UI Element of the directions text result page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyDirectionTextResultPageUIObject(String[] n1,
			String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Direction Text Result Page");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		validate(n1, n2);
	}

	/*
	 * Route Options Pop up
	 * 
	 * @ Amitha Test case to verify UI of Route Options Pop up
	 */

	public void TC_VerifyRouteOptionsPopupPage(String[] n1, String[] n2) {
		System.out.println("Testcase to verify Options button functionality and Route options pop up UI");
		DirectionFormPage.getInstance(page).SearchDirection("Denver, CO","Parker,CO");
		DirectionTextResult.getInstance(page).Options.click();
		validate(n1, n2);
	}

	/*
	 * Test case to verify Recalculate Route button functionality
	 * 
	 * @ Amitha
	 */

	public void TC_VerifyRecalculateRouteOptions() {
		DirectionFormPage.getInstance(page).SearchDirection("Denver, CO",
				"Parker,CO", "Shortest Time");
		String data = "Total Travel Estimate:34 mins / 25.55 mi";
		LOGGER.debug("Verifying travel estimate with shortest time");
		verifyAndContinue((page.isTextPresent(data)),
				"Verifying\"" + data + "\"");
		DirectionTextResult.getInstance(page).Options.click();
	    try{
		Thread.sleep(3000);
	    }catch(Exception e){
	    	System.out.println("Exception while sleeping"+e.getMessage());
	    }
		page.click(RouteOptionsPopup.getInstance(page).shortest_distance.getWindowID());
		page.click(RouteOptionsPopup.getInstance(page).Recalculate_Route.getWindowID());
		String data1 = "Total Travel Estimate:38 mins / 21.62 mi";
		LOGGER.debug("Verifying travel estimate with shortest distance");
		verifyAndContinue((page.isTextPresent(data1)),
				"Verifying\"" + data1 + "\"");
		System.out.println("Route options has been recalculated from shortest time to shortest distance");
	}

	/* ** DIRECTION MAP RESULT * */
	/**
	 * Verify the UI elements of the Directions MAP results page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyDirectionMapResultPageUIObject(String[] n1, String[] n2) {
		System.out.println("Testcase To Verify UI Objects In Direction Map Result Page");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO","Parker,CO");
		DirectionTextResult.getInstance(page).ShowMap.click();
		validate(n1, n2);
	}

	/**
	 * Verify the Map tiles of this Directions Results page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyDirectionMapResultPageMapObject(String[] n1,
			String[] n2) throws IOException {
		System.out
				.println("Testcase To Verify Map tiles In Direction Map Result Page");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		DirectionTextResult.getInstance(page).ShowMap.click();
		String act_fileName = "";
		String exp_fileName = "";
		for (int count = 0; count <= n1.length - 1; count++) {
			act_fileName = page.sPROJECTROOT
					+ "/testdata/dir/" + "act_" + n1[count];
			exp_fileName = page.sPROJECTROOT
					+ "/testdata/dir/" + n1[count];
			page.saveImagefromURL(n2[count], act_fileName,
					"");
			verifyAndContinue(page.imageCompare(
					act_fileName, exp_fileName, 100), "Comparision between "
					+ act_fileName + " and " + exp_fileName
					+ " failed or file doesn't exists....");
		}
		assertEmpty();
	}

	/* ** Direction Options ** */

	/**
	 * shortest time
	 */
	public void TC_VerifyDirectionMapWithShortestTime() {
		System.out
				.println("Testcase To Verify UI Objects In Direction Map Result Page: Route Options: Shortest time  ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO", "Shortest Time");
		System.out
				.println("Verify the Travel Estimate: & one random Road Nerretive");
		String data = "35 mins / 25.55 mi";
		verifyAndContinue((page.isTextPresent(data)),
				"Verifying\"" + data + "\"");
		String data1 = "Turn LEFT onto E MAINSTREET/CR-8 E.";
		verifyAndContinue((page.isTextPresent(data1)),
				"Verifying\"" + data1 + "\"");
		assertEmpty();
	}

	/**
	 * shortest distance
	 */
	public void TC_VerifyDirectionMapWithShortestDistance() {
		System.out
				.println("Testcase To Verify UI Objects In Direction Map Result Page: Route Options: Shortest Distence  ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO", "Shortest Distence");
		System.out
				.println("Verify the Travel Estimate: & one random Road Nerretive");
		String data = "39 mins / 21.62 mi";
		verifyAndContinue((page.isTextPresent(data)),
				"Verifying\"" + data + "\"");
		String data1 = "Turn LEFT onto E MAINSTREET/CR-8 E";
		verifyAndContinue((page.isTextPresent(data1)),
				"Verifying\"" + data1 + "\"");
		assertEmpty();
	}

	/**
	 * walking direction
	 */
	public void TC_VerifyDirectionMapWithWalkingDirection() {
		System.out
				.println("Testcase To Verify UI Objects In Direction Map Result Page: Route Options: Walking Direction  ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO", "Walking Directions");
		System.out
				.println("Verify the Travel Estimate: & one random Road Nerretive");
		String data = "8 hrs 49 mins / 22.07 mi";
		verifyAndContinue((page.isTextPresent(data)),
				"Verifying\"" + data + "\"");
		String data1 = "Turn LEFT onto E MAINSTREET/CR-8.";
		verifyAndContinue((page.isTextPresent(data1)),
				"Verifying\"" + data1 + "\"");
		assertEmpty();
	}

	/**
	 * Avoid Highways
	 */
	public void TC_VerifyDirectionMapWithAvoidHighways() {
		System.out
				.println("Testcase To Verify UI Objects In Direction Map Result Page: Route Options: Avoid Highways  ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO", "Avoid Highways");
		System.out
				.println("Verify the Travel Estimate: & one random Road Nerretive");
		String data = "40 mins / 21.81 mi";
		verifyAndContinue((page.isTextPresent(data)),
				"Verifying\"" + data + "\"");
		String data1 = "Turn LEFT onto E MAINSTREET/CR-8 E.";
		verifyAndContinue((page.isTextPresent(data1)),
				"Verifying\"" + data1 + "\"");
		assertEmpty();
	}

	/**
	 * Avoid Toll road.
	 */
	public void TC_VerifyDirectionMapWithAvoidTollRoad() {
		System.out
				.println("Testcase To Verify UI Objects In Direction Map Result Page: Route Options: Avoid Toll Roads  ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO", "Avoid Toll Roads");
		System.out
				.println("Verify the Travel Estimate: & one random Road Nerretive");
		String data = "38 mins / 25.28 mi";
		verifyAndContinue((page.isTextPresent(data)),
				"Verifying\"" + data + "\"");
		String data1 = "Turn LEFT onto E MAINSTREET/CR-8 E.";
		verifyAndContinue((page.isTextPresent(data1)),
				"Verifying\"" + data1 + "\"");
		assertEmpty();
	}

	/**
	 * Avoid Seasonally Closed Roads.
	 */
	public void TC_VerifyDirectionMapWithAvoidSeasonallyClosedRoads() {
		System.out
				.println("Testcase To Verify UI Objects In Direction Map Result Page: Route Options: Avoid Seasonally Closed Roads  ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO", "Avoid Seasonally Closed Roads");
		System.out
				.println("Verify the Travel Estimate: & one random Road Nerretive");
		String data = "35 mins / 25.55 mi";
		verifyAndContinue((page.isTextPresent(data)),
				"Verifying\"" + data + "\"");
		String data1 = "Turn LEFT onto E MAINSTREET/CR-8 E.";
		verifyAndContinue((page.isTextPresent(data1)),
				"Verifying\"" + data1 + "\"");
		assertEmpty();
	}

	/**
	 * Click Road Narrative to go Map Result Page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyDirectionMapClickRoadNarative(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Direction Map Result Page:Clicking Road Narrative ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		DirectionTextResult.getInstance(page).RandomRoadNarrative.click();
		validate(n1, n2);
	}

	/**
	 * Click Road Shield to go Map Result Page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyDirectionMapClickRoadshield(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Direction Map Result Page: :Clicking Road Narrative");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		DirectionTextResult.getInstance(page).Road_Sh_3.click();
		validate(n1, n2);
	}

	/* ** Map FORM ** */

	/**
	 * verify the UI Element of the Map Form.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMapFormPageUIObject(String[] n1, String[] n2) {
		LOGGER.debug("Testcase To Verify UI Objects In Map Form Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Map.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
	}

	/* ** Map TEXT RESULT ** */

	/**
	 * verify the UI Element of the Map Text Result page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMapTextResultPageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Map Text Result Page");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		validate(n1, n2);
	}

	/* ** Map MAP RESULT * */

	/**
	 * verify the UI Element of the Map Text Result page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMapMapResultPageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Map Map Result Page");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		MapTestResult.getInstance(page).ShowLargerMap.click();
		validate(n1, n2);
	}

	/**
	 * verify the UI Element of the Map Text Result page.
	 * 
	 * @param n1
	 * @param n2
	 * @throws IOException
	 */
	public void TC_VerifyMapMapResultPageMapObject(String[] n1, String[] n2)
			throws IOException {
		System.out
				.println("Testcase To Verify Map tiles In Map Map Result Page");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		MapTestResult.getInstance(page).ShowLargerMap.click();
		String act_fileName = "";
		String exp_fileName = "";
		for (int count = 0; count < n1.length; count++) {
			act_fileName = page.sPROJECTROOT
					+ "/testdata/map/" + "act_" + n1[count];
			exp_fileName = page.sPROJECTROOT
					+ "/testdata/map/" + n1[count];
			page.saveImagefromURL(n2[count], act_fileName,
					"");
			verifyAndContinue(page.imageCompare(
					act_fileName, exp_fileName, 0), "Comparision between "
					+ act_fileName + " and " + exp_fileName
					+ " failed or file doesn't exists....");
		}
		assertEmpty();
	}

	/**
	 * Map results page by clicking "Thumbnail Map".
	 * 
	 * @param n1
	 * @param n2
	 * @throws IOException
	 */
	public void TC_VerifyMapMapResultPageByThumbnailMap(String[] n1, String[] n2)
			throws IOException {
		System.out
				.println("Testcase To Verify UI Objects In Map Map Result Page");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		page.click(
				MapTestResult.getInstance(page).thumbnailMap.getWindowID());
		validate(n1, n2);
	}

	/**
	 * Part 1 : It will verify clicking of first navigation link
	 * "Find XYZ NearBy" in Text result page Part 2 : Verifying the content of
	 * Direction Result Page, after Clicking any of the result in that page
	 * 
	 */
	public void TC_VerifyMapMapResultPageFindXYZNearBy() {
		System.out
				.println("Testcase To Verify first navigation link \"Find XYZ NearBy\" in Text result page");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		String FindBizLocNearby = MapTestResult.getInstance(page).FindBizLocNearby
				.getText();
		String XYZ = FindBizLocNearby.substring((5),
				(FindBizLocNearby.length() - 7));
		LOGGER.debug("XYZ=" + XYZ);
		MapTestResult.getInstance(page).FindBizLocNearby.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		System.out
				.println("Part 1 : Verifying the content of the Search result page , got by clicking Find-Business-NearBy");
		LOGGER.debug("In Results Page verifying the existence of " + XYZ
				+ " and" + "Denver,CO");
		verifyAndContinue((page.isTextPresent(XYZ)),
				"Verifying\"" + XYZ + "\"");
		verifyAndContinue((page.isTextPresent("Denver")),
				"Verifying\"" + "Denver" + "\"");
		verifyAndContinue((page.isTextPresent("CO")),
				"Verifying\"" + "CO" + "\"");
		assertEmpty();
		System.out
				.println("Part 2 : Verifying the content of Direction Result Page, after Clicking any of the result in that page");
		MapBusinessSearchResult.getInstance(page).Get_Direction_1.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		verifyAndContinue((page
				.isElementPresent(DirectionTextResult.getInstance(page).Start_Star
						.getWindowID())), "");
		verifyAndContinue((page
				.isElementPresent(DirectionTextResult.getInstance(page).End_Star
						.getWindowID())), "");
		assertEmpty();
	}

	/**
	 * Part 1 : It will verify clicking of 2nd navigation link
	 * "Search Business NearBy" in Text result page Part 2 : It will verify
	 * clicking of Back link "Search Business NearBy" in Text result page Part 3
	 * : Search initiated from that page & Clicking a Search result to get
	 * Direction Result Page
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMapMapResultPageFindBusinessNearBy(String[] n1,
			String[] n2) {
		System.out
				.println("Part 1: Testcase To verify clicking of 2nd navigation link \"Search Business NearBy\" In Map Text Result Page");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		MapTestResult.getInstance(page).SearchBizNearby.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
		System.out
				.println("Part 2: Clicking Back to come back to results page");
		BrandBizSearchPage.getInstance(page).Back.click();
		assertEmpty();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		MapTestResult.getInstance(page).SearchBizNearby.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		System.out
				.println("Part 3: Search initiated from that page & Clicking a Search result to get Direction Result Page");
		BrandBizSearchPage.getInstance(page).GasStation.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		MapBusinessSearchResult.getInstance(page).Get_Direction_1.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		verifyAndContinue((page
				.isElementPresent(DirectionTextResult.getInstance(page).Start_Star
						.getWindowID())), "");
		verifyAndContinue((page
				.isElementPresent(DirectionTextResult.getInstance(page).End_Star
						.getWindowID())), "");
		assertEmpty();
	}

	/**
	 * Part 1 : It will verify clicking of 2nd navigation link
	 * "Get Directions From Here" in Text result page Part 2: Testcase To Verify
	 * direction search initiated from link \"Get Directions From Here\" in Text
	 * result page
	 * 
	 */
	public void TC_VerifyMapMapResultPageGetDirectionFromHere() {
		System.out
				.println("Part 1: Testcase To Verify first navigation link \"Get Directions From Here\" in Text result page");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		MapTestResult.getInstance(page).GetDirFromHere.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = DirectionFormPage.getInstance(page).StartLocation.getText();
		verifyAndContinue((Value.equals("Denver, CO")), "Verifying\"" + Value
				+ "\"");
		assertEmpty();
		System.out
				.println("Part 2: Testcase To Verify direction search initiated from link \"Get Directions From Here\" in Text result page");
		DirectionFormPage.getInstance(page).EndLocation.setText("Parker, CO");
		DirectionFormPage.getInstance(page).getDirection.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		verifyAndContinue((page
				.isElementPresent(DirectionTextResult.getInstance(page).Start_Star
						.getWindowID())), "");
		verifyAndContinue((page
				.isElementPresent(DirectionTextResult.getInstance(page).End_Star
						.getWindowID())), "");
		assertEmpty();
	}

	/**
	 * Part 1: It will verify clicking of 2nd navigation link
	 * "Get Directions To Here" in Text result page Part 2: Testcase To Verify
	 * direction search initiated from link
	 * \"Get Directions To Here\" in Text result page"
	 * 
	 */
	public void TC_VerifyMapMapResultPageGetDirectionToHere() {
		System.out
				.println("Testcase To Verify first navigation link \"Get Directions To Here\" in Text result page");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		MapTestResult.getInstance(page).GetDirToHere.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = DirectionFormPage.getInstance(page).EndLocation.getText();
		verifyAndContinue((Value.equals("Denver, CO")), "Verifying\"" + Value
				+ "\"");
		assertEmpty();
		System.out
				.println("Part 2: Testcase To Verify direction search initiated from link \"Get Directions To Here\" in Text result page");
		DirectionFormPage.getInstance(page).StartLocation.setText("Parker, CO");
		DirectionFormPage.getInstance(page).getDirection.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		verifyAndContinue((page
				.isElementPresent(DirectionTextResult.getInstance(page).Start_Star
						.getWindowID())), "");
		verifyAndContinue((page
				.isElementPresent(DirectionTextResult.getInstance(page).End_Star
						.getWindowID())), "");
		assertEmpty();
	}

	/************************/
	/* ** Search FORM ** */
	/************************/

	/**
	 * verify the UI Element of the search form page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifySearchFormPageUIObject(String[] n1, String[] n2) {
		LOGGER.debug("Testcase To Verify UI Objects In Search Form Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
	}

	/* ** Search TEXT RESULT ** */

	/**
	 * verify the UI Element of the search text result page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifySearchTextResultPageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Search Text Result Page");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		validate(n1, n2);
	}

	/* ** Search MAP RESULT * */

	/**
	 * verify the UI Element of the search map result page.
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifySearchMapResultPageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Search Map Result Page");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		SearchTextResult.getInstance(page).Show_Map_POI.click();
		validate(n1, n2);
	}

	/**
	 * verify the UI Element of the Directions Results page
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifySearchMapResultPageMapObject(String[] n1, String[] n2)
			throws IOException {
		System.out
				.println("Testcase To Verify Map tiles In Search Map Result Page");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		SearchTextResult.getInstance(page).Show_Map_POI.click();
		String act_fileName = "";
		String exp_fileName = "";
		for (int count = 0; count <= n1.length - 1; count++) {
			act_fileName = page.sPROJECTROOT
					+ "/testdata/search/" + "act_" + n1[count];
			exp_fileName = page.sPROJECTROOT
					+ "/testdata/search/" + n1[count];
			page.saveImagefromURL(n2[count], act_fileName,
					"");
			verifyAndContinue(page.imageCompare(
					act_fileName, exp_fileName, 100), "Comparision between "
					+ act_fileName + " and " + exp_fileName
					+ " failed or file doesn't exists..");
		}
		assertEmpty();
	}

	/**
	 * verify clicking of Search by Categories link in Search Form Page
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifySearchFormSearchByCatagory(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In SearchByCatagory Form Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		SearchFormPage.getInstance(page).Search_by_Categories.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
	}

	/**
	 * verify clicking of Search Result Item to open Map Result page
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_SearchMapResultPageUIFromSearchResultItemClick(String[] n1,
			String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Map Text Result Page came by clicking Business Search Result Item");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		String sValue = "Joey's Pizza";
		// page.click("//td[@class='searchResult']/a[.=\""+sValue+"\"]");
		page.click(
				"//td[@class='searchResult']/a[.=\"" + sValue + "\"]");
		verifyAndContinue((page.isTextPresent(sValue)),
				"Verifying\"" + sValue + "\"");
		validate(n1, n2);
	}

	/**
	 * verify clicking of Search Result Item - "Get Map" Click - to open Map
	 * Result page
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_SearchMapResultPageUIFromSearchResultGETMAPClick(
			String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Search Map Result Page came by clicking Business Search Result Item's \"GET MAP\"");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		String sValue = "Joey's Pizza";
		page.click(
						"//td[@class='searchResult']/a[.=\""
								+ sValue
								+ "\"]/../../td[@class='searchResultSelect']/div/div[1]/a");
		validate(n1, n2);
	}

	/**
	 * verify clicking of Search Result Item - "Get Direction" Click - to open
	 * Map Result page
	 */
	public void TC_SearchMapResultPageUIFromSearchResultGETDirectionClick() {
		System.out
				.println("Testcase To Verify UI Objects In Direction Search Page came by clicking Business Search Result Item's \"GET Direction\"");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		String sValue = "Joey's Pizza";
		page.click(
						"//td[@class='searchResult']/a[.=\""
								+ sValue
								+ "\"]/../../td[@class='searchResultSelect']/div/div[2]/a");
		String Value = DirectionFormPage.getInstance(page).EndLocation.getText();
		verifyAndContinue((Value.equals("329 E Colfax Ave, Denver, CO 80203")),
				"Verifying\"" + Value + "\"");
		assertEmpty();
	}

	/**
	 * verify the Search Using Search By Category page
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifySearchUsingSearchByCatagory(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Search Text Result Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		SearchFormPage.getInstance(page).Search_by_Categories.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		BrandBizSearchPage.getInstance(page).GasStation.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String MapAdd = "Denver,CO";
		SearchFormPage.getInstance(page).Near.setText(MapAdd);
		SearchFormPage.getInstance(page).Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
	}

	/**
	 * verify the Refine Search Page UI
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyRefineSearchFormPage(String[] n1, String[] n2) {
		LOGGER.debug("Testcase To Verify the Refine Search Page UI ");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		SearchTextResult.getInstance(page).Refine_Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
	}

	/**
	 * verify the Refine Search Results Page UI
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyRefineSearchResultPage() {
		System.out
				.println("Testcase To Verify the Refine Search functionality");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		SearchTextResult.getInstance(page).Refine_Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		RefineSearch.getInstance(page).M10.click();
		RefineSearch.getInstance(page).Sug1.click();
		RefineSearch.getInstance(page).UpdateSearch.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		verifyAndContinue((page.isTextPresent("pizza")),
				"");
		verifyAndContinue((page
				.isTextPresent("Denver, CO")), "");
		verifyAndContinue((page
				.isTextPresent("Arvada, CO")), "");
		assertEmpty();
	}

	/************************/
	/* ** MyPlace FORM ** */
	/************************/

	/**
	 * verify the UI Element of the MyPlace form
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMyPlaceFormPageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In MyPlace Form Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_MyPlace.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
	}

	/**
	 * verify the UI Element of the MyPlace TEXT RESULT
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMyPlaceTextResultPageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In MyPlace Text Result Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_MyPlace.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String ScreenName = "test4200";
		String Password = "giri_12";
		MyPlaceFormPage.getInstance(page).ScreenName.setText(ScreenName);
		MyPlaceFormPage.getInstance(page).Password.setText(Password);
		MyPlaceFormPage.getInstance(page).SignIn.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
		LOGGER.debug("Doing Sign-Off");
		MyPlaceTextResult.getInstance(page).SignOut.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		assertEmpty();
	}

	/**
	 * verify the UI elements of the MyPlace TEXT RESULT
	 * 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMyPlaceTextResultPageUIObject_Authenticate(
			String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In MyPlace Text Result Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_MyPlace.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
		assertEmpty();
	}

	/* ********************* */
	/* Saved & Recent Form */
	/* ********************* */

	/* Comments */
	/*
	 * It will verify the UI Element of this page
	 */

	public void TC_VerifySavedAndRecentFormPageUIObject(String[] n1, String[] n2) {
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		DirectionFormPage.getInstance(page).V_EndLocation.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		System.out
				.println("Verifing Saved & Recent page invoked from Direction Search page");
		validate(n1, n2);

		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Map.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		MapFormPage.getInstance(page).V_EnterLocation.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		System.out
				.println("Verifing Saved & Recent page invoked from Map Search page");
		validate(n1, n2);

		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		SearchFormPage.getInstance(page).V_Near.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		System.out
				.println("Verifing Saved & Recent page invoked from Business Search page");
		validate(n1, n2);
	}

	/* Comments */
	/*
	 * It will Recent Location in Search form page
	 */

	public void TC_VerifySearchFormRecentLocation() {
		System.out
				.println("Testcase To Verify Recent Location in Search form page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Search = "Pizza";
		String MapAdd = "Newyork,NY";
		SearchFormPage.getInstance(page).Search_for.setText(Search);
		SearchFormPage.getInstance(page).Near.setText(MapAdd);
		SearchFormPage.getInstance(page).Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		SearchFormPage.getInstance(page).V_Near.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "New York, NY";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();

	}

	// Check Start & End Address Recent location.
	public void TC_VerifyDirectionFormRecentLocation() {
		LOGGER.debug("Testcase To Verify Start Address Recent location");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		DirectionFormPage.getInstance(page).V_StartLocation.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Rdata = "Denver, CO";
		verifyAndContinue((page.isTextPresent(Rdata)),
				"Verifying\"" + Rdata + "\" failed");
		Rdata = "Parker, CO";
		verifyAndContinue((page.isTextPresent(Rdata)),
				"Verifying\"" + Rdata + "\" failed");
		assertEmpty();
	}

	/* Comments */
	/*
	 * It will verify the Recent location in Maps form page
	 */

	public void TC_VerifyMapFormRecentLocation() {
		System.out
				.println("Testcase To Verify Recent location in Maps form page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Map.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String MapAdd = "Seattle,WA";
		MapFormPage.getInstance(page).EnterLocation.setText(MapAdd);
		MapFormPage.getInstance(page).getMap.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_Map.click();
		MapFormPage.getInstance(page).V_EnterLocation.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "Seattle, WA";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();
	}

	/* ******************* */
	/* Ambiguity Page */
	/********************* */

	/* Comments */
	/*
	 * It will verify the UI of the ambiguity page generated from Direction
	 * Search
	 */

	public void TC_VerifyDirectionFormAmbiguityPage(String[] n1, String[] n2) {
		System.out
				.println("Testcase To Verify UI Objects In Direction Text Result Ambiguity Page");
		DirectionFormPage.getInstance(page).SearchDirection("Denver");
		validate(n1, n2);
	}

	/* Comments */
	/*
	 * It will verify the UI of the ambiguity page generated from Map Search
	 */

	public void TC_VerifyMapFormAmbiguityPage(String[] n1, String[] n2) {
		System.out.println("Testcase To Verify UI Objects In Map Text Result Ambiguity Page");
		MapFormPage.getInstance(page).SearchMap("Denver");
		validate(n1, n2);
	}

	/* Comments */
	/*
	 * It will verify the UI of the ambiguity page generated from Business
	 * Search Page
	 */

	public void TC_VerifySearchFormAmbiguityPage(String[] n1, String[] n2)
			throws IOException {
		System.out.println("Testcase To Verify UI Objects In Search Text Result Ambiguity Page");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver");
		validate(n1, n2);
	}

	/* ******************* */
	/* Geodiff Page */
	/********************* */

	/* Comments */
	/*
	 * It will verify the UI of the GeoDiff page generated from Direction Search
	 */

	public void TC_VerifyDirectionFormGepDiffPage(String[] n1, String[] n2) {
		System.out.println("Testcase To Verify UI Objects In Direction Text Result Geodiff Page");
		DirectionFormPage.getInstance(page).SearchDirection("Denvre,CA");
		validate(n1, n2);
	}

	/* Comments */
	/*
	 * It will verify the UI of the GeoDiff page generated from Map Search
	 */

	public void TC_VerifyMapFormGeoDiffPage(String[] n1, String[] n2) {
		System.out.println("Testcase To Verify UI Objects In Map Text Result Geodiff Page");
		MapFormPage.getInstance(page).SearchMap("Denvre,CA");
		validate(n1, n2);
	}

	/* Comments */
	/*
	 * It will verify the UI of the GeoDiff page generated from Business Search
	 */

	public void TC_VerifySearchFormGeoDiffPage(String[] n1, String[] n2) {
		System.out.println("Testcase To Verify UI Objects In Search Text Result Geodiff Page");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denvre,CA");
		validate(n1, n2);
	}

	/* *********************************** */
	/* *** GeoDiff & Ambiguity Search *** */
	/* *********************************** */

	/* Comments */
	/*
	 * It will verify the Direction Search generated from a Ambiguous Start and
	 * Geodiffed End Location
	 */

	@Test(groups = { "groupGeodiff" })
	public void TC_VerifyDirectionSearchAmbiguityAndGeodiff() {
		System.out
				.println("Testcase To Verify the Direction Search generated from a Ambiguous Start and Geodiffed End Location");
		DirectionFormPage.getInstance(page).SearchDirection("Denver", "Denvre,CA");
		AmbiguityPage.getInstance(page).Result1.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		GeoDiffPage.getInstance(page).Suggestion.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();
	}

	/* Comments */
	/*
	 * It will verify the Map Search generated from Ambiguity page
	 */

	public void TC_VerifyMapSearchfromAmbiguityPage() {
		LOGGER.debug("Testcase To Verify Map Search from Ambiguity Page");
		MapFormPage.getInstance(page).SearchMap("Denver");
		AmbiguityPage.getInstance(page).Result1.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();
	}

	/* Comments */
	/*
	 * It will verify the Map Search generated from GeoDiff page
	 */

	public void TC_VerifyMapSearchformGeoDiffPage() {
		System.out
				.println("Testcase To Verify the Map Search generated from GeoDiff page");
		MapFormPage.getInstance(page).SearchMap("Denvre,CA");
		GeoDiffPage.getInstance(page).Suggestion.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();

	}

	/* Comments */
	/*
	 * It will verify the Business Search generated from Ambiguity page
	 */

	public void TC_VerifyBusinessSearchfromAmbiguityPage() {
		System.out
				.println("Testcase To Verify Business Search generated from Ambiguity page");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver");
		AmbiguityPage.getInstance(page).Result1.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();
	}

	/* Comments */
	/*
	 * It will verify the Business Search generated from GeoDiff page
	 */

	public void TC_VerifyBusinessSearchfromGeodiffPage() {
		System.out
				.println("Testcase To Verify Business Search from GeoDiff Page");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denvre,CA");
		GeoDiffPage.getInstance(page).Suggestion.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();
	}

	// New Testcases

	// Comments
	/* Test Case to verify Directions page with only start location */
	// @Amitha
	public void TC_VerifyDirectionspagewithstartlocation() {
		System.out
				.println("Test Case to verify Directions page with only start location");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO");
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();

	}

	// Comments
	/* Test Case to verify Directions page without start and end locations */
	// @Amitha
	public void TC_VerfifyDirectionspagewithoutlocation() {
		System.out
				.println("Test Case to verify Directions page without any  location");
		DirectionFormPage.getInstance(page).getDirection.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Value = "Please enter a location";
		verifyAndContinue((page.isTextPresent(Value)),
				"Verifying\"" + Value + "\"");
		assertEmpty();
	}

	// Comments
	// @Amitha
	/*
	 * This method will click on find business near by link in directions text
	 * result page and verify all the UI Elements in Near a Location page
	 */

	public void TC_VerifyNearaLocationpageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testmethod To Verify UI Objects In Near a Location Page");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		String FindBusinessNearbyL = DirectionTextResult.getInstance(page).FindBusinessNearbyL
				.getText();
		String business = FindBusinessNearbyL.substring((5),
				(FindBusinessNearbyL.length() - 7));
		LOGGER.debug("business=" + business);
		LOGGER.debug("Verifying Near a Location page UI Element");
		DirectionTextResult.getInstance(page).FindBusinessNearbyL.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
		LOGGER.debug("Near a Location UI Element has been verified");
		System.out
				.println("Test method to verify UI elements in directions business results page");
		NearALocation.getInstance(page).start_loc_b.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String Location = "Denver CO";
		verifyAndContinue((page.isTextPresent(business)),
				"Verifying\"" + business + "\"");
		verifyAndContinue((page.isTextPresent(business)),
				"Verifying\"" + Location + "\"");
		LOGGER.debug("Verified " + business + " and Verified " + Location
				+ "");
	}

	/* Comments */
	// @Amitha
	/*
	 * Test case to verify UI elements of Directions Business Search results
	 * Page and click on add to route button and verify that all the 3 locations
	 * are present
	 */
	public void TC_VerifyDirectionsBusinessSearchResultspageUI(String[] n1,
			String[] n2) {
		System.out
				.println("part 1:Testmethod to verify UI Objects in Directions Business Search Results page");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		String FindBusinessNearbyL = DirectionTextResult.getInstance(page).FindBusinessNearbyL
				.getText();
		String business = FindBusinessNearbyL.substring((5),
				(FindBusinessNearbyL.length() - 7));
		LOGGER.debug("business=" + business);
		DirectionTextResult.getInstance(page).FindBusinessNearbyL.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		NearALocation.getInstance(page).start_loc_b.click();
		System.out
				.println("Verify UI elements in Directions Business Search Results Page");
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String AddToRouteLoc = DirectionsBusinessSearchResultsPage
				.getInstance(page).SearchResult_1.getText();
		LOGGER.debug("First search result is :" + AddToRouteLoc);
		validate(n1, n2);
		System.out
				.println("Part2:Test Method Will verify start, end and added route in directions page with 3 routes");
		DirectionsBusinessSearchResultsPage.getInstance(page).Add_To_Route_1
				.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String StartLoc = DirectionsTextresultwith3points.getInstance(page).Start_Text
				.getText();
		LOGGER.debug("Start Location is :" + StartLoc);
		String EndLoc = DirectionsTextresultwith3points.getInstance(page).End_Text
				.getText();
		LOGGER.debug("End Location :" + EndLoc);
		LOGGER.debug("Test directions page with 3 routes");
		verifyAndContinue((page
				.isTextPresent(AddToRouteLoc)), "Verifying\"" + AddToRouteLoc
				+ "\"");
		verifyAndContinue((page.isTextPresent(EndLoc)),
				"Verifying\"" + EndLoc + "\"");
		verifyAndContinue((page.isTextPresent(StartLoc)),
				"Verifying\"" + StartLoc + "\"");
		LOGGER.debug("test");
	}

	/* Comments */
	// @Amitha
	/*
	 * Test case to verify UI elements of Directions Text results Page after
	 * adding the 3rd route
	 */
	public void TC_VerifyDirectionTextResultswith3routespageUI(String[] n1,
			String[] n2) {
		System.out
				.println("Testmethod to verify UI Objects in Directions Text results Page after adding the 3rd route ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		String FindBusinessNearbyL = DirectionTextResult.getInstance(page).FindBusinessNearbyL
				.getText();
		String business = FindBusinessNearbyL.substring((5),
				(FindBusinessNearbyL.length() - 7));
		LOGGER.debug("business=" + business);
		DirectionTextResult.getInstance(page).FindBusinessNearbyL.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		NearALocation.getInstance(page).start_loc_b.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		DirectionsBusinessSearchResultsPage.getInstance(page).Add_To_Route_1
				.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		System.out
				.println("Verify UI elements of directions page with 3 routes");
		validate(n1, n2);
	}

	/* Comments */
	// @Amitha
	/* Test case to verify UI elements of Search Along the Route page */
	public void TC_VerifyAlongtheRoutepageUI(String[] n1, String[] n2) {
		System.out
				.println("Testmethod to verify UI Objects in Search Along the Route Page ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		String FindBusinessNearbyL = DirectionTextResult.getInstance(page).FindBusinessNearbyL
				.getText();
		String business = FindBusinessNearbyL.substring((5),
				(FindBusinessNearbyL.length() - 7));
		LOGGER.debug("business=" + business);
		DirectionTextResult.getInstance(page).FindBusinessNearbyL.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		NearALocation.getInstance(page).along_the_route.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		LOGGER.debug("Verify UI elements of Along the Route page");
		validate(n1, n2);
	}

	/* Comments */
	// @Amitha
	/*
	 * Test case to verify Back & View Route buttons and Near a Location link
	 * functionality in Search Along the Route page
	 */
	public void TC_VerifyAlongtheRoutepagefunctionality() {
		System.out
				.println("Testmethod to verify links, buttons in Search Along the Route page ");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO",
				"Parker,CO");
		String FindBusinessNearbyL = DirectionTextResult.getInstance(page).FindBusinessNearbyL
				.getText();
		String business = FindBusinessNearbyL.substring((5),
				(FindBusinessNearbyL.length() - 7));
		LOGGER.debug("business=" + business);
		DirectionTextResult.getInstance(page).FindBusinessNearbyL.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		NearALocation.getInstance(page).along_the_route.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);

		LOGGER.debug("Verify Back button functionality ");
		AlongtheRoute.getInstance(page).Back.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String NrLoc = "Near a Location";
		LOGGER.debug("Near a Location= " + NrLoc);
		verifyAndContinue((page.isTextPresent(NrLoc)),
				"Verifying\"" + NrLoc + "\"");

		NearALocation.getInstance(page).along_the_route.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);

		LOGGER.debug("Verify Near a Location Link functionality");
		AlongtheRoute.getInstance(page).NearALocation.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String NrLoc1 = "Near a Location";
		LOGGER.debug("Near a Location= " + NrLoc1);
		verifyAndContinue((page.isTextPresent(NrLoc1)),
				"Verifying\"" + NrLoc1 + "\"");

		LOGGER.debug("Verify View Route Button functionality");
		AlongtheRoute.getInstance(page).ViewRoute.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String SrchBizNrByL = DirectionTextResult.getInstance(page).SearchBusinessNearbyL
				.getText();
		LOGGER.debug("Search Business Nearby= " + SrchBizNrByL);
		verifyAndContinue((page
				.isTextPresent(SrchBizNrByL)), "Verifying\"" + SrchBizNrByL
				+ "\"");
		assertEmpty();

	}
	
	
	/**
	 * Testcase to validate UI elements in My Maps login page.
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMyLoginFormPageUIObject(String[] n1, String[] n2) {
		System.out
				.println("Testcase To TC_VerifyMyLoginFormPageUIObject Page");
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		page.click(
				DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_MyPlace.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		validate(n1, n2);
	}
	
		
	/**
	 * This method is used to verify the user credentials 
	 * @param openID (Ideally it will be 'aol','yahoo' etc)
	 * @param userName
	 * @param pwd
	 */
	public void verifyUserCredentials(String openID,String userName,String pwd){
		System.out.println("Testcase To TC_VerifyMyLoginFormPageUIObject Page");
		
		System.out.println("openID============"+openID+",userName------------------>"+userName+",password--------------->"+pwd);
		DirectionFormPage.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(page.sTIMEOUT);
		page.click(DirectionFormPage.getInstance(page).Menu.getWindowID());
		DirectionFormPage.getInstance(page).Menu_MyPlace.click();
		page.waitForPageToLoad(page.sTIMEOUT);
		if(openID.equalsIgnoreCase("GOOGLE")){
			if(page.isElementPresent(MyFormLoginPage.getInstance(page).Google.getWindowID())){
				MyFormLoginPage.getInstance(page).Google.click();
				page.waitForPageToLoad("5000");
				Assert.assertTrue("Google signin button doesn't exist:",page.isElementPresent(MyFormLoginPage.getInstance(page).google_signin_btn.getWindowID()));
				MyFormLoginPage.getInstance(page).google_signin_btn.click();
				page.waitForPageToLoad(page.sTIMEOUT);
			}
		}else if(openID.equalsIgnoreCase("TWITTER")){
			if(page.isElementPresent(MyFormLoginPage.getInstance(page).Twitter.getWindowID())){
				MyFormLoginPage.getInstance(page).Twitter.click();
				page.waitForPageToLoad("5000");
				Assert.assertTrue("Twitter signin button doesn't exist:",page.isElementPresent(MyFormLoginPage.getInstance(page).twitter_sign_btn.getWindowID()));
				MyFormLoginPage.getInstance(page).twitter_sign_btn.click();
				page.waitForPageToLoad(page.sTIMEOUT);
			}
		}else if(openID.equalsIgnoreCase("YAHOO")){
			if(page.isElementPresent(MyFormLoginPage.getInstance(page).Yahoo.getWindowID())){
				MyFormLoginPage.getInstance(page).Yahoo.click();
				page.waitForPageToLoad("5000");
				Assert.assertTrue("Yahoo singin button doesn't exist:",page.isElementPresent(MyFormLoginPage.getInstance(page).yahoo_signin_btn.getWindowID()));
			    MyFormLoginPage.getInstance(page).yahoo_signin_btn.click();
			    page.waitForPageToLoad(page.sTIMEOUT);
			}
		}
		signInOpenAccount(openID,userName,pwd);
		
	}
	
	/**
	 * This method is used to sign into the specified open Account.
	 * @param openID
	 * @param userName
	 * @param password
	 */
	public void signInOpenAccount(String openID,String userName, String password){
		System.out.println("in signInOpenAccount method");
		textfield userNameRef = MyFormLoginPage.getInstance(page,openID).username;
		textfield pwdRef = MyFormLoginPage.getInstance(page,openID).pass;
		userNameRef.setText(userName);
		pwdRef.setText(password);
		MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage(),openID).SignIn.click();
		page.waitForPageToLoad(page.sTIMEOUT);
	}
	
	/**
	 * Validate whether specified message shown on screen.
	 * @param expMsg
	 * @throws Exception
	 */
	public void validateMsg(String expMsg) throws Exception{
		Assert.assertTrue(page.isTextPresent(expMsg));
	}
	
	/**
	 * Verify the traffic in Directions page result.
	 * @throws Exception
	 */
	public void TC_VerifyTrafficInDirectionsPage() throws Exception{
		System.out.println("in TC_VerifyTrafficInDirectionsPage");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO","Parker,CO");
		DirectionTextResult.getInstance(page).ShowMap.click();
		Thread.sleep(8000);
		DirectionTextResult.getInstance(page).view.click();
		Thread.sleep(3000);
		page.click(DirectionTextResult.getInstance(page).traffic.getWindowID());
		Thread.sleep(10000);
		Assert.assertTrue("Fail:Traffic is not shown on the map:",validateTrafficImage());
	}
	
	/**
	 * Verify the traffic image in Map page.
	 * @throws Exception
	 */
	public void TC_VerifyTrafficInMapPage() throws Exception{
		System.out.println("in TC_VerifyTrafficInMapPage");
		MapFormPage.getInstance(page).SearchMap("Denver,CO");
		MapTestResult.getInstance(page).ShowLargerMap.click();
		Thread.sleep(8000);
		DirectionTextResult.getInstance(page).view.click();
		Thread.sleep(3000);
		page.click(DirectionTextResult.getInstance(page).traffic.getWindowID());
		Thread.sleep(10000);
		Assert.assertTrue("Fail:Traffic is not shown on the map:",validateTrafficImage());
	}
	
	public void TC_VerifyTrafficInSearchPage() throws Exception{
		System.out.println("in TC_VerifyTrafficInSearchPage");
		SearchFormPage.getInstance(page).SearchBusiness("Pizza", "Denver,CO");
		SearchTextResult.getInstance(page).Show_Map_POI.click();
		Thread.sleep(8000);
		DirectionTextResult.getInstance(page).view.click();
		Thread.sleep(3000);
		page.click(DirectionTextResult.getInstance(page).traffic.getWindowID());
		Thread.sleep(10000);
		Assert.assertTrue("Fail:Traffic is not shown on the map::",validateTrafficImage());
	}
	
	
	
	/**
	 * Verify the Traffic image appears on the Map or not.
	 */
	public boolean validateTrafficImage() throws Exception {
		return page.isElementPresent(DirectionTextResult.getInstance(page).trafficImage.getWindowID());
	}
	
	
	public void TC_VerifyZoomFuncForDirections() throws Exception{
		System.out.println("in TC_VerifyTrafficInDirectionsPage");
		DirectionFormPage.getInstance(page).SearchDirection("Denver,CO","Parker,CO");
		DirectionTextResult.getInstance(page).ShowMap.click();
		Thread.sleep(8000);
		Assert.assertTrue("Fail:zoomOut button is not shown:" ,page.isElementPresent(DirectionTextResult.getInstance(page).zoomOut.getWindowID()));
		
		
	    Image actualImage = getImageFromURL(getImageSrcFormXpath(DirectionTextResult.getInstance(page).directionsImage.getWindowID()));
	    
	    DirectionTextResult.getInstance(page).zoomOut.click();
	    Thread.sleep(8000);
	    Image zoomOutImage = getImageFromURL(getImageSrcFormXpath(DirectionTextResult.getInstance(page).directionsImage.getWindowID()));
	    Assert.assertTrue("Fail:zoomOut functionality is not working:",(compareImages(zoomOutImage,actualImage) == 1));
	    
	    
	    Assert.assertTrue("Fail:zoomIn button is not shown:" ,page.isElementPresent(DirectionTextResult.getInstance(page).zoomOut.getWindowID()));
	    DirectionTextResult.getInstance(page).zoomIn.click();
	    Thread.sleep(8000);
	    Image zoomInImage = getImageFromURL(getImageSrcFormXpath(DirectionTextResult.getInstance(page).directionsImage.getWindowID()));
	    Assert.assertTrue("Fail:zoomIn functionality is not working:",(compareImages(zoomInImage,zoomOutImage) == -1));
	    
	}
	
	public  Image getImageFromURL(String url) throws Exception{
		URL urlStr = new URL(url);
		java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(urlStr);
		return image;	
	}
	
	public  String getImageSrcFormXpath(String imageXpath) throws Exception{
		return page.getAttribute(imageXpath+"/@src");
	}
	
	
	public int compareImages(Image image1,Image image2) throws Exception{
		//Thread.sleep(3000);
		
		BufferedImage srcImage = new BufferedImage(image1.getWidth(null), image1.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		BufferedImage destImage = new BufferedImage(image2.getWidth(null), image2.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	
        
		int srcWidth=-1;
		int srcHeight = -1;
		int destWidth=-1;
		int destHeight = -1;
		
		srcWidth = srcImage.getWidth();
	    srcHeight = srcImage.getHeight();
	   
	   System.out.println("srcWidth=============="+srcWidth); 
	   System.out.println("srcHeight=============="+srcHeight); 
	   
	    int srcSize=-1;
	    int destSize=-1;
	    
	    if(srcWidth > 0 && srcHeight > 1){
	    	srcSize = (srcWidth*srcHeight);
		}else if(srcWidth == -1 || srcWidth==0){
	    	srcSize = srcHeight;
	    }else if(srcHeight == -1 || srcHeight==0){
	    	srcSize = srcWidth;
	    }
	
	    destWidth = destImage.getWidth();
	    destHeight = destImage.getHeight();
	    
	    System.out.println("destWidth=============="+destWidth); 
		System.out.println("destHeight=============="+destHeight); 
		   
	    if(destWidth > 0 && destHeight > 1){
	    	destSize = (destWidth*destHeight);
		}else if(destWidth == -1 || destWidth==0){
	    	destSize = destHeight;
	    }else if(srcHeight == -1 || srcHeight==0){
	    	destSize = destWidth;
	    }
	    
	    if(srcSize == destSize){
	    	return 0;
	    }else   if(srcSize > destSize){
	    	return 1;
	    }else{
	    	return -1;
	    }
	    
		
	}
	public Image getImageFile(Image image)
	{
	   MediaTracker tracker=new MediaTracker(null);
	   
	   tracker.addImage(image,1);
	   try
	   {
	       tracker.waitForAll();
	   }
	   catch (InterruptedException ie)
	   {
	   }
	   return image;
	}








	
	

} // End of MobileWebTest class
