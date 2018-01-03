package com.james.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 一个请求带的参数
 * @author James Leong
 * @date 2017年11月16日
 */
public class RequestBean {
	private Socket socket ;
	private InputStream inputStream;
	private OutputStream outputStream;
	private HttpMethod HttpMethod;
	
	public RequestBean(Socket socket, InputStream inputStream,
			OutputStream outputStream) {
		this.socket = socket;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}
	
	
	
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public OutputStream getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public HttpMethod getHttpMethod() {
		return HttpMethod;
	}
	public void setHttpMethod(HttpMethod httpMethod) {
		HttpMethod = httpMethod;
	}



	/**
	 * 释放资源
	 */
	public void closeResourse() {
		try {
			this.socket.close();
			this.inputStream.close();
			this.outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
