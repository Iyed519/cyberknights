package tn.coconsultbackend.ProcessManagement.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.Model.ISOSession;
import tn.coconsultbackend.Model.ProcessType;
import tn.coconsultbackend.Model.Process;
import tn.coconsultbackend.ProcessManagement.Repositories.ISOSessionRepo;
import tn.coconsultbackend.ProcessManagement.Repositories.IndicatorRepo;
import tn.coconsultbackend.ProcessManagement.Repositories.OperationRepo;
import tn.coconsultbackend.ProcessManagement.Repositories.ProcessRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProcessManagementService implements IProcessManagementService {
    @Autowired
    IndicatorRepo indicatorRepo;
    @Autowired
    ProcessRepo processRepo;
    @Autowired
    OperationRepo operationRepo;
    @Autowired
    ISOSessionRepo isoSessionRepo;

    @Override
    public Process addProcess(Process process) {
        return processRepo.save(process);
    }

    @Override
    public Process updateProcess(Process process) {
        Process process1 = processRepo.findById(process.getIdProcess()).get();
        if(process1.getProcessType().equals(process.getProcessType())) {
            process1.setProcessType(process.getProcessType());
        }
        return processRepo.save(process1);
    }

    @Override
    public void deleteProcess(Process process) {
        Process process1 = processRepo.findById(process.getIdProcess()).get();

        processRepo.delete(process);
    }

    @Override
    public Process getProcess(Long id, ProcessType processType) {
        Process process = processRepo.findById(id).get();
        if(process.getProcessType().equals(processType)) {
            return process;
        }
        return null;
    }

    @Override
    public List<Process> getAllProcess(ProcessType processType) {
        return List.of();
    }

    @Override
    public ISOSession startSession() {
        ISOSession session = new ISOSession();
        session.setStartDate(LocalDate.now());

        // Fetch all existing processes and set them to "Open"
        List<Process> processes = processRepo.findAll();
        for (Process process : processes) {
            process.setStatus("ACTIVE");
            processRepo.save(process); // Update each process
        }

        session.setProcesses(processes);
        return isoSessionRepo.save(session);
    }

    @Override
    public List<ISOSession> getAllSessions() {
        return isoSessionRepo.findAll();
    }
}
