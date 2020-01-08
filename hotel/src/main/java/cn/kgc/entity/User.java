package cn.kgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * user
 * @author 
 */
public class User{
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 身份证号
     */
    private String cardNumber;

    /**
     * 会员等级(1.普通（0，1000   0），2.黄金（1000，2500，0.95） 3.铂金（2500，6000  0.9），4.钻石（6000以上， 8.5)
     */
    private Integer level;

    /**
     * 积分
     */
    private Integer integral;

    /**
     * 权限1.超级管理员 2.酒店商家 3.普通用户
     */
    private Integer jurisdiction;

    /**
     * 状态 1.正常 2.冻结 3.审核未通过 4.待审核
     */
    private Integer status;

}