package com.aol.functest.mobileweb.std.common.uiobjects;
/**
*	This class defines UI objects of Direction result Page for Std Browsers
*	@version 1.0
*	@author Amitha
*/

import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.image;
import com.aol.functest.common.link;


public class DirectionResultPageUIStd {

	private static DirectionResultPageUIStd dtrInststd = null;
	private browserpage page;

	private DirectionResultPageUIStd(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static DirectionResultPageUIStd getInstance(browserpage page) {
		if (null == dtrInststd) {
			dtrInststd = new DirectionResultPageUIStd(page);
		}
		return dtrInststd;
	}
	

	public image map_image;
	public button zoomin_button;
	public button zoomout_button;
	public button Uparrow_button;
	public button Downarrow_button;
	public button Leftarrow_button;
	public button Rightarrow_button;
	public image FindBizNearByI;
	public link FindBizNearByL;
	public link Road_Sh_1;
	public link Road_Sh_2;
	public link Road_Sh_3;
	public link Road_Sh_4;
	public link Road_Sh_5;
	public link pagination_next_link;
	public link Change_Route_Options;
	public link FindBusinessNearbyL;
	public link ViewTraffic;
	public link Home_link;
	public link AOL_Mobile_Link;
	public link Legal_Terms_Privacy;
	public link Terms_of_use;

	public void initUIElements() {
		map_image				= new image 	(page, "css=img[alt='map']");
		zoomin_button          = new button    (page, "//tr/td[1]/a");
		zoomout_button         = new button    (page, "//tr/td[2]/a");
		Uparrow_button         = new button    (page, "//tr/td[3]/a"); 
		Downarrow_button     	= new button    (page, "//tr/td[4]/a");
		Leftarrow_button       = new button    (page, "//tr/td[5]/a"); 
		Rightarrow_button      = new button    (page, "//tr/td[6]/a"); 
		FindBizNearByI         = new image     (page, "//div[@class='padded']/img"); 
		FindBizNearByL         = new link      (page, "//div[@class='padded']/a"); 
		Road_Sh_1              = new link      (page, "//div[@class='manueverList']/table/tbody/tr[1]/td[1]"); 
		Road_Sh_2              = new link      (page, "//div[@class='manueverList']/table/tbody/tr[2]/td[1]"); 
		Road_Sh_3              = new link      (page, "//div[@class='manueverList']/table/tbody/tr[3]/td[1]");
		Road_Sh_4              = new link      (page, "//div[@class='manueverList']/table/tbody/tr[4]/td[1]");
		Road_Sh_5              = new link      (page, "//div[@class='manueverList']/table/tbody/tr[5]/td[1]");
		pagination_next_link   = new link      (page, "//div[@class='pagination']/a");
		Change_Route_Options   = new link      (page, "css=a:contains('Change Route Options')");
		FindBusinessNearbyL    = new link      (page, "css=a:contains('Find Business Nearby')");
		ViewTraffic         	= new link     (page, "css=a:contains('View Traffic')");
		Home_link				= new link      (page, "//div[@class='menu']/a[@href='/?pva=DRhm']");
		AOL_Mobile_Link		= new link		(page, "css=a[href='http://wap.aol.com/portal/']");
		Legal_Terms_Privacy	= new link		(page, "css=a:contains('Legal Terms and Privacy')");
		Terms_of_use			= new link		(page, "//a[contains(text(),'Terms of Use')]");
	
	}
}
