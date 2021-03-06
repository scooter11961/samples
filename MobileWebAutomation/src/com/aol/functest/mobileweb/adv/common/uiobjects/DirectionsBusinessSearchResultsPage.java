	/**
	*	This class defines UI objects of Business Search Results from maps/ directions page for Advance Browsers (New Requirement introduced at the end of Release 5)
	*	@version 1.0
	*	@author Amitha
	*/

package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.*;

public class DirectionsBusinessSearchResultsPage {

	private static DirectionsBusinessSearchResultsPage dirBizRes = null;
	private browserpage page;

	private DirectionsBusinessSearchResultsPage(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static DirectionsBusinessSearchResultsPage getInstance(browserpage page) {
		if (null == dirBizRes) {
			dirBizRes = new DirectionsBusinessSearchResultsPage(page);
		}
		return dirBizRes;
	}

	// General UI Elements
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
	public button      Add_To_Route_1;	
	public button      Add_To_Route_2;
	public button      Add_To_Route_3;	
	public button      Add_To_Route_4;	
	public button      Add_To_Route_5;	
	public button      Add_To_Route_6;	
	public button      Add_To_Route_7;	
	public button      Add_To_Route_8;	
	public button      Add_To_Route_9;	
	public button      Add_To_Route_10;
	public text        SearchResult_1;
	public text        SearchResult_2;
	public text        SearchResult_3;
	public text        SearchResult_4;
	public text        SearchResult_5;
	public text        SearchResult_6;
	public text        SearchResult_7;
	public text        SearchResult_8;
	public text        SearchResult_9;
	public text        SearchResult_10;
	public text        Next;
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
		Add_To_Route_1          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[1]/td[3]/div/div[2]/a");	
		Add_To_Route_2          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[2]/td[3]/div/div[2]/a");
		Add_To_Route_3          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[3]/td[3]/div/div[2]/a");	
		Add_To_Route_4          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[4]/td[3]/div/div[2]/a");	
		Add_To_Route_5          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[5]/td[3]/div/div[2]/a");	
		Add_To_Route_6          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[6]/td[3]/div/div[2]/a");	
		Add_To_Route_7          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[7]/td[3]/div/div[2]/a");	
		Add_To_Route_8          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[8]/td[3]/div/div[2]/a");	
		Add_To_Route_9          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[9]/td[3]/div/div[2]/a");	
		Add_To_Route_10         = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[10]/td[3]/div/div[2]/a");
		SearchResult_1          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[1]/td[2]");
		SearchResult_2          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[2]/td[2]");
		SearchResult_3          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[3]/td[2]");
		SearchResult_4          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[4]/td[2]");
		SearchResult_5          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[5]/td[2]");
		SearchResult_6          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[6]/td[2]");
		SearchResult_7          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[7]/td[2]");
		SearchResult_8          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[8]/td[2]");
		SearchResult_9          = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[9]/td[2]");
		SearchResult_10         = new text      (page, "//div[@id='wrap_content_main']/div[@class='contentBody contentFooterLite round_border_bottom']/table/tbody/tr[10]/td[2]");
		Next                    = new text      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/a");
		DataByInfoUSA           = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/img");
	}

}
