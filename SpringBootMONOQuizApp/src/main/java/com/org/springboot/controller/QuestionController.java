package com.org.springboot.controller;

import com.org.springboot.entity.Questions;
import com.org.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Questions>> allQuestions(){
        return service.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category){
        return service.getQuestionsByCategory(category);
    }

    @PostMapping("/saveQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return service.addQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeQuestionById(@PathVariable int id){
        return service.removeQuestionById(id);
    }
}
