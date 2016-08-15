package com.lviv.taras.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "persistent_logins")
public class RememberMeToken implements Serializable {

    @Id
    private String series;

    @Column(name = "last_used")
    @Temporal(TemporalType.DATE)
    private Date date;

    private String email;

    private String token;


    public RememberMeToken() {
    }

    public RememberMeToken(PersistentRememberMeToken token) {
        this.email = token.getUsername();
        this.series = token.getSeries();
        this.token = token.getTokenValue();
        this.date = token.getDate();
    }
}