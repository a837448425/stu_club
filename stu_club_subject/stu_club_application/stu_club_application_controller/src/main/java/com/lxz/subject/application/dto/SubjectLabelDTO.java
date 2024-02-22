package com.lxz.subject.application.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目标签表(SubjectLabelDTO)实体类
 * 题目标签DTO
 *
 * @author makejava
 * @since 2023-12-26 18:47:36
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = 142943782760444919L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer isDeleted;


}

