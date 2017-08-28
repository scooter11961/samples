package com.aol.functest.common;

/**
 * This class defined the Object type of text. This refers to the rendered text. 
 * @author shiladityaroy
 *
 */

public class text extends BrowserPageElement {
	
	String sTextID;
	
	/**
	 * Constructor method to initialize the text object 
	 * @param sText - Identification of the rendered text. XPATH, ID etc
	 */
	public text (browserpage page, String sText) {
		super(page);
		sTextID = sText;
	}
	
	/**
	 * Method to get the text. 
	 * @return - Value of the rendered text
	 */
	public String getText () {
		return getBrowserPage().getText(sTextID);
	}
	
	/**
	 * Method to get the Window ID for rendered text
	 * @return - Identifier of the Rendered text
	 */
	public String getWindowID () {
		return sTextID;
	}
}