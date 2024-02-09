package com.org.questionservice.controller;

import com.org.questionservice.model.QuestionWrapper;
import com.org.questionservice.model.Response;
import com.org.questionservice.service.QuestionService;
import com.org.questionservice.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    Environment environment;
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

    //generate questions for quiz and return question id's to quiz service
    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQ){
        return service.getQuestionsForQuiz(category, numQ);
    }

    //get questions by id - quiz service will request for question id
    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> id){
        System.out.println(environment.getProperty("local.server.port"));
        return service.getQuestions(id);
    }

    //get score - as requested by quiz service after submitting the response
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> res){
        return service.getScore(res);
    }
}
