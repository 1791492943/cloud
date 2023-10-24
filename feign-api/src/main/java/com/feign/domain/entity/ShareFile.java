package com.feign.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @TableName share_file
 */
@TableName(value = "share_file")
@Data
@NoArgsConstructor
public class ShareFile implements Serializable {
    /**
     * 文件被分享的id
     */
    @TableId
    private Long shareId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 文件id
     */
    private Long fileId;

    /**
     * 父id
     */
    private Long filePid;

    /**
     * 链接id
     */
    private Long linkId;

    /**
     * minio名称
     */
    private String minioName;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 1: 视频
     * 2: 音频
     * 3: 图片
     * 4: 文档
     * 5: 其他
     */
    private Integer fileCategory;

    /**
     * 0: 目录
     * 1: 文件
     */
    private Integer folderType;

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

    public ShareFile(UserFile userFile) {
        BeanUtils.copyProperties(userFile,this);
    }
}