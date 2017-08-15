package lee.chatting.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import lee.chatting.dto.ChatRoomDTO;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages={"lee.chatting.*"})
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Bean
	public ArrayList<ChatRoomDTO> getChatRoomList(){
		return new ArrayList<ChatRoomDTO>();
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//앤드포인트 지정
		//cors 접근이 가능하게 해줌
		//socketjs로 통신
		registry.addEndpoint("/chatEndpoint").withSockJS();
		
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry){
		
		registry.enableSimpleBroker("/subscribe");
		registry.setApplicationDestinationPrefixes("/app");
		
	}

}