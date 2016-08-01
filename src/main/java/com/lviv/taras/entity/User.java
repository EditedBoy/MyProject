package com.lviv.taras.entity;

import com.lviv.taras.entity.enums.UserRoleEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class User {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(nullable = false)
    private Long id;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private UserRoleEnum role;
}
