package com.lxz.subject.infra.basic.entity;

import lombok.*;

import java.util.Date;
import java.io.Serializable;

/**
 * 单选题信息表(SubjectRadio)实体类
 *
 * @author makejava
 * @since 2024-01-09 12:33:38
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectRadio implements Serializable {
    private static final long serialVersionUID = 829828629159287973L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * a,b,c,d
     */
    private Integer optionType;
    /**
     * 选项内容
     */
    private String optionContent;
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
     * 修改人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     *  是否删除
     */
    private Integer isDeleted;
}

