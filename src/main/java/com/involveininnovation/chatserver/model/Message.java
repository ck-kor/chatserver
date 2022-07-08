package com.involveininnovation.chatserver.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    private String senderName; // 보낸사람
    private String receiverName; // 받는사람
    private String message; // 메시지 내용
    private String date; // 시간? 날짜
    private Status status; // ? 상태라는데
}