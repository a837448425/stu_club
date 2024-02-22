package com.lxz.subject.application.dto;

import com.lxz.subject.common.entity.PageInfo;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目dto
 *
 * @author makejava
 * @since 2024-01-09 12:32:11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectInfoDTO extends PageInfo implements Serializable {
    private static final long serialVersionUID = 916514091742262211L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     *  题目答案
     */
    private String subjectAnswer;
    /**
     * 分类id
     */
    private List<Integer> categoryIds;
    /**
     *  标签id
     */
    private List<Integer> labelIds;
    /**
     *   标签name
     */
    private List<String> labelName;
    /**
     *   答案选项
     */
    private List<SubjectAnswerDTO> optionList;
    /**
     *  删除标志 0未删除 1已删除
     */
    private Integer isDeleted;
    /**
     * 分类id
     */
    private Integer categoryId;
    /**
     *  标签id
     */
    private Long labelId;
}

