package tn.coconsultbackend.CustomerOperationProcess.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.CustomerOperationProcess.Services.ContractService;
import tn.coconsultbackend.CustomerOperationProcess.Services.IContractService;
import tn.coconsultbackend.Model.Contract;
import java.util.List;
import java.util.Optional;

@RestController
public class ContractController {


    @PostMapping("createContract")
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.createContract(contract);
    }


    @DeleteMapping("deleteContract")
    public void deleteContract(Long id) {
        contractService.deleteContract(id);
    }

    @PutMapping("/updateContract{id}")
    public Contract updateContract(Long id, Contract contractDetails) {
        return contractService.updateContract(id, contractDetails);
    }

    @GetMapping("/getContract/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Optional<Contract> contract = contractService.getContractById(id);
        if (contract.isPresent()) {
            return ResponseEntity.ok(contract.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getAllContracts")
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contracts = contractService.getAllContracts();
        if (contracts.isEmpty()) {
            return ResponseEntity.noContent().build();  //204 ken mafamech contracts
        } else {
            return ResponseEntity.ok(contracts);  //  200 ken jawha fesfes
        }
    }

    @Autowired
    private IContractService contractService;
}
