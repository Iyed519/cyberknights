package tn.coconsultbackend.TrainingManagement.Services;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.TrainingManagement.Entities.Question;
import tn.coconsultbackend.TrainingManagement.Entities.Quiz;
import tn.coconsultbackend.TrainingManagement.Exceptions.QuizNotFoundException;
import tn.coconsultbackend.TrainingManagement.Repositories.QuestionRepository;
import tn.coconsultbackend.TrainingManagement.Repositories.QuizRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService implements IQuizService {
    @Autowired
    private final QuizRepository quizRepository;
    @Autowired
    private final QuestionRepository questionRepository;

    public Quiz createQuiz(Quiz quiz) {
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setUpdatedAt(LocalDateTime.now());
        return quizRepository.save(quiz);
    }

    public void updateQuiz(Long id, Quiz quiz) {
        Quiz existingQuiz = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found with ID: " + id));
        existingQuiz.setName(quiz.getName());
        existingQuiz.setDescription(quiz.getDescription());
        existingQuiz.setScore(quiz.getScore());
        existingQuiz.setIsQuizValidated(quiz.getIsQuizValidated());
//        existingQuiz.setQuestions(quiz.getQuestions());
        questionRepository.saveAll(existingQuiz.getQuestions());
        existingQuiz.getQuestions().addAll(quiz.getQuestions());
//        existingQuiz.setQuestions(quiz.getQuestions());
        quizRepository.save(existingQuiz);
    }

    public void deleteQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found with ID: " + id));
        quizRepository.delete(quiz);
    }

    public Quiz findQuizById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found with ID: " + id));
    }

    public List<Quiz> findAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz findQuizByName(String name) {
        return quizRepository.findByName(name);
    }

    public List<Quiz> findQuizzesByCreatedAt(LocalDateTime createdAt) {
        return quizRepository.findByCreatedAt(createdAt);
    }

    public List<Quiz> findQuizzesByUpdatedAt(LocalDateTime updatedAt) {
        return quizRepository.findByUpdatedAt(updatedAt);
    }

    public List<Quiz> findQuizzesByCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return quizRepository.findByCreatedAtBetween(start, end);
    }

    public List<Quiz> findQuizzesByUpdatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return quizRepository.findByUpdatedAtBetween(start, end);
    }

    public List<Quiz> findQuizzesByCreatedAtQuery(LocalDateTime createdAt) {
        return quizRepository.findQuizzesByCreatedAt(createdAt);
    }

    public List<Quiz> findQuizzesByUpdatedAtQuery(LocalDateTime updatedAt) {
        return quizRepository.findQuizzesByUpdatedAt(updatedAt);
    }

    public List<Quiz> findQuizzesByCreatedAtBetweenQuery(LocalDateTime start, LocalDateTime end) {
        return quizRepository.findQuizzesByCreatedAtBetween(start, end);
    }

    public List<Quiz> findQuizzesByUpdatedAtBetweenQuery(LocalDateTime start, LocalDateTime end) {
        return quizRepository.findQuizzesByUpdatedAtBetween(start, end);
    }
}
