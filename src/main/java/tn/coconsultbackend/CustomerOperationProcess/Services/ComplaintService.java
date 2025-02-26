package tn.coconsultbackend.CustomerOperationProcess.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.coconsultbackend.CustomerOperationProcess.Repositories.ComplaintRepository;
import tn.coconsultbackend.CustomerOperationProcess.Repositories.ContractRepository;
import tn.coconsultbackend.Model.Complaint;
import tn.coconsultbackend.Model.Contract;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ComplaintService implements IComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;


    @Override
    public Complaint createComplaint(Complaint complaint) {

        if (complaint.getSubmissionDate() == null) {
            complaint.setSubmissionDate(LocalDateTime.now());
        }
        return complaintRepository.save(complaint);
    }


    @Override
    public boolean deleteComplaint(Long id) {
        // Vérifier si la plainte existe
        if (complaintRepository.existsById(id)) {
            complaintRepository.deleteById(id);  // fasakh bel ID
            return true;
        } else {
            return false;  // ken mafamech
        }
    }


    @Override
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }


    @Override
    public Complaint updateComplaint(Long id, Complaint complaintDetails) {
        return complaintRepository.findById(id)
                .map(complaint -> {
                    if (complaintDetails.getDescription() != null) {
                        complaint.setDescription(complaintDetails.getDescription());
                    }
                    if (complaintDetails.getStatus() != null) {
                        complaint.setStatus(complaintDetails.getStatus());
                    }
                    if (complaintDetails.getSubmissionDate() != null) {
                        complaint.setSubmissionDate(complaintDetails.getSubmissionDate());
                    }
                    if (complaintDetails.getResolutionDate() != null) {
                        complaint.setResolutionDate(complaintDetails.getResolutionDate());
                    }
                    return complaintRepository.save(complaint);
                }).orElse(null);
    }





}
