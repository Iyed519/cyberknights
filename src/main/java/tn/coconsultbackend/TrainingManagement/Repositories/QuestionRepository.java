package tn.coconsultbackend.TrainingManagement.Repositories;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.TrainingManagement.Entities.Question;
import tn.coconsultbackend.TrainingManagement.Entities.Quiz;
import tn.coconsultbackend.TrainingManagement.Entities.TrainingLevel;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {



    Question findQuestionById(long id);

    List<Question> findQuestionsByIsAnswerCorrect(boolean isAnswerCorrect);

    List<Question> findQuestionsByQuestionText(String questionText);


    Optional<Question> findByQuestionText(String questionText);

    @Query("SELECT q FROM Question q ORDER BY q.id ASC")
    List<Question> findAllQuestions();
    void deleteQuestionById(long id);

}
