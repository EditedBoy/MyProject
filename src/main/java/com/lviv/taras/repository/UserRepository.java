package com.lviv.taras.repository;

import com.lviv.taras.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
