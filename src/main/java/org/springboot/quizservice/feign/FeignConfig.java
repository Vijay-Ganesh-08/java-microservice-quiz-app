package org.springboot.quizservice.feign;

import org.springboot.quizservice.model.QuestionWrapper;
import org.springboot.quizservice.model.QuizResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface FeignConfig {

    @GetMapping("/question/getQuestionsIdsForQuiz")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category, @RequestParam Integer limit);

    @PostMapping("/question/getQuestionsForIds")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsForIds(@RequestBody List<Integer> questionIds);

    @PostMapping("/question/getScore")
    public ResponseEntity<Integer> generateScore(@RequestBody List<QuizResponse> quizResponses);
}

