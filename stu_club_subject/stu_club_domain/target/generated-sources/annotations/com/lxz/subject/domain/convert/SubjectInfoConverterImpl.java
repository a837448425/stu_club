package com.lxz.subject.domain.convert;

import com.lxz.subject.domain.entity.SubjectAnswerBO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;
import com.lxz.subject.infra.basic.entity.SubjectInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T13:22:44+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class SubjectInfoConverterImpl implements SubjectInfoConverter {

    @Override
    public SubjectInfo convertBoTOInfo(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectInfo subjectInfo = new SubjectInfo();

        subjectInfo.setId( subjectInfoBO.getId() );
        subjectInfo.setSubjectName( subjectInfoBO.getSubjectName() );
        subjectInfo.setSubjectDifficult( subjectInfoBO.getSubjectDifficult() );
        subjectInfo.setSettleName( subjectInfoBO.getSettleName() );
        subjectInfo.setSubjectType( subjectInfoBO.getSubjectType() );
        subjectInfo.setSubjectScore( subjectInfoBO.getSubjectScore() );
        subjectInfo.setSubjectParse( subjectInfoBO.getSubjectParse() );
        subjectInfo.setIsDeleted( subjectInfoBO.getIsDeleted() );

        return subjectInfo;
    }

    @Override
    public SubjectInfoBO convertOptionTOBo(SubjectOPtionBO subjectOPtionBO) {
        if ( subjectOPtionBO == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        subjectInfoBO.setSubjectAnswer( subjectOPtionBO.getSubjectAnswer() );
        List<SubjectAnswerBO> list = subjectOPtionBO.getOptionList();
        if ( list != null ) {
            subjectInfoBO.setOptionList( new ArrayList<SubjectAnswerBO>( list ) );
        }

        return subjectInfoBO;
    }

    @Override
    public SubjectInfoBO convertOptionAndInfoBO(SubjectOPtionBO subjectOPtionBO, SubjectInfo subjectInfo) {
        if ( subjectOPtionBO == null && subjectInfo == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        if ( subjectOPtionBO != null ) {
            subjectInfoBO.setSubjectAnswer( subjectOPtionBO.getSubjectAnswer() );
            List<SubjectAnswerBO> list = subjectOPtionBO.getOptionList();
            if ( list != null ) {
                subjectInfoBO.setOptionList( new ArrayList<SubjectAnswerBO>( list ) );
            }
        }
        if ( subjectInfo != null ) {
            subjectInfoBO.setId( subjectInfo.getId() );
            subjectInfoBO.setSubjectName( subjectInfo.getSubjectName() );
            subjectInfoBO.setSubjectDifficult( subjectInfo.getSubjectDifficult() );
            subjectInfoBO.setSettleName( subjectInfo.getSettleName() );
            subjectInfoBO.setSubjectType( subjectInfo.getSubjectType() );
            subjectInfoBO.setSubjectScore( subjectInfo.getSubjectScore() );
            subjectInfoBO.setSubjectParse( subjectInfo.getSubjectParse() );
            subjectInfoBO.setIsDeleted( subjectInfo.getIsDeleted() );
        }

        return subjectInfoBO;
    }

    @Override
    public List<SubjectInfoBO> convertListInfoToBOList(List<SubjectInfo> subjectInfoList) {
        if ( subjectInfoList == null ) {
            return null;
        }

        List<SubjectInfoBO> list = new ArrayList<SubjectInfoBO>( subjectInfoList.size() );
        for ( SubjectInfo subjectInfo : subjectInfoList ) {
            list.add( subjectInfoToSubjectInfoBO( subjectInfo ) );
        }

        return list;
    }

    protected SubjectInfoBO subjectInfoToSubjectInfoBO(SubjectInfo subjectInfo) {
        if ( subjectInfo == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        subjectInfoBO.setId( subjectInfo.getId() );
        subjectInfoBO.setSubjectName( subjectInfo.getSubjectName() );
        subjectInfoBO.setSubjectDifficult( subjectInfo.getSubjectDifficult() );
        subjectInfoBO.setSettleName( subjectInfo.getSettleName() );
        subjectInfoBO.setSubjectType( subjectInfo.getSubjectType() );
        subjectInfoBO.setSubjectScore( subjectInfo.getSubjectScore() );
        subjectInfoBO.setSubjectParse( subjectInfo.getSubjectParse() );
        subjectInfoBO.setIsDeleted( subjectInfo.getIsDeleted() );

        return subjectInfoBO;
    }
}
