package com.example.survey.mapper;

import com.example.survey.model.MCQ;
import com.example.survey.requests.MCQPostRequestBody;
import com.example.survey.requests.MCQPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MCQMapper {
    public static final MCQMapper INSTANCE = Mappers.getMapper(MCQMapper.class);
    public abstract MCQ toMcq(MCQPostRequestBody mcqPostRequestBody);
    public abstract MCQ toMcq(MCQPutRequestBody mcqPutRequestBody);

}
