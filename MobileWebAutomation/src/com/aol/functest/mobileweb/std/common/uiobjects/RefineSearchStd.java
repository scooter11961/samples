/**
*	This class defines UI objects of Refine Search for Std Browsers
*	@version 1.0
*	@author Amitha
*/

package com.aol.functest.mobileweb.std.common.uiobjects;

import com.aol.functest.common.*;

public class RefineSearchStd {		
		private static RefineSearchStd rsInst =null;
		
		private browserpage page;
		
		private RefineSearchStd(browserpage page) {
			this.page = page;
			initUIElements();
		}

		public static RefineSearchStd getInstance(browserpage page) {
			if (null == rsInst) {
				rsInst = new RefineSearchStd(page);
			}
			return rsInst;
		}
		public link        Mapquest;  
		//public link        back                    = new link  	   ("//a[contains(text(),'< Back'");
	    public radio       Mile1;     
		public radio       Mile5;     
		public radio       Mile10;    
		public radio       Mile25;    
		public radio       Mile50;    
		public radio       Loc1;      
		public radio       Loc2 ;     
		public radio       Loc3;      
		public radio       Loc4;      
		public radio       Loc5;      
		public radio       Loc6 ;     
		public radio       Loc7;      
		public radio       Loc8 ;     
		public button      UpdateSearch;  
		public link		   Home;				
		public link      AOLMobile_Link;     
		public link      LegalTermsandPrivacy_Link; 

		public void initUIElements(){
			Mapquest                = new link      (page,"//img[@alt='MapQuest']");
			//public link        back                    = new link  	   ("//a[contains(text(),'< Back'");
			Mile1                   = new radio     (page,"//input[1]");
			Mile5                   = new radio     (page,"//input[2]");
			Mile10                  = new radio     (page,"//input[3]");
			Mile25                  = new radio     (page,"//input[4]");
			Mile50                  = new radio     (page,"//input[5]");
			Loc1                    = new radio     (page,"//input[6]");
			Loc2                    = new radio     (page,"//input[7]");
			Loc3                    = new radio     (page,"//input[8]");
			Loc4                    = new radio     (page,"//input[9]");
			Loc5                    = new radio     (page,"//input[10]");
			Loc6                    = new radio     (page,"//input[11]");
			Loc7                    = new radio     (page,"//input[12]");
			Loc8                    = new radio     (page,"//input[13]");
			UpdateSearch            = new button    (page,"//input[@value='Update Search']");
			Home					   = new link	   (page,"//a[contains(@href, '/?pva=SEhm')]");
			AOLMobile_Link            = new link      (page,"//a[@href='http://wap.aol.com/portal/']");
			LegalTermsandPrivacy_Link = new link      (page,"//a[contains(@href, '/terms-of-use')]");

		}
		
}
