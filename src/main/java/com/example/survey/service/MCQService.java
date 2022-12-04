package com.example.survey.service;

import com.example.survey.mapper.MCQMapper;
import com.example.survey.model.MCQ;
import com.example.survey.repository.MCQRepository;
import com.example.survey.requests.MCQPostRequestBody;
import com.example.survey.requests.MCQPutRequestBody;
import com.example.survey.exception.BadRequestException;
import com.example.survey.exception.QuestionExistsException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MCQService {

    MCQRepository repository;

    public Page<MCQ> findAllPagination(Pageable peageable) {
        return repository.findAll(peageable);     }

    public MCQ findByIdOrThrowBadRequestException(String id) {
        return repository.findMCQById(id).
                orElseThrow(() -> new BadRequestException("Question not found"));
    }

    @Transactional(rollbackFor = Exception.class)
    public MCQ save(MCQPostRequestBody mcqPostRequestBody) {
        verifiesQuestionExists(mcqPostRequestBody.getQuestionDetail());
        MCQ mcq = MCQMapper.INSTANCE.toMcq(mcqPostRequestBody);
//        mcq.setCreatedAt(LocalDateTime.now());
        return repository.save(mcq);    }

    public void delete(String id) {
        MCQ mcq = findByIdOrThrowBadRequestException(id);
        repository.deleteById(id);
    }

    public void replace(MCQPutRequestBody mcqRequestBody) {

        MCQ currentUser = findByIdOrThrowBadRequestException(mcqRequestBody.getId());
        MCQ mcqToBeUpdated = MCQMapper.INSTANCE.toMcq(mcqRequestBody);
//        mcqToBeUpdated.setUpdatedAt(currentUser.setUpdatedAt());
//        mcqToBeUpdated.setId(currentUser.getId());
        repository.save(mcqToBeUpdated);
    }

    public void verifiesQuestionExists(String QuestionDetail){
        Optional<MCQ> mcq = repository.findMCQByQuestionDetail(QuestionDetail);
        if(mcq.isPresent()){
            throw new QuestionExistsException("Question already exist");        }
    }
}

