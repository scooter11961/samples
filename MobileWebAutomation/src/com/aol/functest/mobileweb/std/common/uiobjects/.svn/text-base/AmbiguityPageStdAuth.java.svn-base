package com.aol.functest.mobileweb.std.common.uiobjects;

/**
 * Window Declarations for Ambiguity Page. 
 * @author Amitha
 *
 */
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;
import com.aol.functest.common.textfield;
public class AmbiguityPageStdAuth {

		private static AmbiguityPageStdAuth ampInst = null;
		
		private browserpage page;
		
		private AmbiguityPageStdAuth(browserpage page) {
			this.page = page;
			initUIElements();
		}

		public static AmbiguityPageStdAuth getInstance(browserpage page) {
			if (null == ampInst) {
				ampInst = new AmbiguityPageStdAuth(page);
			}
			return ampInst;
		}
		public link        Result1;
		public link        Result2;
		public link        Result3;
		public link        Result4;
		public link        Result5;
		public link        Result6;
		public link        Result7;
		public link        Result8;
		public link        Result9;
		//public link        Result10;
		public textfield   EnterANewLocation;	                                                            
		public button      GO;
		
		public void initUIElements(){
			Result1                = new link      (page,"//div[6]/a");
			Result2                = new link      (page,"//div[7]/a");
			Result3                = new link      (page,"//div[8]/a");
			Result4                = new link      (page,"//div[9]/a");
			Result5                = new link      (page,"//div[10]/a");
			Result6                = new link      (page,"//div[11]/a");
			Result7                = new link      (page,"//div[12]/a");
			Result8                = new link      (page,"//div[13]/a");
			Result9                = new link      (page,"//div[14]/a");
		//	Result10               = new link      (page,"//div[15]/a");
			EnterANewLocation      = new textfield (page,"//input[@name='addressInput']");	                                                            
			GO                     = new button    (page,"//div/input[5]");

		}
		//public link        Mapquest               = new link      ("//img[@id='logo']");
		
	}
