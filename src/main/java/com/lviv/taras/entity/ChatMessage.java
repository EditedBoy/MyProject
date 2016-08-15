package com.lviv.taras.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class ChatMessage {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

    @XmlTransient
    @ManyToOne(fetch = FetchType.EAGER)
    private User receiver;

    public ChatMessage() {
    }

    public ChatMessage(String message, LocalDateTime datetime) {
        this.message = message;
        this.datetime = datetime;
    }

    public ChatMessage(String message, LocalDateTime datetime, User author) {
        this.message = message;
        this.datetime = datetime;
        this.author = author;
    }
}
