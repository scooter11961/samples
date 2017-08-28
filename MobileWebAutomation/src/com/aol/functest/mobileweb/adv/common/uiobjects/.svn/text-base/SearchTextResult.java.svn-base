/**
*	This class defines UI objects of Search Text Result Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/



package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.*;

/**
*	Class the defines the object of Main page of wap.mapquest.com
*	@version 1.0
*	@author manjunathabm
*/
public class SearchTextResult {
	
	private static SearchTextResult strInst = null;
	private browserpage page;

	private SearchTextResult(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static SearchTextResult getInstance(browserpage page) {
		if (null == strInst) {
			strInst = new SearchTextResult(page);
		}
		return strInst;
	}

	public link        Mapquest;
	public dropdown    Menu;
	public button      Show_Map_POI;
	public button      Refine_Search;
	public button      Show_Map_1;
	public button      Show_Map_2;
	public button      Show_Map_3;
	public button      Show_Map_4;
	public button      Show_Map_5;
	public button      Show_Map_6;
	public button      Show_Map_7;
	public button      Show_Map_8;
	public button      Show_Map_9;
	public button      Show_Map_10;
	public button      Get_Direction_1;	
	public button      Get_Direction_2;
	public button      Get_Direction_3;	
	public button      Get_Direction_4;	
	public button      Get_Direction_5;	
	public button      Get_Direction_6;	
	public button      Get_Direction_7;	
	public button      Get_Direction_8;	
	public button      Get_Direction_9;	
	public button      Get_Direction_10;
	public link        SearchResult_1;
	public link        SearchResult_2;
	public link        SearchResult_3;
	public link        SearchResult_4;
	public link        SearchResult_5;
	public link        SearchResult_6;
	public link        SearchResult_7;
	public link        SearchResult_8;
	public link        SearchResult_9;
	public link        SearchResult_10;
	public link        Next;
	public image       DataByInfoUSA;

	public void initUIElements() {
		Mapquest                = new link      (page, "//img[@id='logo']");
		Menu                    = new dropdown  (page, "//button[@id='menu_link']");
		Show_Map_POI            = new button    (page, "//div[@class='contentHeader round_border_top']/button[2]");
		Refine_Search           = new button    (page, "//div[@class='contentHeader round_border_top']/button[1]");
		Show_Map_1              = new button    (page, "//tr[1]/td[3]/div/div[1]/a");
		Show_Map_2              = new button    (page, "//tr[2]/td[3]/div/div[1]/a");
		Show_Map_3              = new button    (page, "//tr[3]/td[3]/div/div[1]/a");
		Show_Map_4              = new button    (page, "//tr[4]/td[3]/div/div[1]/a");
		Show_Map_5              = new button    (page, "//tr[5]/td[3]/div/div[1]/a");
		Show_Map_6              = new button    (page, "//tr[6]/td[3]/div/div[1]/a");
		Show_Map_7              = new button    (page, "//tr[7]/td[3]/div/div[1]/a");
		Show_Map_8              = new button    (page, "//tr[8]/td[3]/div/div[1]/a");
		Show_Map_9              = new button    (page, "//tr[9]/td[3]/div/div[1]/a");
		Show_Map_10             = new button    (page, "//tr[10]/td[3]/div/div[1]/a");
		Get_Direction_1         = new button    (page, "//tr[1]/td[3]/div/div[2]/a");	
		Get_Direction_2         = new button    (page, "//tr[2]/td[3]/div/div[2]/a");
		Get_Direction_3         = new button    (page, "//tr[3]/td[3]/div/div[2]/a");	
		Get_Direction_4         = new button    (page, "//tr[4]/td[3]/div/div[2]/a");	
		Get_Direction_5         = new button    (page, "//tr[5]/td[3]/div/div[2]/a");	
		Get_Direction_6         = new button    (page, "//tr[6]/td[3]/div/div[2]/a");	
		Get_Direction_7         = new button    (page, "//tr[7]/td[3]/div/div[2]/a");	
		Get_Direction_8         = new button    (page, "//tr[8]/td[3]/div/div[2]/a");	
		Get_Direction_9         = new button    (page, "//tr[9]/td[3]/div/div[2]/a");	
		Get_Direction_10        = new button    (page, "//tr[10]/td[3]/div/div[2]/a");
		SearchResult_1          = new link      (page, "//tr[1]/td[2]/a");
		SearchResult_2          = new link      (page, "//tr[2]/td[2]/a");
		SearchResult_3          = new link      (page, "//tr[3]/td[2]/a");
		SearchResult_4          = new link      (page, "//tr[4]/td[2]/a");
		SearchResult_5          = new link      (page, "//tr[5]/td[2]/a");
		SearchResult_6          = new link      (page, "//tr[6]/td[2]/a");
		SearchResult_7          = new link      (page, "//tr[7]/td[2]/a");
		SearchResult_8          = new link      (page, "//tr[8]/td[2]/a");
		SearchResult_9          = new link      (page, "//tr[9]/td[2]/a");
		SearchResult_10         = new link      (page, "//tr[10]/td[2]/a");
		Next                    = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/a");
		DataByInfoUSA           = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/img");
	}

}