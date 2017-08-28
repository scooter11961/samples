package com.aol.functest.mobileweb.std.common.uiobjects;
/**
*	This class defines UI objects of Find A Business form Page for Std Browsers
*	@version 1.0
*	@author Amitha
*/


import com.aol.functest.common.*;

public class FindaBusinessFormPageStd {
		
		private static FindaBusinessFormPageStd sfpInstd = null;
		private browserpage page;
		
		private FindaBusinessFormPageStd(browserpage page) {
			this.page = page;
			initUIElements();
		}
		
		public static FindaBusinessFormPageStd getInstance(browserpage page) {
			if (null == sfpInstd) {
				sfpInstd = new FindaBusinessFormPageStd(page);
			}
			return sfpInstd;
		}
		public link        Map;
		public link        Search_by_Categories;
		public textfield   Enter_Search_Term;
		public textfield   Near;
		public button      V_Near;
		public button      Search;
		public link        Direction_Link;
		public link        Map_Link;																			
		public link        FindABusiness_Link;
		public link        MyPlaces_Link;
		
		public void initUIElements(){
			Map                	   = new link      (page,"//img[@alt='MapQuest']");
			Search_by_Categories    = new link      (page,"//a[contains(@href, '/category?form=search')]");
			Enter_Search_Term       = new textfield (page,"//input[@name='cat']");
			Near                    = new textfield (page,"//input[@name='addressInput']");
			V_Near                  = new button    (page,"//input[@name='snr1']");
			Search                  = new button    (page,"//input[@value='Search']");
			Direction_Link              = new link      (page,"//div[@class='menu']/a[@accesskey='1']");
			Map_Link                    = new link      (page,"//div[@class='menu']/a[@accesskey='2']");																			
			FindABusiness_Link          = new link      (page,"//div[@class='menu']/a[@accesskey='3']");
			MyPlaces_Link               = new link      (page,"//div[@class='menu']/a[@accesskey='4']");


		}
		

		public void FindBusiness(String Business , String Location) 
		{
			DirectionFormPageStd.getInstance(page).Mapquest.click();
			page.waitForPageToLoad(page.sTIMEOUT);	
		    DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		    page.waitForPageToLoad (page.sTIMEOUT);       
		    String sSearch = Business;	
		    String MapAdd = Location;
		    Enter_Search_Term.setText(sSearch);
		    Near.setText(MapAdd);		
		    Search.click();
		    page.waitForPageToLoad (page.sTIMEOUT);
		}
	}

