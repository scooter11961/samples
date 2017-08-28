package com.aol.functest.common;

/**
*	This Class defines one of the object type called button.
*	@version 1.0
*	@author shiladityaroy
*/
public class button extends BrowserPageElement {

	String sBtnToClickID;
	/**
	*	Constructor to initialize a button object. 
	*	@param sBtn Identifier of the button that has to be initialized
	*	@return void
	*/

	public button (browserpage page, String sBtn) {
		super(page);
		sBtnToClickID = sBtn;
	}
	
	/**
	*	Click method to click on the button object. Calls Browserpage click method. 
	*	@param none
	*	@retun void
	*/
	public void click () {
		getBrowserPage().click (sBtnToClickID);
	}
	
	/**
	 * Method which will return the ID of the object being initialized.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getWindowID () {
		return sBtnToClickID;
	}

}