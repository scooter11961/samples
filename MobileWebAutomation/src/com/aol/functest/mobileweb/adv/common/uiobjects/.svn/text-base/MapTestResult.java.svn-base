/**
*	This class defines UI objects of Map Text result Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/



package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.*;

public class MapTestResult {
	
	private static MapTestResult mtrInst = null;
	private browserpage page;

	private MapTestResult(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static MapTestResult getInstance (browserpage page) {
		if (null == mtrInst) {
			mtrInst = new MapTestResult(page);
		}
		return mtrInst;
	}

	public link      Mapquest;
	public dropdown  Menu;
	public button    ShowLargerMap;
	public image     thumbnailMap;
	public link      FindBizLocNearby;
	public link      SearchBizNearby;
	public link      GetDirFromHere;
	public link      GetDirToHere;
	public image     Icon_FindBizLocNearby;
	public image     Icon_SearchBizNearby;
	public image     Icon_GetDirFromHere;
	public image     Icon_GetDirToHere;	

	public void initUIElements() {
		Mapquest               = new link      (page, "//img[@id='logo']");
		Menu                   = new dropdown  (page, "//div[@id='nav']/button[@id='menu_link']");
		ShowLargerMap          = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentHeader round_border_top optionsContentWrap']/div[2]/button");
		thumbnailMap           = new image     (page, "//div[1]/a/img");
		FindBizLocNearby       = new link      (page, "//div[1]/p/a");
		SearchBizNearby        = new link      (page, "//div[2]/p/a");
		GetDirFromHere         = new link      (page, "//div[3]/p/a");
		GetDirToHere           = new link      (page, "//div[4]/p/a");
		Icon_FindBizLocNearby  = new image     (page, "//div[@class='contentHeaderLite round_border_top round_border_bottom mapResultsLinks']/div[1]/img");
		Icon_SearchBizNearby   = new image     (page, "//div[@class='contentHeaderLite round_border_top round_border_bottom mapResultsLinks']/div[2]/img");
		Icon_GetDirFromHere    = new image     (page, "//div[@class='contentHeaderLite round_border_top round_border_bottom mapResultsLinks']/div[3]/img");
		Icon_GetDirToHere      = new image     (page, "//div[@class='contentHeaderLite round_border_top round_border_bottom mapResultsLinks']/div[4]/img");	
	}

}
