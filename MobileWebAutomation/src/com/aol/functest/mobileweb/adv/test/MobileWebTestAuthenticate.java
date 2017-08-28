package com.aol.functest.mobileweb.adv.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aol.functest.common.browserpage;
import com.aol.functest.mobileweb.adv.common.MobileWeb;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceFormPage;
import com.aol.functest.mobileweb.adv.data.Dataprovider;
import com.mapquest.util.Logger;

public class MobileWebTestAuthenticate {

	private static Logger LOGGER = Logger.getLogger(MobileWebTestAuthenticate.class);

	private browserpage page;
	protected MobileWebTest MWTest;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		MobileWeb.getInstance().setUp();
		page = MobileWeb.getInstance().getPage();
		MWTest = new MobileWebTest();
		MWTest.setPage(page);
	}

	@AfterClass(alwaysRun = true)
	public void cleanUp() {
		MobileWeb.getInstance().mobileWebBaseState();
		MobileWeb.getInstance().unAuthenticate();
	}

	/* Comments */
	/*
	 * It will run the base state *
	 */
	@BeforeMethod(alwaysRun = true)
	public void basestate() {
		LOGGER.debug("ack - getting mobileWebBaseState ");
		MobileWeb.getInstance().mobileWebBaseState();
		LOGGER.debug("ack - retrieved mobileWebBaseState ");
	}

	@Test(groups = { "authenticate" })
	public void authenticate1() {
		LOGGER.debug("Running in Authenticated Mode");
		// Checking if the application is already Authenticated with given user.
		if (!MobileWeb.getInstance().isAuthenticated("test")) {
			MobileWeb.getInstance().unAuthenticate();
			DirectionFormPage.getInstance(page).Mapquest.click();
			page.waitForPageToLoad(page.sTIMEOUT);
			page.click(DirectionFormPage.getInstance(page).Menu.getWindowID());
			DirectionFormPage.getInstance(page).Menu_MyPlace.click();
			page.waitForPageToLoad(	page.sTIMEOUT);
			String ScreenName = "test4200";
			String Password = "giri_12";
			MyPlaceFormPage.getInstance(page).ScreenName.setText(ScreenName);
			MyPlaceFormPage.getInstance(page).Password.setText(Password);
			MyPlaceFormPage.getInstance(page).SignIn.click();
			page.waitForPageToLoad(page.sTIMEOUT);
			assertTrue(MobileWeb.getInstance().isAuthenticated("test"));
		}

	} // End of authenticate () Method.

	@Test(groups = { "groupDirection" }, dataProvider = "DirectionFormPageUIElement", dataProviderClass = Dataprovider.class)
	public void TC_VerifyDirectionFormPageUIObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionFormPageUIObject(n1, n2);
	}

	@Test(groups = { "groupDirection" }, dataProvider = "DirectionTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionTextResultPageUIObject_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionTextResultPageUIObject(n1, n2);
	}

	@Test(groups = { "groupDirection" }, dataProvider = "DirectionMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapResultPageUIObject_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionMapResultPageUIObject(n1, n2);
	}

	@Test(groups = { "groupDirection" }, dataProvider = "DirectionMapResultPageMapElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapResultPageMapObject_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionMapResultPageMapObject(n1, n2);
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapWithShortestTime_Authenticate()
			throws IOException {
		MWTest.TC_VerifyDirectionMapWithShortestTime();
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapWithShortestDistance_Authenticate()
			throws IOException {
		MWTest.TC_VerifyDirectionMapWithShortestDistance();
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapWithWalkingDirection_Authenticate()
			throws IOException {
		MWTest.TC_VerifyDirectionMapWithWalkingDirection();
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapWithAvoidHighways_Authenticate()
			throws IOException {
		MWTest.TC_VerifyDirectionMapWithAvoidHighways();
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapWithAvoidTollRoad_Authenticate()
			throws IOException {
		MWTest.TC_VerifyDirectionMapWithAvoidTollRoad();
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapWithAvoidSeasonallyClosedRoads_Authenticate()
			throws IOException {
		MWTest.TC_VerifyDirectionMapWithAvoidSeasonallyClosedRoads();
	}

	@Test(groups = { "groupDirection" }, dataProvider = "DirectionMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapClickRoadNarative_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionMapClickRoadNarative(n1, n2);
	}

	@Test(groups = { "groupDirection" }, dataProvider = "DirectionMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionMapClickRoadshield_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionMapClickRoadshield(n1, n2);
	}

	@Test(groups = { "groupMaps" }, dataProvider = "MapFormPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapFormPageUIObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyMapFormPageUIObject(n1, n2);
	}

	@Test(groups = { "groupMaps" }, dataProvider = "MapTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapTextResultPageUIObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyMapTextResultPageUIObject(n1, n2);
	}

	@Test(groups = { "groupMaps" }, dataProvider = "MapMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapMapResultPageUIObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyMapMapResultPageUIObject(n1, n2);
	}

	@Test(groups = { "groupMaps" }, dataProvider = "MapMapResultPageMapElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapMapResultPageMapObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyMapMapResultPageMapObject(n1, n2);
	}

	@Test(groups = { "groupMaps" }, dataProvider = "MapMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapMapResultPageByThumbnailMap_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyMapMapResultPageByThumbnailMap(n1, n2);
	}

	@Test(groups = { "groupMaps" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapMapResultPageFindXYZNearBy_Authenticate()
			throws IOException {
		MWTest.TC_VerifyMapMapResultPageFindXYZNearBy();
	}

	@Test(groups = { "groupMaps" }, dataProvider = "BrandBizSearchPage", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapMapResultPageFindBusinessNearBy_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyMapMapResultPageFindBusinessNearBy(n1, n2);
	}

	@Test(groups = { "groupMaps" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapMapResultPageGetDirectionFromHere_Authenticate()
			throws IOException {
		MWTest.TC_VerifyMapMapResultPageGetDirectionFromHere();
	}

	@Test(groups = { "groupMaps" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapMapResultPageGetDirectionToHere_Authenticate()
			throws IOException {
		MWTest.TC_VerifyMapMapResultPageGetDirectionToHere();
	}

	@Test(groups = { "groupSearch" }, dataProvider = "SearchFormPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchFormPageUIObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifySearchFormPageUIObject(n1, n2);
	}

	@Test(groups = { "groupSearch" }, dataProvider = "SearchTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchTextResultPageUIObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifySearchTextResultPageUIObject(n1, n2);
	}

	@Test(groups = { "groupSearch" }, dataProvider = "SearchMapResultPageMapElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchMapResultPageMapObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifySearchMapResultPageMapObject(n1, n2);
	}

	@Test(groups = { "groupSearch" }, dataProvider = "BrandBizSearchPage", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchFormSearchByCatagory_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifySearchFormSearchByCatagory(n1, n2);
	}

	@Test(groups = { "groupSearch" }, dataProvider = "MapTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_SearchMapResultPageUIFromSearchResultItemClick_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_SearchMapResultPageUIFromSearchResultItemClick(n1, n2);
	}

	@Test(groups = { "groupSearch" }, dataProvider = "MapMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_SearchMapResultPageUIFromSearchResultGETMAPClick_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_SearchMapResultPageUIFromSearchResultGETMAPClick(n1, n2);
	}

	@Test(groups = { "groupSearch" }, dependsOnGroups = { "authenticate" })
	public void TC_SearchMapResultPageUIFromSearchResultGETDirectionClick_Authenticate()
			throws IOException {
		MWTest.TC_SearchMapResultPageUIFromSearchResultGETDirectionClick();
	}

	@Test(groups = { "groupSearch" }, dataProvider = "SearchfromSearchByCatagoryPage", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchUsingSearchByCatagory_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifySearchUsingSearchByCatagory(n1, n2);
	}

	@Test(groups = { "groupSearch" }, dataProvider = "RefineSearchFormPage", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyRefineSearchFormPage_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyRefineSearchFormPage(n1, n2);
	}

	@Test(groups = { "groupSearch" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyRefineSearchResultPage_Authenticate()
			throws IOException {
		MWTest.TC_VerifyRefineSearchResultPage();
	}

	@Test(groups = { "groupMyPlaces" }, dataProvider = "MyPlaceTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMyPlaceTextResultPageUIObject_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyMyPlaceTextResultPageUIObject_Authenticate(n1, n2);
	}

	@Test(groups = { "groupSavedAndRecent" }, dataProvider = "MyPlaceTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifySavedAndRecentFormPageUIObject_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyMyPlaceTextResultPageUIObject_Authenticate(n1, n2);
	}

	@Test(groups = { "groupSavedAndRecent" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchFormRecentLocation_Authenticate()
			throws IOException {
		MWTest.TC_VerifySearchFormRecentLocation();
	}

	@Test(groups = { "groupSavedAndRecent" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionFormRecentLocation_Authenticate()
			throws IOException {
		MWTest.TC_VerifyDirectionFormRecentLocation();
	}

	@Test(groups = { "groupSavedAndRecent" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapFormRecentLocation_Authenticate()
			throws IOException {
		MWTest.TC_VerifyMapFormRecentLocation();
	}

	@Test(groups = { "groupAmbiguity" }, dataProvider = "AmbiguityPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionFormAmbiguityPage_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionFormAmbiguityPage(n1, n2);
	}

	@Test(groups = { "groupAmbiguity" }, dataProvider = "AmbiguityPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapFormAmbiguityPage_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyMapFormAmbiguityPage(n1, n2);
	}

	@Test(groups = { "groupAmbiguity" }, dataProvider = "AmbiguityPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchFormAmbiguityPage_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifySearchFormAmbiguityPage(n1, n2);
	}

	@Test(groups = { "groupGeodiff" }, dataProvider = "GeoDiffPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionFormGepDiffPage_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionFormGepDiffPage(n1, n2);
	}

	@Test(groups = { "groupGeodiff" }, dataProvider = "GeoDiffPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapFormGeoDiffPage_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyMapFormGeoDiffPage(n1, n2);
	}

	@Test(groups = { "groupGeodiff" }, dataProvider = "GeoDiffPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchFormGeoDiffPage_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifySearchFormGeoDiffPage(n1, n2);
	}

	@Test(groups = { "groupGeodiff" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionSearchAmbiguityAndGeodiff_Authenticate() {
		MWTest.TC_VerifyDirectionSearchAmbiguityAndGeodiff();
	}

	@Test(groups = { "groupGeodiff" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapSearchfromAmbiguityPage_Authenticate() {
		MWTest.TC_VerifyMapSearchfromAmbiguityPage();
	}

	@Test(groups = { "groupGeodiff" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapSearchformGeoDiffPage_Authenticate() {
		MWTest.TC_VerifyMapSearchformGeoDiffPage();
	}

	@Test(groups = { "groupGeodiff" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyBusinessSearchfromAmbiguityPage_Authenticate()
			throws IOException {
		MWTest.TC_VerifyBusinessSearchfromAmbiguityPage();
	}

	@Test(groups = { "groupGeodiff" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyBusinessSearchfromGeodiffPage_Authenticate() {
		MWTest.TC_VerifyBusinessSearchfromGeodiffPage();
	}

	// Creator @ Amitha
	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionspagewithstartlocation_Authenticate() {
		MWTest.TC_VerifyDirectionspagewithstartlocation();
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerfifyDirectionspagewithoutlocation_Authenticate() {
		MWTest.TC_VerfifyDirectionspagewithoutlocation();
	}

	@Test(groups = { "groupSAR" }, dataProvider = "NearALocationUIObject", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyNearaLocationpageUIObject_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyNearaLocationpageUIObject(n1, n2);
	}

	@Test(groups = { "groupSAR" }, dataProvider = "DirectionsBusinessSearchResultsUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionsBusinessSearchResultspageUI_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionsBusinessSearchResultspageUI(n1, n2);
	}

	@Test(groups = { "groupSAR" }, dataProvider = "DirectionsTextResultwith3pointsUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionTextResultswith3routespageUI_Authenticate(
			String[] n1, String[] n2) throws IOException {
		MWTest.TC_VerifyDirectionTextResultswith3routespageUI(n1, n2);
	}

	@Test(groups = { "groupSAR" }, dataProvider = "AlongtheRouteUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyAlongtheRoutepageUI_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyAlongtheRoutepageUI(n1, n2);
	}

	@Test(groups = { "groupSAR" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyAlongtheRoutepagefunctionality_Authenticate()
			throws IOException {
		MWTest.TC_VerifyAlongtheRoutepagefunctionality();
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "authenticate" })
	public void TC_VerifyRecalculateRouteOptions_Authenticate()
			throws IOException {
		MWTest.TC_VerifyRecalculateRouteOptions();
	}

	@Test(groups = { "groupDirection" }, dataProvider = "RouteOptionsUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "authenticate" })
	public void TC_VerifyRouteOptionsPopupPage_Authenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyRouteOptionsPopupPage(n1, n2);
	}
	

	@Test(groups = { "groupTraffic" },dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionsTraffic_Authenticate() throws Exception {
		MWTest.TC_VerifyTrafficInDirectionsPage();
	}
	
	@Test(groups = { "groupTraffic" },dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapTraffic_Authenticate() throws Exception {
		MWTest.TC_VerifyTrafficInMapPage();
	}
	
	@Test(groups = { "groupTraffic" },dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchTraffic_Authenticate() throws Exception {
		MWTest.TC_VerifyTrafficInSearchPage();
	}
	
	
	@Test(groups = { "groupDirectionZoom" },dependsOnGroups = { "authenticate" })
	public void TC_VerifyZoomFuncForDirections_Authenticate() throws Exception {
		MWTest.TC_VerifyZoomFuncForDirections();
	}
	
	
	
	
	
	
}
