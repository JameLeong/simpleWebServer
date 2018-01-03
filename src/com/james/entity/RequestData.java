package com.james.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求的数据
 * @author James Leong
 * @date 2017年11月16日
 */
public class RequestData {
	private String url;
	private String fullUrl;
	private Map<String, String> param;
	public RequestData() {
		param = new HashMap<String, String>();
		
	}
	public RequestData(String fullUrl,String url, Map<String, String> param) {
		super();
		this.fullUrl = fullUrl;
		this.url = url;
		this.param = param;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, String> getParam() {
		return param;
	}
	public void setParam(Map<String, String> param) {
		this.param = param;
	}
	public String getFullUrl() {
		return fullUrl;
	}
	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}
	
	
	
}
