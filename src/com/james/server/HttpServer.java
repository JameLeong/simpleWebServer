package com.james.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import com.james.entity.HttpMethod;
import com.james.entity.RequestBean;
import com.james.entity.RequestData;
import com.james.service.ResponseReply;
import com.james.util.HttpDealUtil;

/**
 * HTTP简易服务器
 * 
 * @author James Leong
 * @date 2017年11月16日
 */
public class HttpServer {
	private static Logger logger = Logger.getLogger(HttpServer.class.getName());
	private static final int PORT = 901;
	private static ServerSocket serverSocket;
	private static final String CHARSET = "utf-8";

	public HttpServer() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			logger.severe("HttpServer停止运行，错误为：");
			e.printStackTrace();
		}
	}

	public void start() {
		if (serverSocket == null) {
			logger.severe("HttpServer初始化异常，结束运行");
			System.exit(0);
		}
		logger.info("HttpServer正在运行...");
		while (true) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try {
				socket = serverSocket.accept();
				logger.info("HttpServer接收到新的请求...");
				input = socket.getInputStream();
				output = socket.getOutputStream();
				this.dealRequst(new RequestBean(socket, input, output));
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	/**
	 * 处理请求
	 */
	public void dealRequst(RequestBean requestBean) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(requestBean.getSocket().getOutputStream(),HttpServer.CHARSET)); 
        BufferedReader br = new BufferedReader(new InputStreamReader(requestBean.getSocket().getInputStream(),HttpServer.CHARSET));

        String mthodStr = br.readLine();
        if(mthodStr!=null){
        	 String requestStr = mthodStr;
             //处理HTTP方法
             String method = mthodStr.substring(0, 4).trim();  
             requestBean.setHttpMethod(HttpMethod.valueOf(method));
             String tmpStr;
             while ((tmpStr = br.readLine()) != null && !tmpStr.isEmpty()) {  
             	requestStr +=tmpStr;
             }
             //处理参数数据
             RequestData requestData = HttpDealUtil.getRequestData(requestStr);
             if(HttpDealUtil.isIndex(requestData.getUrl())){
             	 ResponseReply.indexResponse(bw,requestData);
             }else{
                 ResponseReply.notFoundResponse(bw,requestData);
             }
        }
        requestBean.closeResourse();
	}

}
