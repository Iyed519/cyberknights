package tn.coconsultbackend.TrainingManagement.RestControllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.TrainingManagement.Entities.Question;
import tn.coconsultbackend.TrainingManagement.Services.QuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Question")
@Validated // Optional: Enables validation at the class level
public class QuestionRestController {
    @Autowired
    private final QuestionService questionService;

    @PostMapping("/addQuestion")
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }
    @PostMapping("/updateQuestion")
    public void updateQuestion(@Valid @RequestParam long id, @RequestBody Question question) {
        questionService.updateQuestion(id, question);
    }
    @PostMapping("/deleteQuestion")
    public void deleteQuestion( @RequestParam long id) {
        questionService.deleteQuestion(id);
    }
    @GetMapping("/findQuestionById")
    public Question findQuestion(@RequestParam long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("/findQuestionByQuestionText")
    Optional<Question> findQuestionByText(@RequestParam String text) {
        return questionService.findQuestionByText(text);
    }

    @GetMapping("/getAllQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

}
