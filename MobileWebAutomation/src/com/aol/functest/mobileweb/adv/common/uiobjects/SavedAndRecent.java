package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.dropdown;
import com.aol.functest.common.link;

public class SavedAndRecent {

	private static SavedAndRecent sarInst = null;
	private browserpage page;

	private SavedAndRecent(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static SavedAndRecent getInstance(browserpage page) {
		if (null == sarInst) {
			sarInst = new SavedAndRecent(page);
		}
		return sarInst;
	}

	public link        Mapquest;
	public dropdown    Menu;
	public link        back;

	public void initUIElements() {
		Mapquest                = new link      (page, "//img[@id='logo']");
		Menu                    = new dropdown  (page, "//button[@id='menu_link']");
		back                    = new link      (page, "//div[@class='savedAndMyPlaceHeader contentBody']/div/a");
	}
}
