package com.aol.functest.mobileweb.std.common.uiobjects;
/**
*	This class defines UI objects of Map Form Page for Std Browsers
*	@version 1.0
*	@author Amitha
*/




import com.aol.functest.common.*;


public class MapFormPageStd {	
	
	private static MapFormPageStd mfpInstd = null;
	private browserpage page;
	private MapFormPageStd(browserpage page) {
		this.page = page;
		initUIElements();
	}
	public static MapFormPageStd getInstance(browserpage page) {
		if (null == mfpInstd) {
			mfpInstd = new MapFormPageStd(page);
		}
		return mfpInstd;
	}
	
	public link     Mapquest ;
	public textfield EnterLocation;
	public button    V_EnterLocation;
	public button    Go ;
	public link      Direction_Link;
	public link      Map_Link;																			
	public link      FindABusiness_Link;
	public link      MyPlaces_Link;
	public link      AOLMobile_Link ;
	public link      LegalTermsandPrivacy_Link;
	
	public void initUIElements(){

		Mapquest               		= new link     (page,"//img[@alt='MapQuest']");
		EnterLocation          	= new textfield (page,"//div/input[@name='addressInput']");
		V_EnterLocation        	= new button    (page,"//div/input[@name = 'snr1']");
		Go                 		= new button    (page,"//div/input[@value = 'GO']");
		Direction_Link              = new link      (page,"//div[@class='menu']/a[@accesskey='1']");
		Map_Link                    = new link      (page,"//div[@class='menu']/a[@accesskey='2']");																			
		FindABusiness_Link          = new link      (page,"//div[@class='menu']/a[@accesskey='3']");
		MyPlaces_Link               = new link      (page,"//div[@class='menu']/a[@accesskey='4']");
		AOLMobile_Link              = new link      (page,"//a[@href='http://wap.aol.com/portal/']");
		LegalTermsandPrivacy_Link   = new link      (page,"//a[contains(@href, '/terms-of-use')]");
	}
		
	
	public void SearchMap(String Location) 
	{
		DirectionFormPageStd.getInstance(page).Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT);	
	    DirectionFormPageStd.getInstance(page).Map_Link.click();
	    page.waitForPageToLoad (page.sTIMEOUT);       
	    String MapAdd = Location;			
		EnterLocation.setText(MapAdd);		
		Go.click();
		page.waitForPageToLoad (page.sTIMEOUT);
	}
}

