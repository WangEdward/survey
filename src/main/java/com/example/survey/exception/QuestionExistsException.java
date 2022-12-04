package com.example.survey.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class QuestionExistsException extends RuntimeException{

    public QuestionExistsException(String message){
        super(message);
    }
}
