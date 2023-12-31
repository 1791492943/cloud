package com.feign.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @TableName share_link
 */
@TableName(value ="share_link")
@Data
public class ShareLink implements Serializable {
    /**
     * 链接id
     */
    @TableId
    private Long linkId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 链接
     */
    private String shareLink;

    /**
     * 访问次数
     */
    private Long visitNum;

    /**
     * 密码
     */
    private String code;

    /**
     * 分享时间
     */
    private Timestamp createTime;

    /**
     * 到期时间
     */
    private Timestamp expiryTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}