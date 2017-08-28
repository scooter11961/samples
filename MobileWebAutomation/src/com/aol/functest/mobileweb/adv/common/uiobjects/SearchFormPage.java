/**
*	This class defines UI objects of Search form Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/



package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.*;

/**
*	Class the defines the object of Search Form page of wap.mapquest.com
*	@version 1.0
*	@author shiladitya
*/
public class SearchFormPage {

	private static SearchFormPage sfpInst = null;
	private browserpage page;

	private SearchFormPage(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static SearchFormPage getInstance(browserpage page) {
		if (null == sfpInst) {
			sfpInst = new SearchFormPage(page);
		}
		return sfpInst;
	}
	
	public void SearchBusiness(String Business , String Location) 
	{
		DirectionFormPage.getInstance(page).Mapquest.click();
	    page.waitForPageToLoad (page.sTIMEOUT);	
	    page.click(DirectionFormPage.getInstance(page).Menu.getWindowID());
	    DirectionFormPage.getInstance(page).Menu_Search.click();
	    page.waitForPageToLoad (page.sTIMEOUT);       
	    String sSearch = Business;	
	    String MapAdd = Location;
	    Search_for.setText(sSearch);
	    Near.setText(MapAdd);		
	    Search.click();
	    page.waitForPageToLoad (page.sTIMEOUT);
	}

	public link        Mapquest;
	public dropdown    Menu;
	public link        Search_by_Categories;
	public textfield   Search_for;
	public textfield   Near;
	public button      V_Near;
	public button      Search;

	public void initUIElements() {
		Mapquest                = new link      (page, "css= img[id='logo']");
		Menu                    = new dropdown  (page, "css= #menu_link");
		Search_by_Categories    = new link      (page, "css= a:contains('Search by Categories')");
		Search_for              = new textfield (page, "css= input[id='cat']");
		Near                    = new textfield (page, "css= input[id='1ai']");
		V_Near                  = new button    (page, "css= button[class='recentBtn']");
		Search                  = new button    (page, "css= input[id='btnGetSearch']");
	}

}
