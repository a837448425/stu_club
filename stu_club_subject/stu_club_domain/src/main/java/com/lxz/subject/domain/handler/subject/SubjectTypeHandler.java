package com.lxz.subject.domain.handler.subject;

import com.lxz.subject.common.enums.SubjectInfoTypeEnum;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;

import java.util.List;

public interface SubjectTypeHandler {
    /**
     * 枚举身份的识别
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     *实际题目的插入
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     *  实际的题目查询
     */
    SubjectOPtionBO query(int subjectId);
}
