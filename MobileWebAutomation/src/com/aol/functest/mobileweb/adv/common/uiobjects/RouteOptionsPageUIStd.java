/**
*	This class defines UI objects of Route Options Page for Std Browsers
*	@version 1.0
*	@author Amitha
*/

package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.*;

public class RouteOptionsPageUIStd {
	
	/**
	 * Creating the Singleton to access elements in this class.
	 */
	private static RouteOptionsPageUIStd routeoptstd = null;
	private browserpage page;

	private RouteOptionsPageUIStd (browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static RouteOptionsPageUIStd getInstance (browserpage page) {
		if (null == routeoptstd) {
			routeoptstd = new RouteOptionsPageUIStd(page);
		}
		return routeoptstd;
	}

	// General UI Elements
	public link  	back_link;
	public radio 	Shortest_Driving_time;
	public radio 	Shortest_Driving_Distance;
	public radio 	Walking_Directions;
	public checkbox Avoid_Highways;
	public checkbox	Avoid_Toll_Roads;
	public checkbox Avoid_Seasonally_Closed_Roads;
	public button	Go_Button;
	public link		Home_Link;
	public link		Aol_Mobile;
	public link		Legal_Terms_Privacy;
	public link		Mapquest;

	public void initUIElements() {
		back_link                       = new link  		(page, "//body/a[@class='paddingBottom10px']");
		Shortest_Driving_time			= new radio			(page, "//div/input[1]");
		Shortest_Driving_Distance		= new radio			(page, "//div/input[2]");
		Walking_Directions				= new radio 		(page, "//div/input[3]");
		Avoid_Highways					= new checkbox		(page, "//div/input[4]");
		Avoid_Toll_Roads				= new checkbox		(page, "//div/input[5]");
		Avoid_Seasonally_Closed_Roads	= new checkbox		(page, "//div/input[6]");
		Go_Button						= new button		(page, "//div/input[@class='button']");
		Home_Link						= new link			(page, "//div[@class='menu']/a");
		Aol_Mobile						= new link 			(page, "//div[@class='footerText']/a[@href='http://wap.aol.com/portal/']");
		Legal_Terms_Privacy				= new link 			(page, "//div[@class='footerText']/a[@href='/terms-of-use']");
		Mapquest						= new link			(page, "//div[@class='logo']/a/img");
	}

}
