package com.aol.functest.mobileweb.std.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aol.functest.common.browserpage;
import com.aol.functest.mobileweb.std.common.MobileWeb;
import com.aol.functest.mobileweb.std.common.uiobjects.DirectionFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceFormPageStd;
import com.aol.functest.mobileweb.std.data.Dataprovider;
import com.mapquest.util.Logger;


public class MobileWebTestStdAuthenticate {	

	private static Logger LOGGER = Logger.getLogger(MobileWebTestStdAuthenticate.class);

	private browserpage page;
	protected MobileWebTestStd MWTestStd;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		MobileWeb.getInstance().setUp();
		page = MobileWeb.getInstance().getPage();
		MWTestStd = new MobileWebTestStd();
		MWTestStd.setPage(page);
	}

	@AfterClass (alwaysRun = true)
	public void cleanUp () 
	{
		MobileWeb.getInstance().mobileWebBaseState();
		MobileWeb.getInstance().unAuthenticate();	
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

	@Test (groups = {"authenticate"}) 	
	public void authenticate1 () 
	{
		    LOGGER.debug("Running in Authenticated Mode");	
			// Checking if the application is already Authenticated with given user. 
			if (!MobileWeb.getInstance().isAuthenticated("test")) {			 
				 MobileWeb.getInstance().unAuthenticate();			 
				 DirectionFormPageStd.getInstance(page).Mapquest.click();
				 page.waitForPageToLoad (page.sTIMEOUT);		
				// page.click(DirectionFormPage.getInstance(page).Menu.getWindowID());
				 DirectionFormPageStd.getInstance(page).MyPlaces_Link.click();
				 page.waitForPageToLoad (page.sTIMEOUT);		
				 String ScreenName = "test4200";
				 String Password   = "giri_12";
				 MyPlaceFormPageStd.getInstance(page).ScreenName.setText(ScreenName);
				 MyPlaceFormPageStd.getInstance(page).Password.setText(Password);		
				 MyPlaceFormPageStd.getInstance(page).SignIn.click();
			     page.waitForPageToLoad (page.sTIMEOUT);	
			     assertTrue (MobileWeb.getInstance().isAuthenticated("test"));
			}	
	} // End of authenticate () Method.
	

	//Below testcases are merging from Kartheek	
	
	
	@Test(groups={"DirectionsStd"}, dataProvider ="DirectionFormPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirectionFormPageStdUIObject_Authenticate (String[] n1, String[] n2) throws IOException
	{
			MWTestStd.TC_VerifyDirectionFormPageStdUIObject (n1, n2);
	}
	@Test(groups={"DirectionsStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirectionspageStdwithstartlocation_Authenticate ()
	{
			MWTestStd.TC_VerifyDirectionspageStdwithstartlocation ();
	}


	@Test(groups={"DirectionsStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirectionspagewithoutlocation_Authenticate ()
	{
			MWTestStd.TC_VerifyDirectionspagewithoutlocation ();
	}

	@Test(groups={"DirectionsStd"}, dataProvider="RouteOptionsPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyRouteOptionsPageUIStd_Authenticate (String[] n1, String[] n2) throws IOException
	{
			MWTestStd.TC_VerifyRouteOptionsPageUIStd(n1, n2);
	}

	@Test(groups={"DirectionsStd"}, dataProvider="DirectionResultPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirectionResultPageUIStd_Authenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyDirectionResultPageUIStd(n1, n2);
	}

	@Test(groups={"DirectionsStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyChangeRouteOptionsFunctionality_Authenticate()
	{
	MWTestStd.TC_VerifyChangeRouteOptionsFunctionality();
	}

	@Test(groups={"DirectionsStd"}, dataProvider="NearALocationStdPageUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_NearALocationStdUI_Authenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_NearALocationStdUI(n1, n2);
	}

	@Test(groups={"DirectionsStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyFindBusinessNearbyFunctionality_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyFindBusinessNearbyFunctionalitydirpage();
	}

	@Test(groups={"DirectionsStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyViewTrafficFunctionality_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyViewTrafficFunctionality();
	}

	@Test(groups={"DirectionsStd"}, dataProvider="DirResultPageMap", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirResultPageMapObjectStd_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyDirResultPageMapObjectStd(n1, n2);
	}

	@Test(groups={"MapsStd"}, dataProvider="MapFormPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyMapFormPageUIStd_Authenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMapFormPageUIStd(n1, n2);
	}

	@Test(groups={"MapsStd"}, dataProvider="MapResultPageStdUIElementAuth", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyMapResultPageUIStd_Authenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMapResultPageUIStd(n1, n2);
	}

	@Test(groups={"MapsStd"}, dataProvider="MapResultPageMapElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyMapResultPageMapObjectStd_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMapResultPageMapObjectStd(n1, n2);
	}

	@Test(groups={"MapsStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyFindBizNearbymapspage_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyFindBizNearbymapspageAuth();
	}

	@Test(groups={"MapsStd"},  dependsOnGroups = {"authenticate"})
	public void TC_VerifyFindBusinessNearbyFunctionalitymappage_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyFindBusinessNearbyFunctionalitymappage();
	}

	@Test(groups={"MapsStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyGetDirectionFromHeremapspage_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyGetDirectionFromHeremapspage ();
	}

	@Test(groups={"MapsStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyGetDirectionToHeremapspage_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyGetDirectionToHeremapspage ();
	}

	@Test(groups={"SearchStd"}, dataProvider="FindBusinessPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifySearchFormPageStdUIObject_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifySearchFormPageStdUIObject (n1, n2);
	}

	@Test(groups={"SearchStd"}, dataProvider="CategorysearchPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyCategorySearchFormPageUIObject_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyCategorySearchFormPageUIObject(n1, n2);
	}

	@Test(groups={"SearchStd"}, dataProvider="SearchResultsPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifySearchResultsSearchByCategoryStd_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifySearchResultsSearchByCategoryStd (n1, n2);
	}

	@Test(groups={"SearchStd"}, dataProvider="RefinesearchpageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyRefineSearchFormPage_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyRefineSearchFormPage (n1, n2);
	}

	@Test(groups={"SearchStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyRefineSearchResultPage_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyRefineSearchResultPage ();
	}

	@Test(groups={"SearchStd"}, dataProvider="SearchResultsPageStdUIElement", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifySearchResultsSearchFormPageStd_Authenticate(String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifySearchResultsfromSearchFormPageStd (n1, n2);
	}

	@Test(groups={"SavedandRecentStd"}, dataProvider="SavedandRecentPageStdUIElementAuth", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifySavedAndRecentFormPageUIObjectStd_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifySavedAndRecentFormPageUIObjectStd (n1, n2);
	}

	@Test(groups={"SavedandRecentStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifySearchFormPageRecentLocationStd_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifySearchFormPageRecentLocationStdAuth ();
	}

	@Test(groups={"SavedandRecentStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirectionFormPageRecentLocationStd_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyDirectionFormPageRecentLocationStdAuth ();
	}

	@Test(groups={"SavedandRecentStd"}, dependsOnGroups = {"authenticate"})
	public void TC_VerifyMapFormpageRecentLocationStd_Authenticate() throws IOException
	{
	MWTestStd.TC_VerifyMapFormpageRecentLocationStdAuth ();
	}

	@Test(groups={"MyPlaceStd"}, dataProvider="MyPlaceFormPageStd", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyMyPlacesFormPageStd_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMyPlacesFormPageStd (n1, n2);
	}

	@Test(groups={"MyPlaceStd"}, dataProvider="MyPlaceTextResultStd", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyMyPlaceTextResultPageUIObjectStd_Authenticate (String[] n1, String[] n2) throws IOException
	{
	MWTestStd.TC_VerifyMyPlaceTextResultPageUIObjectStd (n1, n2);
	}

	@Test(groups={"AmbiguityStd"}, dataProvider="AmbiguityPageStdUIElementAuth", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirectionFormAmbiguityPageStd_Authenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifyDirectionFormAmbiguityPageStd (n1, n2);
	}

	@Test(groups={"AmbiguityStd"}, dataProvider="AmbiguityPageStdUIElementAuth", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyMapFormAmbiguityPageStd_Authenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifyMapFormAmbiguityPageStd (n1, n2);
	}

	@Test(groups={"AmbiguityStd"}, dataProvider="AmbiguityPageStdUIElementAuth", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifySearchFormAmbiguityPageStd_Authenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifySearchFormAmbiguityPageStd (n1, n2);
	}

	@Test(groups={"GeodiffStd"}, dataProvider="GeoDiffPageUIElementAuth", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirectionFormGeoDiffPageStd_Authenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifyDirectionFormGeoDiffPageStd (n1, n2);
	}

	@Test(groups={"GeodiffStd"}, dataProvider="GeoDiffPageUIElementAuth", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifyMapFormGeoDiffPageStd_Authenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifyMapFormGeoDiffPageStd (n1, n2);
	}

	@Test(groups={"GeodiffStd"}, dataProvider="GeoDiffPageUIElementAuth", dataProviderClass = Dataprovider.class, dependsOnGroups = {"authenticate"})
	public void TC_VerifySearchFormGeoDiffPageStd_Authenticate (String[] n1, String[] n2)throws IOException
	{
		MWTestStd.TC_VerifySearchFormGeoDiffPageStd (n1, n2);
	}

	@Test(groups={"GeodiffStd"},dependsOnGroups = {"authenticate"})
	public void TC_VerifyDirectionSearchAmbiguityAndGeodiffStd_Authenticate ()
	{
		MWTestStd.TC_VerifyDirectionSearchAmbiguityAndGeodiffStdAuth();
	}


	@Test(groups={"GeodiffStd"},dependsOnGroups = {"authenticate"})
	public void TC_VerifyMapSearchfromAmbiguityPageStd_Authenticate () 
	{
		MWTestStd.TC_VerifyMapSearchfromAmbiguityPageStdAuth();
	}


	@Test(groups={"GeodiffStd"} ,dependsOnGroups = {"authenticate"})
	public void TC_VerifyMapSearchformGeoDiffPageStd_Authenticate () 
	{
		MWTestStd.TC_VerifyMapSearchformGeoDiffPageStdAuth();
	}


	@Test(groups={"AmbiguityStd"},dependsOnGroups = {"authenticate"})
	public void TC_VerifyBusinessSearchfromAmbiguityPageStd_Authenticate () throws IOException 
	{
	  MWTestStd.TC_VerifyBusinessSearchfromAmbiguityPageStdAuth();	
	}


	@Test(groups={"AmbiguityStd"},dependsOnGroups = {"authenticate"})
	public void TC_VerifyBusinessSearchfromGeodiffPageStd_Authenticate () 
	{	
		MWTestStd.TC_VerifyBusinessSearchfromGeodiffPageStdAuth();  
	}

	
	@Test(groups = { "TrafficStd" },dependsOnGroups = { "authenticate" })
	public void TC_VerifyDirectionsTraffic_Authenticate() throws Exception {
		MWTestStd.TC_VerifyTrafficInDirectionsPageStd();
	}
	
	@Test(groups = { "TrafficStd" },dependsOnGroups = { "authenticate" })
	public void TC_VerifyMapTraffic_Authenticate() throws Exception {
		MWTestStd.TC_VerifyTrafficInMapPageStd();
	}
	
	@Test(groups = { "TrafficStd" },dependsOnGroups = { "authenticate" })
	public void TC_VerifySearchTraffic_Authenticate() throws Exception {
		MWTestStd.TC_VerifyTrafficInSearchPageStd();
	}


}
