package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.*;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;


public class GeoDiffPage {

	private static GeoDiffPage gdpInst = null;
	private browserpage page;

	private GeoDiffPage(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static GeoDiffPage getInstance(browserpage page) {
		if (null == gdpInst) {
			gdpInst = new GeoDiffPage(page);
		}
		return gdpInst;
	}

	public link        Mapquest;
	public dropdown    Menu;
	public link        Suggestion;
	public textfield   EnterANewLocation;
	public button      GO;    

	public void initUIElements() {
		Mapquest               = new link      (page, "//img[@id='logo']");
		Menu                   = new dropdown  (page, "//button[@id='menu_link']");
		Suggestion             = new link      (page, "//div[4]/a/span");
		EnterANewLocation      = new textfield (page, "//input[@id]");
		GO                     = new button    (page, "//div/input[2]");    
	}

}
