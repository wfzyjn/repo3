package com.itheima.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName("t_prise")
public class Product {
  @TableId
  private    Long     id;

  private   String    name;

  private   Integer  prise;
  @Version
  private   Integer  version;
}
