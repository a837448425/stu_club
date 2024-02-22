package com.lxz.subject.domain.handler.subject.subjectImpl;

import com.lxz.subject.common.enums.IsDeletedFlagEnum;
import com.lxz.subject.common.enums.SubjectInfoTypeEnum;
import com.lxz.subject.domain.convert.SubjectTopicConverter;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;
import com.lxz.subject.domain.handler.subject.SubjectTypeHandler;
import com.lxz.subject.infra.basic.entity.SubjectBrief;
import com.lxz.subject.infra.basic.service.SubjectBriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: luo
 * @date: 2024/1/9 23:46
 * @Description:
 * @Version: 1.0
 *
 * 简答题目的策略类
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler {

    @Autowired
    private SubjectBriefService subjectBriefService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return  SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 简答题目的插入
        SubjectBrief subjectBrief = SubjectTopicConverter
                .INSANCE.convertBoToBrief(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId().intValue());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOPtionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);

        SubjectBrief resultBrief = subjectBriefService.queryByCondition(subjectBrief);

        SubjectOPtionBO subjectOPtionBO = new SubjectOPtionBO();
        subjectOPtionBO.setSubjectAnswer(resultBrief.getSubjectAnswer());
        return subjectOPtionBO;
    }
}
