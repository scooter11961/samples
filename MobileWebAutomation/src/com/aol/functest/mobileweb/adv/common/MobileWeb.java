
package com.aol.functest.mobileweb.adv.common;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.util.StringUtil;
import com.aol.functest.mobileweb.adv.common.uiobjects.DirectionFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceFormPage;
import com.aol.functest.mobileweb.adv.common.uiobjects.MyPlaceTextResult;
import com.mapquest.util.Logger;
/**
*	MobileWeb class acts like starting point of Mobile web Project
*	@version 1.0
*	@author manjunathabm
*/

public class MobileWeb {

	private static Logger LOGGER = Logger.getLogger(MobileWeb.class);

	private static MobileWeb mwInst = null;

	public boolean setUpAlreadyCalled;
	public browserpage page;
	public String sHostname;
	public Integer iPortNumber;
	public String sExplorer;
	public String sURL;
	//public static String sPROJECTROOT;

	private MobileWeb () {
		setSetUpAlreadyCalled(false);
	}

	public static MobileWeb getInstance () {
		if (null == mwInst) {
			mwInst = new MobileWeb();
		}
		return mwInst;
	}

	/**
	 * @return the setUpAlreadyCalled
	 */
	public boolean isSetUpAlreadyCalled() {
		return setUpAlreadyCalled;
	}

	/**
	 * @param setUpAlreadyCalled the setUpAlreadyCalled to set
	 */
	public void setSetUpAlreadyCalled(boolean setUpAlreadyCalled) {
		this.setUpAlreadyCalled = setUpAlreadyCalled;
	}

	/**
	 * @return the page
	 */
	public browserpage getPage() {
		return page;
	}

	/**
	 * 
	 */
	public void projectInitialize () {
		Properties projectproperty = new Properties ();
		page = new browserpage();
		try {
			projectproperty.load (new FileInputStream ("config/project.properties"));
			page.sPROJECTROOT = StringUtil.stripSlash(projectproperty.getProperty("Project.root"));
			page.sPROJECTPLATFORM = projectproperty.getProperty("Project.platform");
		}
		catch (IOException e){
			System.out.println (e);
		};
		
		
	}
	
	/**
	*	Static Method which will read the properties file and will call Browserpage setup to start the application.
	*	@param none
	*	@return void
	*/
	public void setUp () {
		if (!isSetUpAlreadyCalled()) {
			setSetUpAlreadyCalled(true);
			LOGGER.debug("MobileWeb adv setUp start");
			Properties properties = new Properties ();
			try
			{
				properties.load (new FileInputStream ("config/mobileweb-adv.properties"));
				sHostname = properties.getProperty("hostname");
				iPortNumber = Integer.parseInt(properties.getProperty("portnumber"));
				sExplorer = properties.getProperty("explorer");
				sURL = properties.getProperty("url");
				MobileWeb.getInstance().projectInitialize();
				page.setUp (sHostname, iPortNumber, sExplorer, sURL); 
			}
			catch (IOException e)
			{
				System.out.println (e);
			}
			LOGGER.debug("MobileWeb adv setUp done");
		}
	}
	
	
   /**
   * Static method to set the Base State of the MobileWebApplication
   * This will open the URL and wait for page to load 
   * @param none
   * @return void
   */
	public void mobileWebBaseState () {
		LOGGER.debug(new StringBuilder("testing open firefox browser - url=").append(sURL).toString());
		page.open(sURL);
		page.waitForPageToLoad("50000");
		assertTrue (page.isElementPresent(DirectionFormPage.getInstance(page).getDirection.getWindowID()));
		page.setExecutionSpeed("1000");
	}

	/**
	 * Method to check if the application is authenticated. 
	 * @return True if application is authenticated else will return false.
	 * @see isAuthenticated (String sUser)
	 */
	public boolean isAuthenticated () {
	return page.isElementPresent(MyPlaceTextResult.getInstance(page).SignOut.getWindowID()) ? true : false;
	} // End of isAuthenticated () method.
	
	/**
	 * Method to check if the application is authenticated with the given user.
	 * @param sUser -- User name by which the application is authenticated. 
	 * @return - True if application is authenticated with specified user else will return false.
	 * @see isAuthenticated () 
	 */
	public boolean isAuthenticated (String sUser) {		
		boolean bAuth = false;
		String sHelloUser = "Hello "+ sUser + ".";
		if (MobileWeb.getInstance().isAuthenticated()) {			
			if ((page.isTextPresent(sHelloUser.trim()))) 
			{
				bAuth = true;
			}
		}
		return bAuth;
	} // End of isAuthenticated () method
	
	/**
	 * Method to UnAuthenticate the application. 
	 */
	//@Test (groups = {"unauthenticate"})
	public void unAuthenticate (){
		if (MobileWeb.getInstance().isAuthenticated()) {
			LOGGER.debug("Running in UnAuthenticated Mode");
			MyPlaceTextResult.getInstance(page).SignOut.click();
			page.waitForElement(MyPlaceFormPage.getInstance(page).Signout.getWindowID());
			assertFalse (MobileWeb.getInstance().isAuthenticated(), "Verifying Unauthentication");
		}
	} // End of unAuthenticate () Method
	

	/**
	 * Method to Authenticate the application with specified user.  
	 * @param sUserName -- Username to authenticate
	 * @param sPassword -- Password for the user to be authenticated
	 */
	//@Test (groups = {"authenticate"}) 	
	public void authenticate (String sUserName, String sPassword) {
			
		// Checking if the application is already Authenticated with given user. 
		if (!MobileWeb.getInstance().isAuthenticated(sUserName)) {
			 LOGGER.debug("Running in Authenticated Mode");
			 MobileWeb.getInstance().unAuthenticate();			 
			 DirectionFormPage.getInstance(page).Mapquest.click();
			 page.waitForPageToLoad (page.sTIMEOUT);		
			 page.click(DirectionFormPage.getInstance(page).Menu.getWindowID());
			 DirectionFormPage.getInstance(page).Menu_MyPlace.click();
			 page.waitForPageToLoad (page.sTIMEOUT);		
			 String ScreenName = sUserName;
			 String Password   = sPassword;
			 MyPlaceFormPage.getInstance(page).ScreenName.setText(ScreenName);
			 MyPlaceFormPage.getInstance(page).Password.setText(Password);		
			 MyPlaceFormPage.getInstance(page).SignIn.click();
		     page.waitForPageToLoad (page.sTIMEOUT);	
		     assertTrue (MobileWeb.getInstance().isAuthenticated(sUserName));
		}

	} // End of authenticate () Method.

	/**
	 * Method to close all the browsers.
	 */
	public void closeBrowser () {
		page.close();
	}
	
}