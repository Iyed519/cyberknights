package tn.coconsultbackend.TrainingManagement.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.TrainingManagement.Entities.Question;
import tn.coconsultbackend.TrainingManagement.Entities.Quiz;
import tn.coconsultbackend.TrainingManagement.Repositories.QuizRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IQuizService {
    public Quiz createQuiz(Quiz quiz);

    void addQuestionToQuiz(long id, Question question);

    void deleteQuestionFromQuiz(long idQuiz, Question  question);

    public void updateQuiz(Long id, Quiz quiz);

    public void deleteQuiz(Long id);

    public Quiz findQuizById(Long id);

    public List<Quiz> findAllQuizzes();

    public Quiz findQuizByName(String name);

    public List<Quiz> findQuizzesByCreatedAt(LocalDateTime createdAt);

    public List<Quiz> findQuizzesByUpdatedAt(LocalDateTime updatedAt);

    public List<Quiz> findQuizzesByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    public List<Quiz> findQuizzesByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);

    public List<Quiz> findQuizzesByCreatedAtQuery(LocalDateTime createdAt);


    public List<Quiz> findQuizzesByUpdatedAtQuery(LocalDateTime updatedAt);

    public List<Quiz> findQuizzesByCreatedAtBetweenQuery(LocalDateTime start, LocalDateTime end);

    public List<Quiz> findQuizzesByUpdatedAtBetweenQuery(LocalDateTime start, LocalDateTime end);

}
