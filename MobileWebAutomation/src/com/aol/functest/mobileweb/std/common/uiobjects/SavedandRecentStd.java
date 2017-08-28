package com.aol.functest.mobileweb.std.common.uiobjects;

/**
*	This class defines UI objects of Saved & Recent Page for Std Browsers
*	@version 1.0
*	@author Amitha
*/


import com.aol.functest.common.browserpage;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;

public class SavedandRecentStd {
	private browserpage page;
	private static SavedandRecentStd sarInstStd = null;
	
	private SavedandRecentStd(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static SavedandRecentStd getInstance(browserpage page) {
		if (null == sarInstStd) {
			sarInstStd = new SavedandRecentStd(page);
		}
		return sarInstStd;
	}
	public link        Mapquest;  
//	public link        back                    = new link  	   ("//div[@class='padded5px']/a[@href='%2Fmaps%3F1ai%3D%26amp%3B2ai%3D%26amp%3Br%3Df%26amp%3BreferrerView%3Ddirections&form=directions&pva=SVbck']");
	public link		   Home;		
	public link        Aol_Mobile;
	public link		   LegalTermsandPrivacy;	  

	public void initUIElements(){
		Mapquest                = new link      (page,"//img[@alt='MapQuest']");
		Home					   = new link	   (page,"//a[contains(text(),'Home')]");
		Aol_Mobile			   = new link	   (page,"//a[contains(text(),'AOL Mobile')]");
		LegalTermsandPrivacy	   = new link	   (page,"//a[contains(@href, '/terms-of-use')]");

	}
	
}

