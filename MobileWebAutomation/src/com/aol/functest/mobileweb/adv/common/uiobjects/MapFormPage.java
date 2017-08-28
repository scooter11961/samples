/**
*	This class defines UI objects of Map Form Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/



package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.*;

/**
*	Class the defines the object of Map Search page of wap.mapquest.com
*	@version 1.0
*	@author shiladitya
*/
public class MapFormPage {	
	
	private static MapFormPage mfpInst = null;
	private browserpage page;

	private MapFormPage(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static MapFormPage getInstance(browserpage page) {
		if (null == mfpInst) {
			mfpInst = new MapFormPage(page);
		}
		return mfpInst;
	}

	public void SearchMap(String Location) 
	{
		DirectionFormPage.getInstance(page).Mapquest.click();
	    page.waitForPageToLoad (page.sTIMEOUT);	
	    page.click(DirectionFormPage.getInstance(page).Menu.getWindowID());
	    DirectionFormPage.getInstance(page).Menu_Map.click();
		page.waitForPageToLoad (page.sTIMEOUT);       
	    String MapAdd = Location;			
		EnterLocation.setText(MapAdd);		
		getMap.click();
		page.waitForPageToLoad (page.sTIMEOUT);
	}

	public link      Mapquest;
	public dropdown  Menu;
	public textfield EnterLocation;
	public button    V_EnterLocation;
	public button    getMap;

	public void initUIElements() {
		Mapquest               = new link      (page, "css= img[id='logo']");
		Menu                   = new dropdown  (page, "css= #menu_link");
		EnterLocation          = new textfield (page, "css= #mapForm #addressInput");
		V_EnterLocation        = new button    (page, "css= button[class='recentBtn']");
		getMap                 = new button    (page, "css= #mapForm #btnGetMap");
	}
}
