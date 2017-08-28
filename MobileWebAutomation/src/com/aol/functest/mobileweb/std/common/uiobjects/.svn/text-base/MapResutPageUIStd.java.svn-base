package com.aol.functest.mobileweb.std.common.uiobjects;
/**
*	This class defines UI objects of Map Text result Page for Std Browsers UnAuthenticated Page
*	@version 1.0
*	@author Amitha
*/

import com.aol.functest.common.*;

public class MapResutPageUIStd {
	
	private static MapResutPageUIStd mtrInstd = null;
	private browserpage page;
	
	private MapResutPageUIStd(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static MapResutPageUIStd getInstance(browserpage page) {
		if (null == mtrInstd) {
			mtrInstd = new MapResutPageUIStd(page);
		}
		return mtrInstd;
	}

	
	public image     Map;         
	public button    zoomin_button;        
	public button    zoomout_button;        
	public button    Uparrow_button;         
	public button    Downarrow_button;     	
	public button    Leftarrow_button;        
	public button    Rightarrow_button;      
	public image     FindBizNearby_I;      	
	public link		 FindBizLocNearby;		
	public link		 GetDirToHere;			
	public link		 GetDirFromHere ; 		
	public link      FindBusinessNearby;  	
	public link		 Home;					
	public link		 AOL_Mobile;				
	public link		 LegalTermsandPrivacy;	
	public link		 Terms_of_Use;			
	
	public void initUIElements(){
		Map           			= new image     (page,"//img[@alt='map']");
		zoomin_button          = new button    (page,"//tr/td[1]/a");
		zoomout_button         = new button    (page,"//tr/td[2]/a");
		Uparrow_button         = new button    (page,"//tr/td[3]/a"); 
		Downarrow_button     	= new button    (page,"//tr/td[4]/a");
		Leftarrow_button       = new button    (page,"//tr/td[5]/a"); 
		Rightarrow_button      = new button    (page,"//tr/td[6]/a"); 
		FindBizNearby_I      	= new image     (page,"//div[2]/img");
		FindBizLocNearby		= new link 		(page,"//div[5]/a");
		GetDirToHere			= new link		(page,"//a[contains(text(),'Get Directions To Here')]");
		GetDirFromHere  		= new link		(page,"//a[contains(text(),'Get Directions From Here')]");
		FindBusinessNearby  	= new link     	(page,"//a[contains(text(),'Find Business Nearby')]");
		Home					= new link		(page,"//div[@class='menu']/a[@accesskey='0']");
		AOL_Mobile				= new link		(page,"//a[@href='http://wap.aol.com/portal/']");
		LegalTermsandPrivacy	= new link		(page,"//a[contains(@href, '/terms-of-use')]");
		Terms_of_Use			= new link		(page,"//a[contains(text(),'Terms of Use')]");

	}


}


