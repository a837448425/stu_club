package com.lxz.subject.domain.handler.subject.subjectImpl;

import com.google.common.base.Preconditions;
import com.lxz.subject.common.enums.IsDeletedFlagEnum;
import com.lxz.subject.common.enums.SubjectInfoTypeEnum;
import com.lxz.subject.domain.convert.SubjectTopicConverter;
import com.lxz.subject.domain.entity.SubjectAnswerBO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;
import com.lxz.subject.domain.handler.subject.SubjectTypeHandler;
import com.lxz.subject.infra.basic.entity.SubjectJudge;
import com.lxz.subject.infra.basic.entity.SubjectMultiple;
import com.lxz.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: luo
 * @date: 2024/1/9 23:41
 * @Description:
 * @Version: 1.0
 *
 * 多选题目的策略类
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler {
    @Autowired
    private SubjectMultipleService subjectMultipleService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return  SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 多选题目的插入
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();

        Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoBO.getOptionList()),
                "多选题目的选项不能为空");

        subjectInfoBO.getOptionList().forEach(option ->{
            SubjectMultiple subjectMultiple = SubjectTopicConverter
                    .INSANCE.convertBoToMultiple(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);
    }

    @Override
    public SubjectOPtionBO query(int subjectId) {
        // 查询判断题目的答案
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(Long.valueOf(subjectId));
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBOList =
                SubjectTopicConverter.INSANCE.convertBoToMultipleList(result);
        SubjectOPtionBO subjectOPtionBO = new SubjectOPtionBO();
        subjectOPtionBO.setOptionList(subjectAnswerBOList);
        return subjectOPtionBO;
    }
}
