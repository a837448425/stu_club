package com.lxz.subject.domain.handler.subject.subjectImpl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.lxz.subject.common.enums.IsDeletedFlagEnum;
import com.lxz.subject.common.enums.SubjectInfoTypeEnum;
import com.lxz.subject.domain.convert.SubjectTopicConverter;
import com.lxz.subject.domain.entity.SubjectAnswerBO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;
import com.lxz.subject.domain.handler.subject.SubjectTypeHandler;
import com.lxz.subject.infra.basic.entity.SubjectMultiple;
import com.lxz.subject.infra.basic.entity.SubjectRadio;
import com.lxz.subject.infra.basic.service.SubjectRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: luo
 * @date: 2024/1/9 23:39
 * @Description:
 * @Version: 1.0
 *
 * 单选题目的策略类
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Autowired
    private SubjectRadioService subjectRadioService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //单选题目的插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();

        Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoBO.getOptionList()),
                "单选题目的选项不能为空");
        subjectInfoBO.getOptionList().forEach(option ->{
            SubjectRadio subjectRadio = SubjectTopicConverter
                    .INSANCE.convertBoTORadio(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }

    @Override
    public SubjectOPtionBO query(int subjectId) {
        // 查询判断题目的答案
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(Long.valueOf(subjectId));
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList =
                SubjectTopicConverter.INSANCE.convertBoToRadioList(result);
        SubjectOPtionBO subjectOPtionBO = new SubjectOPtionBO();
        subjectOPtionBO.setOptionList(subjectAnswerBOList);
        return subjectOPtionBO;
    }
}
