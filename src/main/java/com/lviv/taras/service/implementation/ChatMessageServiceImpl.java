package com.lviv.taras.service.implementation;

import com.lviv.taras.entity.ChatMessage;
import com.lviv.taras.entity.User;
import com.lviv.taras.repository.ChatMessageRepository;
import com.lviv.taras.service.abstraction.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public List<ChatMessage> findAll() {
        return this.chatMessageRepository.findAll();
    }

    @Override
    public void save(ChatMessage chatMessage) {
        this.chatMessageRepository.save(chatMessage);
    }

    @Override
    public ChatMessage getOne(Long id) {
        return this.chatMessageRepository.findOne(id);
    }

    @Override
    public List<ChatMessage> findAll(Iterable<Long> ids) {
        return this.chatMessageRepository.findAll(ids);
    }

    @Override
    public List<ChatMessage> findFullDialog(User author, User receiver) {
        return this.chatMessageRepository.findFullDialog(author, receiver);
    }
}
