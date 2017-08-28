/**
*	This class defines data provider methods
*	@version 1.0
*	@author shiladitya
*/



package com.aol.functest.mobileweb.adv.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.aol.functest.mobileweb.adv.common.MobileWeb;
import com.aol.functest.mobileweb.adv.common.uiobjects.AlongtheRoute;
import com.aol.functest.mobileweb.adv.common.uiobjects.AmbiguityPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.BrandBizSearchPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionMapResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionTextResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionsBusinessSearchResultsPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionsTextresultwith3points;
import com.aol.functest.mobileweb.adv.common.uiobjects.GeoDiffPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapBusinessSearchResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapMapResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.MapTestResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyFormLoginPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceTextResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.NearALocation;
import com.aol.functest.mobileweb.adv.common.uiobjects.RefineSearch;
import com.aol.functest.mobileweb.adv.common.uiobjects.RouteOptionsPopup;
import com.aol.functest.mobileweb.adv.common.uiobjects.SavedAndRecent;
import com.aol.functest.mobileweb.adv.common.uiobjects.SearchFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.SearchMapResult;
import com.aol.functest.mobileweb.adv.common.uiobjects.SearchTextResult;


public class Dataprovider {  
	
	
/************************
// Supporting methods	
*************************/
	
	
/* Comments */
/* It will count the number of separator in a string 
*/	
	
public static int numberofSeperator(String actual, char seperator)
{
		String replace = "[^"+seperator+"]";
		int count = actual.replaceAll(replace,"").length();
		return count;
}

/* Comments */
/* Based on Separator it will divide a string into arrays 
*/

public static String[] generateArrayFromString(String actual, char seperator)
	{
	    String splitcon= "\\"+seperator;
		String retArray[]=actual.split(splitcon);
	    return retArray;
	}	
	

/* Comments */
/* It will generate a 2D array with UI objects and value from UI class.
*/

public static Object[][] getObjectUI(String abc[])
	{    
		
		int length, arraylength;
		length= abc.length;	
		arraylength= (length/2);
		
		String [] words= new String [arraylength];
		String [] values= new String [arraylength];		
		
		int temp1=0;
		for (int temp=0; temp<(length/2); temp++)
		{
			words[temp]=abc[temp1];
			values[temp]=abc[temp1+1];
			temp1=temp1+2;			
		}			
		
		return new Object[][] 
        { 				  
	         {words , values }, 				    				   
		};			 	
	}
	

/* Comments */
/* It will generate a array of Text strings from Data.txt based variable name. 
*/
	
public static Object[][] getObjectText(String propertyName)
	{
		Properties dataproperty = new Properties ();
		try{		
			    dataproperty.load (new FileInputStream ("testdata/data.txt"));						
				String[] words = generateArrayFromString(dataproperty.getProperty(propertyName), ';');
				String Type="";
				return new Object[][] 
		        { 				  
			         {Type, words }, 				    				   
				};			
		 }
		 catch (IOException e){
					System.out.println (e);	
					return null;
		 }		
	}

/* Comments */
/* It will generate a array of image names from an array length. 
*/

public static String[] genArray(String type, int limit)
{
	String[] name= new String [limit];
	for (int count=0;count<limit;count++)
	{
	  name[count]= type+"_"+Integer.toString(count)+".gif";
	}
	return name;
}

/* Comments */
/* It will generate a 2d array of image names & src from an array length & data.txt. 
*/

public static Object[][] getMapUI(String type, String propertyName)
{
	Properties dataproperty = new Properties ();
	try{		
		    dataproperty.load (new FileInputStream ("testdata/data.txt"));						
			String[] words = generateArrayFromString(dataproperty.getProperty(propertyName), ';');
			String[] name= genArray(type,words.length);
			return new Object[][] 
	        { 				  
		         {name, words}, 				    				   
			};			
	 }
	 catch (IOException e){
				System.out.println (e);	
				return null;
	 }		
}


/*******************************************************************************************************/


/************************
// Data provider methods	
*************************/
	
	
	
/*****************************/	
/* ** DIRECTION FORM PAGE ** */	
/*****************************/


/* Comments */
/* This array will provide test data to advance browsers Direction form page.
*  It is passing UI objects & their respective Class name* 
*/
	
static String [] data={
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).StartLocation.getWindowID()              ,"",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).EndLocation.getWindowID()                ,"",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).V_StartLocation.getWindowID()            ,"",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).V_EndLocation.getWindowID()              ,"",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).RouteOption.getWindowID()                ,"",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).getDirection.getWindowID()               ,"",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()                   ,"",
		                    //DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).Mq4m.getWindowID()                       ,"MapQuest 4 Mobile",
		                   //   DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).MqNav.getWindowID()                      ,"MapQuest Navigator",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()                       ,"Menu",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).ShortestTime.getWindowID()               ,"Shortest Time",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).ShortestDistence.getWindowID()           ,"Shortest Distance",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).WalkingDirections.getWindowID()          ,"Walking Directions",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).AvoidHighways.getWindowID()              ,"Avoid Highways",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).AvoidTollRoads.getWindowID()             ,"Avoid Toll Roads",
		                      DirectionFormPage.getInstance(MobileWeb.getInstance().getPage()).AvoidSeasonallyClosedRoads.getWindowID() ,"Avoid Seasonally Closed Roads",
		                      "Get Directions"                                           ,"Text",
		                      "Start"                                                    ,"Text",
		                      "End"                                                      ,"Text",
		                      "(optional)"                                               ,"Text",
		                     // "Download"                                                 ,"Text",
		                      "or"                                                       ,"Text",
		                     // "for your phone"                                           ,"Text",
		                      "Options"                                                  ,"Text",
		              };
	
/* Comments */
/* This Data provider method will provide test data for all UI objects in Direction form page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "DirectionFormPageUIElement")
public static Object[][] getObjectDirectionFormUI() 
 {		   
    return getObjectUI(data);	
 }

	

/*  * ** DIRECTION TEXT RESULT PAGE    **  */

/* Comments */
/* This array will provide test data to advance browsers Direction Text Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data1={
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).ShowMap.getWindowID()                                            , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()                                           , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()                                               , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Start_Star.getWindowID()                                         , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).End_Star.getWindowID()                                           , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_1.getWindowID()                                          , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_2.getWindowID()                                          , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_3.getWindowID()                                          , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_4.getWindowID()                                          , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_5.getWindowID()                                          , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_6.getWindowID()                                          , "",
	      // DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_7.getWindowID()                                          , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).footer.getWindowID()                                             , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).FindBusinessNearbyI.getWindowID()                                , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchBusinessNearbyI.getWindowID()                              , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).FindBusinessNearbyL.getWindowID()                                , "",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchBusinessNearbyL.getWindowID()                              , "Search Businesses Nearby",
	       DirectionTextResult.getInstance(MobileWeb.getInstance().getPage()).Options.getWindowID()											  , "",
	       "Start:"                                                                             , "Text",
	       "Denver"                                                                             , "Text",
	       "CO"                                                                                 , "Text",
	       "End:"                                                                               , "Text",
	       "Parker"                                                                             , "Text",
	       "CO"                                                                                 , "Text",
	       "Directions"                                                                         , "Text",
	       "Travel Estimate:"                                                                   , "Text",
	       "35 mins / 25.55 mi"                                                                 , "Text",
	       "Denver"                                                                             , "Text",
	       "CO"                                                                                 , "Text",
	       "Parker"                                                                             , "Text",
	       "CO"                                                                                 , "Text",
	       "1. Start out going SOUTH on SHERMAN ST toward E COLFAX AVE/I-70-BL/US-287/US-40."   , "Text",
	       "0 mi"                                                                               , "Text",
	       "2. Turn RIGHT onto E COLFAX AVE/I-70-BL W/US-287 W/US-40 W."                        , "Text",
	       "1.4 mi"                                                                             , "Text",
	       "3. Merge onto I-25 S/US-87 S toward COLO SPGS."                                     , "Text",
	       "15.9 mi"                                                                            , "Text",
	       "4. Merge onto E-470 N via EXIT 194 toward LIMON (Portions toll)."                  , "Text",
	       "5.4 mi"                                                                               , "Text",
	       "5. Merge onto S PARKER RD/CO-83 S via EXIT 5."                                      , "Text",
	       "2.6 mi"                                                                             , "Text",
	       "6. Turn LEFT onto E MAINSTREET/CR-8 E."                                             , "Text",
	       "0.2 mi"                                                                             , "Text",
	       "Results are informational only with no warranties of any kind. You assume all risk of use. MapQuest and its suppliers shall not be liable for any loss or delay resulting from your use of MapQuest. Your use means you agree to our" , "Text",
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Direction Text Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "DirectionTextResultPageUIElement")
public static Object[][] getObjectDirectionTextResultPageUI() 
 {		   
    return getObjectUI(data1);			
 } 
	
	

/* * *DIRECTION4 MAP RESULT PAGE * */


/* Comments */
/* This array will provide test data to advance browsers Direction Map Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data2={
	       DirectionMapResult.getInstance(MobileWeb.getInstance().getPage()).Plus.getWindowID()  ,"",
	       DirectionMapResult.getInstance(MobileWeb.getInstance().getPage()).Minus.getWindowID() ,"",
	       DirectionMapResult.getInstance(MobileWeb.getInstance().getPage()).View.getWindowID()  ,"",
	       DirectionMapResult.getInstance(MobileWeb.getInstance().getPage()).close.getWindowID() ,"",	       	       
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Direction Map Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "DirectionMapResultPageUIElement")
public static Object[][] getObjectDirectionMapResultPageUI() 
 {		   
    return getObjectUI(data2);			
 } 

/*
 * The Data provider method will provide the URLs to fetch map components
 * 
*/

@DataProvider(name = "DirectionMapResultPageMapElement")
public static Object[][] getObjectDirectionMapResultMapUI() 
 {		   
    return getMapUI("dir","Data.Direction_Map_UI");			
 } 	


/*****************************/
/* ** Map FORM PAGE       ** */	
/*****************************/



/* Comments */
/* This array will provide test data to advance browsers Map form page.
*  It is passing UI objects & their respective Class name* 
*/
	
static String [] data3={
		                      MapFormPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()        ,"",
		                      MapFormPage.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()            ,"",
		                      MapFormPage.getInstance(MobileWeb.getInstance().getPage()).EnterLocation.getWindowID()   ,"",
		                      MapFormPage.getInstance(MobileWeb.getInstance().getPage()).V_EnterLocation.getWindowID() ,"",
		                      MapFormPage.getInstance(MobileWeb.getInstance().getPage()).getMap.getWindowID()          ,"",
		                      "Map a Location"                          ,"Text",
		                      "Enter Address, City, State and/or ZIP"   ,"Text",
		              };
	
/* Comments */
/* This Data provider method will provide test data for all UI objects in Map form page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "MapFormPageUIElement")
public static Object[][] getObjectMapFormUI() 
 {		   
    return getObjectUI(data3);			
 } 
	
	
/* Comments */
/* This Data provider method will provide test data for Text objects in Map form page 
 * It is referring to to the variable "Data.Get_Map_Form" in "data.txt" 
 * It is using the "method" "getObjectText"
*/

@DataProvider(name = "MapFormPageTextElement")
public static Object[][] getObjectMapFormText() 
{ 
   return getObjectText("Data.Map_A_Location_Form");			
}	
	
	

/*  * ** Map TEXT RESULT PAGE    **  */

/* Comments */
/* This array will provide test data to advance browsers Map Text Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data4={
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()              ,"",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()                  ,"",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).ShowLargerMap.getWindowID()         ,"",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).thumbnailMap.getWindowID()          ,"",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).FindBizLocNearby.getWindowID()      ,"",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).SearchBizNearby.getWindowID()       ,"Search Businesses Nearby",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).GetDirFromHere.getWindowID()        ,"Get Directions From Here",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).GetDirToHere.getWindowID()          ,"Get Directions To Here",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).Icon_FindBizLocNearby.getWindowID() ,"",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).Icon_SearchBizNearby.getWindowID()  ,"",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).Icon_GetDirFromHere.getWindowID()   ,"",
	       MapTestResult.getInstance(MobileWeb.getInstance().getPage()).Icon_GetDirToHere.getWindowID()     ,"",
	       "Denver"                                          ,"Text",
	       "CO"                                              ,"Text",
	       "Find"                                            ,"Text",
	       "Nearby"                                          ,"Text",
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Map Text Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "MapTextResultPageUIElement")
public static Object[][] getObjectMapTextResultPageUI() 
 {		   
    return getObjectUI(data4);			
 } 



/* * *Map MAP RESULT PAGE * */


/* Comments */
/* This array will provide test data to advance browsers Map Map Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data5={
	       MapMapResult.getInstance(MobileWeb.getInstance().getPage()).Plus.getWindowID()  ,"",
	       MapMapResult.getInstance(MobileWeb.getInstance().getPage()).Minus.getWindowID() ,"",
	       MapMapResult.getInstance(MobileWeb.getInstance().getPage()).View.getWindowID()  ,"",
	       MapMapResult.getInstance(MobileWeb.getInstance().getPage()).close.getWindowID() ,"",	             
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Map Map Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "MapMapResultPageUIElement")
public static Object[][] getObjectMapMapResultPageUI() 
 {		   
    return getObjectUI(data5);			
 } 

/*
 * The Data provider method will provide the URLs to fetch map components
 * 
*/

@DataProvider(name = "MapMapResultPageMapElement")
public static Object[][] getObjectMapMapResultMapUI() 
 {		   
    return getMapUI("map","Data.Map_Map_UI");			
 } 	


/* Comments */
/* This array will provide test data to advance browsers Map Map Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data11={
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()           ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()               ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).Back.getWindowID()               ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).RestaurantIcon.getWindowID()     ,"",	  
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).GasStationIcon.getWindowID()     ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).ParkingGarageIcon.getWindowID()  ,"", 
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).PostOfficeIcon.getWindowID()     ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).CoffeeShopsIcon.getWindowID()    ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).GroceryStoresIcon.getWindowID()  ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).HotelsIcon.getWindowID()         ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).IceCreamShopsIcon.getWindowID()  ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).BarsIcon.getWindowID()           ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).ParkingGarageIcon.getWindowID()  ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).Restaurant.getWindowID()         ,"",	  
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).GasStation.getWindowID()         ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).ParkingGarage.getWindowID()      ,"", 
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).PostOffice.getWindowID()         ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).CoffeeShops.getWindowID()        ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).GroceryStores.getWindowID()      ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).Hotels.getWindowID()             ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).IceCreamShops.getWindowID()      ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).Bars.getWindowID()               ,"",
	       BrandBizSearchPage.getInstance(MobileWeb.getInstance().getPage()).ParkingGarage.getWindowID()      ,"",
	       "Select a Business or Category"  ,"Text",
	       "Restaurants"                    ,"Text",
	       "Gas Stations"                   ,"Text",
	       "Parking Garages"                ,"Text",
	       "Post Offices"                   ,"Text",
	       "Coffee Shops"                   ,"Text",
	       "Grocery Stores"                 ,"Text",
	       "Hotels"                         ,"Text",
	       "Ice Cream Shops"                ,"Text",
	       "Bars"                           ,"Text",
	       "Pharmacies"                     ,"Text",
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Map Map Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "BrandBizSearchPage")
public static Object[][] getObjectBrandBizSearchPageUI() 
 {		   
    return getObjectUI(data11);			
 } 





/* ** Search FORM PAGE ** */	

/* Comments */
/* This array will provide test data to advance browsers Search form page.
*  It is passing UI objects & their respective Class name* 
*/
	
static String [] data6={
		                      SearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()              ,"",
		                      SearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()                  ,"",
		                      SearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Near.getWindowID()                  ,"",
		                      SearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Search.getWindowID()                ,"",
		                      SearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Search_by_Categories.getWindowID()  ,"Search by Categories",
		                      SearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Search_for.getWindowID()            ,"",
		                      SearchFormPage.getInstance(MobileWeb.getInstance().getPage()).V_Near.getWindowID()                ,"",
		                      "Find a Business"                                  ,"Text",		                     
		                      "Search for:"                                      ,"Text",
		                      "Near:"                                            ,"Text",		                      
		               };
	
/* Comments */
/* This Data provider method will provide test data for all UI objects in Search form page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "SearchFormPageUIElement")
public static Object[][] getObjectSearchFormUI() 
 {		   
    return getObjectUI(data6);			
 } 
	

/*  * ** Search TEXT RESULT PAGE    **  */

/* Comments */
/* This array will provide test data to advance browsers Search Text Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data7={
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).DataByInfoUSA.getWindowID()   , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()        , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()            , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Next.getWindowID()            , "", 
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_POI.getWindowID()    , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Refine_Search.getWindowID()   , "",	  
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_1.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_2.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_3.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_4.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_5.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_6.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_7.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_8.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_9.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_10.getWindowID(), "",      
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_1.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_2.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_3.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_4.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_5.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_6.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_7.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_8.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_9.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_10.getWindowID() , "",	       
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_1.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_2.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_3.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_4.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_5.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_6.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_7.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_8.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_9.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_10.getWindowID()     , "",	       
	       "Results for"                                  , "Text",
	       "Pizza"                                        , "Text",
	       "near"                                         , "Text",
	       "Denver"                                       , "Text",
	       "CO"                                           , "Text",	       
	       ""                                             , "Text",
	       "Results for"                                  , "Text",
	       "Pizza"                                        , "Text",
	       "near"                                         , "Text",
	       "Denver"                                       , "Text",
	       "CO"                                           , "Text",
	       "1"                                            , "Text",	       
	       "2"                                            , "Text",	       
	       "3"                                            , "Text",	       
	       "4"                                            , "Text",	       
	       "5"                                            , "Text",	       
	       "6"                                            , "Text",	       
	       "7"                                            , "Text",	       
	       "8"                                            , "Text",	       
	       "9"                                            , "Text",	       
	       "10"                                           , "Text",	       	       
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Map Text Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "SearchTextResultPageUIElement")
public static Object[][] getObjectSearchTextResultPageUI() 
 {		   
    return getObjectUI(data7);			
 } 
	
		

/* * *Search MAP RESULT PAGE * */


/* Comments */
/* This array will provide test data to advance browsers Search Map Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data8={
	       SearchMapResult.getInstance(MobileWeb.getInstance().getPage()).Plus.getWindowID()  ,"",
	       SearchMapResult.getInstance(MobileWeb.getInstance().getPage()).Minus.getWindowID() ,"",
	       SearchMapResult.getInstance(MobileWeb.getInstance().getPage()).View.getWindowID()  ,"",
	       SearchMapResult.getInstance(MobileWeb.getInstance().getPage()).close.getWindowID() ,"",	             
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Search Map Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "SearchMapResultPageUIElement")
public static Object[][] getObjectSearchMapResultPageUI() 
 {		   
    return getObjectUI(data8);			
 } 

/*
 * The Data provider method will provide the URLs to fetch map components
 * 
*/

@DataProvider(name = "SearchMapResultPageMapElement")
public static Object[][] getObjectSearchMapResultMapUI() 
 {		   
    return getMapUI("search","Data.Search_Map_UI");			
 } 	




/* ** MyPlaces FORM PAGE ** */	

/* Comments */
/* This array will provide test data to advance browsers MyPlaces form page.
*  It is passing UI objects & their respective Class name* 
*/
	
static String [] data9={
		                 //  MyPlaceFormPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),   "",
		                   MyPlaceFormPage.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID(),       "",
		                   MyPlaceFormPage.getInstance(MobileWeb.getInstance().getPage()).Password.getWindowID(),   "",
		                   MyPlaceFormPage.getInstance(MobileWeb.getInstance().getPage()).ScreenName.getWindowID(), "",
		                   MyPlaceFormPage.getInstance(MobileWeb.getInstance().getPage()).SignIn.getWindowID(),     "",
		                   "Sign In to My Places"                  , "Text",
		                   "Screen Name or Email:"                 , "Text",
		                   "Password:"                             , "Text",
		                   "Stay signed in until I sign out"       , "Text",
		               };
	
/* Comments */
/* This Data provider method will provide test data for all UI objects in MyPlaces form page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "MyPlaceFormPageUIElement")
public static Object[][] getObjectMyPlacesFormUI() 
 {		   
    return getObjectUI(data9);			
 } 
	
	
/* Comments */
/* This Data provider method will provide test data for Text objects in MyPlaces form page 
 * It is referring to to the variable "Data.Sign_In_to_My_Places" in "data.txt" 
 * It is using the "method" "getObjectText"
*/

@DataProvider(name = "MyPlaceFormPageTextElement")
public static Object[][] getObjectMyPlacesFormText() 
{ 
   return getObjectText("Data.Sign_In_to_My_Places");			
}	
	
	

/*  * ** MyPlaces TEXT RESULT PAGE    **  */

/* Comments */
/* This array will provide test data to advance browsers MyPlaces Text Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data10={
                MyPlaceTextResult.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                      "",
                MyPlaceTextResult.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID(),                          "",
                MyPlaceTextResult.getInstance(MobileWeb.getInstance().getPage()).Refresh.getWindowID(),                       "",
                MyPlaceTextResult.getInstance(MobileWeb.getInstance().getPage()).See_all_My_Saved_Maps_Routes.getWindowID() , "",
                MyPlaceTextResult.getInstance(MobileWeb.getInstance().getPage()).See_all_My_Locations.getWindowID(),          "",
                MyPlaceTextResult.getInstance(MobileWeb.getInstance().getPage()).See_all_Recent_Locations.getWindowID(),      "",
                MyPlaceTextResult.getInstance(MobileWeb.getInstance().getPage()).SignOut.getWindowID(),                       "",
                "Hello test"                                                 , "Text",
                "Sign Out"                                                   , "Text",
                "My Places"                                                  , "Text",
                "My Saved Maps & Routes"                                     , "Text",
                "See all My Saved Maps & Routes"                             , "Text",                                                        
                "My Locations"                                               , "Text",
                "See all My Locations"                                       , "Text",
                "My Recent Locations"                                        , "Text",
                "See all Recent Locations"                                   , "Text",
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in MyPlace Text Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "MyPlaceTextResultPageUIElement")
public static Object[][] getObjectMyPlaceTextResultPageUI() 
 {		   
    return getObjectUI(data10);			
 } 
	


/* Saved & Recent Form */

/* Comments */
/* This array will provide test data to advance browsers Saved & Recent Form page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data12={
                SavedAndRecent.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                                  "",
                SavedAndRecent.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID(),                                      "",
                SavedAndRecent.getInstance(MobileWeb.getInstance().getPage()).back.getWindowID(),                                "< Back",                
                "Saved & Recents"                                                 , "Text",
                "Recent Locations"                                                , "Text",
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Saved & Recent Form page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	

@DataProvider(name = "Saved&RecentFormUIElement")
public static Object[][] getObjectSavedAndRecentFormUI() 
 {		   
    return getObjectUI(data12);			
 } 


/* ********************* */
/* Ambiguity Page        */
/* ********************* */

static String [] data13={
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                                  "",
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID(),                                      "",
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result1.getWindowID(),                                   "Denver, CO", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result2.getWindowID(),                                   "Denver, IA", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result3.getWindowID(),                                   "Denver, IN", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result4.getWindowID(),                                   "Denver, MO", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result5.getWindowID(),                                   "Denver, PA", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result6.getWindowID(),                                   "Denver, AL", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result7.getWindowID(),                                   "Denver, AR", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result8.getWindowID(),                                   "Denver, FL", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result9.getWindowID(),                                   "Denver, GA", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).Result10.getWindowID(),                                  "Denver, ID", 
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).EnterANewLocation.getWindowID(),                         "",
    AmbiguityPage.getInstance(MobileWeb.getInstance().getPage()).GO.getWindowID(),                                        "",
    "There are 10 results for"                                            , "Text",
    "Denver"                                                              , "Text",
    "Select a location from the list below: "                             , "Text",
    "Or enter a new Location:"                                            , "Text",
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Ambiguity Form page
* It is passing all XPATH and the UI-class name. 
* It is taking input from the above array "data".
* It is using the "method" "getObjectUI"
*/


@DataProvider(name = "AmbiguityPageUIElement")
public static Object[][] getObjectAmbiguityPageUIElement() 
{		   
   return getObjectUI(data13);			
} 

	
/* ********************* */
/* GeoDiff Page        */
/* ********************* */

static String [] data14={
    GeoDiffPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()                                                   , "",
    GeoDiffPage.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()                                                       , "",
    GeoDiffPage.getInstance(MobileWeb.getInstance().getPage()).Suggestion.getWindowID()                                                 , "CA, US",                                     
    GeoDiffPage.getInstance(MobileWeb.getInstance().getPage()).EnterANewLocation.getWindowID()                                          , "",
    GeoDiffPage.getInstance(MobileWeb.getInstance().getPage()).GO.getWindowID()                                                         , "",    
    "We did not find an exact match for \"Denvre,CA\", but we found a similar location"						              											    , "Text",
    "Use this suggested location: "                                                                    , "Text",
    "Or enter a new Location:"                                                                         , "Text",
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in GeoDiff page
* It is passing all XPATH and the UI-class name. 
* It is taking input from the above array "data".
* It is using the "method" "getObjectUI"
*/


@DataProvider(name = "GeoDiffPageUIElement")
public static Object[][] getObjectGeoDiffPageUIElement() 
{		   
   return getObjectUI(data14);			
} 


/* Comments */
/* This array will provide test data to advance browsers Search Text Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data15={
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).DataByInfoUSA.getWindowID()   , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()        , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()            , "",	        
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_POI.getWindowID()    , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Refine_Search.getWindowID()   , "",	  
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_1.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_2.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_3.getWindowID() , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_4.getWindowID() , "",	            
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_1.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_2.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_3.getWindowID()  , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_4.getWindowID()  , "",	       	       
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_1.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_2.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_3.getWindowID()      , "",
	       SearchTextResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_4.getWindowID()      , "",   
	       "Results for"                                  , "Text",
	       "Gas Stations"                                 , "Text",
	       "near"                                         , "Text",
	       "Denver"                                       , "Text",
	       "CO"                                           , "Text",
	       "1"                                            , "Text",	       
	       "2"                                            , "Text",	       
	       "3"                                            , "Text",	       
	       "4"                                            , "Text",	             	       
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Map Text Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "SearchfromSearchByCatagoryPage")
public static Object[][] getObjectSearchfromSearchByCatagoryPage() 
 {		   
    return getObjectUI(data15);			
 } 
	

/* *********************** */
/* ***** Refine Search *** */
/* *********************** */

/* Comments */
/* This array will provide test data to advance browsers Search Text Result page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data16={	       
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()          , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()              , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).M1.getWindowID()                , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).M5.getWindowID()                , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).M10.getWindowID()               , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).M25.getWindowID()               , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).M50.getWindowID()               , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Sug1.getWindowID()              , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Sug2.getWindowID()              , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Sug3.getWindowID()              , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Sug4.getWindowID()              , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Sug5.getWindowID()              , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Sug6.getWindowID()              , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Sug7.getWindowID()              , "",
	       RefineSearch.getInstance(MobileWeb.getInstance().getPage()).Sug8.getWindowID()              , "",	       
	       "Refine Search"                              , "Text",
	       "Search Radius:"                             , "Text",
	       "1 Mile"                                     , "Text",
	       "5 Miles"                                    , "Text",
	       "10 Miles"                                   , "Text",
	       "25 Miles"                                   , "Text",	       
	       "50 Miles"                                   , "Text",	       
	       "Arvada, CO"                                 , "Text",	       
	       "Aurora, CO"                                 , "Text",
	       "Commerce City"                              , "Text",
	       "Denver, CO"                                 , "Text",
	       "Edgewater, CO"                              , "Text",
	       "Englewood, CO"                              , "Text",
	       "Lakewood, CO"                               , "Text",
	       "Wheat Ridge, CO"                            , "Text",
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Map Text Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "RefineSearchFormPage")
public static Object[][] getObjectRefineSearchFormPage() 
 {		   
    return getObjectUI(data16);			
 } 

/* *********************** */
/* ***** Near A Location *** */
/* *********************** */
//@ Amitha
/* Comments */
/* This array will provide test data to advanced browsers Near A Location page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data17={	       
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).mapquest.getWindowID()             		, "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).menu.getWindowID()                  	, "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).start_loc.getWindowID()              	, "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).end_loc.getWindowID()                	, "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).start_loc_b.getWindowID()             	, "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).end_loc_b.getWindowID()               	, "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).start_star.getWindowID()                , "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).end_star.getWindowID()				    , "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).along_the_route.getWindowID()          	, "",      
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).back.getWindowID()               		, "",
    NearALocation.getInstance(MobileWeb.getInstance().getPage()).view_route.getWindowID()          		, "",       
    "Near a Location"                                                   , "Text",
    
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Near A Location Page
* It is passing all XPATH and the UI-class name. 
* It is taking input from the above array "data".
* It is using the "method" "getObjectUI"
*/

@DataProvider(name = "NearALocationUIObject")
public static Object[][] NearALocation() 
{		   
return getObjectUI(data17);		

} 


/*  * ** Map Business Search Results Page   **  */

/* Comments */
//@ Amitha
/* This array will provide test data to advance browsers Map Business Search Results Page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data18={
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).DataByInfoUSA.getWindowID()   , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()        , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()            , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Next.getWindowID()            , "", 
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_POI.getWindowID()    , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Refine_Search.getWindowID()   , "",	  
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_1.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_2.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_3.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_4.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_5.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_6.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_7.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_8.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_9.getWindowID() , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Get_Direction_10.getWindowID(), "",      
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_1.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_2.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_3.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_4.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_5.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_6.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_7.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_8.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_9.getWindowID()  , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).SearchResult_10.getWindowID() , "",	       
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_1.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_2.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_3.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_4.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_5.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_6.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_7.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_8.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_9.getWindowID()      , "",
	       MapBusinessSearchResult.getInstance(MobileWeb.getInstance().getPage()).Show_Map_10.getWindowID()     , "",	       
	       "Results for"                                  , "Text",
	       "near"                                         , "Text",
	       "1"                                            , "Text",	       
	       "2"                                            , "Text",	       
	       "3"                                            , "Text",	       
	       "4"                                            , "Text",	       
	       "5"                                            , "Text",	       
	       "6"                                            , "Text",	       
	       "7"                                            , "Text",	       
	       "8"                                            , "Text",	       
	       "9"                                            , "Text",	       
	       "10"                                           , "Text",	       	       
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Map Business Search Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "MapBusinessSearchResultsUIElement")
public static Object[][] getObjectMapBusinessSearchResultsPageUI() 
 {		   
    return getObjectUI(data18);			
 }

/*  * ** Directions Business Search Results Page   **  */

/* Comments */
//@ Amitha
/* This array will provide test data to advance browsers Directions Business Search Results Page.
*  It is passing UI objects & their respective Class name* 
*/

static String [] data19={
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).DataByInfoUSA.getWindowID()       		, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()        			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()            			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Next.getWindowID()            			, "", 
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_POI.getWindowID()    			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Refine_Search.getWindowID()   			, "",	  
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_1.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_2.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_3.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_4.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_5.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_6.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_7.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_8.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_9.getWindowID() 				, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Add_To_Route_10.getWindowID()				, "",  
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_1.getWindowID()    			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_3.getWindowID()  		    , "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_4.getWindowID()  		    , "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_5.getWindowID()  	        , "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_6.getWindowID()  	        , "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_7.getWindowID()  		    , "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_8.getWindowID()  		    , "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_9.getWindowID()  			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).SearchResult_10.getWindowID() 		    , "",	  
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_1.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_2.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_3.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_4.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_5.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_6.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_7.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_8.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_9.getWindowID()      			, "",
	DirectionsBusinessSearchResultsPage.getInstance(MobileWeb.getInstance().getPage()).Show_Map_10.getWindowID()					, "",	       
	       "Results for"                                  										, "Text",
	       "near"                                         										, "Text",
	       "1"                                           										, "Text",	       
	       "2"                                            										, "Text",	       
	       "3"                                            										, "Text",	       
	       "4"                                            										, "Text",	       
	       "5"                                            										, "Text",	       
	       "6"                                            										, "Text",	       
	       "7"                                            										, "Text",	       
	       "8"                                            										, "Text",	       
	       "9"                                            										, "Text",	       
	       "10"                                           										, "Text",	       	       
};

/* Comments */
/* This Data provider method will provide test data for all UI objects in Directions Business Search Result page
 * It is passing all XPATH and the UI-class name. 
 * It is taking input from the above array "data".
 * It is using the "method" "getObjectUI"
*/
	
@DataProvider(name = "DirectionsBusinessSearchResultsUIElement")
public static Object[][] getObjectDirectionsBusinessSearchResultsPageUI() 
 {		   
    return getObjectUI(data19);			
 } 
/* Comments */
//@ Amitha
/* This array will provide test data to advance browsers Add to route page (Directions results with 3 points).
*  It is passing UI objects & their respective Class name* 
*/

static String [] data20 = {
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()			     ,"",
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()				     ,"",
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).ShowMap.getWindowID()			         ,"",
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).Start_Star.getWindowID()      	     ,"",
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).End_Star.getWindowID()		         ,"",
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).AddtoRoute_Star.getWindowID() 	     ,"",
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).Start_Text.getWindowID()				 ,"",
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).End_Text.getWindowID()				 ,"",
	DirectionsTextresultwith3points.getInstance(MobileWeb.getInstance().getPage()).AddtoRoute_Text.getWindowID()			 ,"",
	"Start:"																		     , "Text",
	"End:" 																				 , "Text",
    "Denver"                                                                             , "Text",
    "CO"                                                                                 , "Text",
    "End:"                                                                               , "Text",
    "Parker"                                                                             , "Text",
    "CO"                                                                                 , "Text",
    "Directions"                                                                         , "Text",
    "Travel Estimate From A to B:"                                                       , "Text",
    "Travel Estimate From B to C:"														 , "Text",
    "Results are informational only with no warranties of any kind. You assume all risk of use. MapQuest and its suppliers shall not be liable for any loss or delay resulting from your use of MapQuest. Your use means you agree to our" , "Text",
};
    /* Comments */
    /* This Data provider method will provide test data for all UI objects in Search Along the Route page
     * It is passing all XPATH and the UI-class name. 
     * It is taking input from the above array "data".
     * It is using the "method" "getObjectUI"
    */
    	
    @DataProvider(name = "DirectionsTextResultwith3pointsUIElement")
    public static Object[][] getObjectDirectionsTextResultwith3pointsPageUI() 
     {		   
        return getObjectUI(data20);			
     } 
    
    /* Comments */
  //@ Amitha
  /* This array will provide test data to advance browsers Search along the route page
  *  It is passing UI objects & their respective Class name* 
  */

  static String [] data21 = {
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()			     						,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID()           							    ,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).NearALocation.getWindowID()			         				,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).Back.getWindowID()      	          						,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).ViewRoute.getWindowID()		         						,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_step1.getWindowID() 	     					,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_step2.getWindowID() 	     					,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_step3.getWindowID() 	     					,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_step4.getWindowID() 	     					,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_step5.getWindowID() 	     					,"",
  	AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_step6.getWindowID() 	     					,"",
  	//AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_step7.getWindowID() 	     					,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Miles1.getWindowID()							,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Miles2.getWindowID()							,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Miles3.getWindowID()							,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Miles4.getWindowID()							,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Miles5.getWindowID()							,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Miles6.getWindowID()							,"",
    //AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Miles7.getWindowID()							,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Button1.getWindowID()						,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Button2.getWindowID()						,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Button3.getWindowID()						,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Button4.getWindowID()						,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Button5.getWindowID()						,"",
    AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Button6.getWindowID()						,"",
    //AlongtheRoute.getInstance(MobileWeb.getInstance().getPage()).RouteNarrative_Button7.getWindowID()						,"",	
  	"From:"																		            ,"Text",
    "Denver"                                                                                ,"Text",
    "CO"                                                                                    ,"Text",
    "To:"                                                                                   ,"Text",
    "Parker"                                                                                ,"Text",
    "CO"                                                                                    ,"Text",
  };
      /* Comments */
      /* This Data provider method will provide test data for all UI objects in Search Along the Route page
       * It is passing all XPATH and the UI-class name. 
       * It is taking input from the above array "data".
       * It is using the "method" "getObjectUI"
      */
      	
      @DataProvider(name = "AlongtheRouteUIElement")
      public static Object[][] getObjectAlongtheRoutePageUI() 
       {		   
          return getObjectUI(data21);			
       }
      
      //Route Options Pop Up //
      
      /* Comments */
      //@ Amitha
      /* This array will provide test data to advance browsers Route Options popup 
      *  It is passing UI objects & their respective Class name* 
      */
      
      static String [] data22 = {
    	  RouteOptionsPopup.getInstance(MobileWeb.getInstance().getPage()).Recalculate_Route.getWindowID()							,"",
    	  RouteOptionsPopup.getInstance(MobileWeb.getInstance().getPage()).shortest_time.getWindowID()								,"",
    	  RouteOptionsPopup.getInstance(MobileWeb.getInstance().getPage()).shortest_distance.getWindowID()							,"",
    	  RouteOptionsPopup.getInstance(MobileWeb.getInstance().getPage()).walking_directions.getWindowID()							,"",
    	  RouteOptionsPopup.getInstance(MobileWeb.getInstance().getPage()).Avoid_Highways.getWindowID()								,"",
    	  RouteOptionsPopup.getInstance(MobileWeb.getInstance().getPage()).Avoid_Toll_Roads.getWindowID()							,"",
    	  RouteOptionsPopup.getInstance(MobileWeb.getInstance().getPage()).Avoid_Closed_Roads.getWindowID()							,"",
    	  RouteOptionsPopup.getInstance(MobileWeb.getInstance().getPage()).popup_close.getWindowID()									,"",
    	  "Route Options"																			,"Text",
    	  "Shortest Time"																			,"Text",
    	  "Shortest Distance"																		,"Text",
    	  "Walking Directions"																		,"Text",
    	  "Avoid Highways"																			,"Text",
    	  "Avoid Toll Roads"																		,"Text",
    	  "Avoid Seasonally Closed Roads"															,"Text",
      };
      
      /* Comments */
      /* This Data provider method will provide test data for all UI objects in Route Options popup page
       * It is passing all XPATH and the UI-class name. 
       * It is taking input from the above array "data".
       * It is using the "method" "getObjectUI"
      */
      	
      @DataProvider(name = "RouteOptionsUIElement")
      public static Object[][] getObjectRouteOptionspopupUI() 
       {		   
          return getObjectUI(data22);			
       } 

      
      //Preparing data provider for MyFormSignInPage      
      
      static String [] data23 = {
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).Aol.getWindowID()							,"",
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).Google.getWindowID()						,"",
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).Twitter.getWindowID()						,"",
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).username.getWindowID()						,"",
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).pass.getWindowID()							,"",
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).SignIn.getWindowID()						,"",
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).cancel.getWindowID()						,"",
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).GetaFreeAOLAccount.getWindowID()			,"",
    	  MyFormLoginPage.getInstance(MobileWeb.getInstance().getPage()).AOLLogo.getWindowID()						,"aol_logo.png",
    	    	  	
    	  "Sign in using any of these options..."											,"Text",
    	  "By proceeding you agree to the"													,"Text",
    	 
      };
      
      @DataProvider(name = "MyFormLoginPage")
      public static Object[][] getObjectMyFormLoginPageUI() 
       {		   
          return getObjectUI(data23);			
       } 

      
	
}


