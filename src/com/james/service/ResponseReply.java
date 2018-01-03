package com.james.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.james.entity.RequestData;

/**
 * 回应
 * 
 * @author James Leong
 * @date 2017年11月16日
 */
public class ResponseReply {
	/**
	 * 404
	 */
	public static void notFoundResponse( BufferedWriter bw , RequestData requestData) throws IOException {
		bw.write("HTTP/1.1 404 File Not Found");
		bw.newLine();
		bw.write("Content-Type: text/html;charset=utf-8");
		bw.newLine();//HTTP响应头的换行
		bw.newLine();
		bw.write("<h1>404 Not Found,请求的链接：["+requestData.getFullUrl()+"] 没有找到</h1>");
		bw.flush();
	}

	/**
	 * 主页
	 */
	public static void indexResponse(BufferedWriter bw , RequestData requestData) throws IOException {
		String body = "<html><head><title>Server Index</title></head><body>";
		body+="<p><h1>HelloWorld</h1></p>";
		for (Map.Entry<String, String> entry : requestData.getParam().entrySet()) {
			 body+="<h2>你输入的参数: "+ entry.getKey()+" = "+entry.getValue()+"</h2>";
		}
		body+="</body></html>";
		bw.write("HTTP/1.1 200 OK");  
		bw.newLine();
		bw.write("Content-type:text/html;charset=utf-8");  
		bw.newLine();
		bw.write("Server:James's Server");  
		bw.newLine();
		bw.newLine();
        bw.write(body);  
        bw.flush();  
	}
}
