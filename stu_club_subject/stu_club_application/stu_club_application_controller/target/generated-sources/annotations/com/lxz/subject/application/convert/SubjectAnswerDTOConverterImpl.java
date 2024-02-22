package com.lxz.subject.application.convert;

import com.lxz.subject.application.dto.SubjectAnswerDTO;
import com.lxz.subject.domain.entity.SubjectAnswerBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T13:22:47+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class SubjectAnswerDTOConverterImpl implements SubjectAnswerDTOConverter {

    @Override
    public SubjectAnswerBO convertDtoToBo(SubjectAnswerDTO subjectAnswerDTO) {
        if ( subjectAnswerDTO == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        subjectAnswerBO.setOptionType( subjectAnswerDTO.getOptionType() );
        subjectAnswerBO.setOptionContent( subjectAnswerDTO.getOptionContent() );
        subjectAnswerBO.setIsCorrect( subjectAnswerDTO.getIsCorrect() );

        return subjectAnswerBO;
    }

    @Override
    public List<SubjectAnswerBO> convertListDtoToBo(List<SubjectAnswerDTO> doList) {
        if ( doList == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( doList.size() );
        for ( SubjectAnswerDTO subjectAnswerDTO : doList ) {
            list.add( convertDtoToBo( subjectAnswerDTO ) );
        }

        return list;
    }
}
