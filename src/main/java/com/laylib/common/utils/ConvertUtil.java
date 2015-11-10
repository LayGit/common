package com.laylib.common.utils;

import org.apache.commons.codec.binary.Base64;

public class ConvertUtil {
	
	/**
	 * String to int
	 * @param str
	 * @return
	 */
	public static int toInt(String str)
	{
		return toInt(str, 0);
	}
	
	public static int toInt(Object obj)
	{
		return toInt(obj.toString(), 0);
	}
	
	/**
	 * String to int
	 * @param str
	 * @param defVal
	 * @return
	 */
	public static int toInt(String str, int defVal)
	{
		try
		{
			return Integer.parseInt(str);
		}
		catch(Exception e)
		{
			return defVal;
		}
	}
	
	public static float toFloat(String str)
	{
		return toFloat(str, 0.0f);
	}
	
	public static float toFloat(String str, float defVal)
	{
		try
		{
			return Float.parseFloat(str);
		}
		catch(Exception e)
		{
			return defVal;
		}
	}
	
	public static double toDouble(Object obj)
	{
		return toDouble(obj.toString(), 0.0d);
	}
	
	public static double toDouble(String str, double defVal)
	{
		try
		{
			return Double.parseDouble(str);
		}
		catch(Exception e)
		{
			return defVal;
		}
	}
	
	public static long toLong(String str)
	{
		return toLong(str, 0l);
	}
	
	public static long toLong(String str, long defVal)
	{
		try
		{
			return Long.parseLong(str);
		}
		catch(Exception e)
		{
			return defVal;
		}
	}
	
	public static String toString(Object obj)
	{
		if (obj != null)
			return obj.toString();
		else
			return "";
	}
	
	public static String toBase64(byte[] b)
	{
		return Base64.encodeBase64String(b);
	}
	
	public static byte[] toByte(String str)
	{
		return Base64.decodeBase64(str);
	}
}
