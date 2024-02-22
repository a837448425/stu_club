package com.lxz.subject.application.convert;

import com.lxz.subject.application.dto.SubjectLabelDTO;
import com.lxz.subject.domain.entity.SubjectLabelBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-02T13:04:47+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class SubjectLabelDTOConverterImpl implements SubjectLabelDTOConverter {

    @Override
    public SubjectLabelBO convertDtoLabelBO(SubjectLabelDTO subjectCategoryDTO) {
        if ( subjectCategoryDTO == null ) {
            return null;
        }

        SubjectLabelBO subjectLabelBO = new SubjectLabelBO();

        subjectLabelBO.setId( subjectCategoryDTO.getId() );
        subjectLabelBO.setLabelName( subjectCategoryDTO.getLabelName() );
        subjectLabelBO.setSortNum( subjectCategoryDTO.getSortNum() );
        subjectLabelBO.setCategoryId( subjectCategoryDTO.getCategoryId() );
        subjectLabelBO.setCreatedBy( subjectCategoryDTO.getCreatedBy() );
        subjectLabelBO.setCreatedTime( subjectCategoryDTO.getCreatedTime() );
        subjectLabelBO.setUpdateBy( subjectCategoryDTO.getUpdateBy() );
        subjectLabelBO.setUpdateTime( subjectCategoryDTO.getUpdateTime() );
        subjectLabelBO.setIsDeleted( subjectCategoryDTO.getIsDeleted() );

        return subjectLabelBO;
    }

    @Override
    public List<SubjectLabelDTO> convertDtoLabelBOList(List<SubjectLabelBO> boList) {
        if ( boList == null ) {
            return null;
        }

        List<SubjectLabelDTO> list = new ArrayList<SubjectLabelDTO>( boList.size() );
        for ( SubjectLabelBO subjectLabelBO : boList ) {
            list.add( subjectLabelBOToSubjectLabelDTO( subjectLabelBO ) );
        }

        return list;
    }

    protected SubjectLabelDTO subjectLabelBOToSubjectLabelDTO(SubjectLabelBO subjectLabelBO) {
        if ( subjectLabelBO == null ) {
            return null;
        }

        SubjectLabelDTO subjectLabelDTO = new SubjectLabelDTO();

        subjectLabelDTO.setId( subjectLabelBO.getId() );
        subjectLabelDTO.setLabelName( subjectLabelBO.getLabelName() );
        subjectLabelDTO.setSortNum( subjectLabelBO.getSortNum() );
        subjectLabelDTO.setCategoryId( subjectLabelBO.getCategoryId() );
        subjectLabelDTO.setCreatedBy( subjectLabelBO.getCreatedBy() );
        subjectLabelDTO.setCreatedTime( subjectLabelBO.getCreatedTime() );
        subjectLabelDTO.setUpdateBy( subjectLabelBO.getUpdateBy() );
        subjectLabelDTO.setUpdateTime( subjectLabelBO.getUpdateTime() );
        subjectLabelDTO.setIsDeleted( subjectLabelBO.getIsDeleted() );

        return subjectLabelDTO;
    }
}
