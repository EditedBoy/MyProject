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
        // with help of our service UserService we get User
        User user = this.userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("There is no user in database with this email.");
        }
        // Setting roles for this user
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));

        // based on received data making object UserDetails
        // which will let to check entered user login and password
        // and then authenticate user
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), roles);
    }
}