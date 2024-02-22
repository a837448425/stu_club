package com.lxz.subject.domain.handler.subject.subjectImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxz.subject.common.enums.IsDeletedFlagEnum;
import com.lxz.subject.common.enums.SubjectInfoTypeEnum;
import com.lxz.subject.domain.convert.SubjectTopicConverter;
import com.lxz.subject.domain.entity.SubjectAnswerBO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;
import com.lxz.subject.domain.handler.subject.SubjectTypeHandler;
import com.lxz.subject.infra.basic.entity.SubjectJudge;
import com.lxz.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: luo
 * @date: 2024/1/9 23:45
 * @Description:
 * @Version: 1.0
 *
 * 判断题目的策略类
 */
@Component
public class JugdeTypeHandler implements SubjectTypeHandler {

    @Autowired
    private SubjectJudgeService subjectJudgeService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return  SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 判断题目的插入
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectJudgeService.insert(subjectJudge);

    }

    @Override
    public SubjectOPtionBO query(int subjectId) {
        // 查询判断题目的答案
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(Long.valueOf(subjectId));
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBOList =
                SubjectTopicConverter.INSANCE.convertBoToJudgeList(result);
        SubjectOPtionBO subjectOPtionBO = new SubjectOPtionBO();
        subjectOPtionBO.setOptionList(subjectAnswerBOList);
        return subjectOPtionBO;
    }
}
