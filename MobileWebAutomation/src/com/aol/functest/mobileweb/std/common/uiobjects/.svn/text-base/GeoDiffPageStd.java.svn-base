package com.aol.functest.mobileweb.std.common.uiobjects;

import com.aol.functest.common.*;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;


public class GeoDiffPageStd {

	private static GeoDiffPageStd gdpInst = null;

	private browserpage page;

	private GeoDiffPageStd(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static GeoDiffPageStd getInstance(browserpage page) {
		if (null == gdpInst) {
			gdpInst = new GeoDiffPageStd(page);
		}
		return gdpInst;
	}
	public link        Mapquest;
	public link        Suggestion;
	public textfield   EnterANewLocation;
	public button      GO;    

	public void initUIElements(){
		Mapquest               = new link      (page,"//img[@alt='MapQuest']");
		Suggestion             = new link      (page,"//div[5]/a");
		EnterANewLocation      = new textfield (page,"//div/input[1]");
		GO                     = new button    (page,"//div/input[5]");    

	}


}




