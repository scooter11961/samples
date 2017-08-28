package com.aol.functest.common;

import com.aol.functest.common.browserpage;
import com.mapquest.util.Logger;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.URL;

/**
*	This class defines one of the object called image
*	@version 1.0
*	@author shiladityaroy
*/
public class image extends BrowserPageElement {

	private static Logger LOGGER = Logger.getLogger(image.class);

	String sImageID;
	/**
	*	Constructor to initialize a Image object. 
	*	@param sImg Identifier of the Image that has to be initialized
	*	@return void
	*/

	public image (browserpage page, String sImg) {
		super(page);
		sImageID = sImg;
	}
	
/*
 * This method will save image from URL
 * 
*/
    public boolean saveImagefromURL (String sSourceURL, String sFileName) throws IOException {		
	  boolean bSaved = false;	
	  if (sSourceURL.length()==0)
	  {
	     sSourceURL = getBrowserPage().getAttribute(sImageID+"@src");
	  }
	  URL uCurrentURL = new URL (sSourceURL);
	  try
	    {      
	       InputStream isFileRead = uCurrentURL.openStream();
	       OutputStream osFileOut = new BufferedOutputStream(new FileOutputStream (sFileName));
	       for (int ibyte; (ibyte = isFileRead.read()) != -1; )
	     	{
	    	   osFileOut.write(ibyte);
	        }
	       osFileOut.close();
	       isFileRead.close(); 
	       bSaved = true;
	    }    
	  catch(Exception e){
	  LOGGER.debug(e);
	  }
		
		return bSaved;
	}
	

	
	
	/**
	 * Method which will return the ID of the object being initialized.
	 * @param none 
	 * @return String - Identifier of the object
	 */
	
	public String getWindowID () {
		return sImageID;
	}
	
	
}

