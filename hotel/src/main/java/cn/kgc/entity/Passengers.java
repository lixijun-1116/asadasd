package cn.kgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * passengers
 * @author 
 */
public class Passengers{
    /**
     * 常用旅客表id
     */
    private Integer id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 身份证号
     */
    private String IDNumber;

    /**
     * 用户id
     */
    private Integer uId;


}