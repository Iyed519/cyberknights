package tn.coconsultbackend.TrainingManagement.RestControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.coconsultbackend.TrainingManagement.Entities.Quiz;
import tn.coconsultbackend.TrainingManagement.Services.QuizService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
@Validated
@ControllerAdvice
public class QuizRestController {
    @Autowired
    private final QuizService quizService;

    @Operation(summary = "Create a new quiz", description = "Creates a new quiz with validation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quiz created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid quiz data: {validation messages}")
    })
    @PostMapping("/createQuiz")
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @Operation(summary = "Update an existing quiz", description = "Updates a quiz with validation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quiz updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid quiz data: {validation messages}")
    })
//    @PutMapping("/updateQuiz/{id}")
    @PutMapping("/{id}")
    public void updateQuiz(@PathVariable Long id, @Valid @RequestBody Quiz quiz) {
        quizService.updateQuiz(id, quiz);
    }

    @Operation(summary = "Delete a quiz", description = "Deletes a quiz by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quiz deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Quiz not found: {error message}")
    })
    @DeleteMapping("/deleteQuiz/{id}")
    public void deleteQuiz(@Valid@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }

//    @Operation(summary = "Get a quiz by ID", description = "Returns a quiz by its ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quiz found"),
//            @ApiResponse(responseCode = "404", description = "Quiz not found: {error message}")
//    })
    @GetMapping("/getQuiz/{id}")
    public Quiz getQuizById(@Valid@PathVariable Long id) {
        return quizService.findQuizById(id);
    }

//    @Operation(summary = "Get all quizzes", description = "Returns all quizzes")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("/getAllQuizzes")
    public List<Quiz> getAllQuizzes() {
        return quizService.findAllQuizzes();
    }

//    @Operation(summary = "Get a quiz by name", description = "Returns a quiz by its name")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quiz found"),
//            @ApiResponse(responseCode = "404", description = "Quiz not found: {error message}")
//    })
    @GetMapping("getQuizByName/{name}")
    public Quiz getQuizByName(@Valid@PathVariable String name) {
        return quizService.findQuizByName(name);
    }

//    @Operation(summary = "Get quizzes by createdAt", description = "Returns quizzes created at a specific date and time")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("getQuizzesByCreatedDate/{createdAt}")
    public List<Quiz> getQuizzesByCreatedAt(@Valid@PathVariable LocalDateTime createdAt) {
        return quizService.findQuizzesByCreatedAt(createdAt);
    }

//    @Operation(summary = "Get quizzes by updatedAt", description = "Returns quizzes updated at a specific date and time")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("/by-updated-at/{updatedAt}")
    public List<Quiz> getQuizzesByUpdatedAt(@PathVariable LocalDateTime updatedAt) {
        return quizService.findQuizzesByUpdatedAt(updatedAt);
    }

//    @Operation(summary = "Get quizzes by createdAt range", description = "Returns quizzes created between two dates and times")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("/by-created-at-between/{start}/{end}")
    public List<Quiz> getQuizzesByCreatedAtBetween(
            @PathVariable LocalDateTime start,
            @PathVariable LocalDateTime end) {
        return quizService.findQuizzesByCreatedAtBetween(start, end);
    }

//    @Operation(summary = "Get quizzes by updatedAt range", description = "Returns quizzes updated between two dates and times")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("/by-updated-at-between/{start}/{end}")
    public List<Quiz> getQuizzesByUpdatedAtBetween(
            @PathVariable LocalDateTime start,
            @PathVariable LocalDateTime end) {
        return quizService.findQuizzesByUpdatedAtBetween(start, end);
    }

//    @Operation(summary = "Get quizzes by createdAt (query)", description = "Returns quizzes created at a specific date and time using query")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("/by-created-at-query/{createdAt}")
    public List<Quiz> getQuizzesByCreatedAtQuery(@PathVariable LocalDateTime createdAt) {
        return quizService.findQuizzesByCreatedAtQuery(createdAt);
    }

//    @Operation(summary = "Get quizzes by updatedAt (query)", description = "Returns quizzes updated at a specific date and time using query")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("/by-updated-at-query/{updatedAt}")
    public List<Quiz> getQuizzesByUpdatedAtQuery(@PathVariable LocalDateTime updatedAt) {
        return quizService.findQuizzesByUpdatedAtQuery(updatedAt);
    }

//    @Operation(summary = "Get quizzes by createdAt range (query)", description = "Returns quizzes created between two dates and times using query")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("/by-created-at-between-query/{start}/{end}")
    public List<Quiz> getQuizzesByCreatedAtBetweenQuery(
            @PathVariable LocalDateTime start,
            @PathVariable LocalDateTime end) {
        return quizService.findQuizzesByCreatedAtBetweenQuery(start, end);
    }

//    @Operation(summary = "Get quizzes by updatedAt range (query)", description = "Returns quizzes updated between two dates and times using query")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Quizzes retrieved successfully")
//    })
    @GetMapping("/by-updated-at-between-query/{start}/{end}")
    public List<Quiz> getQuizzesByUpdatedAtBetweenQuery(
            @PathVariable LocalDateTime start,
            @PathVariable LocalDateTime end) {
        return quizService.findQuizzesByUpdatedAtBetweenQuery(start, end);
    }
}