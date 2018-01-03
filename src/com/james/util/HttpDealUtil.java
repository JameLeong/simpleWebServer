package com.james.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.james.entity.RequestData;

/**
 * HTTP内容处理
 * 
 * @author James Leong
 * @date 2017年11月16日
 */
public class HttpDealUtil {
	private static List<String> INDEX_URL = new ArrayList<String>(){
		private static final long serialVersionUID = 1222435746236660081L;

		{
			add("index.html");
			add("/");
		}
	};
	public static RequestData getRequestData(String requestStr) {
		String url = null;
		if(requestStr!=null){
			int index1, index2;
			index1 = requestStr.indexOf(' ');
			if (index1 != -1) {
				index2 = requestStr.indexOf(' ', index1 + 1);
				if (index2 > index1){
					String dataStr = requestStr.substring(index1 + 1, index2);
					String dataArr[] = dataStr.split("[?]");
					url = dataArr[0];
					Map<String, String> params = new HashMap<String, String>();
					if(dataArr.length>1){
						String paramStr = dataArr[1];
						if(paramStr!=null){
			            	for(String s: paramStr.split("&")){
			            		String[] tmp = s.split("=");
			            		params.put(tmp[0], tmp[1]);
			            	}
			            }
					}
					return new RequestData(dataStr,url, params);
				}
			}
		}
		return new RequestData();
	}

	/**
	 * 是否为主页
	 * @param url
	 * @return
	 */
	public static boolean isIndex(String url) {
		if(INDEX_URL.contains(url)){
			return true;
		}
		return false;
	}
}
