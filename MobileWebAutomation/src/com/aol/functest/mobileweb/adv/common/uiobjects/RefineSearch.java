package com.aol.functest.mobileweb.adv.common.uiobjects;

import com.aol.functest.common.*;


public class RefineSearch {

	private static RefineSearch rsInst = null;
	private browserpage page;

	private RefineSearch(browserpage page) {
		this.page = page;
		initUIElements();
	}

	public static RefineSearch getInstance (browserpage page) {
		if (null == rsInst) {
			rsInst = new RefineSearch(page);
		}
		return rsInst;
	}

	public link        Mapquest;
	public dropdown    Menu;
	public radio       M1;
	public radio       M5;
	public radio       M10;
	public radio       M25;
	public radio       M50;
	public radio       Sug1;
	public radio       Sug2;
	public radio       Sug3;
	public radio       Sug4;
	public radio       Sug5;
	public radio       Sug6;
	public radio       Sug7;
	public radio       Sug8;
	public button      UpdateSearch;

	public void initUIElements() {
		Mapquest                = new link      (page, "//img[@id='logo']");
		Menu                    = new dropdown  (page, "//button[@id='menu_link']");
		M1                      = new radio     (page, "//p[1]/input");
		M5                      = new radio     (page, "//p[2]/input");
		M10                     = new radio     (page, "//p[3]/input");
		M25                     = new radio     (page, "//p[4]/input");
		M50                     = new radio     (page, "//p[5]/input");
		Sug1                    = new radio     (page, "//p[6]/input");
		Sug2                    = new radio     (page, "//p[7]/input");
		Sug3                    = new radio     (page, "//p[8]/input");
		Sug4                    = new radio     (page, "//p[9]/input");
		Sug5                    = new radio     (page, "//p[10]/input");
		Sug6                    = new radio     (page, "//p[11]/input");
		Sug7                    = new radio     (page, "//p[12]/input");
		Sug8                    = new radio     (page, "//p[13]/input");
		UpdateSearch            = new button    (page, "//form/input[1]");
	}
}
