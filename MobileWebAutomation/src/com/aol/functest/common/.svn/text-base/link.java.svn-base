
package com.aol.functest.common;

/**
*	This class defines one of the object called link
*	@version 1.0
*	@author shiladityaroy
*/

public class link extends BrowserPageElement {

	String sLink;

	/**
	*	Constructor to initialize a link object. 
	*	@param slnk Identifier of the link that has to be initialized
	*	@return void
	*/

	public link (browserpage page, String slnk) {
		super(page);
		sLink = slnk;
	}
	
	/**
	*	Click method to click on the link object. Calls Browserpage click method. 
	*	@param none
	*	@retun void
	*/
	public void click () {
		getBrowserPage().click (sLink);
	}
	
	/**
	 * Method which will return the ID of the object being initialized.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getWindowID () {
		return sLink;
	}
	
	/**
	 * Method which will return the Text of the link.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getText () {
		return getBrowserPage().getText(sLink);
	}
}