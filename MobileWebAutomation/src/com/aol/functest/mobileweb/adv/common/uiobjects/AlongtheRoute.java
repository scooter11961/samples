/**
*	This class defines UI objects of Along the Route page (Page which displays after clicking on Along the Route link in Near a Location page)for Advance Browsers
*	@version 1.0
*	@author Amitha
*/

package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.*;


public class AlongtheRoute {
	private static AlongtheRoute sar = null;
	private browserpage page;

	private AlongtheRoute(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static AlongtheRoute getInstance(browserpage page) {
		if (null == sar) {
			sar = new AlongtheRoute(page);
		}
		return sar;
	} 

	//General UI Elements
	public link 		Mapquest;
	public dropdown		Menu;
	public link			NearALocation;
	public button 		Back;
	public button 		ViewRoute;
	public link         RouteNarrative_step1;
	public link         RouteNarrative_step2;
	public link         RouteNarrative_step3;
	public link         RouteNarrative_step4;
	public link         RouteNarrative_step5;
	public link         RouteNarrative_step6;
	public link         RouteNarrative_step7;
	public link 		RouteNarrative_Miles1;
	public link 		RouteNarrative_Miles2;
	public link 		RouteNarrative_Miles3;
	public link 		RouteNarrative_Miles4;
	public link 		RouteNarrative_Miles5;
	public link 		RouteNarrative_Miles6;
	public link 		RouteNarrative_Miles7;
	public button       RouteNarrative_Button1;
	public button       RouteNarrative_Button2;
	public button       RouteNarrative_Button3;
	public button       RouteNarrative_Button4;
	public button       RouteNarrative_Button5;
	public button       RouteNarrative_Button6;
	public button       RouteNarrative_Button7;

	public void initUIElements() {
		Mapquest                		= new link   		(page, "//div[@id='nav']/a/img[@id='logo']");
		Menu                			= new dropdown 		(page, "//div[@id='nav']/button[@id='menu_link']");
		NearALocation					= new link			(page, "//div[@id='wrap_content_main']/div[@class='tabContainer contentBody']/div[1]/a");
		Back							= new button 		(page, "//div[@id='wrap_content_main']/div[@class='contentHeader round_border_top']/div[1]/button");
		ViewRoute						= new button        (page, "//div[@id='wrap_content_main']/div[@class='contentHeader round_border_top']/div[2]/button");
		RouteNarrative_step1            = new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step1']/td[1]/a[1]");
		RouteNarrative_step2            = new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step2']/td[1]/a[1]");
		RouteNarrative_step3            = new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step3']/td[1]/a[1]");
		RouteNarrative_step4            = new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step4']/td[1]/a[1]");
		RouteNarrative_step5            = new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step5']/td[1]/a[1]");
		RouteNarrative_step6            = new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step6']/td[1]/a[1]");
		RouteNarrative_step7            = new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step7']/td[1]/a[1]");
		RouteNarrative_Miles1   		= new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step1']/td[1]/a[2]");
		RouteNarrative_Miles2   		= new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step2']/td[1]/a[2]");
		RouteNarrative_Miles3   		= new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step3']/td[1]/a[2]");
		RouteNarrative_Miles4   		= new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step4']/td[1]/a[2]");
		RouteNarrative_Miles5   		= new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step5']/td[1]/a[2]");
		RouteNarrative_Miles6   		= new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step6']/td[1]/a[2]");
		RouteNarrative_Miles7   		= new link			(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step7']/td[1]/a[2]");
		RouteNarrative_Button1          = new button		(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step1']/td[3]/span");
		RouteNarrative_Button2          = new button		(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step2']/td[3]/span");
		RouteNarrative_Button3          = new button		(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step3']/td[3]/span");
		RouteNarrative_Button4          = new button		(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step4']/td[3]/span");
		RouteNarrative_Button5          = new button		(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step5']/td[3]/span");
		RouteNarrative_Button6          = new button		(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step6']/td[3]/span");
		RouteNarrative_Button7          = new button		(page, "//div[@class='routeNarrative']/table/tbody/tr[@id='step7']/td[3]/span");
	}
}