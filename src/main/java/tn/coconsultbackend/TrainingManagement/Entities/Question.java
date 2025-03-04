package tn.coconsultbackend.TrainingManagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor

public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name must not be blank")
    @NotEmpty(message = "name must not be empty")
    private String questionText;

    @NotBlank(message = "name must not be blank")
    @NotEmpty(message = "name must not be empty")
    private String correctAnswer;

    @NotBlank(message = "name must not be blank")
    @NotEmpty(message = "name must not be empty")
    private String traineeAnswer;

    private Boolean isAnswerCorrect;
//    private List<String> options = new ArrayList<String>();


}
