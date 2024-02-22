package com.lxz.subject.domain.entity;

import lombok.*;

import java.io.Serializable;

/**
 * 题目答案bo
 *
 * @author makejava
 * @since 2024-01-09 12:32:11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectAnswerBO implements Serializable {

    /**
     * 答案选项标识
     */
    private Integer optionType;
    /**
     * 答案
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;
}

