package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.codejudge.sb.exception.BadRequestException;
import org.codejudge.sb.model.Question;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.payload.*;
import org.codejudge.sb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping
public class AppController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/api/quiz/{quizId}")
    public QuizResponse getQuiz(@PathVariable Long quizId) {
        Quiz quiz =  quizService.getQuizById(quizId);
        return new QuizResponse(quiz.getId(),quiz.getName(),quiz.getDescription());
    }

    @PostMapping("/api/quiz")
    public ResponseEntity<?> createQuiz(@Valid @RequestBody QuizRequest quizRequest, Errors errors)
            throws BadRequestException{
        if(errors.hasErrors()) {
            throw new BadRequestException();
        }
        Quiz quiz = quizService.createQuiz(quizRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{pollId}")
                .buildAndExpand(quiz.getId()).toUri();

        QuizResponse quizResponse = new QuizResponse(quiz.getId(),quiz.getName(),quiz.getDescription());

        return ResponseEntity.created(location).body(quizResponse);
    }

    @PostMapping("/api/questions")
    public ResponseEntity<?> addQuestion(@Valid @RequestBody QuestionRequest questionRequest, Errors errors)
            throws BadRequestException{
        if(errors.hasErrors()) {
            throw new BadRequestException();
        }
        Question question = quizService.createQuestion(questionRequest);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping("/api/questions/{questionId}")
    public Question getQuestion(@PathVariable Long questionId){
        return quizService.getQuestionById(questionId);
    }

    @GetMapping("/api/quiz-questions/{quiz_id}")
    public QuizAllResponse getAllQuestionFromQuiz(@PathVariable Long quiz_id){
        return quizService.getAllQuestionFromQuiz(quiz_id);
    }
}

