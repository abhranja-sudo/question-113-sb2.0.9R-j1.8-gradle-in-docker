package org.codejudge.sb.service;

import org.codejudge.sb.exception.BadRequestException;
import org.codejudge.sb.exception.QuizException;
import org.codejudge.sb.model.Question;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.payload.QuestionRequest;
import org.codejudge.sb.payload.QuizAllResponse;
import org.codejudge.sb.payload.QuizRequest;
import org.codejudge.sb.repository.QuestionRepository;
import org.codejudge.sb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(QuizRequest quizRequest){
        Quiz quiz = new Quiz();
        quiz.setName(quizRequest.getName());
        quiz.setDescription(quizRequest.getDescription());
        return quizRepository.save(quiz);
    }

    public Question createQuestion(QuestionRequest questionRequest){

        Quiz quiz = quizRepository.findById(questionRequest.getQuiz()).orElseThrow(() -> new BadRequestException());
        Question question = new Question();
        question.setName(questionRequest.getName());
        question.setCorrect_options(questionRequest.getCorrect_option());
        question.setOptions(questionRequest.getOptions());
        question.setPoints(questionRequest.getPoints());
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }

    public Quiz getQuizById(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new QuizException());
        return quiz;
    }

    public Question getQuestionById(Long id){
        return questionRepository.findById(id).orElseThrow(() -> new QuizException());
    }

    public QuizAllResponse getAllQuestionFromQuiz(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(()->new BadRequestException());
        QuizAllResponse quizAllResponse = new QuizAllResponse();
        quizAllResponse.setDescription(quiz.getDescription());
        quizAllResponse.setName(quiz.getName());
        quizAllResponse.setQuestions(quiz.getQuestion());
        return quizAllResponse;
    }

}
