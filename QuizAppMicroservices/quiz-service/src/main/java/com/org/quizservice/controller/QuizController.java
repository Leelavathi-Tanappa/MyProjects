package com.org.quizservice.controller;


import com.org.quizservice.dto.QuizDto;
import com.org.quizservice.model.QuestionWrapper;
import com.org.quizservice.model.Response;
import com.org.quizservice.service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategory(), quizDto.getNumQ(), quizDto.getQuizTitle());
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

   @PostMapping("/submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> response){
        return quizService.calculateResult(response);
    }
}
