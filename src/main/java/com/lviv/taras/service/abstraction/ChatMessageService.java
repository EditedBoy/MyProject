package com.lviv.taras.service.abstraction;

import com.lviv.taras.entity.ChatMessage;
import com.lviv.taras.entity.User;

import java.util.List;


public interface ChatMessageService extends BaseService<ChatMessage> {

    List<ChatMessage> findFullDialog(User author, User receiver);
}
