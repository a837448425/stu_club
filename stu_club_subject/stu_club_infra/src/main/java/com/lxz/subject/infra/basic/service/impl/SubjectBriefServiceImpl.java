package com.lxz.subject.infra.basic.service.impl;

import com.lxz.subject.infra.basic.entity.SubjectBrief;
import com.lxz.subject.infra.basic.mapper.SubjectBriefDao;
import com.lxz.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 简答题(SubjectBrief)表服务实现类
 *
 * @author makejava
 * @since 2024-01-09 12:32:57
 */
@Service("subjectBriefService")
public class SubjectBriefServiceImpl implements SubjectBriefService {
    @Resource
    private SubjectBriefDao subjectBriefDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectBrief queryById(Long id) {
        return this.subjectBriefDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectBrief 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */




    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief insert(SubjectBrief subjectBrief) {
        this.subjectBriefDao.insert(subjectBrief);
        return subjectBrief;
    }

    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief update(SubjectBrief subjectBrief) {
        this.subjectBriefDao.update(subjectBrief);
        return this.queryById(subjectBrief.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectBriefDao.deleteById(id) > 0;
    }

    /**
     * 条件查询
     * @param subjectBrief
     * @return
     */
    @Override
    public SubjectBrief queryByCondition(SubjectBrief subjectBrief) {
        return this.subjectBriefDao.queryAllByLimit(subjectBrief);
    }
}
