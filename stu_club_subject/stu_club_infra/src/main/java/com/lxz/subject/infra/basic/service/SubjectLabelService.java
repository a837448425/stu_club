package com.lxz.subject.infra.basic.service;

import com.lxz.subject.infra.basic.entity.SubjectLabel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2023-12-26 18:47:36
 */
public interface SubjectLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLabel queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectLabel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    int insert(SubjectLabel subjectLabel);

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    int update(SubjectLabel subjectLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<SubjectLabel> batchQueryById(List<Long> labelIdList);
}
