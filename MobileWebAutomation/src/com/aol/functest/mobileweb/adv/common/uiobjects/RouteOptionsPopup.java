/**
*	This class defines UI objects of Route Options Pop up 
*	@version 1.0
*	@author Amitha
*/

package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.*;



public class RouteOptionsPopup {

	private static RouteOptionsPopup rtopt = null;
	private browserpage page;

	private RouteOptionsPopup(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static RouteOptionsPopup getInstance(browserpage page){
		if (null == rtopt) {
			rtopt = new RouteOptionsPopup(page);
		}
		return rtopt;
	} 

	//General UI Elements
	public button   Recalculate_Route;
	public radio	shortest_time;
	public radio	shortest_distance;
	public radio	walking_directions;
	public checkbox Avoid_Highways;
	public checkbox Avoid_Toll_Roads;
	public checkbox Avoid_Closed_Roads;
	public button 	popup_close;

	public void initUIElements() {
		Recalculate_Route	= new button		(page, "//button[@id='mrwno']");
		shortest_time		= new radio 		(page, "//input[@id='fastest']");
		shortest_distance	= new radio			(page, "//input[@id='shortest']");
		walking_directions	= new radio 		(page, "//input[@id='walking']");
		Avoid_Highways		= new checkbox		(page, "//input[@id='aoh']");
		Avoid_Toll_Roads	= new checkbox		(page, "//input[@id='aot']");
		Avoid_Closed_Roads	= new checkbox		(page, "//input[@id='aos']");
		popup_close			= new button		(page, "//img[@id='closeOptions']");
	}
}
