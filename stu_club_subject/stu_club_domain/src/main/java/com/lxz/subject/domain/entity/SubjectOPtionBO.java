package com.lxz.subject.domain.entity;

import com.lxz.subject.common.entity.PageInfo;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 题目bo(SubjectInfoBO)实体类
 *
 * @author makejava
 * @since 2024-01-09 12:32:11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectOPtionBO implements Serializable {
    /**
     *  题目答案
     */
    private String subjectAnswer;
    /**
     *   答案选项
     */
    private List<SubjectAnswerBO> optionList;
}

