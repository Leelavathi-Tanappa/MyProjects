package com.org.questionservice.service;


import com.org.questionservice.model.QuestionWrapper;
import com.org.questionservice.model.Questions;
import com.org.questionservice.model.Response;
import com.org.questionservice.repository.QuestionRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository repo;
    public ResponseEntity<List<Questions>> getAllQuestions() {
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        repo.save(question);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<String> removeQuestionById(int id) {
        repo.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numQ) {
        List<Integer> questionIds = repo.getQuestionsForQuiz(category, numQ);
        return new ResponseEntity<>(questionIds,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> id) {
        List<Questions> allQuestionsById = repo.findAllById(id);
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        allQuestionsById.forEach(q -> {
            QuestionWrapper qwrapper = new QuestionWrapper(q.getId(),q.getTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qwrapper);
        });
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> res) {
        int score = 0;
        for (Response response : res){
            Questions question = repo.findById(response.getId()).get();
            if (response.getResponse().equals(question.getRight_answer()))
                score++;
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
