package com.org.springboot.controller;

import com.org.springboot.entity.QuestionWrapper;
import com.org.springboot.entity.Questions;
import com.org.springboot.entity.Quiz;
import com.org.springboot.entity.Response;
import com.org.springboot.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String quizTitle){
        return quizService.createQuiz(category, numQ, quizTitle);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> response){
        return quizService.calculateResult(id, response);
    }
}
