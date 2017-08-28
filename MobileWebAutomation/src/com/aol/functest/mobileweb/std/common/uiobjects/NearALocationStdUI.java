package com.aol.functest.mobileweb.std.common.uiobjects;
/**
*	This class defines UI objects of Near a Location Page(Page which displays after clicking on Find Business Near By link in Directions Text REsult Page)for Std Browsers
*	@version 1.0
*	@author Amitha
*/

import com.aol.functest.common.*;

public class NearALocationStdUI {
	
	private static NearALocationStdUI NrALocStd = null;
	private browserpage page;
	private NearALocationStdUI(browserpage page) {
		this.page = page;
		initUIElements();
	}
	public static NearALocationStdUI getInstance(browserpage page) {
		if (null == NrALocStd) {
			NrALocStd = new NearALocationStdUI(page);
		}
		return NrALocStd;
	}

	// General UI Elements

		public link 			mapquest; 	
		public link 			view_route;	
		public link 			A_Start_Loc; 
		public link 			B_end_Loc;	
		public link 			start_loc; 	
		public link 			end_loc;		
		public link 			along_the_route;
		public link           	Home;           
		public link				AOL_Mobile_Link;
		public link				Legal_Terms_Privacy;	

	public void initUIElements(){
		mapquest 				= new link 			(page,"//img[@alt='MapQuest']");
		view_route 				= new link 			(page,"//div[2]/a");
		A_Start_Loc 			= new link 			(page,"//div[5]/a[1]");
		B_end_Loc				= new link			(page,"//div[6]/a[1]");
		start_loc 				= new link 			(page,"//div[5]/a[2]");
		end_loc					= new link 			(page,"//div[6]/a[2]");
		along_the_route 		= new link 			(page,"//div[8]/a");
		Home                    = new link        	(page,"//div[@class='menu']/a[@accesskey='0']");
		AOL_Mobile_Link			= new link			(page,"//a[@href='http://wap.aol.com/portal/']");
		Legal_Terms_Privacy		= new link 			(page,"//a[contains(@href, '/terms-of-use')]");

	}
}

	


