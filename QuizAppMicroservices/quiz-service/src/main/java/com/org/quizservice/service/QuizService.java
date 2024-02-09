package com.org.quizservice.service;

import com.org.quizservice.feign.QuizServiceFeignClient;
import com.org.quizservice.model.QuestionWrapper;
import com.org.quizservice.model.Quiz;
import com.org.quizservice.model.Response;
import com.org.quizservice.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepo;

    @Autowired
    private QuizServiceFeignClient feignClient;

    public ResponseEntity<String> createQuiz(String category, int numQ, String quizTitle) {
       List<Integer> questionIds = feignClient.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(quizTitle);
        quiz.setQuestionIds(questionIds);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz quiz = quizRepo.findById(id).get();
        List<QuestionWrapper> questionsForUser = feignClient.getQuestionsById(quiz.getQuestionIds()).getBody();
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(List<Response> responses) {
        int score = feignClient.getScore(responses).getBody();
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
