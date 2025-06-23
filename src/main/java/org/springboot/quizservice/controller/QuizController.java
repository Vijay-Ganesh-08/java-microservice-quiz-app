package org.springboot.quizservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springboot.quizservice.model.QuestionWrapper;
import org.springboot.quizservice.model.Quiz;
import org.springboot.quizservice.model.QuizDataObject;
import org.springboot.quizservice.model.QuizResponse;
import org.springboot.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("quiz")
public class QuizController {


    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> creatQuiz(@RequestBody QuizDataObject quiz) {
        log.info("Creating Quiz");
        return quizService.createQuiz(quiz);
    }

    @GetMapping("getQuestionsForQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id) {
        log.info("Getting Questions for Quiz");
        return quizService.getQuestionsForQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<QuizResponse> quizResponses) {
        log.info("Submitting Quiz");
        return quizService.getScore(id,quizResponses);
    }
}
