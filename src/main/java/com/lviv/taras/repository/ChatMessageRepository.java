package com.lviv.taras.repository;


import com.lviv.taras.entity.ChatMessage;
import com.lviv.taras.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Query("select u from ChatMessage u where u.author = :author and u.receiver= :receiver or u.author = :receiver and u.receiver = :author")
//    @Query("SELECT * FROM ChatMessage WHERE author_id = :author AND receiver_id = :receiver " +
//            "OR author_id = :receiver AND receiver_id = :author")
    List<ChatMessage> findFullDialog(@Param("author") User author, @Param("receiver") User receiver);
}
