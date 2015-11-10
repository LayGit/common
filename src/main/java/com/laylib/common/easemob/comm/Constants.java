package com.laylib.common.easemob.comm;

/**
 * Constants
 * 
 * @author Lynch 2014-09-15
 *
 */
public interface Constants {

	// API_HTTP_SCHEMA
	public static String API_HTTP_SCHEMA = "https";
	// API_SERVER_HOST
	public static String API_SERVER_HOST = PropertiesUtils.getProperties().getProperty("API_SERVER_HOST");
	// APPKEY
	public static String APPKEY = PropertiesUtils.getProperties().getProperty("APPKEY");
	// APP_CLIENT_ID
	public static String APP_CLIENT_ID = PropertiesUtils.getProperties().getProperty("APP_CLIENT_ID");
	// APP_CLIENT_SECRET
	public static String APP_CLIENT_SECRET = PropertiesUtils.getProperties().getProperty("APP_CLIENT_SECRET");
	// DEFAULT_PASSWORD
	public static String DEFAULT_PASSWORD = "123456";
	
	public static String GROUP_STUDENT_ID = "121785353450291768";
	public static String GROUP_TEACHER_ID = "121785731277390296";
	public static String GROUP_STUDENT_TEST_ID = "121787285942305284";
	public static String GROUP_TEACHER_TEST_ID = "121787597470040668";
}
