package com.laylib.common.model;

import java.util.HashMap;
import java.util.Map;

import com.laylib.common.utils.ConvertUtil;

public class MutableResult {
	private Result result;
	Map<String, Object> map;
	
	public MutableResult()
	{
		result = new Result();
		map = new HashMap<String, Object>();
		result.setCode(0);
		result.setMessage("");
	}
	
	public MutableResult(int code, String message)
	{
		result = new Result();
		map = new HashMap<String, Object>();
		result.setCode(code);
		result.setMessage(message);
	}
	
	public void putList(Object list, int pageIndex, int total)
	{
		this.put("list", list);
		this.put("pageIndex", pageIndex);
		this.put("total", total);
	}
	
	public void put(String key, Object value)
	{
		map.put(key, value);
	}
	
	public void remove(String key)
	{
		map.remove(key);
	}
	
	public Object get(String key)
	{
		return map.get(key);
	}
	
	public String getString(String key)
	{
		return get(key).toString();
	}
	
	public int getInt(String key)
	{
		return ConvertUtil.toInt(getString(key));
	}
	
	public float getFloat(String key)
	{
		return ConvertUtil.toFloat(getString(key));
	}
	
	public long getLong(String key)
	{
		return ConvertUtil.toLong(getString(key));
	}
	
	public Map<String, Object> getData()
	{
		return map;
	}
	
	public Result toResult()
	{
		result.setData(map);
		return result;
	}
}