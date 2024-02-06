package com.org.springboot.service;

import com.org.springboot.entity.QuestionWrapper;
import com.org.springboot.entity.Questions;
import com.org.springboot.entity.Quiz;
import com.org.springboot.entity.Response;
import com.org.springboot.repository.QuestionRepository;
import com.org.springboot.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuizService {
    @Autowired
    QuestionRepository questionRepo;
    @Autowired
    QuizRepository quizRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String quizTitle) {
        List<Questions> questions = questionRepo.findRandomQByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(quizTitle);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        //List<Questions> questions = quiz.get().getQuestions();
        final List<QuestionWrapper> questionsForUser = new ArrayList<>();
        quiz.get().getQuestions().forEach(q -> {
            QuestionWrapper qwrapper = new QuestionWrapper(q.getId(),q.getTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qwrapper);
        });
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Questions> questions = quiz.getQuestions();
        int right = 0;
        int index = 0;
        for(Response res : responses){
            if(res.getResponse().equals(questions.get(index).getRight_answer()))
                right++;

            index++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
