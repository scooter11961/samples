/**
*	This class defines UI objects of Near a Location Page(Page which displays after clicking on Find Business Near By link in Directions Text REsult Page)for Advance Browsers
*	@version 1.0
*	@author Amitha
*/

package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.*;

public class NearALocation {

	private static NearALocation NrALoc = null;
	private browserpage page;

	private NearALocation(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static NearALocation getInstance(browserpage page) {
		if (null == NrALoc) {
			NrALoc = new NearALocation(page);
		}
		return NrALoc;
	}

	// General UI Elements
	public link 			mapquest;
	public dropdown 		menu;
	public link 			start_loc;
	public link 			end_loc;
	//public text             start_text;
	//public text			    end_text;
	public button 			start_loc_b;
	public button 			end_loc_b;
	public link 			start_star;
	public link 			end_star;
	public button 			along_the_route;
	public button           back;
	public button           view_route;

	public void initUIElements() {
		mapquest 				= new link 			(page, "//div[@id='nav']/a/img[@id='logo']");
		menu 					= new dropdown		(page, "//div[@id='nav']/button[@id='menu_link']");
		start_loc 				= new link 			(page, "//div[@id='wrap_content_main']/div[6]/table/tbody/tr[@id='loc0']/td[2]/a");
		end_loc 				= new link 			(page, "//div[@id='wrap_content_main']/div[6]/table/tbody/tr[@id='loc1']/td[2]/a");
		//start_text              = new text          (page, "//div[@id='wrap_content_main']/div[6]/table/tbody/tr[@id='loc0']/td[2]/a");
		//end_text 				= new text 			(page, "//div[@id='wrap_content_main']/div[6]/table/tbody/tr[@id='loc1']/td[2]/a");
		start_loc_b 			= new button 		(page, "//div[@id='wrap_content_main']/div[6]/table/tbody/tr[@id='loc0']/td[3]/span");
		end_loc_b 				= new button 		(page, "//div[@id='wrap_content_main']/div[6]/table/tbody/tr[@id='loc1']/td[3]/span");
		start_star				= new link			(page, "//div[@id='wrap_content_main']/div[6]/table/tbody/tr[@id='loc0']/td[1]/img");
		end_star				= new link			(page, "//div[@id='wrap_content_main']/div[6]/table/tbody/tr[@id='loc1']/td[1]/img");
		along_the_route 		= new button 		(page, "//div[@id='wrap_content_main']/div[5]/div[2]/a");
		back                    = new button        (page, "//div[4]/div[1]/button");
		view_route              = new button        (page, "//div[4]/div[2]/button");
	}

}
