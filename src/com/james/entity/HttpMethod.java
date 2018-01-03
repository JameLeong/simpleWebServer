package com.james.entity;


/**
 * 请求方法
 * 
 * @author James Leong
 * @date 2017年11月16日
 */
public enum HttpMethod {
	POST("POST"), GET("GET"),OTHER("OTHER");

	private String value;

	HttpMethod(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
