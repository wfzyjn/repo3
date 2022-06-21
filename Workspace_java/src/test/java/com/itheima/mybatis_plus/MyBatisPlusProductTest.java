package com.itheima.mybatis_plus;

import com.itheima.mapper.ProductMapper;
import com.itheima.mybatis_plus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusProductTest {
    @Autowired
    private ProductMapper  productMapper;
    @Test
    public   void test01(){

        List<Product> list = productMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
