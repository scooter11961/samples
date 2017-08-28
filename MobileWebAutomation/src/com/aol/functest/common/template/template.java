package com.aol.functest.common.template;


/* This Template has to be used for any common Object Type that you are writing. 
Some of the Object Types are 
	a) button
	b) checkbox
	c) textfield
	d) dropdown

You have to write methods that are relevant to each Object Type. 
One example given below is click () method.

Note : 1) Every class has to follow the JAVA DOC standards that is mentioned in the example. 
	   2) Please remove this comment section when you copy this template. 
*/

/**
*	This Class defines one of the object type called template.
*	@version 1.0
*	@author manjunth
*	@deprecated
*/
public class template {

	String sTempID;

	/**
	*	Constructor to initialize a button object. 
	*	@param sBtn Identifier of the button that has to be initialized
	*	@return void
	*/

	public template (String sTmp) {
		sTempID = sTmp;
	}
	
//	public void click () {
//		browserpage.getInstance().click (sTempID);
//	}
	
	/**
	 * Method which will return the ID of the object being initialized.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getWindowID () {
		return sTempID;
	}

}