package tn.coconsultbackend.TrainingManagement.Exceptions;

public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException(String message) {
        super(message);
    }
}
