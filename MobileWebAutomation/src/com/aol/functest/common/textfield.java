package com.aol.functest.common;


/**
*	This class defines the Textfield object.
*	@version 1.0
*	@author shiladityaroy
*/

public class textfield extends BrowserPageElement {

	String sTxtFieldID;

	/**
	*	Constructor to initialize the text field object
	*	@param sTxt Identifier of text field
	*	@return void
	*/
	public textfield (browserpage page, String sTxt) {
		super(page);
		sTxtFieldID = sTxt;
	}

	/** Method to settext in the text field. 
	*	@param sValue The text that has to be entered in the text field.
	*	@return void
	*/
	public void setText (String sValue) {
		getBrowserPage().type (sTxtFieldID, sValue);
	}

	/**
	*	Method to get the text from the text field
	*	@param none
	*	@return String text that is present in the text field
	*/
	public String getText () {
		return getBrowserPage().getValue(sTxtFieldID);
	}

	/**
	 * Method which will return the ID of the object being initialized.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getWindowID () {
		return sTxtFieldID;
	}
}