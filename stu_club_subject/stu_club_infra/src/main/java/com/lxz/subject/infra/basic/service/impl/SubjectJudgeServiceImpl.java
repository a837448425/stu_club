package com.lxz.subject.infra.basic.service.impl;

import com.lxz.subject.infra.basic.entity.SubjectJudge;
import com.lxz.subject.infra.basic.mapper.SubjectJudgeDao;
import com.lxz.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * 判断题(SubjectJudge)表服务实现类
 *
 * @author makejava
 * @since 2024-01-09 12:34:16
 */
@Service("subjectJudgeService")
public class SubjectJudgeServiceImpl implements SubjectJudgeService {
    @Resource
    private SubjectJudgeDao subjectJudgeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectJudge queryById(Long id) {
        return this.subjectJudgeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectJudge 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectJudge insert(SubjectJudge subjectJudge) {
        this.subjectJudgeDao.insert(subjectJudge);
        return subjectJudge;
    }

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectJudge update(SubjectJudge subjectJudge) {
        this.subjectJudgeDao.update(subjectJudge);
        return this.queryById(subjectJudge.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectJudgeDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectJudge> queryByCondition(SubjectJudge subjectJudge) {

        return this.subjectJudgeDao.queryAllByLimit(subjectJudge);
    }
}
