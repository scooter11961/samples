package com.aol.functest.mobileweb.std.common.uiobjects;

import com.aol.functest.common.*;

public class SearchFormPageStd {

	/**
	 * 
	 * Creating the Singleton to access elements in this class.
	 */
	private static SearchFormPageStd sfpStd = null;
	private browserpage page;

	private SearchFormPageStd(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static SearchFormPageStd getInstance(browserpage page) {
		if (null == sfpStd) {
			sfpStd = new SearchFormPageStd(page);
		}
		return sfpStd;
	}

	public void SearchBusinessstd(String Business, String Location)

	{
		DirectionFormPageStd.getInstance(page).Mapquest.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		DirectionFormPageStd.getInstance(page).FindABusiness_Link.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
		String sSearch = Business;
		String MapAdd = Location;
		Search_term.setText(sSearch);
		Near.setText(MapAdd);
		Search.click();
		page.waitForPageToLoad(
				page.sTIMEOUT);
	}

	// General UI Elements
	public link Search_by_Categories;
	public textfield Search_term;
	public textfield Near;
	public link Mapquest;
	public link AOLMobile_Link;
	public link LegalTermsandPrivacy_Link;
	public button Search;

	// Different Pages
	public link Direction_Link;
	public link Map_Link;
	public link FindABusiness_Link;
	public link MyPlaces_Link;

	public void initUIElements() {
		// General UI Elements
		Search_by_Categories = new link(page, "//div/a");
		Search_term = new textfield(page, "//div/input[1]]");
		Near = new textfield(page, "//div/input[2]");
		Mapquest = new link(page, "//div[@class='logo']/a/img");
		AOLMobile_Link = new link(page, 
				"//div[@class='footerText']/a[@href='http://wap.aol.com/portal/']");
		LegalTermsandPrivacy_Link = new link(page, 
				"//div[@class='footerText']/a[@href='/terms-of-use']");
		Search = new button(page, "//div/span[4]/input");

		// Different Pages
		Direction_Link = new link(page, 
				"//div[@class='menu']/a[@accesskey='1']");
		Map_Link = new link(page, "//div[@class='menu']/a[@accesskey='2']");
		FindABusiness_Link = new link(page, 
				"//div[@class='menu']/a[@accesskey='3']");
		MyPlaces_Link = new link(page, 
				"//div[@id='menu-myplaces']");
	}
	
}
