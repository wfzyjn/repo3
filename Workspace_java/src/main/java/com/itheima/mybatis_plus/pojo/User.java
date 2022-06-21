package com.itheima.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName("t_user")
public class User  implements Serializable {
    @TableId
    private   Long id;
    private   String  name;
    private   Integer  age;
    private   String   emall;
     @TableLogic
    private   Integer   isdelete;
}
