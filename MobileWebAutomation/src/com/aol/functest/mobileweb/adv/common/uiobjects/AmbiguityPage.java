package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;
import com.aol.functest.common.textfield;

/**
 * Window Declarations for Ambiguity Page. 
 * @author manjunathabm
 *
 */
public class AmbiguityPage {
	
	private static AmbiguityPage ampInst = null;
	private browserpage page;
	
	/**
	 * Creating a Singleton. 
	 */
	private AmbiguityPage (browserpage page){
		this.page = page;
		initUIElements();
	}

	public static AmbiguityPage getInstance (browserpage page) {
		if (null == ampInst) {
			ampInst = new AmbiguityPage (page);
		}
		return ampInst;
	}

	public link        Mapquest;
	public dropdown    Menu;
	public link        Result1;
	public link        Result2;
	public link        Result3;
	public link        Result4;
	public link        Result5;
	public link        Result6;
	public link        Result7;
	public link        Result8;
	public link        Result9;
	public link        Result10;
	public textfield   EnterANewLocation;	                                                            
	public button      GO;

	public void initUIElements() {
		Mapquest               = new link      (page, "//img[@id='logo']");
		Menu                   = new dropdown  (page, "//button[@id='menu_link']");
		Result1                = new link      (page, "//div[4]/a/span[1]");
		Result2                = new link      (page, "//div[5]/a/span[1]");
		Result3                = new link      (page, "//div[6]/a/span[1]");
		Result4                = new link      (page, "//div[7]/a/span[1]");
		Result5                = new link      (page, "//div[8]/a/span[1]");
		Result6                = new link      (page, "//div[9]/a/span[1]");
		Result7                = new link      (page, "//div[10]/a/span[1]");
		Result8                = new link      (page, "//div[11]/a/span[1]");
		Result9                = new link      (page, "//div[12]/a/span[1]");
		Result10               = new link      (page, "//div[13]/a/span[1]");
		EnterANewLocation      = new textfield (page, "//div[@id='wrap_content_form']/form/div/input[1]");	                                                            
		GO                     = new button    (page, "//div/input[2]");
	}
}
