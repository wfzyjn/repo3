package com.itheima.mybatis_plus;

import com.itheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlueaServiceTest {


    @Autowired
    private UserService userService;


    @Test
    public void  testGetCont(){
        long count = userService.count();
        System.out.println(count);
    }

}
