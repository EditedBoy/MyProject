package com.lviv.taras.entity.dto;

import com.lviv.taras.entity.ChatMessage;
import com.lviv.taras.util.DateTimeUtil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ChatMessageDto {

    private String message;

    private String datetime;

    private Long receiver;


    public static ChatMessage convertChatDtoToChat(ChatMessageDto chatDto) {
        ChatMessage chat = new ChatMessage();
        chat.setMessage(chatDto.getMessage());
        chat.setDatetime(DateTimeUtil.stringToLocalDateTime(chatDto.getDatetime()));

        return chat;
    }
}
