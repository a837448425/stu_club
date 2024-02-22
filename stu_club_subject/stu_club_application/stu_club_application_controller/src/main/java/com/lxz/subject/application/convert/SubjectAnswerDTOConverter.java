package com.lxz.subject.application.convert;

import com.lxz.subject.application.dto.SubjectAnswerDTO;
import com.lxz.subject.application.dto.SubjectInfoDTO;
import com.lxz.subject.domain.entity.SubjectAnswerBO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签dto的转换
 */
@Mapper
public interface SubjectAnswerDTOConverter {
        SubjectAnswerDTOConverter INSANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);

        // todo dto转bo
        SubjectAnswerBO convertDtoToBo(SubjectAnswerDTO subjectAnswerDTO);

        List<SubjectAnswerBO> convertListDtoToBo(List<SubjectAnswerDTO> doList);
}
