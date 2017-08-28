package com.aol.functest.common;

// Importing Selenium Package
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import com.mapquest.util.Logger;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Wait;



/** BrowserPage class is a generic class which has all the methods defined under selenium class. 
*	All the other classes written have to use these methods
*   @version 1.0
*	@author shiladityaroy
*	@author freebeachler
*
*/
public class browserpage {

	private static Logger LOGGER = Logger.getLogger(browserpage.class);

	public browserpage () {
	}

	/** 
	* Member Variables 
	* selenium which is the object of class DefaultSelenium
	* sTIMEOUT = Miliseconds for the page to timeout
	* sSPEED = The speed in Miliseconds at which the test cases should get executed.
	*
	*/
	protected DefaultSelenium selenium;
	public String sTIMEOUT = "50000";
	public String sSPEED = "1000";
	public String sPROJECTROOT;
	public String sPROJECTPLATFORM;

	/**
	*	Method to create an object of Selenium 
	*	@return void
	*	@param sHostName Variable to specify the machine where Selenium Server is running.
	*	@param iPortNumber Variable to specify the port number at which Selenium Server is running
	*	@param sBrowser Vairable to specify which browser the test has to run. 
	*	@param sUrl Variable to specify which url has to be opened by this selenium object 
	*/
	private void setSelObject (String sHostName, Integer iPortNumber, String sBrowser, String sUrl) {
			selenium = new DefaultSelenium (sHostName, iPortNumber, sBrowser, sUrl);
	}


	/** 
	*	Method to open the browser, delete all cookies and to maximize the window to start testing
	*	@return void
	*	@param sHostName Variable to specify the machine where Selenium Server is running.
	*	@param iPort Variable to specify the port number at which Selenium Server is running
	*	@param sExplorer Vairable to specify which browser the test has to run. 
	*	@param sURL Variable to specify which url has to be opened by this selenium object 

	*/
	public void setUp (String sHostname, Integer iPort, String sExplorer, String sURL) {
		setSelObject (sHostname, iPort, sExplorer, sURL);
		selenium.start();
    	selenium.deleteAllVisibleCookies();
	    selenium.windowMaximize();
	}

	/**
	 * 
	 * @param locator
	 * @param optionLocator
	 */
	public void addSelection (String locator, String optionLocator) {
		selenium.addSelection (locator, optionLocator);
	}
	
	/**
	 * 
	 */
	public void altKeyDown () {
		selenium.altKeyDown ();
	}

	/**
	 * 
	 */
	
	public void altKeyUp () {
		selenium.altKeyUp ();
	}

	/**
	 * 
	 * @param ans
	 */
	public void answerOnNextPrompt (String ans) {
		selenium.answerOnNextPrompt (ans);
	}

	/**
	 * Checks the checkbox or radio button
	 * @param sChk - Identifier of Checkbox or radio button
	 */
	public void check (String sChk){
		selenium.check (sChk);
	}

	public void chooseCancelOnNextConfirmation () {
		selenium.chooseCancelOnNextConfirmation ();
	}

	/**
	 * Clicks on a object specified.
	 * @param sClk - Object Identifier to click at
	 */
	public void click (String sClk) {
		selenium.click (sClk);
	}

	public void clickAt (String locator, String coordinate) {
		selenium.clickAt (locator, coordinate);
	}

	/**
	 * Simulates user clicking of close button on the Browser window. 
	 * Closes the browser
	 */
	public void close () {
		selenium.close ();
	}

	public void controlKeyDown () {
		selenium.controlKeyDown ();
	}

	public void controlKeyUp () {
		selenium.controlKeyUp ();
	}

	/**
	 * 
	 * @param nameValuePair
	 * @param optionsString
	 */
	
	public void createCookie (String nameValuePair, String optionsString) {
		selenium.createCookie (nameValuePair, optionsString);
	}

	/**
	 * Simulates clicking on Back button on the browser
	 */
	
	public void goBack () {
		selenium.goBack ();
	}

	public boolean isAlertPresent () {
		return selenium.isAlertPresent ();
	}
	
	public void cancelAlertWindow () {
		if (isAlertPresent()) {
			selenium.chooseCancelOnNextConfirmation();
		}
	}

	/**
	 * Method to check if confirmation window is present.
	 * @return - true if confirmation window is present else returns false
	 */
	
	public boolean isConfirmationPresent () {
		return selenium.isConfirmationPresent ();
	}
	
	/**
	 * 
	 * @return
	 */
	
	public boolean isPromptPresent () {
		return selenium.isPromptPresent ();
	}

	/**
	 * Verifies if the text pattern specified is present anywhere in the page.
	 * @param sTextPattern - Text pattern to verify
	 * @return - True if present, else False
	 */
	public boolean isTextPresent (String sTextPattern) {
		return selenium.isTextPresent (sTextPattern);
	}

	/**
	 * 
	 */
	
	public void metaKeyDown () {
		selenium.metaKeyDown ();
	}

	/**
	 * 
	 */
	
	public void metaKeyUp () {
		selenium.metaKeyUp (); 
	}

	/**
	 * Will open the URL mentioned 
	 * @param sURL - URL to be opened Ex: http://www.mapquest.com
	 */
	
	public void open (String sURL) {
		selenium.open (sURL);
	}

	/**
	 * Refreshes the current Browser window.
	 */
	
	public void refresh () {
		selenium.refresh ();
	}
	
	/**
	 * 
	 */
	
	public void shiftKeyDown () {
		selenium.shiftKeyDown ();
	}

	/**
	 * 
	 */
	
	public void shiftKeyUp () {
		selenium.shiftKeyUp ();
	}

	/**
	 * Starts a new Browser window.
	 */
	
	public void start () {
		selenium.start ();
	}

	/**
	 * Kills the browser where test is run
	 */
	
	public void stop () {
		selenium.stop ();
	}

	/**
	 * Sets the execution speed of the selenium
	 * @param sSpeed - Speed at which selenium command has to get executed
	 */
	
	public void setExecutionSpeed (String sSpeed) {
		selenium.setSpeed (sSpeed);
	}
	
	/**
	 * Method to set Timeout for the Open method. 
	 * @param sTime - Time to be set for Timeout
	 */
	public void setTimeOut (String sTime) {
		selenium.setTimeout(sTime);
	}

	/**
	 * Waits for a browserpage to load completely.
	 * @param sWaitTime - Time to wait till the page loads properly
	 */
	
	public void waitForPageToLoad (String sWaitTime) {
		selenium.waitForPageToLoad (sWaitTime);
	}

	/**
	 * Sets focus on the current window
	 */
	
	public void windowFocus () {
		selenium.windowFocus ();
	}

	/**
	 * Waits for Popup to appear
	 * @param sWnd - Identifier of the popup window
	 * @param stimeout -- Timeout to wait till that window popsup 
	 */
	
	public void waitForPopUp (String sWnd, String stimeout) {
		selenium.waitForPopUp (sWnd, stimeout);	
	}

	/**
	 * Maximizes the Browser window.
	 */
	
	public void windowMaximize () {
		selenium.windowMaximize ();
	}

	/**
	 * Checks if a checkbox or radio button is checked or not not.
	 * @param sChk - Identifier of the checkbox or radio button
	 * @return - True if checked, else false
	 */
	
	public boolean isChecked (String sChk) {
		return selenium.isChecked (sChk);
	}

	/**
	 * Unchecks the checked chekbox or radio button
	 * @param sChk - Identifier of the Checkbox.
	 */
	
	public void uncheck (String sChk) {
		selenium.uncheck (sChk);
	}

	/**
	 * Types the value in an input field.
	 * @param sLocation - Identifier of the Textfield to type the text
	 * @param sText - The actual text that has to be entered.
	 */
	
	public void type (String sLocation, String sText) {
		selenium.type (sLocation, sText);
	}
	
	/**
	 * Gets the value of Rendered Text. 
	 * @param sLocator -- Identifier of the rendered text
	 * @return - Value of the rendered text
	 */
	
	public String getText (String sLocator) {
			return selenium.getText (sLocator);
	}
	
	/**
	 * Gets the value of an input field.
	 * @param sLocator - Identifier of the Input Field.
	 * @return - String. Value present in the Input field.
	 */
	
	public String getValue (String sLocator) {
		return selenium.getValue(sLocator);
	}
	
	/**
	 * Select a value mentioned in the dropdown list
	 * @param sLocator -- Identifier of the Dropdown list
	 * @param sValue -- Value to be selected.
	 */
	
	public void select (String sLocator, String sValue) {
			selenium.select (sLocator, sValue);
	}
	
	/**
	 * This method verifies whether the element is present on a page or not
	 * @param sLocator - Identifier of the Object / element
	 * @return - True if element is present, else returns False
	 */
	
	public boolean isElementPresent (String sLocator) {
			return selenium.isElementPresent(sLocator);
	}
	
	/**
	 * Method to get the attribute of an Object.
	 * You have to pass @<attribute> to get the attribute value. 
	 * Ex: browserpage.getAttribute ("submit"+@src); Will return the src value for the object selected 
	 * @param sLocator - Identifier + Atrribute key to get the value of that attribute.
	 * @return String - The value of the attribute asked for
	 */
	
	public String getAttribute (String sLocator){
		return selenium.getAttribute(sLocator);
		
	}
	
	/**
	 * Method to verify if the file specified in the path exists or not
	 * @param sFileName - Absolute path of the file.
	 * @return - TRUE if File exists, else returns FALSE
	 */
	
	public boolean isFileExists (String sFileName) {
		File fFile = new File (sFileName);		
		return fFile.exists();
	}
	
	
	/**
	 * This method is used for comparing the Images.
	 * @param sActualImage -- Specify Absolute path of the Actual Image file. The image file which you want to compare 
	 * @param sExpectedImage -- Specify Absolute path of the Expected Image File. The image file which you want the actual image to compared with
	 * @param iIgnorePixelDiff -- Integer -- Specify Integer value in case you want to ignore some % of Pixel difference. Ideally it should be 0
	 * @return Boolean Returns TRUE if image matches, else returns FALSE
	 */
	
	public boolean imageCompare(String sActualImage, String sExpectedImage, int iIgnorePixelDiff) {
		boolean bCompare = false;
		try {			    
			    String stringName = "";
			    if (sPROJECTPLATFORM.equals("windows"))
			    {
			      stringName = sPROJECTROOT + "/lib/perceptualdiff.exe  -threshold  " + iIgnorePixelDiff + "  " + sExpectedImage + " " + sActualImage;
			    }
			    else if (sPROJECTPLATFORM.equals("linux"))
			    {
					stringName = sPROJECTROOT + "/lib/perceptualdiff  -threshold  " + iIgnorePixelDiff + "  " + sExpectedImage + " " + sActualImage;	
			    }
			    LOGGER.debug(new StringBuilder("path to perceptual diff executable is: ").append(stringName).toString());
		        Process P = Runtime.getRuntime().exec(stringName);
		        BufferedReader br = new BufferedReader (new InputStreamReader(P.getInputStream()));
		        StringBuilder resultBuilder = new StringBuilder();
		        String InpLine;
		        while ((InpLine = br.readLine()) != null) {
		            resultBuilder.append(InpLine);
		        }
		       
			    if(resultBuilder.toString()==null || resultBuilder.toString()=="" || resultBuilder.toString().length()==0 || resultBuilder.toString().contains("PASS") ) {
			    	bCompare=true;
			    }
				LOGGER.debug(bCompare);
			                    
	    } catch(IOException e) {
	    	LOGGER.debug(e);
	    }
		
		return bCompare; 
	}
	
	/**
	 * Method to wait for a element to appear.
	 * @param sElement - Element to look for to appear
	 */
	
	public void waitForElement (String sElement) {
		final String sWaitElement = sElement;
		new Wait ("Couldn't find the elemnet..." + sElement) {
			public boolean until () {
				return (isElementPresent(sWaitElement));
				}
			};
		}
	
	/**
	 * Method to get the value from the table.
	 * @param sTableID - Identifier of the table
	 * @return - String value in the table
	 */
	public String getTable (String sTableID) {
		return selenium.getTable(sTableID);
	}
	
	/**
	 * Method to get the value from a Xpath.
	 * @param sTableID - Identifier of the table
	 * @return - String value in the table
	 */
	
	/*
	 * This method will save image from URL
	 * 
	*/
	    public boolean saveImagefromURL (String sSourceURL, String sFileName, String sImageID) throws IOException {		
		  boolean bSaved = false;	
		  if (sSourceURL.length()==0)
		  {
		     sSourceURL = getAttribute(sImageID+"@src");  
		  }
		  URL uCurrentURL = new URL (sSourceURL);
		  try
		    {      
		       InputStream isFileRead = uCurrentURL.openStream();
		       OutputStream osFileOut = new BufferedOutputStream(new FileOutputStream (sFileName));
		       for (int ibyte; (ibyte = isFileRead.read()) != -1; )
		     	{
		    	   osFileOut.write(ibyte);
		        }
		       osFileOut.close();
		       isFileRead.close(); 
		       bSaved = true;
		    }    
		  catch(Exception e){
		  LOGGER.debug(e);
		  }
			
			return bSaved;
		}
		

} // End of browserpage class