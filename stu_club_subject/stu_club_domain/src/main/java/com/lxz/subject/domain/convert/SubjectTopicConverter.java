package com.lxz.subject.domain.convert;

import com.lxz.subject.domain.entity.SubjectAnswerBO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;
import com.lxz.subject.infra.basic.entity.SubjectBrief;
import com.lxz.subject.infra.basic.entity.SubjectJudge;
import com.lxz.subject.infra.basic.entity.SubjectMultiple;
import com.lxz.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签dto的转换
 */
@Mapper
public interface SubjectTopicConverter {
        SubjectTopicConverter INSANCE = Mappers.getMapper(SubjectTopicConverter.class);

        // todo bo转info
        SubjectRadio convertBoTORadio(SubjectAnswerBO subjectAnswerBO);

        SubjectMultiple convertBoToMultiple(SubjectAnswerBO subjectAnswerBO);

        SubjectBrief convertBoToBrief(SubjectInfoBO subjectInfoBO);

        SubjectJudge convertBoToJudge(SubjectAnswerBO subjectAnswerBO);

        List<SubjectAnswerBO> convertBoToJudgeList(List<SubjectJudge>  subjectJudge);

        List<SubjectAnswerBO> convertBoToMultipleList(List<SubjectMultiple>  subjectMultiple);

        List<SubjectAnswerBO> convertBoToRadioList(List<SubjectRadio>  subjectRadio);
}
