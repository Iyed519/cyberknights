package tn.coconsultbackend.TrainingManagement.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.TrainingManagement.Entities.Question;
import tn.coconsultbackend.TrainingManagement.Repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService {
    @Autowired
    private final QuestionRepository questionRepository;

    @Override
    public Question getQuestion(long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = questionRepository.findAllQuestions();
        return new ArrayList<>(questions);
    }

    @Override
    public Optional<Question> findQuestionByText(String text){
        Optional<Question> question = questionRepository.findByQuestionText(text);
        return question;
    }


    @Override
    public void addQuestion(Question question) {
        Question newQuestion = new Question();

        newQuestion.setQuestionText(question.getQuestionText());
        newQuestion.setTraineeAnswer(question.getTraineeAnswer());
        newQuestion.setCorrectAnswer(question.getCorrectAnswer());
        newQuestion.setIsAnswerCorrect(question.getIsAnswerCorrect());

        questionRepository.save(newQuestion);
    }

    @Override
    public void updateQuestion(long id, Question question) {
        Question updatedQuestion = questionRepository.findById(id).orElse(null);
        updatedQuestion.setQuestionText(question.getQuestionText());
        updatedQuestion.setTraineeAnswer(question.getTraineeAnswer());
        updatedQuestion.setCorrectAnswer(question.getCorrectAnswer());
        updatedQuestion.setIsAnswerCorrect(question.getIsAnswerCorrect());

        questionRepository.save(updatedQuestion);
    }

    @Override
    public void deleteQuestion(long id){
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Question not found with ID: " + id));
        questionRepository.delete(question);
    }
}
