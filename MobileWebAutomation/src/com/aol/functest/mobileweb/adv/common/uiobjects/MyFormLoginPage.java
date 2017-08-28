
/**
*	This class defines UI objects of My Form page for Adv Browsers
*	@version 1.0
*	
*/


package com.aol.functest.mobileweb.adv.common.uiobjects;
import com.aol.functest.common.browserpage;
import com.aol.functest.common.button;
import com.aol.functest.common.image;
import com.aol.functest.common.link;
import com.aol.functest.common.textfield;


public class MyFormLoginPage{

	private static MyFormLoginPage myplacelogin = null;
	private browserpage page;
	private String openID="AOL";

	private MyFormLoginPage(browserpage page,String openID) {
		this.page = page;
		this.openID = openID;
		initUIElements();
	}

	private MyFormLoginPage(browserpage page) {
		this.page = page;
		initUIElements();
	}
	
	public static MyFormLoginPage getInstance(browserpage page,String openID) {
		if (null == myplacelogin) {
			
			myplacelogin = new MyFormLoginPage(page,openID);
		}
		return myplacelogin;
	}

	public static MyFormLoginPage getInstance(browserpage page) {
		if (null == myplacelogin) {
			myplacelogin = new MyFormLoginPage(page);
		}
		return myplacelogin;
	}
	public link         Aol;
	public link         Google;
	public link         Twitter;
	public link 		Yahoo;
	
	public textfield    username;
    public textfield 	pass;
	public button       SignIn;
	public button       cancel;
	
	public link         GetaFreeAOLAccount;
	public image 		AOLLogo;
	public button       google_signin_btn;
	public button       yahoo_signin_btn;
	public button       twitter_sign_btn;
	public link   		SignOutBtn;


	public void initUIElements() {
		Aol            = new link (page, "//img[@alt='aol']");
		Google         = new link (page, "//img[@alt='google']");
		Twitter        = new link (page, "//img[@id='twitter-img']");
		Yahoo 		   = new link (page, "//img[@id='yahoo']");
		cancel         = new button(page, "//input[@id='aolcancel']");
		SignOutBtn     = new link(page,"link=Sign Out");
		if(openID.equals("AOL")){
			username       =  new textfield(page, "//input[@id='lgnId']");
			pass       = new textfield(page, "//input[@id='pwdId']");
			SignIn         = new button (page, "//input[@id='aolsubmit']");
			
		}else if(openID.equals("GOOGLE")){
			username       =  new textfield(page, "//input[@id='Email']");
			pass       = new textfield(page, "//input[@id='Passwd']");
			SignIn         = new button (page, "//input[@name='signIn']");
			
		}else if(openID.equals("YAHOO")){
			username       =  new textfield(page, "//input[@id='username']");
			pass       = new textfield(page, "//input[@id='passwd']");
			SignIn         = new button (page, "//input[@id='.save']");
			
		}else if(openID.equals("TWITTER")){
			username       =  new textfield(page, "//x:input[@id='username_or_email']");
			pass       = new textfield(page, "//x:input[@id='session[password]']");
			SignIn         = new button (page, "//x:button[@id='signin']");
		
		}
		
		//add else ifs if you want to handle more open accounts.
		
		GetaFreeAOLAccount = new link (page,"link=Get a Free AOL Account");
		AOLLogo 		= new image(page,"/div[@id='oa-hdr']/h2/img");
		google_signin_btn = new button(page,"//a[@id='google-btn']/span");
		yahoo_signin_btn = new button(page,"//a[@id='yahoo-btn']/span");
		twitter_sign_btn = new button(page,"//a[@id='google-btn']/span");
	
	
	}

}
