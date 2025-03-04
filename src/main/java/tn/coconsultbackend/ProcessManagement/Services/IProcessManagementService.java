package tn.coconsultbackend.ProcessManagement.Services;

import tn.coconsultbackend.Model.ISOSession;
import tn.coconsultbackend.Model.ProcessType;
import tn.coconsultbackend.Model.Process;

import java.util.List;

public interface IProcessManagementService {
    //process
    public Process addProcess(Process process);
    public Process updateProcess(Process process);
    public void deleteProcess(Process process);
    public Process getProcess(Long id,ProcessType processType);
    public List<Process> getAllProcess(ProcessType processType);

    //Session
    public ISOSession startSession();
    public List<ISOSession> getAllSessions();

    //Indicators

}
