package tn.coconsultbackend.TrainingManagement.RestControllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.TrainingManagement.Entities.Training;
import tn.coconsultbackend.TrainingManagement.Services.ITrainingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Training")
public class TrainingRestController {
    @Autowired
    private  final ITrainingService trainingService;

    @PostMapping("/addTrainning")
    Training addTraining(@RequestBody Training training){
        return trainingService.addTraining(training);
    }

    @PostMapping("/updateTraining")
    Training updateTraining(@RequestParam long id, @RequestBody Training training){
        return trainingService.updateTraining(id,training);
    }


}
