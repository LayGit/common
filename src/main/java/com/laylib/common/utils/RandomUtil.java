package com.laylib.common.utils;

import java.util.UUID;

public class RandomUtil {
	
	/**
	 * 获取随机token
	 * @param lowerCase	是否小写
	 * @return
	 */
	public static String genToken(Boolean lowerCase)
	{
		String s = UUID.randomUUID().toString();
		s = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
		if (lowerCase)
			return s.toLowerCase();
		else
			return s.toUpperCase();
	}
	
	/**
	 * 获取随机数
	 * @param length	随机数长度
	 * @return
	 */
	public static String genNum(int length)
	{
		if (length < 0)
			length = 1;
		StringBuilder sbNum = new StringBuilder();
		for (int i = 0; i < length; i++)
		{
			sbNum.append((int)(Math.random() * 10));
		}
		return sbNum.toString();
	}
}
