package com.example.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
// import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // private final StompHandler stompHandler; // jwt 관련 로직 추가?

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .withSockJS();
                // .setInterceptors(new HttpSessionHandshakeInterceptor()); // 필요 시 세션 처리

        // CORS 설정: WebSocket 연결에 대한 출처를 허용합니다.
        // WebSocket 엔드포인트 "/ws"에 대해 CORS 정책을 설정하려면 `setAllowedOrigins`를 사용
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*");  // 원하는 출처로 CORS 허용
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");  // 메시지를 발행할 주제(topic) 또는 큐(queue)
        registry.setApplicationDestinationPrefixes("/app");  // 클라이언트에서 서버로 보내는 메시지의 접두사
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        // registration.interceptors(stompHandler);
    }
}