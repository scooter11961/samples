/**
*	This class defines UI objects of My Places results Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/


package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;
import com.aol.functest.common.text;

public class MyPlaceTextResult {
	
	private static MyPlaceTextResult mptrInst = null;
	private browserpage page;

	private MyPlaceTextResult(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static MyPlaceTextResult getInstance(browserpage page) {
		if (null == mptrInst) {
			mptrInst = new MyPlaceTextResult(page);
		}
		return mptrInst;
	}

	public link      Mapquest;
	public link      See_all_My_Saved_Maps_Routes;
	public link      See_all_My_Locations;
	public link      See_all_Recent_Locations;
	public link      SignOut;
	public button    Refresh;
	public dropdown  Menu;
	public text      hello;

	public void initUIElements() {
		Mapquest                        = new link      (page, "//div[@id='nav']/a/img[@id='logo']");
		See_all_My_Saved_Maps_Routes    = new link      (page, "//div[@id='wrap_content_main']/div[@class='contentBody seeMore']/a[@href='/myplaces/savedMaps?backLink=']");
		See_all_My_Locations            = new link      (page, "//div[@id='wrap_content_main']/div[@class='contentBody seeMore']/a[@href='/myplaces/locations?backLink=']");
		See_all_Recent_Locations        = new link      (page, "//div[@id='wrap_content_main']/div[@class='contentBody seeMore']/a[@href='/myplaces/recentLocations?backLink=']");
		SignOut                         = new link      (page, "link=Sign Out");
		Refresh                         = new button    (page, "//div[@id='wrap_content_main']/div[@class='savedAndMyPlaceHeader contentTitle round_border']/button");
		Menu                            = new dropdown  (page, "//div[@id='nav']/button[@id='menu_link']");
		hello                           = new text      (page, "//div[@id='wrap_content_main']/div[4]");
	}

}
