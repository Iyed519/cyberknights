package tn.coconsultbackend.TrainingManagement.Services;

import jakarta.validation.constraints.NotBlank;
import tn.coconsultbackend.TrainingManagement.Entities.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {

    Question getQuestion(long id);

    List<Question> getAllQuestions();

    void addQuestion(Question question);

    void updateQuestion(long id,Question question);

    public void deleteQuestion(long id);

//    Question findQuestionByText(String text);

    }
