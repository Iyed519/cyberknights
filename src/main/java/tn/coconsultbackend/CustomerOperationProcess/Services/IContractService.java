package tn.coconsultbackend.CustomerOperationProcess.Services;
import tn.coconsultbackend.Model.Contract;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    Contract createContract(Contract contract);
    Optional<Contract> getContractById(Long id);
    List<Contract> getAllContracts();
    Contract updateContract(Long id, Contract contractDetails);
    void deleteContract(Long id);



}
