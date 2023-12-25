package com.lxz.subject.application.convert;

import com.lxz.subject.application.dto.SubjectCategoryDTO;
import com.lxz.subject.domain.entity.SubjectCategoryBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-25T06:15:45+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class SubjectCategoryDTOConverterImpl implements SubjectCategoryDTOConverter {

    @Override
    public SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategoryDTO) {
        if ( subjectCategoryDTO == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategoryDTO.getId() );
        subjectCategoryBO.setCategoryName( subjectCategoryDTO.getCategoryName() );
        subjectCategoryBO.setCategoryType( subjectCategoryDTO.getCategoryType() );
        subjectCategoryBO.setImageUrl( subjectCategoryDTO.getImageUrl() );
        subjectCategoryBO.setParentId( subjectCategoryDTO.getParentId() );
        subjectCategoryBO.setCreatedBy( subjectCategoryDTO.getCreatedBy() );
        subjectCategoryBO.setCreatedTime( subjectCategoryDTO.getCreatedTime() );
        subjectCategoryBO.setUpdateBy( subjectCategoryDTO.getUpdateBy() );
        subjectCategoryBO.setUpdateTime( subjectCategoryDTO.getUpdateTime() );
        subjectCategoryBO.setIsDeleted( subjectCategoryDTO.getIsDeleted() );

        return subjectCategoryBO;
    }

    @Override
    public List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryBOList) {
        if ( subjectCategoryBOList == null ) {
            return null;
        }

        List<SubjectCategoryDTO> list = new ArrayList<SubjectCategoryDTO>( subjectCategoryBOList.size() );
        for ( SubjectCategoryBO subjectCategoryBO : subjectCategoryBOList ) {
            list.add( subjectCategoryBOToSubjectCategoryDTO( subjectCategoryBO ) );
        }

        return list;
    }

    @Override
    public SubjectCategoryBO convertDtoCategoryBo(SubjectCategoryDTO subjectCategoryDTO) {
        if ( subjectCategoryDTO == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategoryDTO.getId() );
        subjectCategoryBO.setCategoryName( subjectCategoryDTO.getCategoryName() );
        subjectCategoryBO.setCategoryType( subjectCategoryDTO.getCategoryType() );
        subjectCategoryBO.setImageUrl( subjectCategoryDTO.getImageUrl() );
        subjectCategoryBO.setParentId( subjectCategoryDTO.getParentId() );
        subjectCategoryBO.setCreatedBy( subjectCategoryDTO.getCreatedBy() );
        subjectCategoryBO.setCreatedTime( subjectCategoryDTO.getCreatedTime() );
        subjectCategoryBO.setUpdateBy( subjectCategoryDTO.getUpdateBy() );
        subjectCategoryBO.setUpdateTime( subjectCategoryDTO.getUpdateTime() );
        subjectCategoryBO.setIsDeleted( subjectCategoryDTO.getIsDeleted() );

        return subjectCategoryBO;
    }

    protected SubjectCategoryDTO subjectCategoryBOToSubjectCategoryDTO(SubjectCategoryBO subjectCategoryBO) {
        if ( subjectCategoryBO == null ) {
            return null;
        }

        SubjectCategoryDTO subjectCategoryDTO = new SubjectCategoryDTO();

        subjectCategoryDTO.setId( subjectCategoryBO.getId() );
        subjectCategoryDTO.setCategoryName( subjectCategoryBO.getCategoryName() );
        subjectCategoryDTO.setCategoryType( subjectCategoryBO.getCategoryType() );
        subjectCategoryDTO.setImageUrl( subjectCategoryBO.getImageUrl() );
        subjectCategoryDTO.setParentId( subjectCategoryBO.getParentId() );
        subjectCategoryDTO.setCreatedBy( subjectCategoryBO.getCreatedBy() );
        subjectCategoryDTO.setCreatedTime( subjectCategoryBO.getCreatedTime() );
        subjectCategoryDTO.setUpdateBy( subjectCategoryBO.getUpdateBy() );
        subjectCategoryDTO.setUpdateTime( subjectCategoryBO.getUpdateTime() );
        subjectCategoryDTO.setIsDeleted( subjectCategoryBO.getIsDeleted() );

        return subjectCategoryDTO;
    }
}
