package tn.coconsultbackend.CustomerOperationProcess.Services;

import tn.coconsultbackend.Model.Complaint;

public interface IComplaintService {

    Complaint createComplaint(Complaint complaint);
    Complaint updateComplaint(Long id, Complaint complaintDetails);


    boolean deleteComplaint(Long id);

    Complaint getComplaintById(Long id);

}
