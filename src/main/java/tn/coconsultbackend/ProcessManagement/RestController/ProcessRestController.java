package tn.coconsultbackend.ProcessManagement.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.Model.Process;
import tn.coconsultbackend.Model.ProcessType;
import tn.coconsultbackend.ProcessManagement.Services.IProcessManagementService;

@RestController
@AllArgsConstructor
@RequestMapping("/process")
public class ProcessRestController {
    @Autowired
    IProcessManagementService processManagementService;

    @PostMapping("addProcess")
    public Process addProcess(@RequestBody Process process){
        return processManagementService.addProcess(process);
    }
    @PutMapping("updateProcess")
    public Process updateProcess(@RequestBody Process process){
        return processManagementService.updateProcess(process);
    }
    @DeleteMapping("deleteProcess")
    public void deleteProcess(@RequestBody Process process){
        processManagementService.deleteProcess(process);
    }
    @GetMapping("getProcess")
    public Process getProcess(@RequestParam Long id, @RequestParam ProcessType processType){
        return processManagementService.getProcess(id, processType);
    }
}
