package com.lxz.subject.infra.basic.service;

import com.lxz.subject.infra.basic.entity.SubjectCategory;

import java.util.List;


/**
 * 题目分类(SubjectCategory)表服务接口
 *
 * @author makejava
 * @since 2023-12-11 19:52:12
 */
public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    int update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<SubjectCategory> queryPrimaryCategory(SubjectCategory subjectCategory);

    /**
     * 查询岗位大类
     * @return
     */
    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);
}
