package com.feng.springbootdataaccess2.service;

import com.feng.springbootdataaccess2.entity.UserBean;
import com.feng.springbootdataaccess2.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;

    public UserBean LoginIn(String username, String password) {
        return userMapper.getInfo(username,password);
    }

    public void Insert(String username,String password){
        userMapper.saveInfo(username, password);
    }
    public List<UserBean> selectAll ( ){
        return userMapper.selectAll ();
    }
}