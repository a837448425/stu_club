package com.lxz.subject.domain.service;

import com.lxz.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> queryPrimaryCategory();

    /**
     * 查询岗位大类
     * @param subjectCategoryBO
     * @return
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @param subjectCategoryBO
     * @return
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 删除分类
     * @param subjectCategoryBO
     * @return
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
