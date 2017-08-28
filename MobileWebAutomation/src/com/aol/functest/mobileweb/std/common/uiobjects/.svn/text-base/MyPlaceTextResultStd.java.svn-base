
/**
*	This class defines UI objects of My Places results Page for Advance Browsers
*	@version 1.0
*	@author Amitha
*/


package com.aol.functest.mobileweb.std.common.uiobjects;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;
import com.aol.functest.common.text;

public class MyPlaceTextResultStd {
	
	private static MyPlaceTextResultStd mptrInst = null;
	private browserpage page;
	
	private MyPlaceTextResultStd(browserpage page) {
		this.page = page;
		initUIElements();
	}
	public static MyPlaceTextResultStd getInstance(browserpage page) {
		if (null == mptrInst) {
			mptrInst = new MyPlaceTextResultStd(page);
		}
		return mptrInst;
	}
	
	
	public link      Mapquest;
	public link      See_all_My_Saved_Maps_Routes;
	public link      See_all_My_Locations;  
	public link      See_all_Recent_Locations ;
	public link      SignOut;                  
	public button    Refresh;                  
	public dropdown  Menu;                   
	public text      hello;                  
	public link      Direction_Link;          
	public link      Map_Link;                 																			
	public link      FindABusiness_Link;       
	public link      MyPlaces_Link;             
	public link      AOLMobile_Link;            
	public link      LegalTermsandPrivacy_Link; 
	
	public void initUIElements(){
		Mapquest                        = new link      (page,"//img[@alt='MapQuest']");
		See_all_My_Saved_Maps_Routes    = new link      (page,"//a[contains(@href, '/myplaces/savedMaps?backLink=/myplaces?pva=MPsem')]");
		See_all_My_Locations            = new link      (page,"//a[contains(@href, '/myplaces/locations?backLink=/myplaces?pva=MPsel')]");
		See_all_Recent_Locations        = new link      (page,"//a[contains(@href, '/myplaces/recentLocations?backLink=/myplaces')]");
		SignOut                         = new link      (page,"//div[2]/a");
		Refresh                         = new button    (page,"//div[@class='savedAndMyPlaceHeader contentTitle round_border']/button");
		Menu                            = new dropdown  (page,"//div[@id='nav']/button[@id='menu_link']");
		hello                           = new text      (page,"//div[2]");
		Direction_Link              	 = new link      (page,"//div[@class='menu']/a[@accesskey='1']");
		Map_Link                    	 = new link      (page,"//div[@class='menu']/a[@accesskey='2']");																			
		FindABusiness_Link          	 = new link      (page,"//div[@class='menu']/a[@accesskey='3']");
		MyPlaces_Link               	 = new link      (page,"//div[@class='menu']/a[@accesskey='4']");
		AOLMobile_Link              	 = new link      (page,"//a[@href='http://wap.aol.com/portal/']");
		LegalTermsandPrivacy_Link   	 = new link      (page,"//a[contains(@href, '/terms-of-use')]");

	}
}


