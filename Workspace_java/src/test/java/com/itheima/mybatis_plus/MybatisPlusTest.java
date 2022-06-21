package com.itheima.mybatis_plus;

import com.itheima.mapper.UserMapper;
import com.itheima.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {
   @Resource
    private UserMapper userMapper;
    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public  void   tsetInsert(){
        User user=new User();
        user.setAge(10);
        user.setName("王五");
        user.setEmall("test@1taobao.com");
        int result = userMapper.insert(user);
        System.out.println("result:"+result);
        System.out.println("id:"+user.getId());
    }
    @Test
    public void testDelete(){
       /* int i = userMapper.deleteById(1514908115614134274l);
        System.out.println(i);
        System.out.println("-----------------------");
        Map<String,Object> map=new HashMap<>();
        map.put("name","jack");
        map.put("age",20);
        userMapper.deleteByMap(map);*/
        System.out.println("------------");
        List<Long> list = Arrays.asList(1l, 3l);
        userMapper.deleteBatchIds(list);
        list.forEach(System.out::println);
    }

    @Test
    public  void  testUpdate(){
        User user = new User();
        user.setId(1514908115614134274l);
        user.setName("洪七公");
        user.setAge(100);
        user.setEmall("hongqigong@taobao.com");
        int result = userMapper.updateById(user);
        System.out.println("result:"+result);
    }


@Test
    public void testSelect(){
//    查询方法
   /* User user = userMapper.selectById(1);*/
   /* List<Long> list = Arrays.asList(1L, 2L, 1514908115614134274L);
    userMapper.selectBatchIds(list);
    list.forEach(System.out::println);
*/
    System.out.println("----------------");
//    Map<String, Object> map=new HashMap<>();
//    map.put("name","Jone");
//    map.put("age",18);
//    List<User> list = userMapper.selectByMap(map);
//    list.forEach(System.out::println);
    Map<String, Object> map = userMapper.selectMapById(1l);
    System.out.println(map);

}

}
