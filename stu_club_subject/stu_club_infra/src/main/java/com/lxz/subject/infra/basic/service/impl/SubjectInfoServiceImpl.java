package com.lxz.subject.infra.basic.service.impl;

import com.lxz.subject.infra.basic.entity.SubjectInfo;
import com.lxz.subject.infra.basic.mapper.SubjectInfoDao;
import com.lxz.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-01-09 12:32:11
 */
@Service("subjectInfoService")
public class SubjectInfoServiceImpl implements SubjectInfoService {
    @Resource
    private SubjectInfoDao subjectInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectInfo queryById(Long id) {
        return this.subjectInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo insert(SubjectInfo subjectInfo) {
        this.subjectInfoDao.insert(subjectInfo);
        return subjectInfo;
    }

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo update(SubjectInfo subjectInfo) {
        this.subjectInfoDao.update(subjectInfo);
        return this.queryById(subjectInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectInfoDao.deleteById(id) > 0;
    }

    @Override
    public int countByCondition(SubjectInfo subjectInfo, Integer categoryId, Integer labelId) {
        return this.subjectInfoDao.countByCondition(subjectInfo, categoryId, labelId);
    }

    @Override
    public List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Integer categoryId, Integer labelId, int start, Integer pageSize) {
        return this.subjectInfoDao.queryPage(subjectInfo, categoryId, labelId, start, pageSize);
    }
}
