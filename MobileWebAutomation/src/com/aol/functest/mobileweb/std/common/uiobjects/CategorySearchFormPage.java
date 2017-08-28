package com.aol.functest.mobileweb.std.common.uiobjects;
//creator @ Amitha

	import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
	import com.aol.functest.common.dropdown;
	import com.aol.functest.common.image;
import com.aol.functest.common.link;

	public class CategorySearchFormPage {
		
		
		private static CategorySearchFormPage bspInstStd = null;
		private browserpage page;
		private CategorySearchFormPage(browserpage page) {
			this.page = page;
			initUIElements();
		}
		public static CategorySearchFormPage getInstance(browserpage page) {
			if (null == bspInstStd) {
				bspInstStd = new CategorySearchFormPage(page);
			}
			return bspInstStd;
		}
		
		public link      Mapquest;
		public button    Back;
		public image  Restaurant_I;
		public image  GasStation_I;
		public image  ParkingGarage_I;
		public image  PostOffice_I;
		public image  CoffeeShops_I;
		public image  GroceryStores_I;
		public image  Hotels_I;
		public image  IceCreamShops_I;
		public image  Bars_I;
		public image  Pharmacies_I;

		public link  Restaurant_L;
		public link  GasStation_L;
		public link  ParkingGarage_L;
		public link  PostOffice_L;
		public link  CoffeeShops_L;
		public link  GroceryStores_L;
		public link  Hotels_L;
		public link  IceCreamShops_L;
		public link  Bars_L;
		public link  Pharmacies_L;
		public link  AOLMobile_Link;
		public link  LegalTermsandPrivacy_Link;
		public link	 Home;
		
		public void initUIElements(){
			Mapquest               = new link      (page,"//img[@alt='MapQuest']");
			Back                   = new button    (page,"//div[@class='padded5px']/a[@href='/maps?form=search&pva=SCbck']");
			Restaurant_I            	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/restaurants.png')]");
			GasStation_I            	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/gas.png')]");
			ParkingGarage_I         	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/parking.png')]");
			PostOffice_I            	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/postoffice.png')]");
			CoffeeShops_I           	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/coffee.png')]");
			GroceryStores_I         	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/groceries.png')]");
			Hotels_I                	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/hotel.png')]");
			IceCreamShops_I         	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/icecream.png')]");
			Bars_I                  	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/bars.png')]");
			Pharmacies_I            	= new image     (page,"//img[contains(@src,'http://cdn.mapquest.com/bizloc_general/pharmacies.png')]");

			Restaurant_L               = new link      (page,"//a[contains(text(),'Restaurants')]");
			GasStation_L               = new link      (page,"//a[contains(text(),'Gas Stations')]");
			ParkingGarage_L            = new link      (page,"//a[contains(text(),'Parking Garages')]");
			PostOffice_L               = new link      (page,"//a[contains(text(),'Post Offices')]");
			CoffeeShops_L              = new link      (page,"//a[contains(text(),'Coffee Shops')]");
			GroceryStores_L            = new link      (page,"//a[contains(text(),'Grocery Stores')]");
			Hotels_L                   = new link      (page,"//a[contains(text(),'Hotels')]");
			IceCreamShops_L            = new link      (page,"//a[contains(text(),'Ice Cream Shops')]");
			Bars_L                     = new link      (page,"//a[contains(text(),'Bars')]");
			Pharmacies_L               = new link      (page,"//a[contains(text(),'Pharmacies')]");
			AOLMobile_Link             = new link      (page,"//a[@href='http://wap.aol.com/portal/']");
			LegalTermsandPrivacy_Link  = new link      (page,"//a[contains(@href, '/terms-of-use')]");
			Home					    = new link	    (page,"//a[contains(text(),'Home')]");

		}
		

	}

