package com.involveininnovation.chatserver.controller;

import com.involveininnovation.chatserver.model.Channel;
import com.involveininnovation.chatserver.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class ChatController {
    HashMap<String,Channel> hashMap = new HashMap<>();

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping({"/message","/message/{username}"}) // /app/message 이리로 보내면  (공개대화방 )
//    @SendTo("/chatroom/public") // 처리를 마친 후 이리로 메세지를 보내겠다. 이리로 다 보내라?
    public Message receiveMessage(@Payload Message message, @DestinationVariable String username){
        simpMessagingTemplate.convertAndSend("/chatroom/public"+username,message);
        System.out.println(message.toString());
        return message;
    }

//    @MessageMapping("/private-message") // (개인 메시지 )
//    public Message recMessage(@Payload Message message){
//        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message); // /user/david/private
//        System.out.println(message.toString());
//        return message;
//    }

    @ResponseBody
    @PostMapping("/api/channel") // 나중에 통일 -> 만들기 눌렀을 때
    public void createChannel(@RequestBody String username) {
        Channel channel = new Channel(username);
        hashMap.put(channel.getRoomId(),channel);
    }

//    @ResponseBody
//    @GetMapping("/api/channel")
//    public List<Channel> readChannel() {
//        hashMap
//    }

}