package com.mapsTree.account.service;

import com.ctc.wstx.util.StringUtil;
import com.mapsTree.account.domain.User;
import com.mapsTree.account.exception.UserAlreadyExists;
import com.mapsTree.account.exception.UserNotFoundException;
import com.mapsTree.account.repository.UserRepostitory;
import com.mapsTree.model.UserCreate;
import com.mapsTree.model.UserLogin;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    static final Logger LOG= LoggerFactory.getLogger(UserService.class);
    private final UserRepostitory userRepository;
    public UserService(UserRepostitory userRepository){
        this.userRepository=userRepository;
    }

    public User insert(User user) throws UserAlreadyExists{
        LOG.info("In userService {}", user.toString());
        user.setUserId(generateEvent().toString());
//        System.out.println("here"+userRepository.findUserByUsername(user.getUsername()));
//        Boolean userexists = userRepository.userExists(user.getUsername());
//        System.out.print("herer"+userexists);
//        if(userexists.equals("true")){
//            throw new UserAlreadyExists("User Already Exists");
//        }
        return userRepository.save(user);
    }

    public User findUser(User user){
        LOG.info("In userService findUser {}", user);
        User userexists = userRepository.findUserByUsername(user.getUsername());
        System.out.print("herer"+userexists);
        if(!Optional.of(userexists).isPresent()){
            throw new UserNotFoundException("User Does not exist");
        }
        return userRepository.findUserByUserNameandPassword(user.getUsername(),user.getPassword());
    }
    public User findUserById(User user){
        String id= user.getUserId();
        return userRepository.findUserById(id);
    }
    public UUID generateEvent(){
        return UUID.randomUUID();
    }

}
