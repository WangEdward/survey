package com.example.survey.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Document
@Builder
@AllArgsConstructor
public class MCQ implements Serializable {

    private static final long serialVersionUID = 2763083176353200618L;
    @Id private String id;

    private String questionDetail;
    private SingleOption[] options;

//    @CreatedDate
//    private Timestamp createdAt;
//    @CreatedBy
//    private String createdBy;
//    @LastModifiedDate
//    private Timestamp updatedAt;
//    @LastModifiedBy
//    private String updatedBy;

//    public String getQuestionDetail() {
//        return questionDetail;
//    }
//
//    public void setQuestionDetail(String questionDetail) {
//        this.questionDetail = questionDetail;
//    }
//
//    public SingleOption[] getOptions() {
//        return options;
//    }
//
//    public void setOptions(SingleOption[] options) {
//        this.options = options;
//    }
}

