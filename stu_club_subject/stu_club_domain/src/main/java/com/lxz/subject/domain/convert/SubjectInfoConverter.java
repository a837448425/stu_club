package com.lxz.subject.domain.convert;

import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;
import com.lxz.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签dto的转换
 */
@Mapper
public interface SubjectInfoConverter {
        SubjectInfoConverter INSANCE = Mappers.getMapper(SubjectInfoConverter.class);

        // todo bo转info
        SubjectInfo convertBoTOInfo(SubjectInfoBO subjectInfoBO);

        //
        SubjectInfoBO convertOptionTOBo(SubjectOPtionBO subjectOPtionBO);

        //
        SubjectInfoBO convertOptionAndInfoBO(SubjectOPtionBO subjectOPtionBO,SubjectInfo subjectInfo);

        // todo infoList转boList
        List<SubjectInfoBO> convertListInfoToBOList(List<SubjectInfo> subjectInfoList);
}
