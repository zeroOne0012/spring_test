package com.example.demo.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat/send")  // "/app/send"로 온 메시지 처리
    @SendTo("/topic/messages")  // 메시지를 "/topic/messages"로 발행

    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("Received message: " + message.getContent());
        return message;  // 받은 메시지를 그대로 반환
    }
}

// private final MessageService messageService;

// @MessageMapping("/rooms/{roomId}/message")
// public void message(@DestinationVariable final Long roomId, SaveMessageRequest saveMessageRequest) {
//     messageService.createMessage(roomId, saveMessageRequest);
// }



/* DONE
https://jiangxy.github.io/websocket-debug-tool/

V STOMP
ws://localhost:8080/ws

subscribe destination: /topic/messages
send destination: /app/chat/send

Msg: {"content":"TEST"} // ChatMessage 필드에 맞게

 */