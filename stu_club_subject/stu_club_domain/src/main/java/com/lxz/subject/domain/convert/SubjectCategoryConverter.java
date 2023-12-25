package com.lxz.subject.domain.convert;

import com.lxz.subject.domain.entity.SubjectCategoryBO;
import com.lxz.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {
        SubjectCategoryConverter INSANCE = Mappers.getMapper(SubjectCategoryConverter.class);

        SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);

        List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> categoryList);

}
