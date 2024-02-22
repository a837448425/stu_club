package com.lxz.subject.infra.basic.entity;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 简答题(SubjectBrief)实体类
 *
 * @author makejava
 * @since 2024-01-09 12:32:57
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectBrief implements Serializable {
    private static final long serialVersionUID = -72628253728540285L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Integer subjectId;
    /**
     * 题目答案
     */
    private String subjectAnswer;
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
    /**
     *  是否删除（0：未删除，1：已删除）
     */
    private Integer isDeleted;

}

