package com.aol.functest.common;

/**
*	This class defines the object	called radio button. 
*	@version 1.0
*	@author shiladityaroy
*/

public class radio extends BrowserPageElement {

	String sRadioID;
	/**
	*	Constructor to initialize the radio button object
	*	@param sRad - Identifier to identify the radio button object. 
	*	@return void
	*/

	public radio (browserpage page, String sRad) {
		super(page);
		sRadioID = sRad;
	}
	
	/**
	*	Method to check the radio button. Calls Browserpage check method. 
	*	@param none
	*	@return void
	*/
	public void check () {
		getBrowserPage().check (sRadioID);
		if(!getBrowserPage().isChecked(sRadioID));
		    getBrowserPage().click(sRadioID);
	}
	
	/**  
	 * Method to check of Uncheck the Checkbox.
	 * @param bCheck - boolean value, Pass true to Check and pass false to UnCheck the Checkbox.
	 */
	public void check (boolean bCheck) {
		if (bCheck){
			getBrowserPage().check(sRadioID);
		}
		else {
			getBrowserPage().uncheck(sRadioID);
		}
	}

	/**
	*	Method to uncheck the checkbox. Calls BrowserPage uncheck method
	*	@param none
	*	@return void
	*/
	public void uncheck () {
		getBrowserPage().uncheck (sRadioID);		
	}

	/**
	*	Method to verify if the checkbox is checked or not. Calls BrowserPage isChecked method. 
	*	@param none
	*	@return boolean True if the checkbox is checked, False if unchecked. 
	*/
	public boolean isChecked () {
		return (getBrowserPage().isChecked (sRadioID));
	}

	/**
	*	Method to click on a radio button. Inturn calls Browserpage click method. 
	*	@param none
	*	@return void
	*/
	public void click () {
		getBrowserPage().click (sRadioID);
	}
	
	/**
	 * Method which will return the ID of the object being initialized.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getWindowID () {
		return sRadioID;
	}
}