/**
*	This class defines UI objects of Map Map result Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/



package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;

public class MapMapResult {
	
	private static MapMapResult mrInst = null;
	private browserpage page;

	private MapMapResult(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static MapMapResult getInstance (browserpage page) {
		if (null == mrInst) {
			mrInst = new MapMapResult(page);
		}
		return mrInst;
	}

	public button    Plus;
	public button    Minus;
	public dropdown  View;
	public button    close;	

	public void initUIElements() {
		Plus                  = new button    (page, "//div[@id='mapContainer']/div[@id='mcontrols']/button[1]");
		Minus                 = new button    (page, "//div[@id='mapContainer']/div[@id='mcontrols']/button[2]");
		View                  = new dropdown  (page, "//div[@id='mapContainer']/div[@id='mcontrols']/button[3]");
		close                 = new button    (page, "//div[@id='mcontrols']/img");	
	}

}
