package com.involveininnovation.chatserver.controller;

import com.involveininnovation.chatserver.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message") // /app/message 이리로 보내면  (공개대화방 )
    @SendTo("/chatroom/public") // 처리를 마친 후 이리로 메세지를 보내겠다. 이리로 다 보내라?
    public Message receiveMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message") // (개인 메시지 )
    public Message recMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message); // /user/david/private
        System.out.println(message.toString());
        return message;
    }
}