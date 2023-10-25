package com.tirthaj.quizapp.service;

import com.tirthaj.quizapp.Question;
import com.tirthaj.quizapp.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("ADD SUCCESSFUL", HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Creation unsuccessful", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public String deleteQuestion(int id) {
        questionDAO.findById(id)
                .orElseThrow(() -> new IllegalStateException("Question does not exist with id:" + id));
        questionDAO.deleteById(id);
        return "DELETE SUCCESS";
    }

    public String updateQuestion(int id, Question question) {
        Question updatequestion = questionDAO.findById(id)
                .orElseThrow(() -> new IllegalStateException("Question does not exist with id:" + id));
        updatequestion.setQuestionTitle(question.getQuestionTitle());
        updatequestion.setOption1(question.getOption1());
        updatequestion.setOption2(question.getOption2());
        updatequestion.setOption3(question.getOption3());
        updatequestion.setOption4(question.getOption4());
        updatequestion.setRightAnswer(question.getRightAnswer());
        updatequestion.setDifficultylevel(question.getDifficultylevel());
        updatequestion.setCategory(question.getCategory());
        questionDAO.save(updatequestion);
        return "UPDATE SUCCESSFUL";
    }
}
