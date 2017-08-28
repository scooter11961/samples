package com.aol.functest.mobileweb.adv.test;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aol.functest.common.browserpage;
import com.aol.functest.mobileweb.adv.common.MobileWeb;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceTextResult;
import com.aol.functest.mobileweb.adv.data.Dataprovider;
import com.mapquest.util.Logger;

public class MobileWebTestUnAuthenticate {

	private static Logger LOGGER = Logger.getLogger(MobileWebTestUnAuthenticate.class);

	private browserpage page;
	protected MobileWebTest MWTest;

	@BeforeClass(alwaysRun = true)
	public void setup() 
	{
		MobileWeb.getInstance().setUp();
		page = MobileWeb.getInstance().getPage();
		MWTest = new MobileWebTest();
		MWTest.setPage(page);
	}

	@AfterClass (alwaysRun = true)
	public void cleanUp () 
	{
		MobileWeb.getInstance().mobileWebBaseState();	
	}

	/* Comments */
	/* It will run the base state * 
	*/
	@BeforeMethod (alwaysRun = true)
	public void basestate () 
	{
		LOGGER.debug("ack - getting mobileWebBaseState ");
		MobileWeb.getInstance().mobileWebBaseState();
		LOGGER.debug("ack - retrieved mobileWebBaseState ");
	}

	@Test (groups = {"unauthenticate"})
	public void unAuthenticate (){
		    LOGGER.debug("Running in UnAuthenticated Mode");
			if (MobileWeb.getInstance().isAuthenticated()) {			
				MyPlaceTextResult.getInstance(page).SignOut.click();
				page.waitForElement(MyPlaceFormPage.getInstance(page).Signout.getWindowID());
				assertFalse (MobileWeb.getInstance().isAuthenticated(), "Verifying Unauthentication");
			}
			
	} // End of unAuthenticate () Method

	@Test(groups={"groupDirection"}, dataProvider ="DirectionFormPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionFormPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException{
		MWTest.TC_VerifyDirectionFormPageUIObject (n1, n2);
	}
	
	

	@Test(groups={"groupDirection"}, dataProvider ="DirectionTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionTextResultPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifyDirectionTextResultPageUIObject(n1,n2); 
	}

	@Test(groups={"groupDirection"}, dataProvider ="DirectionMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapResultPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifyDirectionMapResultPageUIObject(n1,n2);
	}

	@Test(groups={"groupDirection"}, dataProvider ="DirectionMapResultPageMapElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"} )
	public void TC_VerifyDirectionMapResultPageMapObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyDirectionMapResultPageMapObject(n1,n2);
	}
	
	@Test(groups={"groupDirection"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapWithShortestTime_UnAuthenticate () throws IOException 
	{		
		MWTest.TC_VerifyDirectionMapWithShortestTime();
	}
	
	@Test(groups={"groupDirection"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapWithShortestDistance_UnAuthenticate () throws IOException 
	{
		MWTest.TC_VerifyDirectionMapWithShortestDistance();
	}

	@Test(groups={"groupDirection"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapWithWalkingDirection_UnAuthenticate () throws IOException 
	{		
	  MWTest.TC_VerifyDirectionMapWithWalkingDirection();
	}	

	@Test(groups={"groupDirection"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapWithAvoidHighways_UnAuthenticate () throws IOException 
	{		
	  MWTest.TC_VerifyDirectionMapWithAvoidHighways();
	}

	@Test(groups={"groupDirection"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapWithAvoidTollRoad_UnAuthenticate () throws IOException 
	{		
	  MWTest.TC_VerifyDirectionMapWithAvoidTollRoad();
	}

	@Test(groups={"groupDirection"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapWithAvoidSeasonallyClosedRoads_UnAuthenticate () throws IOException 
	{		
	  MWTest.TC_VerifyDirectionMapWithAvoidSeasonallyClosedRoads();
	}

	@Test(groups={"groupDirection"}, dataProvider ="DirectionMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapClickRoadNarative_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifyDirectionMapClickRoadNarative(n1,n2);
	}

	@Test(groups={"groupDirection"}, dataProvider ="DirectionMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionMapClickRoadshield_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifyDirectionMapClickRoadshield(n1,n2);
	}

	@Test(groups={"groupMaps"}, dataProvider ="MapFormPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapFormPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifyMapFormPageUIObject(n1,n2);
	}

	@Test(groups={"groupMaps"}, dataProvider ="MapTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapTextResultPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	       MWTest.TC_VerifyMapTextResultPageUIObject(n1,n2);  
	}

	@Test(groups={"groupMaps"}, dataProvider ="MapMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapMapResultPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifyMapMapResultPageUIObject(n1,n2);
	}

	@Test(groups={"groupMaps"}, dataProvider ="MapMapResultPageMapElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapMapResultPageMapObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyMapMapResultPageMapObject(n1,n2);
	}

	@Test(groups={"groupMaps"}, dataProvider ="MapMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapMapResultPageByThumbnailMap_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
	  MWTest.TC_VerifyMapMapResultPageByThumbnailMap(n1,n2);
	}

	@Test(groups={"groupMaps"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapMapResultPageFindXYZNearBy_UnAuthenticate () throws IOException 
	{		
	       MWTest.TC_VerifyMapMapResultPageFindXYZNearBy();
	}

	@Test(groups={"groupMaps"}, dataProvider ="BrandBizSearchPage", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapMapResultPageFindBusinessNearBy_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	       MWTest.TC_VerifyMapMapResultPageFindBusinessNearBy(n1,n2);
	}

	@Test(groups={"groupMaps"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapMapResultPageGetDirectionFromHere_UnAuthenticate () throws IOException 
	{		
	       MWTest.TC_VerifyMapMapResultPageGetDirectionFromHere();
	}

	@Test(groups={"groupMaps"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapMapResultPageGetDirectionToHere_UnAuthenticate () throws IOException 
	{		
	       MWTest.TC_VerifyMapMapResultPageGetDirectionToHere();
	}

	@Test(groups={"groupSearch"}, dataProvider ="SearchFormPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifySearchFormPageUIObject(n1,n2);
	}

	@Test(groups={"groupSearch"}, dataProvider ="SearchTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchTextResultPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifySearchTextResultPageUIObject(n1,n2);
	}

	@Test(groups={"groupSearch"}, dataProvider ="SearchMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchMapResultPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifySearchMapResultPageUIObject(n1,n2);
	}

	@Test(groups={"groupSearch"}, dataProvider ="SearchMapResultPageMapElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchMapResultPageMapObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{		
	  MWTest.TC_VerifySearchMapResultPageMapObject(n1,n2);
	}

	@Test(groups={"groupSearch"}, dataProvider ="BrandBizSearchPage", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormSearchByCatagory_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifySearchFormSearchByCatagory(n1,n2);
	}

	@Test(groups={"groupSearch"}, dataProvider ="MapTextResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_SearchMapResultPageUIFromSearchResultItemClick_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_SearchMapResultPageUIFromSearchResultItemClick(n1,n2);
	}

	@Test(groups={"groupSearch"}, dataProvider ="MapMapResultPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_SearchMapResultPageUIFromSearchResultGETMAPClick_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_SearchMapResultPageUIFromSearchResultGETMAPClick(n1,n2);
	}

	@Test(groups={"groupSearch"}, dependsOnGroups = {"unauthenticate"})
	public void TC_SearchMapResultPageUIFromSearchResultGETDirectionClick_UnAuthenticate () throws IOException 
	{		
	  MWTest.TC_SearchMapResultPageUIFromSearchResultGETDirectionClick();
	}

	@Test(groups={"groupSearch"}, dataProvider ="SearchfromSearchByCatagoryPage", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchUsingSearchByCatagory_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
	      MWTest.TC_VerifySearchUsingSearchByCatagory(n1,n2);
	}

	@Test(groups={"groupSearch"}, dataProvider ="RefineSearchFormPage", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyRefineSearchFormPage_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyRefineSearchFormPage(n1,n2);
	}
	
	@Test(groups={"groupSearch"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyRefineSearchResultPage_UnAuthenticate () throws IOException 
	{
		MWTest.TC_VerifyRefineSearchResultPage();
	}
	
	@Test(groups={"groupMyPlaces"}, dataProvider ="MyPlaceFormPageUIElement", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMyPlaceFormPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
	  MWTest.TC_VerifyMyPlaceFormPageUIObject(n1,n2);	
	}

	@Test(groups={"groupMyPlaces"}, dataProvider ="MyPlaceTextResultPageUIElement", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMyPlaceTextResultPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyMyPlaceTextResultPageUIObject(n1,n2);
	}

	@Test(groups={"groupSavedAndRecent"}, dataProvider ="Saved&RecentFormUIElement", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySavedAndRecentFormPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifySavedAndRecentFormPageUIObject(n1,n2);
	}

	@Test(groups={"groupSavedAndRecent"} , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormRecentLocation_UnAuthenticate () throws IOException 
	{
		MWTest.TC_VerifySearchFormRecentLocation();
	}

	@Test(groups={"groupSavedAndRecent"} , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionFormRecentLocation_UnAuthenticate () throws IOException 
	{
		MWTest.TC_VerifyDirectionFormRecentLocation();
	}

	@Test(groups={"groupSavedAndRecent"} , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapFormRecentLocation_UnAuthenticate () throws IOException 
	{
		MWTest.TC_VerifyMapFormRecentLocation();
	}

	@Test(groups={"groupAmbiguity"}, dataProvider ="AmbiguityPageUIElement", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionFormAmbiguityPage_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyDirectionFormAmbiguityPage(n1,n2);
	}

	@Test(groups={"groupAmbiguity"}, dataProvider ="AmbiguityPageUIElement", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapFormAmbiguityPage_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyMapFormAmbiguityPage(n1,n2);
	}

	@Test(groups={"groupAmbiguity"}, dataProvider ="AmbiguityPageUIElement", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormAmbiguityPage_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifySearchFormAmbiguityPage(n1,n2);
	}

	@Test(groups={"groupGeodiff"}, dataProvider ="GeoDiffPageUIElement", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionFormGepDiffPage_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyDirectionFormGepDiffPage(n1,n2);
	}

	@Test(groups={"groupGeodiff"}, dataProvider ="GeoDiffPageUIElement", dataProviderClass = Dataprovider.class , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapFormGeoDiffPage_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyMapFormGeoDiffPage(n1,n2);
	}

	@Test(groups={"groupGeodiff"}, dataProvider ="GeoDiffPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormGeoDiffPage_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifySearchFormGeoDiffPage(n1,n2);
	}

	@Test(groups={"groupGeodiff"} , dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionSearchAmbiguityAndGeodiff_UnAuthenticate ()
	{
		MWTest.TC_VerifyDirectionSearchAmbiguityAndGeodiff();
	}

	@Test(groups={"groupGeodiff"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapSearchfromAmbiguityPage_UnAuthenticate () 
	{
		MWTest.TC_VerifyMapSearchfromAmbiguityPage();
	}

	@Test(groups={"groupGeodiff"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapSearchformGeoDiffPage_UnAuthenticate () 
	{
		MWTest.TC_VerifyMapSearchformGeoDiffPage();
	}

	@Test(groups={"groupGeodiff"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyBusinessSearchfromAmbiguityPage_UnAuthenticate () throws IOException 
	{
	  MWTest.TC_VerifyBusinessSearchfromAmbiguityPage();	
	}

	@Test(groups={"groupGeodiff"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyBusinessSearchfromGeodiffPage_UnAuthenticate () 
	{	
		MWTest.TC_VerifyBusinessSearchfromGeodiffPage();  
	}

	// New Testcases creator @ Amitha	 
	@Test(groups={"groupDirection"},dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionspagewithstartlocation_UnAuthenticate ()
	{
		MWTest.TC_VerifyDirectionspagewithstartlocation();
	}
	
	@Test(groups={"groupDirection"},dependsOnGroups = {"unauthenticate"})
	public void TC_VerfifyDirectionspagewithoutlocation_UnAuthenticate ()
	{
		MWTest.TC_VerfifyDirectionspagewithoutlocation();
	}
	
	@Test(groups={"groupSAR"}, dataProvider ="NearALocationUIObject", dataProviderClass = Dataprovider.class,dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyNearaLocationandsearchresultspageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyNearaLocationpageUIObject(n1,n2);
	}
	
	@Test(groups={"groupSAR"}, dataProvider ="DirectionsBusinessSearchResultsUIElement", dataProviderClass = Dataprovider.class,dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionsBusinessSearchResultspageUI_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyDirectionsBusinessSearchResultspageUI(n1,n2);
	}
	
	@Test(groups={"groupSAR"}, dataProvider ="DirectionsTextResultwith3pointsUIElement", dataProviderClass = Dataprovider.class,dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionTextResultswith3routespageUI_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyDirectionTextResultswith3routespageUI(n1,n2);
	}
	
	@Test(groups={"groupSAR"}, dataProvider ="AlongtheRouteUIElement", dataProviderClass = Dataprovider.class,dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyAlongtheRoutepageUI_UnAuthenticate (String[] n1, String[] n2) throws IOException 
	{
		MWTest.TC_VerifyAlongtheRoutepageUI(n1,n2);
	}
	
	@Test(groups = { "groupSAR" }, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyAlongtheRoutepagefunctionality_UnAuthenticate()
			throws IOException {
		MWTest.TC_VerifyAlongtheRoutepagefunctionality();
	}

	@Test(groups = { "groupDirection" }, dataProvider = "RouteOptionsUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyRouteOptionsPopupPage_UnAuthenticate(String[] n1,
			String[] n2) throws IOException {
		MWTest.TC_VerifyRouteOptionsPopupPage(n1, n2);
	}

	@Test(groups = { "groupDirection" }, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyRecalculateRouteOptions_UnAuthenticate()
			throws IOException {
		MWTest.TC_VerifyRecalculateRouteOptions();
	}
	
	
	//Testcases for Validating My Maps menu option.
	@Test(groups={"MyMaps1"}, dataProvider ="MyFormLoginPage", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMyLoginFormPageObject_UnAuthenticate (String[] n1, String[] n2) throws IOException{
		MWTest.TC_VerifyMyLoginFormPageUIObject (n1, n2);
	}
	
	@Test(groups={"MyMaps1"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyAOLLoginCredentials_UnAuthenticate () throws Exception{
		MWTest.verifyUserCredentials("AOL","newmobiletest","mapquest123");
		MWTest.validateMsg("Hello newmobiletest");
	}
	
	@Test(groups={"MyMaps1"},  dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyGoogleLoginCredentials_UnAuthenticate () throws Exception{
		MWTest.verifyUserCredentials("GOOGLE","newmobiletest","mapquest123");
		MWTest.validateMsg("Hello newmobiletest");
	}
	
	@Test(groups={"MyMaps1"},  dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyTwitterLoginCredentials_UnAuthenticate () throws Exception{
		MWTest.verifyUserCredentials("TWITTER","newmobiletest","mapquest123");
		MWTest.validateMsg("Hello newmobiletest");
	}
	
	@Test(groups = { "groupTraffic" },dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyDirectionsTraffic_Authenticate() throws Exception {
		MWTest.TC_VerifyTrafficInDirectionsPage();
	}
	
	@Test(groups = { "groupTraffic" },dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyMapTraffic_Authenticate() throws Exception {
		MWTest.TC_VerifyTrafficInMapPage();
	}
	
	@Test(groups = { "groupTraffic" },dependsOnGroups = { "unauthenticate" })
	public void TC_VerifySearchTraffic_Authenticate() throws Exception {
		MWTest.TC_VerifyTrafficInSearchPage();
	}
	

}
