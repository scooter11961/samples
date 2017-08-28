package com.aol.functest.mobileweb.std.data;


	/**
	*	This class defines data provider methods for all the pages in Std Browser
	*	@version 1.0
	*	@author Amitha
	*/

	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.aol.functest.mobileweb.std.common.MobileWeb;
import com.aol.functest.mobileweb.std.common.uiobjects.AmbiguityPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.AmbiguityPageStdAuth;
import com.aol.functest.mobileweb.std.common.uiobjects.CategorySearchFormPage;
import com.aol.functest.mobileweb.std.common.uiobjects.DirectionFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.DirectionResultPageUIStd;
import com.aol.functest.mobileweb.std.common.uiobjects.FindaBusinessFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.GeoDiffPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.GeoDiffPageStdAuth;
import com.aol.functest.mobileweb.std.common.uiobjects.MapFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MapResultPageUiStdAuth;
import com.aol.functest.mobileweb.std.common.uiobjects.MapResutPageUIStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceTextResultStd;
import com.aol.functest.mobileweb.std.common.uiobjects.NearALocationStdUI;
import com.aol.functest.mobileweb.std.common.uiobjects.RefineSearchStd;
import com.aol.functest.mobileweb.std.common.uiobjects.RouteOptionsPageUIStd;
import com.aol.functest.mobileweb.std.common.uiobjects.SavedandRecentStd;
import com.aol.functest.mobileweb.std.common.uiobjects.SavedandRecentStdAuth;
import com.aol.functest.mobileweb.std.common.uiobjects.SearchResultsPageUIStd;


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
				    dataproperty.load (new FileInputStream ("testdata/data_std.txt"));						
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
			    dataproperty.load (new FileInputStream ("testdata/data_std.txt"));						
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
	/* This array will provide test data to std browsers Direction form page.
	*  It is passing UI objects & their respective Class name* 
	*  @Amitha
	*/
		
	static String [] data={
		                          DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).StartLocation.getWindowID()           		,"",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).EndLocation.getWindowID()             		,"",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).V_StartLocation.getWindowID()         		,"",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).V_EndLocation.getWindowID()           		,"",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).RouteOptions.getWindowID()             	,"",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).go.getWindowID()                      		,"",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()                		,"",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).AOLMobile_Link.getWindowID()          		,"AOL Mobile",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy_Link.getWindowID()	,"Legal Terms and Privacy",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Direction_Link.getWindowID()          		,"Get Directions",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Map_Link.getWindowID()                		,"Map a Location",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).FindABusiness_Link.getWindowID()      		,"Find a Business",
			                      DirectionFormPageStd.getInstance(MobileWeb.getInstance().getPage()).MyPlaces_Link.getWindowID()          		,"",
			                      "My Places"																	,"Text",
			                      "Get Directions"                                           				    ,"Text",
			                      "Start"                                                    					,"Text",
			                      "End"                                                      					,"Text",
			                      "(Optional)"                                               					,"Text",
			              };
		
	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Direction form page for Std Browser
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "DirectionFormPageStdUIElement")
	public static Object[][] getObjectDirectionFormStdUI() 
	 {		   
	    return getObjectUI(data);	
	 }
	
	/*****************************/	
	/* ** Route Options Page ** */	
	/*****************************/


	/* Comments */
	/* This array will provide test data to std browsers Route Options page.
	*  It is passing UI objects & their respective Class name* 
	*  @Amitha
	*/
		
	static String [] data1={
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).back_link.getWindowID()           			,"",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Shortest_Driving_time.getWindowID()			,"",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Shortest_Driving_Distance.getWindowID()		,"",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Avoid_Highways.getWindowID()					,"",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Avoid_Toll_Roads.getWindowID()				,"",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Avoid_Seasonally_Closed_Roads.getWindowID()	,"",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Go_Button.getWindowID()						,"",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Home_Link.getWindowID()						,"Home",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Aol_Mobile.getWindowID()						,"AOL Mobile",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Legal_Terms_Privacy.getWindowID()				,"Legal Terms and Privacy",
		                          RouteOptionsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()						,"",
		                          "Route Options"																	,"Text",
		                          "Optimize Route:"																	,"Text",
		                          "Shortest Driving Time"															,"Text",
		                          "Shortest Driving Distance"														,"Text",
		                          "Walking Directions"																,"Text",
		                          "Avoid:"																			,"Text",
		                          "Highways"																		,"Text",
		                          "Toll Roads"																		,"Text",
		                          "Seasonally Closed Roads"															,"Text",
		                          

			              };
		
	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Route Options page for Std Browser
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "RouteOptionsPageStdUIElement")
	public static Object[][] getObjectRouteOptionsPageStdUI() 
	 {		   
	    return getObjectUI(data1);	
	 }
	
	/*****************************/	
	/* ** Direction Result Page ** */	
	/*****************************/


	/* Comments */
	/* This array will provide test data to std browsers Direction Result page.
	*  It is passing UI objects & their respective Class name* 
	*  @Amitha
	*/
		
	static String [] data2={
		                        //  DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).map_image.getWindowID()           			,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).zoomin_button.getWindowID()				,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).zoomout_button.getWindowID()				,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Uparrow_button.getWindowID()				,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Downarrow_button.getWindowID()				,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Leftarrow_button.getWindowID()				,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Rightarrow_button.getWindowID()			,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).FindBizNearByI.getWindowID()				,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).FindBizNearByL.getWindowID()				,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).FindBusinessNearbyL.getWindowID()			,"",
		                          //DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).pagination_next_link.getWindowID()			,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_1.getWindowID()					,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_2.getWindowID()					,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_3.getWindowID()					,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_4.getWindowID()					,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Road_Sh_5.getWindowID()					,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Change_Route_Options.getWindowID()			,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).ViewTraffic.getWindowID()					,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Home_link.getWindowID()					,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).AOL_Mobile_Link.getWindowID()				,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Legal_Terms_Privacy.getWindowID()			,"",
		                          DirectionResultPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Terms_of_use.getWindowID()					,"",
		                          "Start:"																				,"Text",
		                          "End:"																				,"Text",
		                          "Total Est. Time:"																,"Text",
		                          "Total Est. Distance:"															,"Text",
		                          "Directions"																		,"Text",
		                          "Travel Estimate From A to B"														,"Text",
"Results are informational only with no warranties of any kind. You assume all risk of use. MapQuest and its suppliers shall not be liable for any loss or delay resulting from your use of MapQuest. Your use means you agree to our  Terms of Use"
		                          																					,"Text",
		                          																					

			              };
		
	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Direction Result page for Std Browser
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "DirectionResultPageStdUIElement")
	public static Object[][] getObjectDirectionResultPageStdUI() 
	 {		   
	    return getObjectUI(data2);	
	 }
	
	
	/* ** MyPlaces FORM PAGE ** */	

	/* Comments */
	/* This array will provide test data to Std browsers MyPlaces form page.
	*  It is passing UI objects & their respective Class name* 
	*/
		
	static String [] data3={
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()	                       		,"",
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Direction_Link.getWindowID()								   	,"",
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Password.getWindowID()							   	,"",
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).ScreenName.getWindowID()						   	,"",
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).SignIn.getWindowID()							   	,"",
							   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Map_Link.getWindowID()								,"",
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).FindABusiness_Link.getWindowID()					,"",
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).MyPlaces_Link.getWindowID()							,"",
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).AOLMobile_Link.getWindowID()						,"",
			                   MyPlaceFormPageStd.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy_Link.getWindowID()				,"",	                   
			                   "My Places"                  										   				,"Text",
			                   "Screen Name or Email:"                 												,"Text",
			                   "Password:"                             												,"Text",
			                   "Stay signed in until I sign out"       												,"Text",
			               };
		
	/* Comments */
	/* This Data provider method will provide test data for all UI objects in MyPlaces form page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "MyPlaceFormPageStdUIElement")
	public static Object[][] getObjectMyPlacesStdFormUI() 
	 {		   
	    return getObjectUI(data3);			
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

	static String [] data4={
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                      "",
	              //MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).Menu.getWindowID(),                          "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).Refresh.getWindowID(),                       "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).See_all_My_Saved_Maps_Routes.getWindowID() , "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).See_all_My_Locations.getWindowID(),          "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).See_all_Recent_Locations.getWindowID(),      "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).Direction_Link.getWindowID(),                       "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).Map_Link.getWindowID(),                      "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).FindABusiness_Link.getWindowID(),            "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).MyPlaces_Link.getWindowID(),                 "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).AOLMobile_Link.getWindowID(),                "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy_Link.getWindowID(),     "",
	                MyPlaceTextResultStd.getInstance(MobileWeb.getInstance().getPage()).SignOut.getWindowID(),                       "",
	                "Hello test"                                                 , 					"Text",
	                "Sign Out"                                                   , 					"Text",
	                "My Places"                                                  , 					"Text",
	                "My Saved Maps & Routes"                                     , 					"Text",
	                "See all My Saved Maps & Routes"                             , 					"Text",                                                        
	                "My Locations"                                               , 					"Text",
	                "See all My Locations"                                       , 					"Text",
	                "My Recent Locations"                                        , 					"Text",
	                "See all Recent Locations"                                   , 					"Text",
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in MyPlace Text Result page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "MyPlaceTextResultStdPageUIElement")
	public static Object[][] getObjectMyPlaceTextResultStdPageUI() 
	 {		   
	    return getObjectUI(data4);			
	 } 
	

	/*  * ** Near A Location    **  */

	/* Comments */
	/* This array will provide test data to advance browsers Near A Location page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data5={
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).mapquest.getWindowID(),                      	"",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).view_route.getWindowID(),                      "",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).A_Start_Loc.getWindowID(),                     "",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).B_end_Loc.getWindowID() , 						"",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).start_loc.getWindowID(),          				"",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).end_loc.getWindowID(),      					"",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).along_the_route.getWindowID(),                 "From Denver, CO to Parker, CO",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).Home.getWindowID(),							"Home",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).AOL_Mobile_Link.getWindowID(),					"AOL Mobile",
	                NearALocationStdUI.getInstance(MobileWeb.getInstance().getPage()).Legal_Terms_Privacy.getWindowID(),				"Legal Terms and Privacy",
	                "Search for",																	"Text",
	                "Near a Location:",																"Text",
	                "Along the Route:",																"Text",	
	                
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Near A Location page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "NearALocationStdPageUIElement")
	public static Object[][] getObjectNearALocationStdPageUIElement() 
	 {		   
	    return getObjectUI(data5);			
	 } 
	
	/*  * ** Map Form Page   **  */

	/* Comments */
	/* This array will provide test data to advance browsers Map form page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data6={
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                      			"",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).EnterLocation.getWindowID(),                     	"",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).V_EnterLocation.getWindowID(),                     "",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Go.getWindowID() , 								"",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Direction_Link.getWindowID(),          			"Get Directions",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Map_Link.getWindowID(),      						"Map a Location",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).FindABusiness_Link.getWindowID(),                 	"Find a Business",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).MyPlaces_Link.getWindowID(),						"",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).AOLMobile_Link.getWindowID(),						"AOL Mobile",
	                MapFormPageStd.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy_Link.getWindowID(),			"Legal Terms and Privacy",
	                "Map a Location",																"Text",
	                "Enter Address, City, State and/or ZIP:",										"Text",	            
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Map Result Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "MapFormPageStdUIElement")
	public static Object[][] getObjectMapFormPageUIElement() 
	 {		   
	    return getObjectUI(data6);			
	 } 
	
	/*  * ** Map Result Page UnAuthenticate  **  */

	/* Comments */
	/* This array will provide test data to Std browsers Map result page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data7={
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Map.getWindowID(),                      		"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).zoomin_button.getWindowID(),                    "",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).zoomout_button.getWindowID(),                   "",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Downarrow_button.getWindowID() , 				"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Uparrow_button.getWindowID(),          			"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Leftarrow_button.getWindowID(),      			"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Rightarrow_button.getWindowID(),                "",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).FindBizNearby_I.getWindowID(),					"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).FindBizLocNearby.getWindowID(),					"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).GetDirFromHere.getWindowID(),					"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).GetDirToHere.getWindowID(),						"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).FindBusinessNearby.getWindowID(),				"",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Home.getWindowID(),								"Home",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).AOL_Mobile.getWindowID(),						"AOL Mobile",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy.getWindowID(),				"Legal Terms and Privacy",
	                MapResutPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Terms_of_Use.getWindowID(),						"",
"Results are informational only with no warranties of any kind. You assume all risk of use. MapQuest and its suppliers shall not be liable for any loss or delay resulting from your use of MapQuest. Your use means you agree to our  Terms of Use",																"Text",
	               									                                                "Text",	            
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Map Result Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "MapResultPageStdUIElement")
	public static Object[][] getObjectMapResultPageUIElement() 
	 {		   
	    return getObjectUI(data7);			
	 } 
	
	/*  * ** Map Result Page authenticate  **  */

	/* Comments */
	/* This array will provide test data to Std browsers Map result page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data8={
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).Map.getWindowID(),                      		 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).zoomin_button.getWindowID(),                    "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).zoomout_button.getWindowID(),                   "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).Downarrow_button.getWindowID() , 				 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).Uparrow_button.getWindowID(),          		 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).Leftarrow_button.getWindowID(),      			 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).Rightarrow_button.getWindowID(),                "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).FindBizNearby_I.getWindowID(),					 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).FindBizLocNearby.getWindowID(),				 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).GetDirFromHere.getWindowID(),					 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).GetDirToHere.getWindowID(),					 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).FindBusinessNearby.getWindowID(),				 "",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).Home.getWindowID(),							 "Home",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).AOL_Mobile.getWindowID(),						 "AOL Mobile",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy.getWindowID(),			 "Legal Terms and Privacy",
	                MapResultPageUiStdAuth.getInstance(MobileWeb.getInstance().getPage()).Terms_of_Use.getWindowID(),					 "",
"Results are informational only with no warranties of any kind. You assume all risk of use. MapQuest and its suppliers shall not be liable for any loss or delay resulting from your use of MapQuest. Your use means you agree to our  Terms of Use",																"Text",
	               									                                                     "Text",	            
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Map Result Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "MapResultPageStdUIElementAuth")
	public static Object[][] getObjectMapResultPageUIElementAuth() 
	 {		   
	    return getObjectUI(data8);			
	 } 
	
	/*  * ** Saved & Recents Page   **  */

	/* Comments */
	/* This array will provide test data to Std browsers Saved and Recent Page
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data9={
	                SavedandRecentStd.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                      	"",
	     //           SavedandRecentStd.getInstance().back.getWindowID(),                    			"",
	                SavedandRecentStd.getInstance(MobileWeb.getInstance().getPage()).Home.getWindowID() , 							"Home",
	                SavedandRecentStd.getInstance(MobileWeb.getInstance().getPage()).Aol_Mobile.getWindowID(),          				"AOL Mobile",
	                SavedandRecentStd.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy.getWindowID(),      		"Legal Terms and Privacy",
	                "Saved & Recent",																"Text",									
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Map Result Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "SavedandRecentPageStdUIElement")
	public static Object[][] getObjectSavedandRecentUIElement() 
	 {		   
	    return getObjectUI(data9);			
	 } 
	
	/*  * ** Saved & Recents Page for Authentication Page  **  */

	/* Comments */
	/* This array will provide test data to Std browsers Saved and Recent Page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data10={
	                SavedandRecentStdAuth.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                     "",
	           //     SavedandRecentStdAuth.getInstance().back.getWindowID(),                    		"",
	                SavedandRecentStdAuth.getInstance(MobileWeb.getInstance().getPage()).Home.getWindowID() , 						"Home",
	                SavedandRecentStdAuth.getInstance(MobileWeb.getInstance().getPage()).Aol_Mobile.getWindowID(),          			"AOL Mobile",
	                SavedandRecentStdAuth.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy.getWindowID(),      	"Legal Terms and Privacy",
	                SavedandRecentStdAuth.getInstance(MobileWeb.getInstance().getPage()).Recents.getWindowID(),						"",
	                "Saved & Recent",																"Text",
	               // "Recents",																		"Text",
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Map Result Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "SavedandRecentPageStdUIElementAuth")
	public static Object[][] getObjectSavedandRecentUIElementAuth() 
	 {		   
	    return getObjectUI(data10);			
	 } 
	
	
	/*  * ** Find a Business Form Page   **  */

	/* Comments */
	/* This array will provide test data to Std browsers Find a Business Form page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data11={
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Map.getWindowID(),                 		"",
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Search_by_Categories.getWindowID(),      "",
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Enter_Search_Term.getWindowID(),         "",
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Near.getWindowID() , 					"",
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Search.getWindowID(),          			"",
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Direction_Link.getWindowID(),      		"Get Directions",
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).Map_Link.getWindowID(),      			"Map a Location",
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).FindABusiness_Link.getWindowID(),      	"Find a Business",
	                FindaBusinessFormPageStd.getInstance(MobileWeb.getInstance().getPage()).MyPlaces_Link.getWindowID(),      		"",
	                "Find a Business",																"Text",
	                "Or Enter a Search Term (Optional)",											"Text",
	                "Near:",																		"Text",												
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Find Business Form Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "FindBusinessPageStdUIElement")
	public static Object[][] getObjectFindBusinessPageStdUIElement() 
	 {		   
	    return getObjectUI(data11);			
	 } 
	
	
	/*  * ** Category Business Form Page   **  */

	/* Comments */
	/* This array will provide test data to Std browser Category Business Form Page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data12={
	                CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                    "",
	                CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Back.getWindowID(),      					"",
	                CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Restaurant_I.getWindowID(),         		"",
					CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).GasStation_I.getWindowID(),				"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).ParkingGarage_I.getWindowID(),				"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).PostOffice_I.getWindowID(),				"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).CoffeeShops_I.getWindowID(),				"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).GroceryStores_I.getWindowID(),				"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Hotels_I.getWindowID(),					"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).IceCreamShops_I.getWindowID(),				"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Bars_I.getWindowID(),						"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Pharmacies_I.getWindowID(),				"",
	                CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Restaurant_L.getWindowID(),         		"Restaurants",
					CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).GasStation_L.getWindowID(),				"Gas Stations",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).ParkingGarage_L.getWindowID(),				"Parking Garages",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).PostOffice_L.getWindowID(),				"Post Offices",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).CoffeeShops_L.getWindowID(),				"Coffee Shops",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).GroceryStores_L.getWindowID(),				"Grocery Stores",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Hotels_L.getWindowID(),					"Hotels",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).IceCreamShops_L.getWindowID(),				"Ice Cream Shops",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Bars_L.getWindowID(),						"Bars",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Pharmacies_L.getWindowID(),				"Pharmacies",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).Home.getWindowID(),						"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).AOLMobile_Link.getWindowID(),				"",
				    CategorySearchFormPage.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy_Link.getWindowID(),	"",
				    "Select Business Or Category",													"Text",
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Find Business Form Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "CategorysearchPageStdUIElement")
	public static Object[][] getObjectCategorySearchPageStdUIElement() 
	 {		   
	    return getObjectUI(data12);			
	 } 
	
	
	
	/*  * ** Search Results Page   **  */

	/* Comments */
	/* This array will provide test data to Std browser Category Business Form Page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data13={
	                SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).map.getWindowID(),                    		"",
	                SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).zoomin_button.getWindowID(),      			"",
	                SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).zoomout_button.getWindowID(),         		"",
					SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Uparrow_button.getWindowID(),				"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Downarrow_button.getWindowID(),			"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Leftarrow_button.getWindowID(),			"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Rightarrow_button.getWindowID(),			"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Refine_Search.getWindowID(),				"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).New_Search.getWindowID(),					"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Search_Result_1.getWindowID(),				"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Search_Result_2.getWindowID(),				"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Search_Result_3.getWindowID(),				"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Search_Result_4.getWindowID(),				"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Search_Result_5.getWindowID(),				"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Next.getWindowID(),						"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Home.getWindowID(),						"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).AOL_Mobile.getWindowID(),					"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy.getWindowID(),		"",
				    SearchResultsPageUIStd.getInstance(MobileWeb.getInstance().getPage()).Terms_of_Use.getWindowID(),				"",
				    "Results for",																	"Text",
				    "near",																			"Text",
				    "Results are informational only with no warranties of any kind. You assume all risk of use. MapQuest and its suppliers shall not be liable for any loss or delay resulting from your use of MapQuest. Your use means you agree to our  Terms of Use",
				                                                                                     "Text"
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Find Business Form Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "SearchResultsPageStdUIElement")
	public static Object[][] getObjectSearchResultsPageStdUIElement() 
	 {		   
	    return getObjectUI(data13);			
	 } 
	
	/*  * ** Refine Search Page   **  */

	/* Comments */
	/* This array will provide test data to Std browser Refine Search Page.
	*  It is passing UI objects & their respective Class name* 
	*/

	static String [] data14={
	                RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID(),                    		"",
	            //    RefineSearchStd.getInstance().back.getWindowID(),      							"",
	                RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Mile1.getWindowID(),         						"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Mile5.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Mile10.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Mile25.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Mile50.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Loc1.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Loc2.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Loc3.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Loc4.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Loc5.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Loc6.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Loc7.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Loc8.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).UpdateSearch.getWindowID(),						"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).Home.getWindowID(),								"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).AOLMobile_Link.getWindowID(),						"",
					RefineSearchStd.getInstance(MobileWeb.getInstance().getPage()).LegalTermsandPrivacy_Link.getWindowID(),			"",
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Find Business Form Page
	 * It is passing all XPATH and the UI-class name. 
	 * It is taking input from the above array "data".
	 * It is using the "method" "getObjectUI"
	*/
		
	@DataProvider(name = "RefinesearchpageStdUIElement")
	public static Object[][] getObjectRefinesearchpageStdUIElement() 
	 {		   
	    return getObjectUI(data14);			
	 }
	
	/* ********************* */
	/* Ambiguity Page        */
	/* ********************* */

	static String [] data15={
	  //  AmbiguityPageStd.getInstance().Mapquest.getWindowID(),                                  "",
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result1.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result2.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result3.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result4.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result5.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result6.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result7.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result8.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result9.getWindowID(),                                   "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).Result10.getWindowID(),                                  "", 
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).EnterANewLocation.getWindowID(),                         "",
	    AmbiguityPageStd.getInstance(MobileWeb.getInstance().getPage()).GO.getWindowID(),                                        "",
	    "There are 10 results for"                                            , "Text",
	    "Denver"                                                              , "Text",
	   // "Select a location from the list below:"                              , "Text",
	    "Or enter a new Location:"                                            , "Text",
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Ambiguity Form page
	* It is passing all XPATH and the UI-class name. 
	* It is taking input from the above array "data".
	* It is using the "method" "getObjectUI"
	*/


	@DataProvider(name = "AmbiguityPageStdUIElement")
	public static Object[][] getObjectAmbiguityPageStdUIElement() 
	{		   
	   return getObjectUI(data15);			
	} 

		
	/* ********************* */
	/* GeoDiff Page        */
	/* ********************* */

	static String [] data16={
	    GeoDiffPageStd.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()                                                   , "",
	    GeoDiffPageStd.getInstance(MobileWeb.getInstance().getPage()).Suggestion.getWindowID()                                                 , "CA, US",                                     
	    GeoDiffPageStd.getInstance(MobileWeb.getInstance().getPage()).EnterANewLocation.getWindowID()                                          , "",
	    GeoDiffPageStd.getInstance(MobileWeb.getInstance().getPage()).GO.getWindowID()                                                         , "",    
	    "We did not find an exact match for \"Denvre,CA\", but we found a similar location"                , "Text",
	   // "Use this suggested location:"                                                                    , "Text",
	   // "Or enter a new Location:"                                                                         , "Text",
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
	   return getObjectUI(data16);			
	} 
	

	/* ********************* */
	/* Ambiguity Page Auth       */
	/* ********************* */

	static String [] data17={
	 //   AmbiguityPageStdAuth.getInstance().Mapquest.getWindowID(),                                  "",
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result1.getWindowID(),                                   "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result2.getWindowID(),                                   "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result3.getWindowID(),                                   "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result4.getWindowID(),                                   "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result5.getWindowID(),                                   "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result6.getWindowID(),                                   "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result7.getWindowID(),                                   "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result8.getWindowID(),                                   "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result9.getWindowID(),                                   "", 
	   // AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Result10.getWindowID(),                                  "", 
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).EnterANewLocation.getWindowID(),                         "",
	    AmbiguityPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).GO.getWindowID(),                                        "",
	    "There are 10 results for"                                            , "Text",
	    "Denver"                                                              , "Text",
	   // "Select a location from the list below:"                              , "Text",
	    "Or enter a new Location:"                                            , "Text",
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in Ambiguity Form page
	* It is passing all XPATH and the UI-class name. 
	* It is taking input from the above array "data".
	* It is using the "method" "getObjectUI"
	*/


	@DataProvider(name = "AmbiguityPageStdUIElementAuth")
	public static Object[][] getObjectAmbiguityPageStdUIElementAuth() 
	{		   
	   return getObjectUI(data17);			
	} 
	
	/* ********************* */
	/* GeoDiff Page   Auth     */
	/* ********************* */

	static String [] data18={
	    GeoDiffPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Mapquest.getWindowID()                                                   , "",
	    GeoDiffPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).Suggestion.getWindowID()                                                 , "CA, US",                                     
	    GeoDiffPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).EnterANewLocation.getWindowID()                                          , "",
	    GeoDiffPageStdAuth.getInstance(MobileWeb.getInstance().getPage()).GO.getWindowID()                                                         , "",    
	    "We did not find an exact match for \"Denvre,CA\", but we found a similar location"                , "Text",
	   // "Use this suggested location:"                                                                    , "Text",
	    "Or enter a new Location:"                                                                         , "Text",
	};

	/* Comments */
	/* This Data provider method will provide test data for all UI objects in GeoDiff page
	* It is passing all XPATH and the UI-class name. 
	* It is taking input from the above array "data".
	* It is using the "method" "getObjectUI"
	*/


	@DataProvider(name = "GeoDiffPageUIElementAuth")
	public static Object[][] getObjectGeoDiffPageUIElementAuth() 
	{		   
	   return getObjectUI(data18);			
	}

	/*
	 * The Data provider method will provide the URLs to fetch map components
	 * 
	*/

	@DataProvider(name = "MapResultPageMapElement")
	public static Object[][] getObjectMapResultMapUI() 
	 {		   
	    return getMapUI("map_std","Data.Map_Std_UI");			
	 }
	
	@DataProvider(name = "DirResultPageMap")
	public static Object[][] getObjectDirResultPageMap() 
	 {		   
	    return getMapUI("dir_std","Data.Dir_Map_Std");			
	 } 
		
	}