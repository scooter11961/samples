/**
*	This class defines UI objects of Direction Form Page for Std Browsers
*	@version 1.0
*	@author Amitha
*/
package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.link;
import com.aol.functest.common.textfield;

public class DirectionFormPageStd {
	
	/**
	 * Creating the Singleton to access elements in this class.
	 */
	private static DirectionFormPageStd dfpStd = null;
	private browserpage page;

	private DirectionFormPageStd (browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static DirectionFormPageStd getInstance (browserpage page) {
		if (null == dfpStd) {
			dfpStd = new DirectionFormPageStd(page);
		}
		return dfpStd;
	}
	
	public void SearchDirection(String To) 
	{
		Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		String Start = To;		
		StartLocation.setText(Start);	
		go.click();
		page.waitForPageToLoad (page.sTIMEOUT);	 
	}
	
	public void SearchDirection(String To, String From) 
	{
		Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		String Start = To;
		String End   = From;
		StartLocation.setText(Start);
		EndLocation.setText(End);		
		go.click();
		page.waitForPageToLoad (page.sTIMEOUT);	 
	}
	
/*	
	public void SearchDirection(String To, String From , String Option) 
	{
		Mapquest.click();
		browserpage.getInstance().waitForPageToLoad (browserpage.getInstance().sTIMEOUT); 
		String Start = To;
		String End   = From;
		StartLocation.setText(Start);
		EndLocation.setText(End);		
		RouteOption.click();	
		if(Option.equals("Shortest Time"))
		{
			ShortestTime.click();
		}
		if(Option.equals("Shortest Distence"))
		{
			ShortestDistence.click();
		}
		if(Option.equals("Walking Directions"))
		{
			WalkingDirections.click();
		}
		if(Option.equals("Avoid Highways"))
		{
			browserpage.getInstance().click(AvoidHighways.getWindowID());
		}
		if(Option.equals("Avoid Toll Roads"))
		{
			browserpage.getInstance().click(AvoidTollRoads.getWindowID());
		}
		if(Option.equals("Avoid Seasonally Closed Roads"))
		{
			browserpage.getInstance().click(AvoidSeasonallyClosedRoads.getWindowID());
		}
		if(Option.equals(""))
		{
		}
		DirectionFormPage.getInstance().getDirection.click();
		browserpage.getInstance().waitForPageToLoad (browserpage.getInstance().sTIMEOUT);
	}
	*/

	// General UI Elements
	public textfield StartLocation; 
	public textfield EndLocation; 
	public button    V_StartLocation; 
	public button    V_EndLocation; 
	public button    RouteOptions; 
	public button    go; 
	public link      Mapquest; 
	public link      AOLMobile_Link;
	public link      LegalTermsandPrivacy_Link;
	
	// Different Pages
	public link      Direction_Link;
	public link      Map_Link;																			
	public link      FindABusiness_Link;
	public link      MyPlaces_Link;

	public void initUIElements() {
		StartLocation               = new textfield (page, "//div/input[@name='1ai']"); 
		EndLocation                 = new textfield (page, "//div/input[@name='2ai']"); 
		V_StartLocation             = new button    (page, "//div/input[@name='snr1']"); 
		V_EndLocation               = new button    (page, "//div/input[@name='snr2']"); 
		RouteOptions                = new button    (page, "//div/input[@class='robutton']"); 
		go                          = new button    (page, "//div/input[@value='GO']"); 
		Mapquest                    = new link      (page, "//div[@class='logo']/a/img"); 
		AOLMobile_Link              = new link      (page, "//div[@class='footerText']/a[@href='http://wap.aol.com/portal/']");
		LegalTermsandPrivacy_Link   = new link      (page, "//div[@class='footerText']/a[@href='/terms-of-use']");

		Direction_Link              = new link      (page, "//div[@class='menu']/a[@accesskey='1']");
		Map_Link                    = new link      (page, "//div[@class='menu']/a[@accesskey='2']");																			
		FindABusiness_Link          = new link      (page, "//div[@class='menu']/a[@accesskey='3']");
		MyPlaces_Link               = new link      (page, "//div[@class='menu']/a[@accesskey='4']");
	}
}
