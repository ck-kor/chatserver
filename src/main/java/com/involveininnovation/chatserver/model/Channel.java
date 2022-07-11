package com.involveininnovation.chatserver.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    private String roomId; // 채널 고유값
    private String owner; // 만든사람
    private String channelName; // 채널이름

    public Channel (String username) {
        this.roomId = UUID.randomUUID().toString();
        this.owner = username;
        this.channelName = username;
    }
}
