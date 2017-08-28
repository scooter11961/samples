/**
*	This class defines UI objects of Search Map Result Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/



package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.dropdown;

public class SearchMapResult {

	private static SearchMapResult smrInst = null;
	private browserpage page;

	private SearchMapResult(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static SearchMapResult getInstance (browserpage page) {
		if (null == smrInst) {
			smrInst = new SearchMapResult(page);
		}
		return smrInst;
	}

	public button    Plus;
	public button    Minus;
	public dropdown  View;
	public button    close;	

	public void initUIElements() {
		Plus                  = new button    (page, "//div[@id='mcontrols']/button[1]");
		Minus                 = new button    (page, "//div[@id='mcontrols']/button[2]");
		View                  = new dropdown  (page, "//div[@id='mcontrols']/button[3]");
		close                 = new button    (page, "//div[@id='mcontrols']/img");	
	}

}
