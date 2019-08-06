package com.bywin.download.controller;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * created by yeric on 2019/6/12
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyResultDTO {
    /**
     * 数据库密钥记录id
     */
    private Long id;
    /**
     * 接入方名称
     */
    private String customerName;
    /**
     * 1启用 0停用
     */
    private Integer state;
    /**
     * 联系人姓名
     */
    private String adminName;
    /**
     * 联系人手机号
     */
    private String adminMobile;
    /**
     * 密钥开始使用时间
     */
    private String startTime;
    /**
     * 密钥过期时间
     */
    private String endTime;
    private String createTime;
    private String modifyTime;
    private String approvalTime;
    /**
     * 审核状态
     */
    private String approvalStatus;
    private String appId;
    private String appKey;
    private Long appInfoId;
    /**
     * 备注
     */
    private String remark;


    private Integer isView;
    private Integer isDownload;
    /**
     * 技术负责人邮箱
     */
    private String adminEmail;
}
