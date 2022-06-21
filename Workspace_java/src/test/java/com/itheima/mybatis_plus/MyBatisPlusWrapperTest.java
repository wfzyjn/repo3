package com.itheima.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.itheima.mapper.UserMapper;
import com.itheima.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "J")
                .between("age", 11, 20)
                .isNotNull("emall");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void tesst02() {
        /*按年龄升序，如果年龄相同则按id降序*/
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("name")
                .orderByDesc("age");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("emall");
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

    @Test
    public void testUpdate() {
        /*(年龄大于20并且名字包含a)或者邮箱为空*/
        /* UPDATE t_user SET name=?, age=?, emall=? WHERE isdelete=0 AND (age <= ? AND name LIKE ? OR emall IS NULL)  */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("age", 15)
                .like("name", "11")
                .or()
                .isNull("emall");
        User user = new User();
        user.setName("taobaowanjia");
        user.setEmall("baidu.com");
        user.setAge(25);
        int update = userMapper.update(user, queryWrapper);
        System.out.println("update:" + update);
    }

    @Test
    public void test04() {
//      用户中包含a并且（年龄大于20或邮箱为空）的用户信息,括号中条件先执行，用lab表达式and方法，gt大于
        /*  UPDATE t_user SET name=?, emall=? WHERE isdelete=0 AND (name LIKE ? AND (age > ? OR emall IS NULL))*/
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "t")
                .and(i -> i.gt("age", 20).or().isNull("emall"));
        User user = new User();
        user.setName("haungrong");
        user.setEmall("12306haungrong.com");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    @Test
    public void test05() {
//          查询出name.age.emall信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age", "emall");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test06() {
        /*查询出id小于等于10的用户详细*/
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.inSql("id", "SELECT id FROM t_user WHERE id<=10");
        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void test07() {
        /*   用户中包含a并且（年龄大于20或邮箱为空）的用户信息,括号中条件先执行，用lab表达式and方法，gt大于       */
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name", "郭靖")
                .and(i -> i.gt("age", 20).or().isNull("emall"));
        updateWrapper.set("name", "sunwukong").set("emall", "jiaoyuwnag$163.com").set("age", 13);
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);

    }

    @Test
    public void test08() {
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 15;
        QueryWrapper queryWrapper = new QueryWrapper();
        if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank("username")) {

            queryWrapper.like("name", "username");
        }
        if (ageBegin != null) {
            queryWrapper.ge("age", ageBegin);

        }

        if (ageEnd != null) {
            queryWrapper.ge("age", ageEnd);

        }

        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void test09() {
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 15;
        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.like(com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank("username"), "name", "username")
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void test10() {
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 15;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank("username"), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void test11() {
        /*   用户中包含a并且（年龄大于20或邮箱为空）的用户信息,括号中条件先执行，用lab表达式and方法，gt大于       */
       LambdaUpdateWrapper<User> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.like(User::getName, "lisi")
                .and(i -> i.gt(User::getAge, 15).or().isNull(User::getEmall));
        queryWrapper.set(User::getName, "李四").set(User::getEmall, "李四$163.com").set(User::getAge, 25);
        int update = userMapper.update(null, queryWrapper);
        System.out.println(update);


    }

}