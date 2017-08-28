//creator @ shiladithya
//updated by @ Amitha
package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.image;
import com.aol.functest.common.link;

public class BrandBizSearchPage {
	
	private static BrandBizSearchPage bspInst = null;
	private browserpage page;

	private BrandBizSearchPage(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static BrandBizSearchPage getInstance (browserpage page) {
		if (null == bspInst) {
			bspInst = new BrandBizSearchPage(page);
		}
		return bspInst;
	}

	public link      Mapquest;
	public dropdown  Menu;
	public button    Back;
	public image  RestaurantIcon;
	public image  GasStationIcon;
	public image  ParkingGarageIcon;
	public image  PostOfficeIcon;
	public image  CoffeeShopsIcon;
	public image  GroceryStoresIcon;
	public image  HotelsIcon;
	public image  IceCreamShopsIcon;
	public image  BarsIcon;
	public image  PharmaciesIcon;
	
	public link  Restaurant;
	public link  GasStation;
	public link  ParkingGarage;
	public link  PostOffice;
	public link  CoffeeShops;
	public link  GroceryStores;
	public link  Hotels;
	public link  IceCreamShops;
	public link  Bars;
	public link  Pharmacies;

	public void initUIElements() {
		Mapquest               = new link      (page, "//a/img[@id='logo']");
		Menu                   = new dropdown  (page, "//button[@id='menu_link']");
		Back                   = new button    (page, "//div[@id='wrap_content_main']/div[@class='contentHeader round_border_top']/a");
		RestaurantIcon            = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[1]/img[1]");
		GasStationIcon            = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[2]/img[1]");
		ParkingGarageIcon         = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[3]/img[1]");
		PostOfficeIcon            = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[4]/img[1]");
		CoffeeShopsIcon           = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[5]/img[1]");
		GroceryStoresIcon         = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[6]/img[1]");
		HotelsIcon                = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[7]/img[1]");
		IceCreamShopsIcon         = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[8]/img[1]");
		BarsIcon                  = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[9]/img[1]");
		PharmaciesIcon            = new image     (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[10]/img[1]");
		
		Restaurant                 = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[1]/a");
		GasStation                 = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[2]/a");
		ParkingGarage              = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[3]/a");
		PostOffice                 = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[4]/a");
		CoffeeShops                = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[5]/a");
		GroceryStores              = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[6]/a");
		Hotels                     = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[7]/a");
		IceCreamShops              = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[8]/a");
		Bars                       = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[9]/a");
		Pharmacies                 = new link      (page, "//div[@class='contentBody contentFooterLite round_border_bottom']/div/div[10]/a");
	}
}
