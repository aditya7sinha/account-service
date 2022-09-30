package com.mapsTree.account.controller;

import com.mapsTree.account.exception.UserAlreadyExists;
import com.mapsTree.account.exception.UserNotFoundException;
import com.mapsTree.account.service.UserService;
import com.mapsTree.account.web.rest.mapper.UserLoginMapper;
import com.mapsTree.account.web.rest.mapper.UserMapper;
import com.mapsTree.api.UserApi;
import com.mapsTree.model.User;
import com.mapsTree.model.UserCreate;
import com.mapsTree.model.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final UserLoginMapper userLoginMapper;

    public UserController(
            final UserService userService,
            final UserMapper userMapper,
            final UserLoginMapper userLoginMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userLoginMapper = userLoginMapper;
    }

    @Override
    public ResponseEntity<User> userRegisterPost(UserCreate user) throws UserAlreadyExists {
        LOG.info("POST /user/register");
        String payload = user.toString();
        LOG.info("payload: {}",payload);
        com.mapsTree.account.domain.User savedUser = userService.insert(userMapper.map(user));
        LOG.info("Saved {}", savedUser.toString());
        return new ResponseEntity<>(userMapper.map(savedUser), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> userLoginPost(UserLogin userLogin) throws UserNotFoundException {
        LOG.info("POST /user/login");
        LOG.info("payload: {}",userLogin.toString());
        com.mapsTree.account.domain.User returnedUser = userService.findUser(userLoginMapper.map(userLogin));
        LOG.info("Retrieved User {}",returnedUser.toString());
        return new ResponseEntity<>(userMapper.map(returnedUser),(HttpStatus.ACCEPTED) );
    }

    @Override
    public ResponseEntity<User> userIdGet(String id) {
        LOG.info("GET /user/{id}");
        LOG.info("payload: {}",id.toString());
        User user= new User();
        user.setUserId(id.toString());
        com.mapsTree.account.domain.User returnedUser = userService.findUserById(userMapper.map(user));
        return new ResponseEntity<>(userMapper.map(returnedUser),(HttpStatus.OK));
    }
}

