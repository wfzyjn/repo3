package com.itheima.mybatis_plus;

import com.itheima.enums.SexEnum;
import com.itheima.mapper.ProductMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.mybatis_plus.pojo.Product;
import com.itheima.mybatis_plus.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusStudentTest {
    @Autowired
    private StudentMapper  studentMapper;
    @Test
    public   void test01(){
        Student student = new Student();
        student.setName("homgxiao11");
        student.setAge(21);
        student.setSex(SexEnum.MALE);
        int insert = studentMapper.insert(student);
        System.out.println("------------");
        System.out.println(insert);
    }
}
