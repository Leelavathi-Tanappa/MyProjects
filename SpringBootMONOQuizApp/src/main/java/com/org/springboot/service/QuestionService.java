package com.org.springboot.service;


import com.org.springboot.entity.Questions;
import com.org.springboot.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
}
