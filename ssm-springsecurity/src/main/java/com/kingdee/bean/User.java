package com.kingdee.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
/**
 * 生成全参构造
 */
@AllArgsConstructor
/**
 * 生成无参构造
 */
@NoArgsConstructor
/**
 * 开启链式编程，setter方法返回的是对象本身而不是void
 */
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 2684609809780170734L;

    private Integer id;
    private String name;
    private String password;
    private String remark;
}
