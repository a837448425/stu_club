package com.lxz.subject.domain.convert;

import com.lxz.subject.domain.entity.SubjectAnswerBO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.infra.basic.entity.SubjectBrief;
import com.lxz.subject.infra.basic.entity.SubjectJudge;
import com.lxz.subject.infra.basic.entity.SubjectMultiple;
import com.lxz.subject.infra.basic.entity.SubjectRadio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-15T16:52:08+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class SubjectTopicConverterImpl implements SubjectTopicConverter {

    @Override
    public SubjectRadio convertBoTORadio(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectRadio subjectRadio = new SubjectRadio();

        subjectRadio.setOptionType( subjectAnswerBO.getOptionType() );
        subjectRadio.setOptionContent( subjectAnswerBO.getOptionContent() );
        subjectRadio.setIsCorrect( subjectAnswerBO.getIsCorrect() );

        return subjectRadio;
    }

    @Override
    public SubjectMultiple convertBoToMultiple(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectMultiple subjectMultiple = new SubjectMultiple();

        if ( subjectAnswerBO.getOptionType() != null ) {
            subjectMultiple.setOptionType( subjectAnswerBO.getOptionType().longValue() );
        }
        subjectMultiple.setOptionContent( subjectAnswerBO.getOptionContent() );
        subjectMultiple.setIsCorrect( subjectAnswerBO.getIsCorrect() );

        return subjectMultiple;
    }

    @Override
    public SubjectBrief convertBoToBrief(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectBrief subjectBrief = new SubjectBrief();

        subjectBrief.setId( subjectInfoBO.getId() );
        subjectBrief.setSubjectAnswer( subjectInfoBO.getSubjectAnswer() );
        subjectBrief.setIsDeleted( subjectInfoBO.getIsDeleted() );

        return subjectBrief;
    }

    @Override
    public SubjectJudge convertBoToJudge(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectJudge subjectJudge = new SubjectJudge();

        subjectJudge.setIsCorrect( subjectAnswerBO.getIsCorrect() );

        return subjectJudge;
    }

    @Override
    public List<SubjectAnswerBO> convertBoToJudgeList(List<SubjectJudge> subjectJudge) {
        if ( subjectJudge == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( subjectJudge.size() );
        for ( SubjectJudge subjectJudge1 : subjectJudge ) {
            list.add( subjectJudgeToSubjectAnswerBO( subjectJudge1 ) );
        }

        return list;
    }

    @Override
    public List<SubjectAnswerBO> convertBoToMultipleList(List<SubjectMultiple> subjectMultiple) {
        if ( subjectMultiple == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( subjectMultiple.size() );
        for ( SubjectMultiple subjectMultiple1 : subjectMultiple ) {
            list.add( subjectMultipleToSubjectAnswerBO( subjectMultiple1 ) );
        }

        return list;
    }

    @Override
    public List<SubjectAnswerBO> convertBoToRadioList(List<SubjectRadio> subjectRadio) {
        if ( subjectRadio == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( subjectRadio.size() );
        for ( SubjectRadio subjectRadio1 : subjectRadio ) {
            list.add( subjectRadioToSubjectAnswerBO( subjectRadio1 ) );
        }

        return list;
    }

    protected SubjectAnswerBO subjectJudgeToSubjectAnswerBO(SubjectJudge subjectJudge) {
        if ( subjectJudge == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        subjectAnswerBO.setIsCorrect( subjectJudge.getIsCorrect() );

        return subjectAnswerBO;
    }

    protected SubjectAnswerBO subjectMultipleToSubjectAnswerBO(SubjectMultiple subjectMultiple) {
        if ( subjectMultiple == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        if ( subjectMultiple.getOptionType() != null ) {
            subjectAnswerBO.setOptionType( subjectMultiple.getOptionType().intValue() );
        }
        subjectAnswerBO.setOptionContent( subjectMultiple.getOptionContent() );
        subjectAnswerBO.setIsCorrect( subjectMultiple.getIsCorrect() );

        return subjectAnswerBO;
    }

    protected SubjectAnswerBO subjectRadioToSubjectAnswerBO(SubjectRadio subjectRadio) {
        if ( subjectRadio == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        subjectAnswerBO.setOptionType( subjectRadio.getOptionType() );
        subjectAnswerBO.setOptionContent( subjectRadio.getOptionContent() );
        subjectAnswerBO.setIsCorrect( subjectRadio.getIsCorrect() );

        return subjectAnswerBO;
    }
}
