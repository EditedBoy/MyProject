package com.lviv.taras.service;


import com.lviv.taras.entity.User;
import com.lviv.taras.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // с помощью нашего сервиса UserService получаем User
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("There is no user in database with this email.");
        }
        // указываем роли для этого пользователя
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));

        // на основании полученныйх даных формируем объект UserDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getEmail(),
                        user.getPassword(), roles);
        System.out.println(user);
        System.out.println(roles);
        System.out.println(userDetails);

        return userDetails;
    }
}