/**
*	This class defines UI objects of My Places form Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/




package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;
import com.aol.functest.common.text;
import com.aol.functest.common.textfield;


public class MyPlaceFormPage {
	
	private static MyPlaceFormPage mfpInst = null;
	private browserpage page;

	private MyPlaceFormPage (browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static MyPlaceFormPage getInstance(browserpage page) {
		if (null == mfpInst) {
			mfpInst = new MyPlaceFormPage(page);
		}
		return mfpInst;
	}

	//public link      Mapquest;
	public dropdown  Menu;
	public textfield ScreenName;
	public textfield Password;
	public button    SignIn;
	public text      Signout;

	public void initUIElements() {
		//Mapquest            = new link      (page, "//img[@id='logo']");
		Menu                = new dropdown  (page, "//button[@id='menu_link']");
		ScreenName          = new textfield (page, "//input[@id='sn']");
		Password            = new textfield (page, "//input[@id='pw']");
		SignIn              = new button    (page, "//form/div[2]/div[2]/input");
		Signout             = new text      (page, "//form/div[1]/div[1]/div");
	}

}
