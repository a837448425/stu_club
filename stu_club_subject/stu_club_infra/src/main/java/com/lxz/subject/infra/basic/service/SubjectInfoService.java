package com.lxz.subject.infra.basic.service;

import com.lxz.subject.infra.basic.entity.SubjectInfo;

import java.util.List;


/**
 * 题目信息表(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2024-01-09 12:32:11
 */
public interface SubjectInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Long id);



    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo insert(SubjectInfo subjectInfo);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo update(SubjectInfo subjectInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询题目数据
     * @param subjectInfo
     * @param categoryId
     * @param labelId
     * @return
     */
    int countByCondition(SubjectInfo subjectInfo, Integer categoryId, Integer labelId);

    /**
     * 分页查询
     * @param subjectInfo
     * @param categoryId
     * @param labelId
     * @param start
     * @param pageSize
     * @return
     */
    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Integer categoryId, Integer labelId, int start, Integer pageSize);
}
