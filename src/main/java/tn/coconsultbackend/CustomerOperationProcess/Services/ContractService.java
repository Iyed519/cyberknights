package tn.coconsultbackend.CustomerOperationProcess.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.CustomerOperationProcess.Repositories.ContractRepository;
import tn.coconsultbackend.Model.Contract;
import java.util.List;
import java.util.Optional;


@Service
public class ContractService implements IContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> getContractById(Long id) {
        return contractRepository.findById(id);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract updateContract(Long id, Contract contractDetails) {
        Optional<Contract> optionalContract = contractRepository.findById(id);
        if (optionalContract.isPresent()) {
            Contract contract = optionalContract.get();

            // Update  num ken mch null
            if (contractDetails.getContractNumber() != null) {
                contract.setContractNumber(contractDetails.getContractNumber());
            }

            // Update start date
            if (contractDetails.getStartDate() != null) {
                contract.setStartDate(contractDetails.getStartDate());
            }

            // Update status
            if (contractDetails.getStatus() != null) {
                contract.setStatus(contractDetails.getStatus());
            }

            // Update amount
            if (contractDetails.getAmount() != 0) {
                contract.setAmount(contractDetails.getAmount());
            }

            // Save w return el updated contract
            return contractRepository.save(contract);
        } else {
            return null;  //  null ken mafamech contract bel ID l mahtouta
        }
    }




    @Override
    public void deleteContract(Long id) {
        // Delete a contract by its ID
        if (contractRepository.existsById(id)) {
            contractRepository.deleteById(id);
        } else {
            throw new RuntimeException("Contract not found with id " + id);
        }
    }


}
