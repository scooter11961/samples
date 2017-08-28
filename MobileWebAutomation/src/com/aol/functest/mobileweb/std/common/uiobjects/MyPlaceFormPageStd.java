
/**
*	This class defines UI objects of My Places form Page for Std Browsers
*	@version 1.0
*	@author Amitha
*/




package com.aol.functest.mobileweb.std.common.uiobjects;
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
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
	
	public link      Mapquest ;          
	public textfield ScreenName;
	public textfield Password;
	public button    SignIn;
	public text      Signout;
	public link      Direction_Link;
	public link      Map_Link;																			
	public link      FindABusiness_Link;
	public link      MyPlaces_Link;
	public link      AOLMobile_Link;
	public link      LegalTermsandPrivacy_Link;
	
	public void initUIElements(){
		Mapquest            = new link      (page,"//img[@alt='MapQuest']");
		ScreenName          = new textfield (page,"//div/input[@name='sn']");
		Password            = new textfield (page,"//div/input[@name='pw']");
		SignIn              = new button    (page,"//div/span[@class='buttonHolder']/input");
		Signout     		 = new text      (page,"//form/div/span[1]");
		Direction_Link              = new link      (page,"//div[@class='menu']/a[@accesskey='1']");
		Map_Link                    = new link      (page,"//div[@class='menu']/a[@accesskey='2']");																			
		FindABusiness_Link          = new link      (page,"//div[@class='menu']/a[@accesskey='3']");
		MyPlaces_Link               = new link      (page,"//div[@class='menu']/a[@accesskey='4']");
		AOLMobile_Link              = new link      (page,"//a[@href='http://wap.aol.com/portal/']");
		LegalTermsandPrivacy_Link   = new link      (page,"//a[contains(@href, '/terms-of-use')]");
		
		
	}

	

}




