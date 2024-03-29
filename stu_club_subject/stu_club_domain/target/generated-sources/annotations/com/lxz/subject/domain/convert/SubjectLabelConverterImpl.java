package com.lxz.subject.domain.convert;

import com.lxz.subject.domain.entity.SubjectLabelBO;
import com.lxz.subject.infra.basic.entity.SubjectLabel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-02T13:04:45+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class SubjectLabelConverterImpl implements SubjectLabelConverter {

    @Override
    public SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO) {
        if ( subjectLabelBO == null ) {
            return null;
        }

        SubjectLabel subjectLabel = new SubjectLabel();

        subjectLabel.setId( subjectLabelBO.getId() );
        subjectLabel.setLabelName( subjectLabelBO.getLabelName() );
        subjectLabel.setSortNum( subjectLabelBO.getSortNum() );
        subjectLabel.setCategoryId( subjectLabelBO.getCategoryId() );
        subjectLabel.setCreatedBy( subjectLabelBO.getCreatedBy() );
        subjectLabel.setCreatedTime( subjectLabelBO.getCreatedTime() );
        subjectLabel.setUpdateBy( subjectLabelBO.getUpdateBy() );
        subjectLabel.setUpdateTime( subjectLabelBO.getUpdateTime() );
        subjectLabel.setIsDeleted( subjectLabelBO.getIsDeleted() );

        return subjectLabel;
    }
}
