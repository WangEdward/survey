package com.example.survey.controller;

import com.example.survey.model.MCQ;
import com.example.survey.repository.MCQRepository;
import com.example.survey.requests.MCQPostRequestBody;
import com.example.survey.requests.MCQPutRequestBody;
import com.example.survey.service.MCQService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/mcq")
@AllArgsConstructor
@Log4j2
public class MCQController {

    MCQService service;
    MCQRepository repository;


    @GetMapping("/allpagination")
    public ResponseEntity<Page<MCQ>> findAllPagination(@ParameterObject Pageable peageable){
        return ResponseEntity.ok(service.findAllPagination(peageable));
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<MCQ> findMCQById(@PathVariable String id) {
        return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping("/new")
    public ResponseEntity<MCQ> saveMCQ(@RequestBody @Valid MCQPostRequestBody mcqPostRequestBody) {
        return new ResponseEntity<>(service.save(mcqPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<Void> deleteMCQ(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateMCQ(@RequestBody @Valid MCQPutRequestBody mcqPutRequestBody){
        service.replace(mcqPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
