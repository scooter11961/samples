/**
 * 
 */
package com.aol.functest.common.util;

/**
 * @author freebeachler
 *
 */
public class StringUtil {

	/**
	 * Strips the last '/' off the end of a string
	 * @param in the string to be sanitized
	 * @return
	 */
	public static String stripSlash(final String in) {
		if (null == in) {
			return null;
		}
		String ret = "";
	    int slashPos = in.lastIndexOf('/');
	    if (slashPos == in.length() - 1 && 0 < slashPos) {
	    	ret = in.substring(0, slashPos);
	    }
		return ret;
	}
}
