package com.xugongwei.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 徐功伟
 * @date 2019-01-08 17:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Student implements Serializable {

    private Long id;

    private String name;

    private Integer sex;

    private Integer age;

    private  String address;
}
