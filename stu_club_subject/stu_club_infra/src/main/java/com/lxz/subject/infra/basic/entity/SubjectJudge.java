package com.lxz.subject.infra.basic.entity;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 判断题(SubjectJudge)实体类
 *
 * @author makejava
 * @since 2024-01-09 12:34:16
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectJudge implements Serializable {
    private static final long serialVersionUID = 566633580866752060L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * 是否正确
     */
    private Integer isCorrect;
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
     *  是否删除
     */
    private Integer isDeleted;
}

