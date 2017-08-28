package com.aol.functest.common;

/**
*	This class defines one of the object type called "checkbox"
*	@version 1.0
*	@author shiladityaroy
*/
public class checkbox extends BrowserPageElement {

	String sCheckBoxID;
	/**
	*	Constructor to initialize the checkbox object
	*	@param sChk Identifier of the checkbox object
	*	@return void
	*/

	public checkbox (browserpage page, String sChk) {
		super(page);
		sCheckBoxID = sChk;
	}

	/**
	*	Method to check the checkbox. Calls Browserpage check method. 
	*	@param none
	*	@return void
	*/
	public void check () {
		getBrowserPage().check(sCheckBoxID);
		if(!getBrowserPage().isChecked(sCheckBoxID)) {
			getBrowserPage().click(sCheckBoxID);
		}
	}
	
	/**  
	 * Method to check of Uncheck the Checkbox.
	 * @param bCheck - boolean value, Pass true to Check and pass false to UnCheck the Checkbox.
	 */
	public void check (boolean bCheck) {
		if (bCheck){
			getBrowserPage().check(sCheckBoxID);
		}
		else {
			getBrowserPage().uncheck(sCheckBoxID);
		}
	}

	/**
	*	Method to uncheck the checkbox. Calls BrowserPage uncheck method
	*	@param none
	*	@return void
	*/
	public void uncheck () {
		getBrowserPage().uncheck (sCheckBoxID);		
	}

	/**
	*	Method to verify if the checkbox is checked or not. Calls BrowserPage isChecked method. 
	*	@param none
	*	@return boolean True if the checkbox is checked, False if unchecked. 
	*/
	public boolean isChecked () {
		return (getBrowserPage().isChecked (sCheckBoxID));
	}

	/**
	 * Method which will return the ID of the object being initialized.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getWindowID() {
		return sCheckBoxID;
	}
}