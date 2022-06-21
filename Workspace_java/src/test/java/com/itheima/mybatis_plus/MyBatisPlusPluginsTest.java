package com.itheima.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mapper.UserMapper;
import com.itheima.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public  void test01(){
        Page<User> page = new Page<>(1,3);
         userMapper.selectPage(page, null);
        System.out.println(page);
    }
    @Test
    public  void test02(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPageVo(page,10);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
    }
}
