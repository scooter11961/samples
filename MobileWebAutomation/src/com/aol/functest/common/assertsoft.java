package com.aol.functest.common;

/**
*	This Class defines implements the functionality of Verify and Continue
*   In the Testcase if a step has to verify something and continue with other steps,
*   it has to use verifyAndContinue method.
*	@version 1.0
*	@author shiladityaroy
*/

public class assertsoft {

	public static StringBuilder sbBuilder = new StringBuilder ();
	
	/**
	 * verifyAndContinue method which will help in continuing with the testcase even
	 * if one verification fails to pass. 
	 * @param bSuccess - Boolean Value
	 * @param sMessage - Message that has to be reported when the testcase fails. 
	 */
	public static void verifyAndContinue (boolean bSuccess, String sMessage) {
		if (!bSuccess) {
			sbBuilder.append(sMessage);
		}
	}
	
	/**
	 * This method is used to fail the testcase in case one of the 
	 * verification has failed. 
	 */
	public static void assertEmpty () {
		if (sbBuilder.length() > 0) {
			String sErrorMessage = sbBuilder.toString();
			sbBuilder.delete(0, sbBuilder.length());
			throw new RuntimeException(sErrorMessage);
			
		}
	}

}