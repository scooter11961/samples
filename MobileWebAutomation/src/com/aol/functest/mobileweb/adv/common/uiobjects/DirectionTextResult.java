/**
*	This class defines UI objects of Direction Text result Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/


package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;
import com.aol.functest.common.image;
import com.aol.functest.common.checkbox;

public class DirectionTextResult {

	private static DirectionTextResult dtrInst = null;
	private browserpage page;

	private DirectionTextResult(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static DirectionTextResult getInstance(browserpage page) {
		if (null == dtrInst) {
			dtrInst = new DirectionTextResult(page);
		}
		return dtrInst;
	}

	public button    ShowMap;
	public link      Mapquest;
	public dropdown  Menu;
	public link      Start_Star; 
	public link      End_Star;
	public link      Road_Sh_1; 
	public link      Road_Sh_2; 
	public link      Road_Sh_3; 
	public link      Road_Sh_4; 
	public link      Road_Sh_5; 
	public link      Road_Sh_6; 
	public link      Road_Sh_7;
	public link      footer;
	public link      RandomRoadNarrative;
	public image     FindBusinessNearbyI;
	public image     SearchBusinessNearbyI;
	public link      FindBusinessNearbyL;
	public link      SearchBusinessNearbyL;
	public button    Options;
	public button 	 view;
	public checkbox  traffic;
	public image	 trafficImage;
	public image	 directionsImage;
	public button    zoomOut;
	public button    zoomIn;

	public void initUIElements() {
		ShowMap                = new button    (page, "//div[3]/button");
		Mapquest               = new link      (page, "//img[@id='logo']");
		Menu                   = new dropdown  (page, "//button[@id='menu_link']");
		Start_Star             = new link      (page, "//div[@id='loc0']/img"); 
		End_Star               = new link      (page, "//div[@id='loc1']/img");
		Road_Sh_1              = new link      (page, "//div[@id='narrative0']/table/tbody/tr[1]/td[1]/img"); 
		Road_Sh_2              = new link      (page, "//div[@id='narrative0']/table/tbody/tr[2]/td[1]/img"); 
		Road_Sh_3              = new link      (page, "//div[@id='narrative0']/table/tbody/tr[3]/td[1]/img"); 
		Road_Sh_4              = new link      (page, "//div[@id='narrative0']/table/tbody/tr[4]/td[1]/img"); 
		Road_Sh_5              = new link      (page, "//div[@id='narrative0']/table/tbody/tr[5]/td[1]/img"); 
		Road_Sh_6              = new link      (page, "//div[@id='narrative0']/table/tbody/tr[6]/td[1]/img"); 
		Road_Sh_7              = new link      (page, "//div[@id='narrative0']/table/tbody/tr[7]/td[1]/img");
		footer                 = new link      (page, "//div[@id='wrap_content_main']/div[@class='DDdisclaimer']");
		RandomRoadNarrative    = new link      (page, "//div[@id='narrative0']/table/tbody/tr[6]/td[2]");
		FindBusinessNearbyI    = new image     (page, "//div[@class='contentBody optionsContentWrap contentFooterLite round_border_bottom dirResultsLinks']/div[2]/img");
		SearchBusinessNearbyI  = new image     (page, "//div[@class='contentBody optionsContentWrap contentFooterLite round_border_bottom dirResultsLinks']/div[3]/img");
		FindBusinessNearbyL    = new link      (page, "//div[@class='contentBody optionsContentWrap contentFooterLite round_border_bottom dirResultsLinks']/div[2]/p/a");
		SearchBusinessNearbyL  = new link      (page, "//div[@class='contentBody optionsContentWrap contentFooterLite round_border_bottom dirResultsLinks']/div[3]/p/a");
		Options                = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentHeader round_border_top']/div[@class='fltl wrap-options-btn']/button");
		view				   = new button    (page,"//div[@id='mcontrols']/button[3]");
		traffic				   = new checkbox  (page,"//input[@id='trafficCheckbox']");
		trafficImage		   = new image	   (page, "//div[@id='map']/div/div/div[7]/img");
		zoomOut				   = new button    (page,"//div[@id='mcontrols']/button[1]");
		zoomIn				   = new button    (page,"//div[@id='mcontrols']/button[2]");
		directionsImage        = new image 	   (page,"//div[@id='map']/div/div/div[10]/img");
	}

}
