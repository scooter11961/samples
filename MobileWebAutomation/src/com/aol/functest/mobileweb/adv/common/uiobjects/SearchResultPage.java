package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.*;

/**
*	Class the defines the object of Main page of wap.mapquest.com
*	@version 1.0
*	@author manjunathabm
*/
public class SearchResultPage {

	private static SearchResultPage srpInst = null;
	private browserpage page;

	private SearchResultPage(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static SearchResultPage getInstance(browserpage page) {
		if (null == srpInst) {
			srpInst = new SearchResultPage(page);
		}
		return srpInst;
	}

	public button returntohomepage;

	public void initUIElements() {
		returntohomepage = new button (page, "igbypassimp");
	}

}