package com.lxz.subject.application.convert;

import com.lxz.subject.application.dto.SubjectLabelDTO;
import com.lxz.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签dto的转换
 */
@Mapper
public interface SubjectLabelDTOConverter {
        SubjectLabelDTOConverter INSANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

        // todo dto转bo
        SubjectLabelBO convertDtoLabelBO(SubjectLabelDTO subjectCategoryDTO);

        // todo dto转List<bo>
        List<SubjectLabelDTO> convertDtoLabelBOList(List<SubjectLabelBO> boList);

}
