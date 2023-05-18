package com.softusing.hejunjie.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterFace {

    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        return userMapper.insert(user);
    }


}
