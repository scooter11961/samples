/**
*	This class defines UI objects of Direction Text result with 3 points Page(Click on add to route button in directions business search results page) for Advance Browsers
*	@version 1.0
*	@author Amitha
*/


package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;
import com.aol.functest.common.text;

public class DirectionsTextresultwith3points {
	
	private static DirectionsTextresultwith3points dtrInst3points = null;
	private browserpage page;

	private DirectionsTextresultwith3points(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static DirectionsTextresultwith3points getInstance (browserpage page) {
		if (null == dtrInst3points) {
			dtrInst3points = new DirectionsTextresultwith3points(page);
		}
		return dtrInst3points;
	}

	public button    ShowMap;
	public link      Mapquest;
	public dropdown  Menu;
	public text      Start_Text;
	public text 	 End_Text;
	public text      AddtoRoute_Text;
	public link      Start_Star; 
	public link   	 AddtoRoute_Star;
	public link      End_Star;

	public void initUIElements() {
		ShowMap                = new button    (page, "//div[3]/button");
		Mapquest               = new link      (page, "//img[@id='logo']");
		Menu                   = new dropdown  (page, "//button[@id='menu_link']");
		Start_Text       		= new text      (page, "//div[@id='wrap_content_main']/div[@id='loc0']/div[1]/div[1]");
		End_Text				= new text      (page, "//div[@id='loc2']/div[1]/div[1]");
		AddtoRoute_Text        = new text      (page, "//div[@id='loc1']/div[1]/div[1]");
		Start_Star             = new link      (page, "//body[@id='dirResultsPage']/div[@id='wrap_content_main']/div[@id='loc0']/img"); 
		AddtoRoute_Star        = new link 		(page, "//body[@id='dirResultsPage']/div[@id='wrap_content_main']/div[@id='loc1']/img");
		End_Star               = new link      (page, "//body[@id='dirResultsPage']/div[@id='wrap_content_main']/div[@id='loc2']/img");
	}

}
