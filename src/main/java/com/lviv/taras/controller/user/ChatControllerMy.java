package com.lviv.taras.controller.user;

import com.lviv.taras.entity.ChatMessage;
import com.lviv.taras.entity.User;
import com.lviv.taras.entity.dto.ChatMessageDto;
import com.lviv.taras.service.abstraction.ChatMessageService;
import com.lviv.taras.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChatControllerMy {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatMessageService chatMessageService;


    @RequestMapping(value = "/chatMy", method = RequestMethod.GET)
    public String getChatPage() {
        System.out.println("ChatMy");

        return "chatMy";
    }


    @RequestMapping(value = "/chatMy/inComingMessage", method = RequestMethod.POST)
    public String postMessage(@RequestBody ChatMessageDto messageData) {
        System.out.println("Incoming message");

        User messageAuthor = this.userService.findByEmail(this.getAuthenticationEmail());
        User messageReceiver = this.userService.getOne(messageData.getReceiver());

        ChatMessage chatMessage = ChatMessageDto.convertChatDtoToChat(messageData);
        chatMessage.setAuthor(messageAuthor);
        chatMessage.setReceiver(messageReceiver);

        this.chatMessageService.save(chatMessage);
        return "chatMy";
    }

    @ResponseBody
    @RequestMapping(value = "/chatMy/outComingMessage/{idUser}", method = RequestMethod.POST)
    public List<ChatMessage> getMessageByUserId(@PathVariable Long idUser) {
        System.out.println("id " + idUser);

        User requestUserData = this.userService.getOne(idUser);
        User authUserData = this.userService.findByEmail(this.getAuthenticationEmail());

        List<ChatMessage> messages = this.chatMessageService.findFullDialog(authUserData, requestUserData);

        return messages;
    }


    @ResponseBody
    @RequestMapping(value = "/chatMy/getMyUsers", method = RequestMethod.POST, produces = "application/json")
    public List<User> getUserList() {
        User authUserData = this.userService.findByEmail(this.getAuthenticationEmail());
        List<User> myUserList = this.userService.findAll();
        myUserList.remove(authUserData);

        return myUserList;
    }


    private String getAuthenticationEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
