package com.aol.functest.mobileweb.std.common.uiobjects;

/**
*	This class defines UI objects of Saved & Recent Page for Std Browsers Authentication Page
*	@version 1.0
*	@author Amitha
*/


import com.aol.functest.common.browserpage;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;

public class SavedandRecentStdAuth {
	private browserpage page;
	
	private static SavedandRecentStdAuth sarInstStdauth = null;
	
	private SavedandRecentStdAuth(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static SavedandRecentStdAuth getInstance(browserpage page) {
		if (null == sarInstStdauth) {
			sarInstStdauth = new SavedandRecentStdAuth(page);
		}
		return sarInstStdauth;
	}
	public link        Mapquest;        
//	public link        back                    = new link  	   ("//div[@class='padded5px']/a[@href='%2Fmaps%3F1ai%3D%26amp%3B2ai%3D%26amp%3Br%3Df%26amp%3BreferrerView%3Ddirections&form=directions&pva=SVbck']");
	public link		   Home	;			
	public link        Aol_Mobile;		
	public link		   LegalTermsandPrivacy	; 
	public link		   Recents;			

	public void initUIElements(){

		Mapquest                = new link      (page,"//img[@alt='MapQuest']");
		//		public link        back                    = new link  	   ("//div[@class='padded5px']/a[@href='%2Fmaps%3F1ai%3D%26amp%3B2ai%3D%26amp%3Br%3Df%26amp%3BreferrerView%3Ddirections&form=directions&pva=SVbck']");
		Home					   = new link	   (page,"//a[contains(text(),'Home')]");
		Aol_Mobile			   = new link	   (page,"//a[contains(text(),'AOL Mobile')]");
		LegalTermsandPrivacy	   = new link	   (page,"//a[contains(@href, '/terms-of-use')]");
		Recents				   = new link      (page,"//div[5]/a");

		
	}
	
}


