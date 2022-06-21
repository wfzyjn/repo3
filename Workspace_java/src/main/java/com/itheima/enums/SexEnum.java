package com.itheima.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {
    MALE(1,"男"),
    FMALE(2,"女");
    /*将注解该属性的值存取到数据库中*/
     @EnumValue
    private  Integer  sex;

    private  String   sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}

