package com.james;

import com.james.server.HttpServer;
/**
 * 启动webServer
 * http://127.0.0.1:901
 * @author James Leong
 * @date 2017年11月16日
 */
public class Main {
	public static void main(String[] args) {
		new HttpServer().start();
	}

}
