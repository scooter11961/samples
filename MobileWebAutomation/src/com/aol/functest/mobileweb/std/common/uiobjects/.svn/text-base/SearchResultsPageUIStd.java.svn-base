package com.aol.functest.mobileweb.std.common.uiobjects;


	/**
	*	This class defines UI objects of Search Result Page for Std Browsers
	*	@version 1.0
	*	@author Amitha
	*/


	import com.aol.functest.common.*;

	public class SearchResultsPageUIStd {
		
		private static SearchResultsPageUIStd strInstd = null;
		
		private browserpage page;
		
		private SearchResultsPageUIStd(browserpage page) {
			this.page = page;
			initUIElements();
		}

		public static SearchResultsPageUIStd getInstance(browserpage page) {
			if (null == strInstd) {
				strInstd = new SearchResultsPageUIStd(page);
			}
			return strInstd;
		}
				
		public image     map;           
		public button    zoomin_button;   
		public button    zoomout_button;  
		public button    Uparrow_button;   
		public button    Downarrow_button;
		public button    Leftarrow_button; 
		public button    Rightarrow_button; 
		public link      Refine_Search;		
		public link      New_Search;			
		public link		 Search_Result_1;	
		public link		 Search_Result_2;	
		public link		 Search_Result_3;	
		public link		 Search_Result_4;	
		public link		 Search_Result_5;	
		public link		 Next;				
		public link		 Home;				
		public link		 AOL_Mobile;			
		public link		 LegalTermsandPrivacy;	
		public link		 Terms_of_Use;					 

		public void initUIElements() {
			map                	= new image     (page,"//img[@alt='map']");
			zoomin_button          = new button    (page,"//tr/td[1]/a");
			zoomout_button         = new button    (page,"//tr/td[2]/a");
			Uparrow_button         = new button    (page,"//tr/td[3]/a"); 
			Downarrow_button     	= new button    (page,"//tr/td[4]/a");
			Leftarrow_button       = new button    (page,"//tr/td[5]/a"); 
			Rightarrow_button      = new button    (page,"//tr/td[6]/a"); 
			Refine_Search			= new link		(page,"//a[contains(text(),'Refine Search')]");
			New_Search				= new link		(page,"//a[contains(text(),'New Search')]");
					
			Search_Result_1		= new link		(page,"//div[9]/a[1]");
			Search_Result_2		= new link		(page,"//div[11]/a[1]");
			Search_Result_3		= new link		(page,"//div[13]/a[1]");
			Search_Result_4		= new link		(page,"//div[15]/a[1]");
			Search_Result_5		= new link		(page,"//div[17]/a[1]");
			
			Next					= new link		(page,"//a[contains(text(),'Next >')]");
			Home					= new link		(page,"//a[contains(text(),'Home')]");
			AOL_Mobile				= new link		(page,"//a[contains(text(),'AOL Mobile')]");
			LegalTermsandPrivacy	= new link		(page,"//a[contains(@href, '/terms-of-use')]");
			Terms_of_Use			= new link		(page,"//a[contains(text(),'Terms of Use')]");		 
	
		}
		
	}
