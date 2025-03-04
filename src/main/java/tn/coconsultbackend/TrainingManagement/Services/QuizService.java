package tn.coconsultbackend.TrainingManagement.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.TrainingManagement.Entities.Question;
import tn.coconsultbackend.TrainingManagement.Entities.Quiz;
import tn.coconsultbackend.TrainingManagement.Exceptions.QuestionNotFoundException;
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
    private final QuestionService questionService;
    @Autowired
    private final QuestionRepository questionRepository;

    public Quiz createQuiz(Quiz quiz) {
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setUpdatedAt(LocalDateTime.now());
        return quizRepository.save(quiz);
    }

    @Override
    public void addQuestionToQuiz(long id, Question question) {
        Quiz quizToAdd = quizRepository.findQuizById(id);
        questionService.addQuestion(question);
        quizToAdd.getQuestions().add(question);
        quizRepository.save(quizToAdd);
    }

//    @Override
//    public void deleteQuestionFromQuiz(long idQuiz, Question question) {
//        Quiz quiz = quizRepository.findById(idQuiz);
//
//        List<Question> questions = quiz.getQuestions();
//        Question deletedQuestion = questionService.getQuestion(question.getId());
//        questions.remove(deletedQuestion);
//        questionRepository.removeQuestionById(deletedQuestion.getId());
//        quiz.setQuestions(questions);
//        quizRepository.save(quiz);
        @Override
        public void deleteQuestionFromQuiz(long idQuiz, Question question) {
            // Fetch the quiz, exit if not found
            Quiz quiz = quizRepository.findQuizById(idQuiz);
            if (quiz == null) {
                throw new QuizNotFoundException("Quiz not found"); // Or log this case
            }

            // Get the question list
            List<Question> questions = quiz.getQuestions();
            if (questions == null) {
                throw new QuestionNotFoundException("No Question found");
            }

            // Fetch the question to delete, exit if not found
            Question deletedQuestion = questionRepository.findQuestionById(question.getId());
            if (deletedQuestion == null) {
                throw new QuestionNotFoundException("Question not found");
            }
            for (Question questionToDelete : questions) {
                if (questionToDelete.getId() == deletedQuestion.getId()) {
                   quiz.getQuestions().remove(questionToDelete);
                   if  (questionRepository.findQuestionById(deletedQuestion.getId()) !=null){
                       questionRepository.deleteById(questionToDelete.getId());
                   }
                   quizRepository.save(quiz);
                }
            }
        }




    @Override
    public void updateQuiz(Long id, Quiz quiz) {
        Quiz existingQuiz = quizRepository.findQuizById(id);
        existingQuiz.setName(quiz.getName());
        existingQuiz.setDescription(quiz.getDescription());
        existingQuiz.setScore(quiz.getScore());
        existingQuiz.setIsQuizValidated(quiz.getIsQuizValidated());
        existingQuiz.setQuestions(quiz.getQuestions());
        questionRepository.saveAll(existingQuiz.getQuestions());
//        existingQuiz.getQuestions().addAll(quiz.getQuestions());

//        existingQuiz.setQuestions(quiz.getQuestions());
        quizRepository.save(existingQuiz);
    }

    public void deleteQuiz(Long id) {
        Quiz quiz = quizRepository.findQuizById(id);
        quizRepository.delete(quiz);
    }

    public Quiz findQuizById(Long id) {
        return quizRepository.findQuizById(id);
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
