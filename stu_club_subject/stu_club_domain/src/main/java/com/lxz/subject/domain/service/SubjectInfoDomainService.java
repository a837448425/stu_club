package com.lxz.subject.domain.service;

import com.lxz.subject.common.entity.PageResult;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * 题目题目领域服务
 */
public interface SubjectInfoDomainService {

    /**
     * 新增题目
     *
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询
     * @param subjectInfoBO
     * @return
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目详情
     * @param subjectInfoBO
     * @return
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
