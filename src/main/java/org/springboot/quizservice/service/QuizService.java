package org.springboot.quizservice.service;

import org.springboot.quizservice.feign.FeignConfig;
import org.springboot.quizservice.model.QuestionWrapper;
import org.springboot.quizservice.model.Questions;
import org.springboot.quizservice.model.Quiz;
import org.springboot.quizservice.model.QuizDataObject;
import org.springboot.quizservice.model.QuizResponse;
//import org.springboot.quizservice.repository.QuestionRepository;
import org.springboot.quizservice.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private FeignConfig feignConfig;

    public ResponseEntity<String> createQuiz(QuizDataObject quiz) {

        List<Integer> questionIds = feignConfig.generateQuestions(quiz.getCategory(),quiz.getNumQuestion()).getBody();
        Quiz quiz1 = new  Quiz();
        quiz1.setTitle(quiz.getTitle());
        quiz1.setQuestions(questionIds);
        quizRepository.save(quiz1);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(Integer id) {

        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Integer> questionIds = quiz.get().getQuestions();
        ResponseEntity<List<QuestionWrapper>> questionWrappers = feignConfig.getQuestionsForIds(questionIds);

        return questionWrappers;
    }

    public ResponseEntity<Integer> getScore(Integer id, List<QuizResponse> quizResponses) {

        ResponseEntity<Integer> correctAnswers = feignConfig.generateScore(quizResponses);

        return correctAnswers;
    }
}
