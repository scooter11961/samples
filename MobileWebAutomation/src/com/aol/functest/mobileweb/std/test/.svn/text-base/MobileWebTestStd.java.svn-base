package com.aol.functest.mobileweb.std.test;
/**
 *	This class defines testcases
 *	@version 1.0
 *	@author Amitha
 */


import static com.aol.functest.common.assertsoft.assertEmpty;
import static com.aol.functest.common.assertsoft.verifyAndContinue;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.aol.functest.common.browserpage;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionTextResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapTestResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.SearchFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.SearchTextResult;
import com.aol.functest.mobileweb.std.common.uiobjects.DirectionFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.DirectionResultPageUIStd;
import com.aol.functest.mobileweb.std.common.uiobjects.RouteOptionsPageUIStd;
import com.aol.functest.mobileweb.std.common.uiobjects.AmbiguityPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.AmbiguityPageStdAuth;
import com.aol.functest.mobileweb.std.common.uiobjects.CategorySearchFormPage;
import com.aol.functest.mobileweb.std.common.uiobjects.FindaBusinessFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.GeoDiffPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.GeoDiffPageStdAuth;
import com.aol.functest.mobileweb.std.common.uiobjects.MapFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MapResutPageUIStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceTextResultStd;
import com.aol.functest.mobileweb.std.common.uiobjects.RefineSearchStd;
import com.aol.functest.mobileweb.std.common.uiobjects.SavedandRecentStd;
import com.aol.functest.mobileweb.std.common.uiobjects.SavedandRecentStdAuth;
import com.aol.functest.mobileweb.std.common.uiobjects.SearchResultsPageUIStd;
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
public class MobileWebTestStd {

	private static Logger LOGGER = Logger.getLogger(MobileWebTestStd.class);

	public static String pRoot; 
	private browserpage page;

	public MobileWebTestStd() {
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
	public void validate(String[] n1, String[] n2)
	{
		for(int count=0;count<n2.length;count++)
		{ 		  

			if(n2[count].equals("Text"))
			{		   
				LOGGER.debug("Verifying Text - "+n1[count]);
				verifyAndContinue((page.isTextPresent(n1[count])),"Verifying\""+n1[count]+"\" failed");
			}
			else 
			{	
				if(n2[count].equals(""))
				{
					LOGGER.debug("Verifying XPath - "+n1[count]);
					verifyAndContinue((page.isElementPresent(n1[count])),"Verifying\""+n1[count]+"\" failed");
				}
				else
				{			  
					LOGGER.debug("Verifying XPath - "+n1[count]);
					verifyAndContinue((page.isElementPresent(n1[count])),"Verifying\""+n1[count]+"\"failed");
					LOGGER.debug("Inner Text of the XPath- "+n2[count]);
					verifyAndContinue(page.getText(n1[count]).equals(n2[count]),"Verifying\""+n1[count]+"\"" + "text failed");
				}
			}      
		}
		assertEmpty();
	}

	/* ** DIRECTION FORM ** */

	/**
	 * verify the UI Element of the directions form page
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyDirectionFormPageStdUIObject (String[] n1, String[] n2)
	{		
		LOGGER.debug("Testcase To Verify UI Objects In Direction Form Page");
		DirectionFormPageStd.getInstance(page).Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		validate(n1, n2);
	}

	//Comments
	/* Test Case to verify Directions page with only start location */
	//@Amitha

	public void TC_VerifyDirectionspageStdwithstartlocation ()
	{
		LOGGER.debug("Test Case to verify Directions page with only start location");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver,CO"); 
		page.waitForPageToLoad (page.sTIMEOUT);

		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();

	}
	//Comments
	/* Test Case to verify Directions page without start and end locations */
	//@Amitha
	public void TC_VerifyDirectionspagewithoutlocation ()
	{
		LOGGER.debug("Test Case to verify Directions page without any  location");
		DirectionFormPageStd.getInstance(page).go.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "Please enter a location";
		verifyAndContinue((page.isTextPresent(Value)), "Verifying\""+Value+"\"");
		assertEmpty();
	}

	//Comments
	/* Test Case to verify Route Options page UI */
	//@Amitha

	public void TC_VerifyRouteOptionsPageUIStd(String[] n1, String[] n2)
	{
		LOGGER.debug("Test Case to verify UI Elements in Route Options Page");
		DirectionFormPageStd.getInstance(page).Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		DirectionFormPageStd.getInstance(page).RouteOptions.click();
		validate(n1, n2);
	}

	//Comments
	/* Test Case to verify Directions Result page UI */
	//@Amitha
	public void TC_VerifyDirectionResultPageUIStd(String[] n1, String[] n2)
	{
		LOGGER.debug("Testcase to verify UI Elements in Direction Result Page");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver, CO", "Parker, CO");
		page.waitForPageToLoad(page.sTIMEOUT);
		validate(n1, n2);
	}

	//Comments
	/* Test Case to verify Change route Options functionality */
	//@Amitha

	public void TC_VerifyChangeRouteOptionsFunctionality()
	{
		LOGGER.debug(new StringBuilder("Testcase to verify Change Route Options Functionality, page: ").append(page.toString()).toString());
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver, CO", "Parker, CO");
		page.waitForPageToLoad(page.sTIMEOUT);
		String data1 = "Total Est. Time: 34 mins";
		LOGGER.debug("Verifying travel estimate with shortest Driving time");
		verifyAndContinue((page.isTextPresent(data1)),"Verifying\""+data1+"\"");
		DirectionResultPageUIStd.getInstance(page).Change_Route_Options.click();
		page.waitForPageToLoad(page.sTIMEOUT);
		RouteOptionsPageUIStd.getInstance(page).Shortest_Driving_time.isChecked();
		LOGGER.debug("Shortest Driving time radio button is checked or unchecked");
		RouteOptionsPageUIStd.getInstance(page).Shortest_Driving_time.uncheck();
		LOGGER.debug("unchecking shortest driving time radio button");
		RouteOptionsPageUIStd.getInstance(page).Shortest_Driving_Distance.check();
		LOGGER.debug("Shortest Driving Distance route options should be checked");
		RouteOptionsPageUIStd.getInstance(page).Go_Button.click();
		page.waitForPageToLoad(page.sTIMEOUT);
		String data2 = "Total Est. Time: 38 mins";
		LOGGER.debug("Verifying travel estimate with shortest Driving Distance");
		verifyAndContinue((page.isTextPresent(data2)),"Verifying\""+data2+"\"");
		LOGGER.debug("Travel distance should be different if the route options are changed");	

	}


	/**
	 * merged testcases from Kartheek.
	 * @param n1
	 * @param n2
	 */
	/* ** DIRECTION FORM ** */

	//Comments

	public void TC_NearALocationStdUI(String[] n1, String[] n2)
	{
		System.out.println("Testcase to verify Near A Location Page UI after clicking on find biz(any category)Nearby in Direction Result Page");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver, CO", "Parker, CO");
		String FindBizNearByL = DirectionResultPageUIStd.getInstance(page).FindBizNearByL.getText();  
		String Biz = FindBizNearByL.substring((5), (FindBizNearByL.length()-7)); 
		DirectionResultPageUIStd.getInstance(page).FindBizNearByL.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		validate(n1, n2);
		verifyAndContinue((page.isTextPresent(Biz)),"Verifying\""+Biz+"\"");
	}

	public void TC_VerifyFindBusinessNearbyFunctionalitydirpage()
	{
		System.out.println("Testcase to verify Find Business Near By Functionality from directions result page");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver, CO", "Parker, CO");
		page.waitForPageToLoad (page.sTIMEOUT);
		DirectionResultPageUIStd.getInstance(page).FindBusinessNearbyL.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String data = "Find a Business";
		System.out.println("Verifying for Find a Business Text in the page");
		verifyAndContinue((page.isTextPresent(data)),"Verifying\""+data+"\"");
	}

	public void TC_VerifyViewTrafficFunctionality()
	{
		System.out.println("Testcase to verify view traffic functionality");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver, CO", "Parker, CO");
		page.waitForPageToLoad (page.sTIMEOUT);
		DirectionResultPageUIStd.getInstance(page).ViewTraffic.click();
		String data = "Turn Traffic Off";
		verifyAndContinue((page.isTextPresent(data)),"Verifying\""+data+"\"");
	}

	/*MAP FORM PAGE */

	public void TC_VerifyMapFormPageUIStd(String[] n1, String[] n2)
	{
		System.out.println("Testcase to verify Map Form Page UI Objects");
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		validate(n1, n2);
	}

	public void TC_VerifyMapResultPageUIStd(String[] n1, String[] n2)
	{
		System.out.println("Test case to verify map a location functionality and Ui objects in Map Result Page");
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		MapFormPageStd.getInstance(page).SearchMap("Denver, CO");
		String location = "Denver, CO";
		verifyAndContinue((page.isTextPresent(location)), "Verifying\""+location+"\"");
		validate(n1, n2);
	}

	public void TC_VerifyMapResultPageMapObjectStd (String[] n1, String[] n2) throws IOException 
	{		
		System.out.println("Testcase To Verify Map tiles In Map Result Page");
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		MapFormPageStd.getInstance(page).SearchMap("Denver, CO");
		String act_fileName="" ;
		String exp_fileName= "";
		for (int count=0;count<=n1.length-1;count++){	  
			act_fileName = page.sPROJECTROOT + "/testdata/map_std/"+"act_"+n1[count];
			exp_fileName = page.sPROJECTROOT + "/testdata/map_std/"+n1[count];	  
			page.saveImagefromURL(n2[count],act_fileName,"");	  
			verifyAndContinue (page.imageCompare(act_fileName, exp_fileName,100), "Comparision between "+act_fileName+" and "+exp_fileName+" failed or file doesn't exists....");
		}  
		assertEmpty(); 
	}	

	public void TC_VerifyDirResultPageMapObjectStd (String[] n1, String[] n2) throws IOException 
	{		
		System.out.println("Testcase To Verify Map tiles In Dir Result Page");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver, CO", "Parker, CO");
		String act_fileName="" ;
		String exp_fileName= "";
		for (int count=0;count<=n1.length-1;count++)
		{	  
			act_fileName = page.sPROJECTROOT + "/testdata/dir_std/"+"act_"+n1[count];
			exp_fileName = page.sPROJECTROOT + "/testdata/dir_std/"+n1[count];	  
			page.saveImagefromURL(n2[count],act_fileName,"");	  
			verifyAndContinue (page.imageCompare(act_fileName, exp_fileName,100), "Comparision between "+act_fileName+" and "+exp_fileName+" failed or file doesn't exists....");
		}  
		assertEmpty(); 
	}

	/* Test case to verify Find Biz Nearby functionality and from there results page */ 

	public void TC_VerifyFindBizNearbymapspageAuth() throws IOException
	{
		System.out.println("Testcase to verify Find Biz Near by in maps page");
		MapFormPageStd.getInstance(page).SearchMap("Denver, CO");
		System.out.println("Test");
		String FindBizLocNearby = MapResutPageUIStd.getInstance(page).FindBizLocNearby.getText(); 
		System.out.println("FindBizLocNearby=" +FindBizLocNearby);
		String Biz = FindBizLocNearby.substring((5), (FindBizLocNearby.length()-7));  
		System.out.println("Biz="+ Biz);
		MapResutPageUIStd.getInstance(page).FindBizLocNearby.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		verifyAndContinue((page.isTextPresent(Biz)),"Verifying\""+Biz+"\"");
		assertEmpty(); 
	}
	/* Test case to verify Find Biz Nearby functionality and from there results page */ 

	public void TC_VerifyFindBizNearbymapspageUnAuth() throws IOException
	{
		System.out.println("Testcase to verify Find Biz Near by in maps page");
		MapFormPageStd.getInstance(page).SearchMap("Denver, CO");
		System.out.println("Test");
		String FindBizLocNearby = MapResutPageUIStd.getInstance(page).FindBizLocNearby.getText(); 
		System.out.println("FindBizLocNearby=" +FindBizLocNearby);
		String Biz = FindBizLocNearby.substring((5), (FindBizLocNearby.length()-7));  
		System.out.println("Biz="+ Biz);
		MapResutPageUIStd.getInstance(page).FindBizLocNearby.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		verifyAndContinue((page.isTextPresent(Biz)),"Verifying\""+Biz+"\"");
		assertEmpty(); 
	}


	public void TC_VerifyFindBusinessNearbyFunctionalitymappage() throws IOException
	{
		System.out.println("Testcase to verify Find Business Near By Functionality from maps result page");
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		MapFormPageStd.getInstance(page).SearchMap("Denver, CO");
		MapResutPageUIStd.getInstance(page).FindBusinessNearby.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String data = "Find a Business";
		String data1 = "Select Business Or Category";
		System.out.println("Verifying for Find a Business Text in the page");
		verifyAndContinue((page.isTextPresent(data)),"Verifying\""+data+"\"");
		System.out.println("Verifying for Select Business or Category Text in the page");
		verifyAndContinue((page.isTextPresent(data1)),"Verifying\""+data1+"\"");
	}

	/**
	 * Part 1 : It will verify clicking of 2nd navigation link "Get Directions From Here" in Map result page
	 * Part 2: Testcase To Verify direction search initiated from link \"Get Directions From Here\" in Map result page
	 * 
	 */
	public void TC_VerifyGetDirectionFromHeremapspage ()  
	{		
		System.out.println("Part 1: Testcase To Verify first navigation link \"Get Directions From Here\" in Text result page");
		MapFormPageStd.getInstance(page).SearchMap("Denver,CO");
		MapResutPageUIStd.getInstance(page).GetDirFromHere.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		String Value= DirectionFormPageStd.getInstance(page).StartLocation.getText(); 
		verifyAndContinue((Value.equals("Denver, CO")),"Verifying\""+Value+"\"");
		assertEmpty();
		System.out.println("Part 2: Testcase To Verify direction search initiated from link \"Get Directions From Here\" in Text result page");
		DirectionFormPageStd.getInstance(page).EndLocation.setText("Parker, CO");
		DirectionFormPageStd.getInstance(page).go.click();
		page.waitForPageToLoad (page.sTIMEOUT);       
		verifyAndContinue((page.isElementPresent(DirectionResultPageUIStd.getInstance(page).map_image.getWindowID())),"");
		assertEmpty();  
	}

	/**
	 * Part 1: It will verify clicking of 2nd navigation link "Get Directions To Here" in Map result page
	 * Part 2: Testcase To Verify direction search initiated from link \"Get Directions To Here\" in Map result page" 
	 * 
	 */
	public void TC_VerifyGetDirectionToHeremapspage ()
	{		
		System.out.println("Testcase To Verify first navigation link \"Get Directions To Here\" in Text result page");
		MapFormPageStd.getInstance(page).SearchMap("Denver,CO");
		MapResutPageUIStd.getInstance(page).GetDirToHere.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		String Value= DirectionFormPageStd.getInstance(page).EndLocation.getText();       
		verifyAndContinue((Value.equals("Denver, CO")),"Verifying\""+Value+"\"");
		assertEmpty();
		System.out.println("Part 2: Testcase To Verify direction search initiated from link \"Get Directions To Here\" in Text result page");
		DirectionFormPageStd.getInstance(page).StartLocation.setText("Parker, CO");
		DirectionFormPageStd.getInstance(page).go.click();
		page.waitForPageToLoad (page.sTIMEOUT);       
		verifyAndContinue((page.isElementPresent(DirectionResultPageUIStd.getInstance(page).map_image.getWindowID())),"");
		assertEmpty(); 
	}


	/************************/
	/* ** Search FORM Page ** */
	/************************/

	/**
	 * verify the UI Element of the search form page.
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifySearchFormPageStdUIObject (String[] n1, String[] n2)  
	{		
		System.out.println("Testcase To Verify UI Objects In Search Form Page");
		DirectionFormPageStd.getInstance(page).Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT);  
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);  
		validate(n1, n2);
	}
	/* ********************* */
	/* Category Search Form Page   */
	/* ********************* */

	/* Comments */
	/* It will verify the UI Element of this page 
	 */	

	public void TC_VerifyCategorySearchFormPageUIObject (String[] n1, String[] n2)
	{
		System.out.println("Testcase to verify UI objects In Category Search Form Page");
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);  
		FindaBusinessFormPageStd.getInstance(page).Search_by_Categories.click();
		page.waitForPageToLoad (page.sTIMEOUT);  
		validate(n1, n2);
	}/**
	 * verify the Search Results Page Using Search By Category page 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifySearchResultsSearchByCategoryStd (String[] n1, String[] n2) 
	{		
		System.out.println("Testcase To Verify UI Objects In Search Result Page, searching by category page");
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		FindaBusinessFormPageStd.getInstance(page).Search_by_Categories.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		CategorySearchFormPage.getInstance(page).GasStation_L.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String MapAdd = "Denver,CO";
		FindaBusinessFormPageStd.getInstance(page).Near.setText(MapAdd);		
		FindaBusinessFormPageStd.getInstance(page).Search.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		validate(n1, n2);
	}

	public void TC_VerifySearchResultsfromSearchFormPageStd (String[] n1, String[] n2) 
	{		
		System.out.println("Testcase To Verify UI Objects In Search Result Page, searching by find a business page");
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("pizza", "Denver, CO");
		validate(n1, n2);
	}


	/* ********************* */
	/* Saved & Recent Form   */
	/* ********************* */

	/* Comments */
	/* It will verify the UI Element of this page 
	 */	

	public void TC_VerifySavedAndRecentFormPageUIObjectStd (String[] n1, String[] n2)  
	{		
		DirectionFormPageStd.getInstance(page).Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver, CO", "Parker, Co");
		DirectionResultPageUIStd.getInstance(page).Home_link.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		DirectionFormPageStd.getInstance(page).V_EndLocation.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		System.out.println("Verifying Saved & Recent page invoked from Direction form page");
		validate(n1, n2);
		DirectionFormPageStd.getInstance(page).Mapquest.click();

		page.waitForPageToLoad (page.sTIMEOUT);	
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		MapFormPageStd.getInstance(page).V_EnterLocation.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		System.out.println("Verifying Saved & Recent page invoked from Map Search page");
		validate(n1, n2); 
		DirectionFormPageStd.getInstance(page).Mapquest.click();	
		page.waitForPageToLoad (page.sTIMEOUT);	
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		FindaBusinessFormPageStd.getInstance(page).V_Near.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		System.out.println("Verifying Saved & Recent page invoked from Find a Business page");
		validate(n1, n2); 	
	}


	/* Comments */
	/* It will Recent Location in Search form page
	 */	

	public void TC_VerifySearchFormPageRecentLocationStd () 
	{		
		System.out.println("Testcase To Verify Recent Location in Search form page");
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);       
		String Search = "Pizza";	
		String MapAdd = "Newyork,NY";
		FindaBusinessFormPageStd.getInstance(page).Enter_Search_Term.setText(Search);
		FindaBusinessFormPageStd.getInstance(page).Near.setText(MapAdd);		
		FindaBusinessFormPageStd.getInstance(page).Search.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		SearchResultsPageUIStd.getInstance(page).Home.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		FindaBusinessFormPageStd.getInstance(page).V_Near.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "New York, NY";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();

	}	


	//Check Start & End Address Recent location.
	public void TC_VerifyDirectionFormPageRecentLocationStd () 
	{		
		System.out.println("Testcase To Verify Start Address Recent location");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver,CO","Parker,CO");	  
		SavedandRecentStd.getInstance(page).Home.click();
		page.waitForPageToLoad (page.sTIMEOUT);	 
		DirectionFormPageStd.getInstance(page).V_StartLocation.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		String Rdata = "Denver, CO";
		verifyAndContinue((page.isTextPresent(Rdata)),"Verifying\""+Rdata+"\" failed"); 
		Rdata = "Parker, CO";  
		verifyAndContinue((page.isTextPresent(Rdata)),"Verifying\""+Rdata+"\" failed");  
		assertEmpty();
	}


	/* Comments */
	/* It will verify the Recent location in Maps form page
	 */	

	public void TC_VerifyMapFormpageRecentLocationStd ()
	{		
		System.out.println("Testcase To Verify Recent location in Maps form page");
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);       
		String MapAdd = "Seattle,WA";			
		MapFormPageStd.getInstance(page).EnterLocation.setText(MapAdd);		
		MapFormPageStd.getInstance(page).Go.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		MapResutPageUIStd.getInstance(page).Home.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		MapFormPageStd.getInstance(page).V_EnterLocation.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		String Value = "Seattle, WA";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();
	}	

	/* Comments */
	/* It will Recent Location in Search form page
	 */	

	public void TC_VerifySearchFormPageRecentLocationStdAuth () 
	{		
		System.out.println("Testcase To Verify Recent Location in Search form page");
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);       
		String Search = "Pizza";	
		String MapAdd = "Newyork,NY";
		FindaBusinessFormPageStd.getInstance(page).Enter_Search_Term.setText(Search);
		FindaBusinessFormPageStd.getInstance(page).Near.setText(MapAdd);		
		FindaBusinessFormPageStd.getInstance(page).Search.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		SearchResultsPageUIStd.getInstance(page).Home.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		FindaBusinessFormPageStd.getInstance(page).V_Near.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		SavedandRecentStdAuth.getInstance(page).Recents.click();
		String Value = "New York, NY";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();

	}	


	//Check Start & End Address Recent location.
	public void TC_VerifyDirectionFormPageRecentLocationStdAuth () 
	{		
		System.out.println("Testcase To Verify Start Address Recent location");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver,CO","Parker,CO");	  
		SavedandRecentStd.getInstance(page).Home.click();
		page.waitForPageToLoad (page.sTIMEOUT);	 
		DirectionFormPageStd.getInstance(page).V_StartLocation.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		SavedandRecentStdAuth.getInstance(page).Recents.click();
		String Rdata = "Denver, CO";
		verifyAndContinue((page.isTextPresent(Rdata)),"Verifying\""+Rdata+"\" failed"); 
		Rdata = "Parker, CO";  
		verifyAndContinue((page.isTextPresent(Rdata)),"Verifying\""+Rdata+"\" failed");  
		assertEmpty();
	}


	/* Comments */
	/* It will verify the Recent location in Maps form page
	 */	

	public void TC_VerifyMapFormpageRecentLocationStdAuth ()
	{		
		System.out.println("Testcase To Verify Recent location in Maps form page");
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);       
		String MapAdd = "Seattle,WA";			
		MapFormPageStd.getInstance(page).EnterLocation.setText(MapAdd);		
		MapFormPageStd.getInstance(page).Go.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		MapResutPageUIStd.getInstance(page).Home.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		MapFormPageStd.getInstance(page).V_EnterLocation.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		SavedandRecentStdAuth.getInstance(page).Recents.click();
		String Value = "Seattle, WA";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();
	}

	/************************/
	/* ** MyPlace FORM ** */
	/************************/	

	/**
	 * verify the UI Element of the MyPlace form
	 * @param n1
	 * @param n2
	 */

	public void TC_VerifyMyPlacesFormPageStd (String[] n1, String[] n2)
	{
		System.out.println("Testcase to Verify My Places form Page");
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);       
		validate(n1, n2);
	}

	/**
	 * verify the UI Element of the MyPlace TEXT RESULT
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMyPlaceTextResultPageUIObjectStd (String[] n1, String[] n2)
	{		
		System.out.println("Testcase To Verify UI Objects In MyPlace Result Page");
		DirectionFormPageStd.getInstance(page).MyPlaces_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);		
		String ScreenName = "test4200";
		String Password   = "giri_12";
		MyPlaceFormPageStd.getInstance(page).ScreenName.setText(ScreenName);
		MyPlaceFormPageStd.getInstance(page).Password.setText(Password);		
		MyPlaceFormPageStd.getInstance(page).SignIn.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		validate(n1, n2);        
		System.out.println("Doing Sign-Off");
		MyPlaceTextResultStd.getInstance(page).SignOut.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		assertEmpty();      
	}

	/**
	 * verify the Refine Search Page UI 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyRefineSearchFormPage (String[] n1, String[] n2) 
	{		
		System.out.println("Testcase To Verify the Refine Search Page UI ");
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("Pizza","Denver,CO");
		SearchResultsPageUIStd.getInstance(page).Refine_Search.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		validate(n1, n2);
	}

	/**
	 * verify the Refine Search Results Page UI 
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyRefineSearchResultPage () 
	{		
		System.out.println("Testcase To Verify the Refine Search functionality");
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("Pizza","Denver,CO");
		SearchResultsPageUIStd.getInstance(page).Refine_Search.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		RefineSearchStd.getInstance(page).Mile10.click();
		RefineSearchStd.getInstance(page).Loc1.click();
		RefineSearchStd.getInstance(page).UpdateSearch.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		verifyAndContinue((page.isTextPresent("pizza")),"");
		verifyAndContinue((page.isTextPresent("Denver, CO")),"");
		verifyAndContinue((page.isTextPresent("Arvada, CO")),"");
		assertEmpty();     
	} 

	//New test case in business PC

	/**
	 * verify the UI elements of the MyPlace TEXT RESULT
	 * @param n1
	 * @param n2
	 */
	public void TC_VerifyMyPlaceTextResultPageUIObjectStd_Authenticate (String[] n1, String[] n2)
	{
		System.out.println("Testcase To Verify UI Objects In MyPlace Text Result Page");
		DirectionFormPageStd.getInstance(page).Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT);		
		DirectionFormPageStd.getInstance(page).MyPlaces_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		validate(n1, n2);
		assertEmpty();
	}

	/* ******************* */
	/* Ambiguity Page      */
	/********************* */

	/* Comments */
	/* It will verify the UI of the ambiguity page generated from Direction Search
	 */

	public void TC_VerifyDirectionFormAmbiguityPageStd (String[] n1, String[] n2)
	{		
		System.out.println("Testcase To Verify UI Objects In Direction Text Result Ambiguity Page");	   	
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver");	  
		validate(n1, n2);  
	}



	/* Comments */
	/* It will verify the UI of the ambiguity page generated from Map Search
	 */

	public void TC_VerifyMapFormAmbiguityPageStd (String[] n1, String[] n2)
	{		
		System.out.println("Testcase To Verify UI Objects In Map Text Result Ambiguity Page");
		MapFormPageStd.getInstance(page).SearchMap("Denver");	
		validate(n1, n2);  
	}



	/* Comments */
	/* It will verify the UI of the ambiguity page generated from Business Search Page
	 */

	public void TC_VerifySearchFormAmbiguityPageStd (String[] n1, String[] n2) throws IOException 
	{		
		System.out.println("Testcase To Verify UI Objects In Search Text Result Ambiguity Page");
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("Pizza","Denver");	
		validate(n1, n2);
	}


	/* ******************* */
	/* Geodiff Page      */
	/********************* */

	/* Comments */
	/* It will verify the UI of the GeoDiff page generated from Direction Search
	 */

	public void TC_VerifyDirectionFormGeoDiffPageStd (String[] n1, String[] n2) 
	{		
		System.out.println("Testcase To Verify UI Objects In Direction Text Result Geodiff Page");	  	    	
		DirectionFormPageStd.getInstance(page).SearchDirection("Denvre,CA");  
		validate(n1, n2);  
	}


	/* Comments */
	/* It will verify the UI of the GeoDiff page generated from Map Search
	 */


	public void TC_VerifyMapFormGeoDiffPageStd (String[] n1, String[] n2) 
	{		
		System.out.println("Testcase To Verify UI Objects In Map Text Result Geodiff Page");
		MapFormPageStd.getInstance(page).SearchMap("Denvre,CA");
		validate(n1, n2);  
	}


	/* Comments */
	/* It will verify the UI of the GeoDiff page generated from Business Search
	 */

	public void TC_VerifySearchFormGeoDiffPageStd (String[] n1, String[] n2) 
	{		
		System.out.println("Testcase To Verify UI Objects In Search Text Result Geodiff Page");
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("Pizza","Denvre,CA");
		validate(n1, n2);
	}


	/* *********************************** */
	/* *** GeoDiff & Ambiguity Search  *** */
	/* *********************************** */

	/* Comments */
	/* It will verify the Direction Search generated from a Ambiguous Start and Geodiffed End Location
	 */

	@Test(groups={"groupGeodiff"})
	public void TC_VerifyDirectionSearchAmbiguityAndGeodiffStd ()
	{		
		System.out.println("Testcase To Verify the Direction Search generated from a Ambiguous Start and Geodiffed End Location");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver","Denvre,CA");
		AmbiguityPageStd.getInstance(page).Result1.click(); 
		page.waitForPageToLoad (page.sTIMEOUT);
		GeoDiffPageStd.getInstance(page).Suggestion.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();
	}



	/* Comments */
	/* It will verify the Map Search generated from Ambiguity page
	 */

	public void TC_VerifyMapSearchfromAmbiguityPageStd () 
	{		
		System.out.println("Testcase To Verify Map Search from Ambiguity Page");
		MapFormPageStd.getInstance(page).SearchMap("Denver");	
		AmbiguityPageStd.getInstance(page).Result1.click();  
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();      
	}


	/* Comments */
	/* It will verify the Map Search generated from GeoDiff page
	 */

	public void TC_VerifyMapSearchformGeoDiffPageStd () 
	{		
		System.out.println("Testcase To Verify the Map Search generated from GeoDiff page");
		MapFormPageStd.getInstance(page).SearchMap("Denvre,CA");
		GeoDiffPageStd.getInstance(page).Suggestion.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();

	}



	/* Comments */
	/* It will verify the Business Search generated from Ambiguity page
	 */

	public void TC_VerifyBusinessSearchfromAmbiguityPageStd ()
	{		
		System.out.println("Testcase To Verify Business Search generated from Ambiguity page");
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("Pizza","Denver");
		AmbiguityPageStd.getInstance(page).Result1.click();  
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty(); 
	}


	/* Comments */
	/* It will verify the Business Search generated from GeoDiff page
	 */


	public void TC_VerifyBusinessSearchfromGeodiffPageStd () 
	{		
		System.out.println("Testcase To Verify Business Search from GeoDiff Page");
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("Pizza","Denvre,CA");
		GeoDiffPageStd.getInstance(page).Suggestion.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();
	}


	/* *********************************** */
	/* *** GeoDiff & Ambiguity Search  *** */
	/* *********************************** */

	/* Comments */
	/* It will verify the Direction Search generated from a Ambiguous Start and Geodiffed End Location
	 */

	@Test(groups={"groupGeodiff"})
	public void TC_VerifyDirectionSearchAmbiguityAndGeodiffStdAuth ()
	{		
		System.out.println("Testcase To Verify the Direction Search generated from a Ambiguous Start and Geodiffed End Location");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver","Denvre,CA");
		AmbiguityPageStdAuth.getInstance(page).Result1.click(); 
		page.waitForPageToLoad (page.sTIMEOUT);
		GeoDiffPageStdAuth.getInstance(page).Suggestion.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();
	}



	/* Comments */
	/* It will verify the Map Search generated from Ambiguity page
	 */

	public void TC_VerifyMapSearchfromAmbiguityPageStdAuth () 
	{		
		System.out.println("Testcase To Verify Map Search from Ambiguity Page");
		MapFormPageStd.getInstance(page).SearchMap("Denver");	
		AmbiguityPageStdAuth.getInstance(page).Result1.click();  
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();      
	}


	/* Comments */
	/* It will verify the Map Search generated from GeoDiff page
	 */

	public void TC_VerifyMapSearchformGeoDiffPageStdAuth () 
	{		
		System.out.println("Testcase To Verify the Map Search generated from GeoDiff page");
		MapFormPageStd.getInstance(page).SearchMap("Denvre,CA");
		GeoDiffPageStdAuth.getInstance(page).Suggestion.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();

	}



	/* Comments */
	/* It will verify the Business Search generated from Ambiguity page
	 */

	public void TC_VerifyBusinessSearchfromAmbiguityPageStdAuth ()
	{		
		System.out.println("Testcase To Verify Business Search generated from Ambiguity page");
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("Pizza","Denver");
		AmbiguityPageStdAuth.getInstance(page).Result1.click();  
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "Denver";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		Value = "CO";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty(); 
	}


	/* Comments */
	/* It will verify the Business Search generated from GeoDiff page
	 */


	public void TC_VerifyBusinessSearchfromGeodiffPageStdAuth () 
	{		
		System.out.println("Testcase To Verify Business Search from GeoDiff Page");
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("Pizza","Denvre,CA");
		GeoDiffPageStdAuth.getInstance(page).Suggestion.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		String Value = "CA";
		verifyAndContinue((page.isTextPresent(Value)),"Verifying\""+Value+"\"");
		assertEmpty();
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
	public void TC_VerifyTrafficInDirectionsPageStd() throws Exception{
		System.out.println(" in TC_VerifyTrafficInDirectionsPageStdAuth method");
		DirectionFormPageStd.getInstance(page).SearchDirection("Denver, CO", "Parker, CO");
		page.waitForPageToLoad (page.sTIMEOUT);
		DirectionResultPageUIStd.getInstance(page).ViewTraffic.click();
		Thread.sleep(10000);
		Assert.assertTrue("Fail:Traffic is not shown on the map:",validateTrafficImage());
		
	}
	
	/**
	 * Verify the traffic image in Map page.
	 * @throws Exception
	 */
	public void TC_VerifyTrafficInMapPageStd() throws Exception{
		System.out.println("in TC_VerifyTrafficInMapPageStdAuth method");
		DirectionFormPageStd.getInstance(page).Map_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);
		MapFormPageStd.getInstance(page).SearchMap("Denver, CO");
		page.waitForPageToLoad (page.sTIMEOUT);
		DirectionResultPageUIStd.getInstance(page).ViewTraffic.click();
		Thread.sleep(10000);
		Assert.assertTrue("Fail:Traffic is not shown on the map:",validateTrafficImage());
		
	}
	
	public void TC_VerifyTrafficInSearchPageStd() throws Exception{
		System.out.println("in TC_VerifyTrafficInSearchPageStdAuth method");
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
		FindaBusinessFormPageStd.getInstance(page).FindBusiness("pizza", "Denver, CO");
		page.waitForPageToLoad (page.sTIMEOUT);	
		DirectionResultPageUIStd.getInstance(page).ViewTraffic.click();
		Thread.sleep(10000);
		Assert.assertTrue("Fail:Traffic is not shown on the map::",validateTrafficImage());
	}
	
	
	
	/**
	 * Verify the Traffic image appears on the Map or not.
	 */
	public boolean validateTrafficImage() throws Exception {
		return page.isElementPresent("css=img[alt='map']");
		//return page.isElementPresent("//div[1]/img");
	}
	
	

}

