
package com.aol.functest.mobileweb.std.common;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aol.functest.common.browserpage;
import com.aol.functest.common.util.StringUtil;
import com.aol.functest.mobileweb.std.common.uiobjects.DirectionFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceFormPageStd;
import com.aol.functest.mobileweb.std.common.uiobjects.MyPlaceTextResultStd;
import com.mapquest.util.Logger;

/**
*	MobileWeb class acts like starting point of Mobile web Project
*	@version 1.0
*	@author manjunathabm
*/

public class MobileWeb {

	private static Logger LOGGER = Logger.getLogger(MobileWeb.class);
	private static MobileWeb mwInstStd = null;

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
		if (null == mwInstStd) {
			mwInstStd = new MobileWeb();
		}
		return mwInstStd;
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
	public void setUp() {
		if (!isSetUpAlreadyCalled()) {
			setSetUpAlreadyCalled(true);
			LOGGER.debug("MobileWeb std setUp start");
			Properties properties = new Properties ();
			try
			{
				properties.load (new FileInputStream ("config/mobileweb-std.properties"));
				sHostname = properties.getProperty("hostname");
				iPortNumber = Integer.parseInt(properties.getProperty("portnumber"));
				sExplorer = properties.getProperty("explorer");
				sURL = properties.getProperty("url");
			} catch (IOException e) {
				LOGGER.debug(e);
			}
			MobileWeb.getInstance().projectInitialize();
			page.setUp(sHostname, iPortNumber, sExplorer, sURL); 
			LOGGER.debug("MobileWeb std setUp done");
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
		assertTrue (page.isElementPresent(DirectionFormPageStd.getInstance(page).go.getWindowID()));
		page.setExecutionSpeed("1000");
	}

	/**
	 * Method to check if the application is authenticated. 
	 * @return True if application is authenticated else will return false.
	 * @see isAuthenticated (String sUser)
	 */
	public boolean isAuthenticated () {
		return page.isElementPresent(MyPlaceTextResultStd.getInstance(page).SignOut.getWindowID()) ? true : false;
	} // End of isAuthenticated () method.
	
	/**
	 * Method to check if the application is authenticated with the given user.
	 * @param sUser -- User name by which the application is authenticated. 
	 * @return - True if application is authenticated with specified user else will return false.
	 * @see isAuthenticated () 
	 */
	public boolean isAuthenticated (String sUser) {		
		boolean bAuth = false;
		String sHelloUser = "Hello "+ sUser + "!";
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
			LOGGER.debug("Running in Authenticated Mode");
			MyPlaceTextResultStd.getInstance(page).SignOut.click();
			LOGGER.debug("unauthenticated mode");
			page.waitForElement(MyPlaceFormPageStd.getInstance(page).Signout.getWindowID());
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
			 DirectionFormPageStd.getInstance(page).Mapquest.click();
			 page.waitForPageToLoad (page.sTIMEOUT);		
			// page.click(DirectionFormPage.getInstance(page).Menu.getWindowID());
			 DirectionFormPageStd.getInstance(page).MyPlaces_Link.click();
			 page.waitForPageToLoad (page.sTIMEOUT);		
			 String ScreenName = sUserName;
			 String Password   = sPassword;
			 MyPlaceFormPageStd.getInstance(page).ScreenName.setText(ScreenName);
			 MyPlaceFormPageStd.getInstance(page).Password.setText(Password);		
			 MyPlaceFormPageStd.getInstance(page).SignIn.click();
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