package com.lxz.subject.domain.convert;

import com.lxz.subject.domain.entity.SubjectLabelBO;
import com.lxz.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * 标签bo的转换
 */
@Mapper
public interface SubjectLabelConverter {
        SubjectLabelConverter INSANCE = Mappers.getMapper(SubjectLabelConverter.class);

        // todo bo转换subjectLabel
        SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);

}
