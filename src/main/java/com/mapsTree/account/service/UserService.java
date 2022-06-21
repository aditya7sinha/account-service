package com.mapsTree.account.service;

import com.mapsTree.account.domain.User;
import com.mapsTree.account.repository.UserRepostitory;
import com.mapsTree.model.UserCreate;
import com.mapsTree.model.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    static final Logger LOG= LoggerFactory.getLogger(UserService.class);
    private final UserRepostitory userRepository;
    public UserService(UserRepostitory userRepository){
        this.userRepository=userRepository;
    }

    public User insert(User user){
        LOG.info("In userService {}", user.toString());
        return userRepository.save(user);
    }

    public User findUser(User user){
        LOG.info("In userService findUser {}", user);
        return userRepository.findUserByUserNameandPassword(user.getUsername(),user.getPassword());
    }

}
