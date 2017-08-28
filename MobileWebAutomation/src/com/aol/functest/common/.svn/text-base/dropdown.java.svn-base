package com.aol.functest.common;

/**
*	This class defines one of the object called dropdown
*	@version 1.0
*	@author shiladityaroy
*/
public class dropdown extends BrowserPageElement {

	String sDrpDownID;

	/**
	*	Constructor to initialize the dropdown object.
	*	@param sdd Identifier of the Dropdown object.
	*	@return void
	*/
	public dropdown (browserpage page, String sdd) {
		super(page);
		sDrpDownID = sdd;
	}

	/**
	*	Method to select any value from the dropdown list. 
	*	@param sValue Value in the dropdown to be selected
	*	@return void
	*/
	public void select (String sValue) {
		getBrowserPage().select (sDrpDownID, sValue);
	}

	/**
	 * Method which will return the ID of the object being initialized.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getWindowID () {
		return sDrpDownID;
	}
	
}



