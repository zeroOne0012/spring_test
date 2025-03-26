package com.example.demo.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/send")  // "/app/send"로 온 메시지 처리
    @SendTo("/topic/messages")  // 메시지를 "/topic/messages"로 발행
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("Received message: " + message.getContent());
        return message;  // 받은 메시지를 그대로 반환
    }
}