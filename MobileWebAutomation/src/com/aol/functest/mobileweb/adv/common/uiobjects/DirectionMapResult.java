/**
*	This class defines UI objects of Direction Map result Page for Advance Browsers
*	@version 1.0
*	@author shiladitya
*/


package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.*;


public class DirectionMapResult {
	
	/**
	 * Creating Singleton to access elements in this class. 
	 */
	private static DirectionMapResult dmrInst = null;
	private browserpage page;

	private DirectionMapResult(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static DirectionMapResult getInstance(browserpage page) {
		if (null == dmrInst) {
			dmrInst = new DirectionMapResult(page);
		}
		return dmrInst;
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
