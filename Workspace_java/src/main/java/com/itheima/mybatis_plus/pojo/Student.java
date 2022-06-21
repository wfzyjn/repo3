package com.itheima.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itheima.enums.SexEnum;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_student")
public class Student implements Serializable {
    @TableId
    private   Long    id;
    private   String   name;
    private   SexEnum   sex;
    private   Integer  age;
    private   String   emall;
     @TableLogic
    private   Integer   isdelete;
}
