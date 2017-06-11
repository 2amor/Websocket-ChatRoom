/******************************************************************************
 * Copyright (C) 2017 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ�����
 * ����ʹ�á����ơ��޸Ļ򷢲������.
 *****************************************************************************/

package com.websocket;

import java.util.Map;
import java.util.Random;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * @author wuwenhai
 * @since JDK1.6
 * @history 2017-6-3 wuwenhai �½�
 * ��˵��
 */
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{  
	@Override  
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> attributes) throws Exception {  
        System.out.println("Before handshake "+request.getRemoteAddress().toString());
        //attributes��session������������Ե�map��ʾ
        attributes.put("user", getRandomNickName());
        return super.beforeHandshake(request, response, handler, attributes);  
    } 
	
    @Override  
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {  
        System.out.println("After handshake "+request.getRemoteAddress().toString());  
        super.afterHandshake(request, response, wsHandler, ex);  
    }        
    
    //����û�����ƣ������������ڵ��������ƿ��ܷ����ظ�
    public String getRandomNickName(){
    	String[] nickNameArray={"Captain America","Deadpool","Hawkeye","Hulk","Iron Man","Spider Man","Thor","Wolverine","Black Panther","Colossus"};
    	Random random=new Random();
    	return nickNameArray[random.nextInt(10)];
    }
}  
