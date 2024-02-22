package com.lxz.subject.application.convert;

import com.lxz.subject.application.dto.SubjectInfoDTO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 标签dto的转换
 */
@Mapper
public interface SubjectInfoDTOConverter {
        SubjectInfoDTOConverter INSANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

        // todo dto转bo
        SubjectInfoBO convertDtoToBo(SubjectInfoDTO subjectInfoDTO);

        // todo bo转dto
        SubjectInfoDTO convertBoToDto(SubjectInfoBO subjectInfoBO);
}
