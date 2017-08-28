package com.aol.functest.common;

/**
 * This Class defined the Object Type called list which has multiple options. 
 * @author shiladityaroy
 *
 */
public class list extends BrowserPageElement {
	
	String sListID;
	
	/**
	 * Constructor method to initialize the List Object. 
	 * @param sList
	 */
	public list (browserpage page, String sList) {
		super(page);
		sListID = sList;
	}
	
	/**
	 * Method to check if a value is present in the List
	 * @param sValue -- Value to be checked for its presence
	 * @return -- true if the value is present else will return false
	 */
	public boolean isValuePresent (String sValue) {
		boolean bPresent = false;
		if (getBrowserPage().isElementPresent(sListID+"/option[.='"+sValue+"'")) {
			bPresent = true;
		}
		return bPresent;
	}
	
	/**
	 * Method to select the value from the list 
	 * @param sValue - Value to be selected from the list. 
	 */
	public void selectFromList (String sValue) {
		getBrowserPage().click(sListID + "/option[.='" +sValue+"'");
	}
	
	/**
	 * Method to get the Identifier of the List
	 * @return - Identifier of the string.
	 */
	public String getWindowID () {
		return sListID;
	}
	
}