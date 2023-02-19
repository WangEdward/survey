package com.example.survey.repository;


import  com.example.survey.model.MCQ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface MCQRepository extends MongoRepository<MCQ, String> {

    Optional<MCQ> findMCQById(String id);
    Optional<MCQ> findMCQByQuestionDetail(String QuestionDetail);

    void deleteById(String id);

    Iterable<MCQProjection> findAllBy();


}

