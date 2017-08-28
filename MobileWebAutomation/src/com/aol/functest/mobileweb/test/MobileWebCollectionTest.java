package com.aol.functest.mobileweb.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mapquest.util.Logger;

/**
 * Tests mobileweb collection actions via MobileWebCollectionIOServlet. 
 * Most of these tests follow the winston FitNesse tests defined here:
 * http://mqsquidy.office.aol.com:15000/FitNesse.WinstonCollectionsTests
 * 
 * @author leahpodkaminer
 */
public class MobileWebCollectionTest {
	
	private static Logger LOGGER = Logger.getLogger(MobileWebCollectionTest.class);
	
	protected static final int DEFAULT_HTTP_CLIENT_CONNECTION_TIMEOUT = 5000;
	
	private String sURL;
	private String testUserId = "4c5605e4aec5857483d68058";
	private HttpClient client;
	
	@BeforeClass(alwaysRun = true)
	public void setupTest()
	{
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config/mobileweb-adv.properties"));
		} catch (FileNotFoundException e) {
			LOGGER.debug(e);
		} catch (IOException e) {
			LOGGER.debug(e);
		}
		sURL = properties.getProperty("url");
		client = new HttpClient();
   }

   @AfterClass(alwaysRun = true)
   public void tearDownTestSuite()
   {
	   client = null;
   }
   
   @BeforeTest
   public void setup()
   {
   }

   @AfterTest
   public void tearDown()
   {
   }
   
   /////////////
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testGetCollection_validCollectionId() throws JSONException, IOException {
	   LOGGER.debug("running TC_testGetCollection_validCollectionId");
	   
	   // add a test collection
	   JSONObject testCollection = addTestCollection();
	   String testCollectionId = testCollection.getJSONObject("collection").getString("id");
	   
	   String getAction = "get?userId=".concat(testUserId);
	   String postParams = new JSONObject().put("id", testCollectionId).toString();
	   HttpMethod method = null; 
	  
	   try {
		   	method = executeCollectionPost(getAction, postParams);
		   
		   	// validate the response
		   	int actualResponseCode = method.getStatusCode();
		   	AssertJUnit.assertEquals(200, actualResponseCode);
	       
		   	String jsonResponseString = method.getResponseBodyAsString();
	
	       	List<String> expectedStrings = new ArrayList<String>();
	       	expectedStrings.add("\"statuscode\":0");
	       	expectedStrings.add("\"messages\":[]");
	       	expectedStrings.add("\"collection\":{");
	       	expectedStrings.add("\"userId\":\""+testUserId+"\"");
	       	expectedStrings.add("\"id\":\""+testCollectionId+"\"");
	       	expectedStrings.add("\"items\":[");
	       	expectedStrings.add("\"type\":\"Point\"");
	       	expectedStrings.add("\"icon\":\"http://www.mapquest.com/icons/rad.png\"");
	       	expectedStrings.add("\"startDate\":\"03-15-2010 20:00:00\"");
	       	expectedStrings.add("\"endDate\":\"03-15-2010 22:00:00\"");
			expectedStrings.add("\"source\":\"DOTCOM\"");
			expectedStrings.add("\"location\":{");
			expectedStrings.add("\"phone\":");
			expectedStrings.add("\"county\":");
			expectedStrings.add("\"postalCode\":");
			expectedStrings.add("\"sourceId\":");
			expectedStrings.add("\"country\":");
			expectedStrings.add("\"street\":");
			expectedStrings.add("\"state\":");
			expectedStrings.add("\"source\":");
			expectedStrings.add("\"name\":");
			expectedStrings.add("\"website\":");
			expectedStrings.add("\"city\":");
			expectedStrings.add("\"type\":\"Route\"");
			expectedStrings.add("\"points\":[{");
			expectedStrings.add("\"avoids\":[\"Limited Access\",\"Toll Road\"]");
			expectedStrings.add("\"routeType\":0");
			expectedStrings.add("\"type\":\"LineString\"");
			expectedStrings.add("\"style\":\"linecolor:FF0000\"");
			expectedStrings.add("\"points\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.094},{\"lat\":39.8585,\"lng\":-104.9525}]");
			expectedStrings.add("\"type\":\"Polygon\"");
			expectedStrings.add("\"linecolor:FF0000;backgroundcolor:FFFFFF;opacity:50\"");
			expectedStrings.add("\"outerPoints\":[{");
			expectedStrings.add("\"innerPoints\":[[{");
			
			for (String expected : expectedStrings) {
				AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
			}
  	  	
	   } finally {
		   // delete the collection
		   deleteTestCollection(testCollectionId);
			
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testGetCollection_invalidCollectionId() throws JSONException, IOException {
	   LOGGER.debug("running TC_testGetCollection_invalidCollectionId");
	   
	   String getAction = "get?userId=".concat(testUserId);
	   String postParams = getPostParamsForGetCollection_invalidId().toString();
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(getAction, postParams);
	  
	       // validate the response
	       int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       JSONObject jsonResponse = new JSONObject(method.getResponseBodyAsString());
	       JSONObject infoBlock = jsonResponse.getJSONObject("info");
	       AssertJUnit.assertEquals(400, infoBlock.get("statuscode"));
	       
	       JSONArray messages = infoBlock.getJSONArray("messages");
	       AssertJUnit.assertTrue(messages.length() > 0);
	       
	       String firstMessage = messages.getString(0);
	       AssertJUnit.assertTrue(firstMessage.indexOf("invalid ObjectId") > -1);
	   } finally {
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testGetCollectionsForUser() throws JSONException, IOException {
	   LOGGER.debug("running TC_testGetCollectionsForUser");
	   
	   // add some new collections
	   JSONObject testCollection1 = addTestCollection();
	   JSONObject testCollection2 = addTestCollection();
	   
	   String testCollectionId1 = testCollection1.getJSONObject("collection").getString("id");
       String testCollectionId2 = testCollection2.getJSONObject("collection").getString("id");
	   
	   String getAction = "get?userId=".concat(testUserId);
	   String postParams = getPostParamsForGetCollectionsForUser().toString();
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(getAction, postParams);
	  
	       // validate the response
	       int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       String jsonResponseString = method.getResponseBodyAsString();
	       
	       List<String> expectedStrings = new ArrayList<String>();
	       expectedStrings.add("\"statuscode\":0");
	       expectedStrings.add("\"messages\":[]");
	       expectedStrings.add("\"collections\":[{");
	       expectedStrings.add("\"userId\":\""+testUserId+"\"");
	       expectedStrings.add("\"items\":[");
	       expectedStrings.add("\"type\":\"Point\"");
	       expectedStrings.add("\"type\":\"LineString\"");
	       expectedStrings.add("\"type\":\"Route\"");
	       expectedStrings.add("\"type\":\"Polygon\"");
	       expectedStrings.add("\"id\":\""+testCollectionId1+"\"");
	       expectedStrings.add("\"id\":\""+testCollectionId2+"\"");
	       
	       for (String expected : expectedStrings) {
	    	   AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
	       }
	       
	       /* for debugging
	       JSONObject jsonResponse = new JSONObject(jsonResponseString);
	       JSONArray collections = jsonResponse.getJSONArray("collections");
	       List<JSONObject> collectionsList = getJSONArrayAsList(collections);
	       
	       LOGGER.debug("user collections: ");
	       for (JSONObject coll : collectionsList) {
	    	   LOGGER.debug("\t"+coll.getString("id"));
	       }*/
	       
	   } finally {
		   // cleanup the test collections
	       deleteTestCollection(testCollectionId1);
	       deleteTestCollection(testCollectionId2);
	       
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testSaveNewCollection() throws JSONException, IOException {
	   LOGGER.debug("running TC_testSaveNewCollection");
	   
	   String action = "save?userId=".concat(testUserId);
	   String postParams = getPostParamsForSaveNewCollection().toString();
	   String testCollectionId = null;
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(action, postParams);
		   
		   // validate the response
		   int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
		   
	       // response should look something like this:
	       // {"info":{"statuscode":0,"copyright":{"text":" 2010 MapQuest, Inc.","imageUrl":"http://tile21.mqcdn.com/res/mqlogo.gif","imageAltText":" 2010 MapQuest, Inc."},"messages":[]},"collection":{"userId":"4c5605e4aec5857483d68058","items":[{"type":"Point","id":"4c571350b91e60731964178c"},{"type":"LineString","id":"4c571350b91e60731a64178c"},{"type":"Route","id":"4c571350b91e60731b64178c"},{"type":"Polygon","id":"4c571350b91e60731c64178c"}],"id":"4c571350b91e60731d64178c"}}
	       JSONObject jsonResponse = new JSONObject(method.getResponseBodyAsString());
	       testCollectionId = jsonResponse.getJSONObject("collection").getString("id");
	       JSONObject infoBlock = jsonResponse.getJSONObject("info");
	       AssertJUnit.assertEquals(0, infoBlock.get("statuscode"));
	       
	       JSONArray messages = infoBlock.getJSONArray("messages");
	       AssertJUnit.assertEquals(0, messages.length());
	       AssertJUnit.assertTrue(jsonResponse.has("collection"));
	       
	       JSONArray items = jsonResponse.getJSONObject("collection").getJSONArray("items");
	       AssertJUnit.assertEquals(4, items.length());
	       
	       String itemsAsString = items.toString();
	       AssertJUnit.assertTrue(itemsAsString.indexOf("\"type\":\"Point\"") > -1);
	       AssertJUnit.assertTrue(itemsAsString.indexOf("\"type\":\"LineString\"") > -1);
	       AssertJUnit.assertTrue(itemsAsString.indexOf("\"type\":\"Route\"") > -1);
	       AssertJUnit.assertTrue(itemsAsString.indexOf("\"type\":\"Polygon\"") > -1);
	       
	   } finally {
		   // cleanup - delete the collection
	       if (testCollectionId != null)
	    	   deleteTestCollection(testCollectionId);
	       
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testSaveNewCollection_withBadJSONObjectParam() throws JSONException, IOException {
	   LOGGER.debug("running TC_testSaveNewCollection_withBadJSONObjectParam");
	   
	   String action = "save?userId=".concat(testUserId);
	   String postParams = getPostParamsForSaveNewCollection_withBadJSONObjectParam().toString();
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(action, postParams);
		   
		   // validate the response
		   int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       String jsonResponseString = method.getResponseBodyAsString();
	       List<String> expectedStrings = new ArrayList<String>();
	       expectedStrings.add("{\"info\":{");
	       expectedStrings.add("\"statuscode\":400");
	       expectedStrings.add("\"messages\":[\"Error parsing JSON from Request: Invalid item element [3]: 'lat' is not a number., see http://www.mapquestapi.com/collections/ for details on correctly formatting collections.\"]}}");
	       
	       for (String expected : expectedStrings) {
	    	   AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
	       }
	   } finally {
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testSaveExistingCollection() throws JSONException, IOException {
	   LOGGER.debug("running TC_testSaveExistingCollection");
	   
	   JSONObject testCollection = addTestCollection();
	   String testCollectionId = testCollection.getJSONObject("collection").getString("id");
	   
	   String action = "save?userId=".concat(testUserId);
	   String postParams = getPostParamsForSaveExistingCollection(testCollectionId).toString();
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(action, postParams);
		   
		   // validate the response
		   int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       String jsonResponseString = method.getResponseBodyAsString();
	       List<String> expectedStrings = new ArrayList<String>();
	       expectedStrings.add("{\"info\":{");
	       expectedStrings.add("\"statuscode\":0");
	       expectedStrings.add("\"messages\":[]");
	       expectedStrings.add("\"collection\":{");
	       expectedStrings.add("\"items\":[{");
	       expectedStrings.add("\"type\":\"Point\"");
	       expectedStrings.add("\"type\":\"LineString\"");
	       expectedStrings.add("\"type\":\"Route\"");
	       expectedStrings.add("\"type\":\"Polygon\"");
	       expectedStrings.add("\"id\":\""+testCollectionId+"\"");
	       
	       for (String expected : expectedStrings) {
	    	   AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
	       }
	       
	       // refetch the saved collection and validate the changed info
	       JSONObject thisCollection = getCollection(testCollectionId);
	       String collectionString = thisCollection.toString();
	       
	       List<String> savedExpected = new ArrayList<String>();
	       savedExpected.add("\"notes\":\"Saved Over Collection\"");
	       
	       for (String expected : savedExpected) {
	    	   AssertJUnit.assertTrue(expected, collectionString.indexOf(expected) > -1);
	       }
	       
	   } finally {
		   // cleanup - delete the collection
	       deleteTestCollection(testCollectionId);
	       
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testUpdateCollection() throws JSONException, IOException {
	   LOGGER.debug("running TC_testUpdateCollection");
	   
	   JSONObject testCollection = addTestCollection();
	   String testCollectionId = testCollection.getJSONObject("collection").getString("id");
	   
	   String action = "update?userId=".concat(testUserId);
	   String postParams = getPostParamsForUpdateCollection(testCollectionId).toString();
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(action, postParams);
		   
		   // validate the response
		   int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       String jsonResponseString = method.getResponseBodyAsString();
	   
	       List<String> expectedStrings = new ArrayList<String>();
	       expectedStrings.add("{\"info\":{");
	       expectedStrings.add("\"statuscode\":0");
	       expectedStrings.add("\"messages\":[]");
	       expectedStrings.add("\"collection\":{");
	       expectedStrings.add("\"items\":[{");
	       expectedStrings.add("\"type\":\"Point\"");
	       expectedStrings.add("\"type\":\"LineString\"");
	       expectedStrings.add("\"type\":\"Route\"");
	       expectedStrings.add("\"type\":\"Polygon\"");
	       expectedStrings.add("\"id\":\""+testCollectionId+"\"");
	       
	       for (String expected : expectedStrings) {
	    	   AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
	       }
	       
	       // refetch the updated collection and validate the changed info
	       JSONObject thisCollection = getCollection(testCollectionId);
	       String collectionString = thisCollection.toString();
	       
	       List<String> updatedExpected = new ArrayList<String>();
	       updatedExpected.add("\"notes\":\"updated notes\"");
	       
	       for (String expected : updatedExpected) {
	    	   AssertJUnit.assertTrue(expected, collectionString.indexOf(expected) > -1);
	       }

	   } finally {
		   // cleanup - delete the collection
	       deleteTestCollection(testCollectionId);
	       
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testUpdateCollection_withInvalidCollectionId() throws JSONException, IOException {
	   LOGGER.debug("running TC_testUpdateCollection");
	   
	   JSONObject testCollection = addTestCollection();
	   String testCollectionId = testCollection.getJSONObject("collection").getString("id");
	   
	   String action = "update?userId=".concat(testUserId);
	   String invalidCollectionId = "4b96af24d5404fd82c058faf";
	   String postParams = getPostParamsForUpdateCollection(invalidCollectionId).toString();
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(action, postParams);
		   
		   // validate the response
		   int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       String jsonResponseString = method.getResponseBodyAsString();
	   
	       List<String> expectedStrings = new ArrayList<String>();
	       expectedStrings.add("{\"info\":{");
	       expectedStrings.add("{\"statuscode\":404");
	       expectedStrings.add("\"messages\":[\"Invalid collection.\"]}}");
	       
	       for (String expected : expectedStrings) {
	    	   AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
	       }
	       
	   } finally {
		   // cleanup - delete the collection
	       deleteTestCollection(testCollectionId);
	       
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testUpdateItem() throws JSONException, IOException {
	   LOGGER.debug("running TC_testUpdateItem");
	   
	   JSONObject testCollection = addTestCollection();
	   String testCollectionId = testCollection.getJSONObject("collection").getString("id");
	   
	   String action = "updateitem?userId=".concat(testUserId);
	   JSONObject postParamsForUpdateItem_typeRoute = getPostParamsForUpdateItemInCollection_typeRoute(testCollectionId);
	   String itemId = postParamsForUpdateItem_typeRoute.getJSONObject("item").getString("id");
	   String postParams = postParamsForUpdateItem_typeRoute.toString();
	   
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(action, postParams);
		   
		   // validate the response
		   int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       String jsonResponseString = method.getResponseBodyAsString();
	       List<String> expectedStrings = new ArrayList<String>();
	       expectedStrings.add("\"statuscode\":0");
	       expectedStrings.add("{\"item\":{\"type\":\"Route\"");
	       expectedStrings.add("\"id\":\""+itemId+"\"");
	       
	       for (String expected : expectedStrings) {
	    	   AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
	       }
	       
	       //// test another update, this time for a point item
	       JSONObject postParamsForUpdateItem_typePoint = getPostParamsForUpdateItemInCollection_typePoint(testCollectionId);
	       itemId = postParamsForUpdateItem_typeRoute.getJSONObject("item").getString("id");
	       postParams = postParamsForUpdateItem_typePoint.toString();
	       method = executeCollectionPost(action, postParams);
		   
		   // validate the response
		   actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       jsonResponseString = method.getResponseBodyAsString();
	       expectedStrings = new ArrayList<String>();
	       expectedStrings.add("\"statuscode\":0");
	       expectedStrings.add("{\"item\":{\"type\":\"Point\"");
	       expectedStrings.add("\"id\":\""+itemId+"\"");
	       
	       for (String expected : expectedStrings) {
	    	   AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
	       }
	       
	   } finally {
		   // cleanup - delete the collection
	       deleteTestCollection(testCollectionId);
	       
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   @Test(groups = { "groupMobileWebCollections" })
   public void TC_testAddItem() throws JSONException, IOException {
	   LOGGER.debug("running TC_testAddItem");
	   
	   JSONObject testCollection = addTestCollection();
	   String testCollectionId = testCollection.getJSONObject("collection").getString("id");
	   
	   String action = "additem?userId=".concat(testUserId);
	   String postParams = getPostParamsForAddItemToCollection(testCollectionId).toString();
	   HttpMethod method = null;
	   
	   try {
		   method = executeCollectionPost(action, postParams);
		   
		   // validate the response
		   int actualResponseCode = method.getStatusCode();
	       AssertJUnit.assertEquals(200, actualResponseCode);
	       
	       String jsonResponseString = method.getResponseBodyAsString();
	       
	       List<String> expectedStrings = new ArrayList<String>();
	       expectedStrings.add("{\"item\":{");
	       expectedStrings.add("\"type\":\"Point\"");
	       expectedStrings.add("\"id\":");
	       expectedStrings.add("\"info\":{");
	       expectedStrings.add("\"statuscode\":0");
	       expectedStrings.add("\"messages\":[]");
	       
	       for (String expected : expectedStrings) {
	    	   AssertJUnit.assertTrue(expected, jsonResponseString.indexOf(expected) > -1);
	       }
	   
	   } finally {
		   // cleanup - delete the collection
	       deleteTestCollection(testCollectionId);
	       
		   if (method != null)
			   method.releaseConnection();
	   }
   }
   
   ////// utility methods
   
   private JSONObject getPostParamsForUpdateItemInCollection_typeRoute(String collectionId) throws JSONException {
	   String jsonString = "{\"id\":\""+collectionId+"\",\"item\":{\"type\":\"ROUTE\",\"source\":\"DOTCOM\",\"options\":{\"avoids\":[\"Limited Access\",\"Toll Road\"],\"routeType\":0,\"distanceUnit\":0},\"points\":[{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7299,\"lng\":-104.9777},\"location\":{\"source\":\"GSS\",\"sourceId\":\"67890\",\"name\":\"Two Handed Pete's\",\"street\":\"860 Clarkson Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80218\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"5552225555\",\"website\":\"http://www.fakewebsite.com\"}}],\"id\":\"4beab00d94d1c283d9117e1d\"}}";
	   JSONObject jsonObject = new JSONObject(jsonString);
	   return jsonObject;
   }
   
   private JSONObject getPostParamsForUpdateItemInCollection_typePoint(String collectionId) throws JSONException {
	   String jsonString = "{\"id\":\""+collectionId+"\",\"item\":{\"type\":\"POINT\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\", \"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Zach's Place\",\"street\":\"10 Wilbur Dr\",\"city\":\"Sinking Spring\",\"state\":\"PA\",\"postalCode\":\"19608\",\"county\":\"Berks\",\"country\":\"US\",\"phone\":\"5552225555\",\"website\":\"http://www.notarealsite.com\"},\"id\":\"4beab00d94d1c283d9117e1d\"}}";
	   JSONObject jsonObject = new JSONObject(jsonString);
	   return jsonObject;
   }
   
   private JSONObject getPostParamsForAddItemToCollection(String collectionId) throws JSONException {
	   String jsonString = "{\"id\":\""+collectionId+"\",\"item\":{\"type\":\"POINT\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\", \"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Zach's Place\",\"street\":\"10 Wilbur Dr\",\"city\":\"Sinking Spring\",\"state\":\"PA\",\"postalCode\":\"19608\",\"county\":\"Berks\",\"country\":\"US\",\"phone\":\"5552225555\",\"website\":\"http://www.notarealsite.com\"}}}";
	   JSONObject jsonObject = new JSONObject(jsonString);
	   return jsonObject;
   }
   
   private JSONObject getPostParamsForUpdateCollection(String collectionId) throws JSONException {
	   String jsonString = "{\"id\":\""+collectionId+"\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"updated notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"items\":[{\"type\":\"POINT\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"updated notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\", \"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"type\":\"LINESTRING\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"updated notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"style\":\"linecolor:FF0000\",\"points\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.0940},{\"lat\":39.8585,\"lng\":-104.9525}]},{\"type\":\"ROUTE\",\"source\":\"DOTCOM\",\"options\":{\"avoids\":[\"Limited Access\",\"Toll Road\"],\"routeType\":0,\"distanceUnit\":0},\"points\":[{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"updated notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"updated notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7299,\"lng\":-104.9777},\"location\":{\"source\":\"GSS\",\"sourceId\":\"67890\",\"name\":\"Two Handed Pete's\",\"street\":\"860 Clarkson Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80218\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"5552225555\",\"website\":\"http://www.fakewebsite.com\"}}]},{\"type\":\"POLYGON\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"updated notes\",\"style\":\"linecolor:FF0000;backgroundcolor:FFFFFF;opacity:50\",\"outerPoints\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.0940},{\"lat\":39.8585,\"lng\":-104.9525},{\"lat\":39.7488,\"lng\":-104.9786}],\"innerPoints\":[[{\"lat\":39.7427,\"lng\":-104.9694},{\"lat\":39.7428,\"lng\":-104.9724},{\"lat\":39.7405,\"lng\":-104.9694},{\"lat\":39.7427,\"lng\":-104.9694}]]}]}";
	   JSONObject jsonObject = new JSONObject(jsonString);
	   return jsonObject;
   }
   
   private JSONObject getPostParamsForSaveNewCollection() throws JSONException {
	   String jsonString = "{\"userId\":\""+testUserId+"\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"items\":[{\"type\":\"POINT\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\", \"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"type\":\"LINESTRING\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"style\":\"linecolor:FF0000\",\"points\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.0940},{\"lat\":39.8585,\"lng\":-104.9525}]},{\"type\":\"ROUTE\",\"source\":\"DOTCOM\",\"options\":{\"avoids\":[\"Limited Access\",\"Toll Road\"],\"routeType\":0,\"distanceUnit\":0},\"points\":[{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7299,\"lng\":-104.9777},\"location\":{\"source\":\"GSS\",\"sourceId\":\"67890\",\"name\":\"Two Handed Pete's\",\"street\":\"860 Clarkson Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80218\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"5552225555\",\"website\":\"http://www.fakewebsite.com\"}}]},{\"type\":\"POLYGON\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"style\":\"linecolor:FF0000;backgroundcolor:FFFFFF;opacity:50\",\"outerPoints\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.0940},{\"lat\":39.8585,\"lng\":-104.9525},{\"lat\":39.7488,\"lng\":-104.9786}],\"innerPoints\":[[{\"lat\":39.7427,\"lng\":-104.9694},{\"lat\":39.7428,\"lng\":-104.9724},{\"lat\":39.7405,\"lng\":-104.9694},{\"lat\":39.7427,\"lng\":-104.9694}]]}]}";
	   JSONObject jsonObject = new JSONObject(jsonString);
	   return jsonObject;
   }
   
   private JSONObject getPostParamsForSaveNewCollection_withBadJSONObjectParam() throws JSONException {
	   String jsonString = "{\"userId\":\""+testUserId+"\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"items\":[{\"type\":\"POINT\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\", \"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"type\":\"LINESTRING\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"style\":\"linecolor:FF0000\",\"points\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.0940},{\"lat\":39.8585,\"lng\":-104.9525}]},{\"type\":\"ROUTE\",\"source\":\"DOTCOM\",\"options\":{\"avoids\":[\"Limited Access\",\"Toll Road\"],\"routeType\":0,\"distanceUnit\":0},\"points\":[{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"notes\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7299,\"lng\":-104.9777},\"location\":{\"source\":\"GSS\",\"sourceId\":\"67890\",\"name\":\"Two Handed Pete's\",\"street\":\"860 Clarkson Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80218\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"5552225555\",\"website\":\"http://www.fakewebsite.com\"}}]},{\"type\":\"POLYGON\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"notes\",\"style\":\"linecolor:FF0000;backgroundcolor:FFFFFF;opacity:50\",\"outerPoints\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.0940},{\"lat\":39.8585,\"lng\":-104.9525},{\"lat\":39.7488,\"lng\":-104.9786}],\"innerPoints\":[[{\"lat\":ab.cdefg,\"lng\":-gfe.dcba},{\"lat\":ab.cdefg,\"lng\":-gfe.dcba},{\"lat\":ab.cdefg,\"lng\":-gfe.dcba},{\"lat\":ab.cdefg,\"lng\":-gfe.dcba}]]}]}";
	   JSONObject jsonObject = new JSONObject(jsonString);
	   return jsonObject;
   }
   
   private JSONObject getPostParamsForSaveExistingCollection(String collectionId) throws JSONException {
	   String jsonString = "{\"id\":\""+collectionId+"\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"Saved Over Collection\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"items\":[{\"type\":\"POINT\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"Saved Over Collection\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\", \"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"type\":\"LINESTRING\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"Saved Over Collection\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"style\":\"linecolor:FF0000\",\"points\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.0940},{\"lat\":39.8585,\"lng\":-104.9525}]},{\"type\":\"ROUTE\",\"source\":\"DOTCOM\",\"options\":{\"avoids\":[\"Limited Access\",\"Toll Road\"],\"routeType\":0,\"distanceUnit\":0},\"points\":[{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"Saved Over Collection\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7499,\"lng\":-104.9977},\"location\":{\"source\":\"GSS\",\"sourceId\":\"12345\",\"name\":\"Two Fisted Mario's\",\"street\":\"1626 Market Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80202\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"3036233523\",\"website\":\"http://www.doubledaughters.com\"}},{\"pointType\":\"STOP\",\"title\":\"title\",\"notes\":\"Saved Over Collection\",\"startDate\":\"03-15-2010 20:00:00\",\"endDate\":\"03-15-2010 22:00:00\",\"icon\":\"http://www.mapquest.com/icons/rad.png\",\"point\":{\"lat\":39.7299,\"lng\":-104.9777},\"location\":{\"source\":\"GSS\",\"sourceId\":\"67890\",\"name\":\"Two Handed Pete's\",\"street\":\"860 Clarkson Street\",\"city\":\"Denver\",\"state\":\"CO\",\"postalCode\":\"80218\",\"county\":\"Denver\",\"country\":\"US\",\"phone\":\"5552225555\",\"website\":\"http://www.fakewebsite.com\"}}]},{\"type\":\"POLYGON\",\"source\":\"DOTCOM\",\"title\":\"title\",\"notes\":\"Saved Over Collection\",\"style\":\"linecolor:FF0000;backgroundcolor:FFFFFF;opacity:50\",\"outerPoints\":[{\"lat\":39.7488,\"lng\":-104.9786},{\"lat\":39.7968,\"lng\":-105.0940},{\"lat\":39.8585,\"lng\":-104.9525},{\"lat\":39.7488,\"lng\":-104.9786}],\"innerPoints\":[[{\"lat\":39.7427,\"lng\":-104.9694},{\"lat\":39.7428,\"lng\":-104.9724},{\"lat\":39.7405,\"lng\":-104.9694},{\"lat\":39.7427,\"lng\":-104.9694}]]}]}";
	   JSONObject jsonObject = new JSONObject(jsonString);
	   return jsonObject;
   }
   
   private JSONObject getPostParamsForGetCollectionsForUser() throws JSONException {
	   JSONObject jsonObject = new JSONObject();
	   jsonObject.put("userId", testUserId);
	   return jsonObject;
   }
   
   private JSONObject getPostParamsForGetCollection_invalidId() throws JSONException {
	   JSONObject jsonObject = new JSONObject();
	   jsonObject.put("id", "4nota4realid");
	   return jsonObject;
   }
   
   private HttpMethod executeCollectionPost(String collectionAction, String postParams) throws IOException {
	   String collectionUrl = sURL.concat("/_svc/collectionio/").concat(collectionAction);
	   
	   // open http connection
       client.getHttpConnectionManager().getParams().setConnectionTimeout(DEFAULT_HTTP_CLIENT_CONNECTION_TIMEOUT);
       
       // create a method object
       PostMethod method = new PostMethod(collectionUrl);
       method.setRequestHeader("content-type", "text/plain");

       RequestEntity requestEntity = new StringRequestEntity(postParams, null, null);
       method.setRequestEntity(requestEntity);

       // execute the request
       try {
    	   client.executeMethod(method);
       } catch (HttpException e) {
           AssertJUnit.fail(new StringBuilder("There was an HttpException when trying to open site at ")
           		.append(collectionUrl).toString());
       } catch (IOException e) {
    	   e.printStackTrace();
    	   AssertJUnit.fail(new StringBuilder("There was an IOException when trying to open site at ")
           		.append(collectionUrl).toString());
       }
       
       LOGGER.debug("url: "+collectionUrl+", response: "+method.getResponseBodyAsString());
       return method;
   }
   
   private JSONObject getCollection(String collectionId) throws JSONException, IOException {
	   String getAction = "get?userId=".concat(testUserId);
	   String postParams = new JSONObject().put("id", collectionId).toString();
	   HttpMethod method = executeCollectionPost(getAction, postParams);
	  
	   // validate the response
	   int actualResponseCode = method.getStatusCode();
	   AssertJUnit.assertEquals(200, actualResponseCode);
	   
	   return new JSONObject(method.getResponseBodyAsString());
   }
   
   private JSONObject addTestCollection() throws JSONException, IOException {
	   String action = "save?userId=".concat(testUserId);
	   String postParams = getPostParamsForSaveNewCollection().toString();
	   
	   HttpMethod method = executeCollectionPost(action, postParams);
	   
	   // validate the response
	   int actualResponseCode = method.getStatusCode();
       AssertJUnit.assertEquals(200, actualResponseCode);
	   
       // response should look something like this:
       // {"info":{"statuscode":0,"copyright":{"text":" 2010 MapQuest, Inc.","imageUrl":"http://tile21.mqcdn.com/res/mqlogo.gif","imageAltText":" 2010 MapQuest, Inc."},"messages":[]},"collection":{"userId":"4c5605e4aec5857483d68058","items":[{"type":"Point","id":"4c571350b91e60731964178c"},{"type":"LineString","id":"4c571350b91e60731a64178c"},{"type":"Route","id":"4c571350b91e60731b64178c"},{"type":"Polygon","id":"4c571350b91e60731c64178c"}],"id":"4c571350b91e60731d64178c"}}
       return new JSONObject(method.getResponseBodyAsString());
   }
   
   private void deleteTestCollection(String collectionId) throws JSONException, IOException {
       //LOGGER.debug("deleting collection: "+collectionId);
       
       String action = "delete?userId=".concat(testUserId);
       String postParams = new JSONObject().put("id", collectionId).toString();
       HttpMethod method = executeCollectionPost(action, postParams);
       
       int actualResponseCode = method.getStatusCode();
       AssertJUnit.assertEquals(200, actualResponseCode);
   }
   
   public static List<JSONObject> getJSONArrayAsList(JSONArray jsonArray) throws JSONException {
	   if (jsonArray == null) {
		   return new ArrayList<JSONObject>();
	   }
	   
	   int count = jsonArray.length();
	   List<JSONObject> objects = new ArrayList<JSONObject>(count);
	   int i = 0;

	   for (; i < count; ++i) {
		   objects.add(jsonArray.getJSONObject(i));
	   }
	   return objects;
   }
}
