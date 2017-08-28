package com.aol.functest.mobileweb.std.test;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aol.functest.common.browserpage;
import com.aol.functest.mobileweb.std.common.MobileWeb;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceTextResultStd;
import com.aol.functest.mobileweb.std.data.Dataprovider;
import com.mapquest.util.Logger;

public class MobileWebTestStdUnAuthenticate {

	private static Logger LOGGER = Logger.getLogger(MobileWebTestStdUnAuthenticate.class);

	private browserpage page;
	private MobileWebTestStd MWTestStd;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		MobileWeb.getInstance().setUp();
		page = MobileWeb.getInstance().getPage();
		MWTestStd = new MobileWebTestStd();
		MWTestStd.setPage(page);
	}

	@AfterClass (alwaysRun = true)
	public void cleanUp() 
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
		//page = MobileWeb.getInstance().getPage();
		LOGGER.debug("ack - retrieved mobileWebBaseState ");
	}

	@Test (groups = {"unauthenticate"})
	public void unAuthenticate (){
		    LOGGER.debug("Running in UnAuthenticated Mode");
			if (MobileWeb.getInstance().isAuthenticated()) {			
				MyPlaceTextResultStd.getInstance(page).SignOut.click();
				page.waitForElement(MyPlaceFormPageStd.getInstance(page).Signout.getWindowID());
				assertFalse (MobileWeb.getInstance().isAuthenticated(), "Verifying Unauthentication");
			}
			
	} // End of unAuthenticate () Method

	@Test(groups = { "DirectionsStd" }, dataProvider = "DirectionFormPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyDirectionFormPageStdUIObject_UnAuthenticate(
			String[] n1, String[] n2) throws IOException {
		MWTestStd.TC_VerifyDirectionFormPageStdUIObject(n1, n2);
	}

	@Test(groups = { "DirectionsStd" }, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyDirectionspageStdwithstartlocation_UnAuthenticate() {
		MWTestStd.TC_VerifyDirectionspageStdwithstartlocation();
	}

	@Test(groups = { "DirectionsStd" }, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyDirectionspagewithoutlocation_UnAuthenticate() {
		MWTestStd.TC_VerifyDirectionspagewithoutlocation();
	}

	@Test(groups = { "DirectionsStd" }, dataProvider = "RouteOptionsPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyRouteOptionsPageUIStd_UnAuthenticate(String[] n1,
			String[] n2) throws IOException {
		MWTestStd.TC_VerifyRouteOptionsPageUIStd(n1, n2);
	}

	@Test(groups = { "DirectionsStd" }, dataProvider = "DirectionResultPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyDirectionResultPageUIStd_UnAuthenticate(String[] n1,
			String[] n2) throws IOException {
		MWTestStd.TC_VerifyDirectionResultPageUIStd(n1, n2);
	}

	@Test(groups = { "DirectionsStd" }, dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyChangeRouteOptionsFunctionality_UnAuthenticate() {
		MWTestStd.TC_VerifyChangeRouteOptionsFunctionality();
	}
	
	
	
	
	/**
	 * Below testcases are merging from Kartheek
	 */


	@Test(groups={"DirectionsStd"}, dataProvider="NearALocationStdPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_NearALocationStdUI_UnAuthenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_NearALocationStdUI(n1, n2);
	}

	@Test(groups={"DirectionsStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyFindBusinessNearbyFunctionality_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyFindBusinessNearbyFunctionalitydirpage();
	}

	@Test(groups={"DirectionsStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyViewTrafficFunctionality_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyViewTrafficFunctionality();
	}

	@Test(groups={"DirectionsStd"}, dataProvider="DirResultPageMap", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirResultPageMapObjectStd_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyDirResultPageMapObjectStd(n1, n2);
	}

	@Test(groups={"MapsStd"}, dataProvider="MapFormPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapFormPageUIStd_UnAuthenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMapFormPageUIStd(n1, n2);
	}

	@Test(groups={"MapsStd"}, dataProvider="MapResultPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapResultPageUIStd_UnAuthenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMapResultPageUIStd(n1, n2);
	}

	@Test(groups={"MapsStd"}, dataProvider="MapResultPageMapElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapResultPageMapObjectStd_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMapResultPageMapObjectStd(n1, n2);
	}


	@Test(groups={"MapsStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyFindBizNearbymapspage_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyFindBizNearbymapspageUnAuth();
	}

	@Test(groups={"MapsStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyFindBusinessNearbyFunctionalitymappage_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyFindBusinessNearbyFunctionalitymappage();
	}

	@Test(groups={"MapsStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyGetDirectionFromHeremapspage_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyGetDirectionFromHeremapspage ();
	}

	@Test(groups={"MapsStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyGetDirectionToHeremapspage_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyGetDirectionToHeremapspage ();
	}

	@Test(groups={"SearchStd"}, dataProvider="FindBusinessPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormPageStdUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifySearchFormPageStdUIObject (n1, n2);
	}

	@Test(groups={"SearchStd"}, dataProvider="CategorysearchPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyCategorySearchFormPageUIObject_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyCategorySearchFormPageUIObject(n1, n2);
	}

	@Test(groups={"SearchStd"}, dataProvider="SearchResultsPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchUsingSearchByCategoryStd_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifySearchResultsSearchByCategoryStd (n1, n2);
	}

	@Test(groups={"SearchStd"}, dataProvider="RefinesearchpageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyRefineSearchFormPage_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyRefineSearchFormPage (n1, n2);
	}

	@Test(groups={"SearchStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyRefineSearchResultPage_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyRefineSearchResultPage ();
	}

	@Test(groups={"SearchStd"}, dataProvider="SearchResultsPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchResultsSearchFormPageStd_UnAuthenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifySearchResultsfromSearchFormPageStd (n1, n2);
	}

	@Test(groups={"SavedandRecentStd"}, dataProvider="SavedandRecentPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySavedAndRecentFormPageUIObjectStd_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifySavedAndRecentFormPageUIObjectStd (n1, n2);
	}

	@Test(groups={"SavedandRecentStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormPageRecentLocationStd_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifySearchFormPageRecentLocationStd ();
	}

	@Test(groups={"SavedandRecentStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionFormPageRecentLocationStd_UNAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyDirectionFormPageRecentLocationStd ();
	}

	@Test(groups={"SavedandRecentStd"}, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapFormpageRecentLocationStd_UnAuthenticate() throws IOException
	{
	MWTestStd.TC_VerifyMapFormpageRecentLocationStd ();
	}

	@Test(groups={"MyPlaceStd"}, dataProvider="MyPlaceFormPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMyPlacesFormPageStd_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMyPlacesFormPageStd (n1, n2);
	}

	@Test(groups={"MyPlaceStd"}, dataProvider="MyPlaceFormPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMyPlaceTextResultPageUIObjectStd_UnAuthenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMyPlaceTextResultPageUIObjectStd (n1, n2);
	}

	@Test(groups={"AmbiguityStd"}, dataProvider="AmbiguityPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionFormAmbiguityPageStd_UnAuthenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifyDirectionFormAmbiguityPageStd (n1, n2);
	}

	@Test(groups={"AmbiguityStd"}, dataProvider="AmbiguityPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapFormAmbiguityPageStd_UnAuthenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifyMapFormAmbiguityPageStd (n1, n2);
	}

	@Test(groups={"AmbiguityStd"}, dataProvider="AmbiguityPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormAmbiguityPageStd_UnAuthenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifySearchFormAmbiguityPageStd (n1, n2);
	}

	@Test(groups={"GeodiffStd"}, dataProvider="GeoDiffPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionFormGeoDiffPageStd_UnAuthenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifyDirectionFormGeoDiffPageStd (n1, n2);
	}

	@Test(groups={"GeodiffStd"}, dataProvider="GeoDiffPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapFormGeoDiffPageStd_UnAuthenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifyMapFormGeoDiffPageStd (n1, n2);
	}

	@Test(groups={"GeodiffStd"}, dataProvider="GeoDiffPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"unauthenticate"})
	public void TC_VerifySearchFormGeoDiffPageStd_UnAuthenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifySearchFormGeoDiffPageStd (n1, n2);
	}

	@Test(groups={"GeodiffStd"},dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyDirectionSearchAmbiguityAndGeodiffStd_UnAuthenticate ()
	{
		MWTestStd.TC_VerifyDirectionSearchAmbiguityAndGeodiffStd();
	}


	@Test(groups={"GeodiffStd"},dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapSearchfromAmbiguityPageStd_UnAuthenticate () 
	{
		MWTestStd.TC_VerifyMapSearchfromAmbiguityPageStd();
	}


	@Test(groups={"GeodiffStd"} ,dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyMapSearchformGeoDiffPageStd_UnAuthenticate () 
	{
		MWTestStd.TC_VerifyMapSearchformGeoDiffPageStd();
	}


	@Test(groups={"AmbiguityStd"},dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyBusinessSearchfromAmbiguityPageStd_UnAuthenticate () throws IOException 
	{
	  MWTestStd.TC_VerifyBusinessSearchfromAmbiguityPageStd();	
	}


	@Test(groups={"AmbiguityStd"},dependsOnGroups = {"unauthenticate"})
	public void TC_VerifyBusinessSearchfromGeodiffPageStd_UnAuthenticate () 
	{	
		MWTestStd.TC_VerifyBusinessSearchfromGeodiffPageStd();  
	}

	@Test(groups = { "TrafficStd" },dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyDirectionsTraffic_UnAuthenticate() throws Exception {
		MWTestStd.TC_VerifyTrafficInDirectionsPageStd();
	}
	
	@Test(groups = { "TrafficStd" },dependsOnGroups = { "unauthenticate" })
	public void TC_VerifyMapTraffic_UnAuthenticate() throws Exception {
		MWTestStd.TC_VerifyTrafficInMapPageStd();
	}
	
	@Test(groups = { "TrafficStd" },dependsOnGroups = { "unauthenticate" })
	public void TC_VerifySearchTraffic_UnAuthenticate() throws Exception {
		MWTestStd.TC_VerifyTrafficInSearchPageStd();
	}

}