package com.feign.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户信息
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 最后登录时间
     */
    private Timestamp lastTime;

    /**
     * 状态 0: 启用 1: 禁用
     */
    private Integer status;

    /**
     * 使用空间
     */
    private Long useSpace;

    /**
     * 总空间
     */
    private Long totalSpace;

    private static final long serialVersionUID = 1L;
}