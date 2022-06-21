package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mapper.UserMapper;
import com.itheima.mybatis_plus.pojo.User;
import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class  UserServiceImpl  extends ServiceImpl<UserMapper,User> implements UserService {
}
