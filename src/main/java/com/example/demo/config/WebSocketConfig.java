package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.demo.handler.SocketHandler;

// 구현체 등록
@Configuration
@EnableWebSocket 
public class WebSocketConfig  implements WebSocketConfigurer{
	
	@Autowired
	SocketHandler socketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		//구현체를 등록하였던 url정보를 방번호에 따라 구분될 수 있도록 변경해준다.
		registry.addHandler(socketHandler, "/chating/{roomNumber}");
	}
}
