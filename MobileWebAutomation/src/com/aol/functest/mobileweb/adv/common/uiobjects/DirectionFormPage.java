/**
*	This class defines UI objects of Direction Form Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/



package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.*;

/**
*	Class the defines the object of Direction Form page of wap.mapquest.com
*	@version 1.0
*	@author shiladitya roy
*	@author freebeachler
*/
public class DirectionFormPage {
	
	/**
	 * Creating the Singleton to access elements in this class.
	 */
	private static DirectionFormPage dfpInst = null;
	private browserpage page;

	private DirectionFormPage (browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static DirectionFormPage getInstance(browserpage page) {
		if (null == dfpInst) {
			dfpInst = new DirectionFormPage(page);
		}
		return dfpInst;
	}

	public void SearchDirection(String To) 
	{
		Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
		String Start = To;		
		StartLocation.setText(Start);	
		getDirection.click();
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
		getDirection.click();
		page.waitForPageToLoad (page.sTIMEOUT);	 
	}
	
	
	public void SearchDirection(String To, String From , String Option) 
	{
		Mapquest.click();
		page.waitForPageToLoad (page.sTIMEOUT); 
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
			page.click(AvoidHighways.getWindowID());
		}
		if(Option.equals("Avoid Toll Roads"))
		{
			page.click(AvoidTollRoads.getWindowID());
		}
		if(Option.equals("Avoid Seasonally Closed Roads"))
		{
			page.click(AvoidSeasonallyClosedRoads.getWindowID());
		}
		if(Option.equals(""))
		{
		}
		DirectionFormPage.getInstance(page).getDirection.click();
		page.waitForPageToLoad (page.sTIMEOUT);
	}

	// General UI Elements
	public textfield StartLocation; 
	public textfield EndLocation; 
	public button    V_StartLocation; 
	public button    V_EndLocation; 
	public button    RouteOption; 
	public button    getDirection; 
	public link      Mapquest; 
	public dropdown  Menu; 
	public link      Mq4m;
	//public link      MqNav;
	
	// "Menu" drop down UI elements
	public link      Menu_Direction;
	public link      Menu_Map;																			
	public link      Menu_Search;
	public link      Menu_MyPlace;
	public link      Menu_Local;

	// Options UI elements	
	public radio     ShortestTime;
	public radio     ShortestDistence;
	public radio     WalkingDirections;
	public checkbox  AvoidHighways;
	public checkbox  AvoidTollRoads;
	public checkbox  AvoidTimedRestrictions;
	public checkbox  AvoidSeasonallyClosedRoads;
	public checkbox  AvoidFerries;
	
	public void initUIElements() {
		// General UI Elements
		StartLocation               = new textfield (page, "//input[@id='1ai']"); 
		EndLocation                 = new textfield (page, "//input[@id='2ai']"); 
		V_StartLocation             = new button    (page, "//form[@id='dirForm']/div[1]/div/button"); 
		V_EndLocation               = new button    (page, "//form[@id='dirForm']/div[2]/div[1]/button"); 
		RouteOption                 = new button    (page, "//div[2]/a[@id='advancedOptionsLink']"); 
		getDirection                = new button    (page, "//input[@id='btnGetDir']"); 
		Mapquest                    = new link      (page, "//img[@id='logo']"); 
		Menu                        = new dropdown  (page, "//button[@id='menu_link']"); 
		//Mq4m                        = new link      (page, "//div[@class='otherProducts round_border']/a[1]/b");
		Mq4m                        = new link      (page, "//div[@id='wrap_content_main']/div[@id='ad']/div[@id='mqar-DF-2']/a/img");
		//MqNav                       = new link      (page, "//div[@id='wrap_content_main']/div[6]/a/span");
		
		// "Menu" drop down UI elements
		Menu_Direction              = new link      (page, "//div[@id='menu-location']");
		Menu_Map                    = new link      (page, "//div[@id='menu-maps']");																			
		Menu_Search                 = new link      (page, "//div[@id='menu-search']");
		Menu_MyPlace                = new link      (page, "//div[@id='menu-myplaces']");
		Menu_Local                  = new link      (page, "//div[@id='menu-local']");

		// Options UI elements	
		ShortestTime                = new radio     (page, "//div[@id='advancedOptions']/label[1]");
		ShortestDistence            = new radio     (page, "//div[@id='advancedOptions']/label[2]");
		WalkingDirections           = new radio     (page, "//div[@id='advancedOptions']/label[3]");
		AvoidHighways               = new checkbox  (page, "//div[@id='advancedOptions']/label[4]");
		AvoidTollRoads              = new checkbox  (page, "//div[@id='advancedOptions']/label[5]");
		AvoidTimedRestrictions      = new checkbox  (page, "//div[@id='advancedOptions']/label[6]");
		AvoidSeasonallyClosedRoads  = new checkbox  (page, "//div[@id='advancedOptions']/label[7]");
		AvoidFerries				= new checkbox  (page, "//div[@id='advancedOptions']/label[8]");

	}
}