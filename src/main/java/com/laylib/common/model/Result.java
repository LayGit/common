package com.laylib.common.model;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Result implements Serializable {
	private int code;
	
	private Object data;
	
	private String message;
	
	public Result()
	{
		this(0, null, "");
	}
	
	public Result(Object data)
	{
		this(0, data, "");
	}
	
	public Result(int code, String message)
	{
		this(code, null, message);
	}
	
	public Result(int code, Object data, String message)
	{
		this.code = code;
		this.data = data != null ? data : new HashMap<String, String>();
		this.message = message != null ? message : "";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
