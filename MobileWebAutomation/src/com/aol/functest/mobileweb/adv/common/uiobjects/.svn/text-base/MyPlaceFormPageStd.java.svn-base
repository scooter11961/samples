
/**
*	This class defines UI objects of My Places form Page for Std Browsers
*	@version 1.0
*	@author Amitha
*/




package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.link;
import com.aol.functest.common.text;
import com.aol.functest.common.textfield;


public class MyPlaceFormPageStd {

	private static MyPlaceFormPageStd myplacestd = null;
	private browserpage page;

	private MyPlaceFormPageStd(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static MyPlaceFormPageStd getInstance(browserpage page) {
		if (null == myplacestd) {
			myplacestd = new MyPlaceFormPageStd(page);
		}
		return myplacestd;
	}

	public link      Mapquest;
	public textfield ScreenName;
	public textfield Password;
	public button    SignIn;
	public text      Signout;

	public void initUIElements() {
		Mapquest            = new link      (page, "//img[@id='logo']");
		ScreenName          = new textfield (page, "//div/input[@name='sn']");
		Password            = new textfield (page, "//div/input[@name='pw']");
		SignIn              = new button    (page, "//div/span[@class='buttonHolder']/input");
		Signout     		 = new text      (page, "//form/div/span[1]");
	}

}
