package com.lxz.subject.application.convert;

import com.lxz.subject.application.dto.SubjectCategoryDTO;
import com.lxz.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryDTOConverter {
        SubjectCategoryDTOConverter INSANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);


        SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategoryDTO);

        List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryBOList);

        SubjectCategoryBO convertDtoCategoryBo(SubjectCategoryDTO subjectCategoryDTO);
}
