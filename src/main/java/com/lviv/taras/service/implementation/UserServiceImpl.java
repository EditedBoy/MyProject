package com.lviv.taras.service.implementation;

import com.lviv.taras.entity.User;
import com.lviv.taras.repository.UserRepository;
import com.lviv.taras.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getOne(Long id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public List<User> findAll(Iterable<Long> ids) {
        return this.userRepository.findAll(ids);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}