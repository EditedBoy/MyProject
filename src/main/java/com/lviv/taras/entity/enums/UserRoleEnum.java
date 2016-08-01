package com.lviv.taras.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRoleEnum implements GrantedAuthority {

    USER("USER"),
    ADMINISTRATOR("ADMINISTRATOR");
    String name;


    UserRoleEnum(final String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
