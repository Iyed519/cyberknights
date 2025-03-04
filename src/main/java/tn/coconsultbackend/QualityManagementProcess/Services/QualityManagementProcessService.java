package tn.coconsultbackend.QualityManagementProcess.Services;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.Model.*;
import tn.coconsultbackend.QualityManagementProcess.Repositories.AuditRepo;
import tn.coconsultbackend.QualityManagementProcess.Repositories.CorrectionEfficiencyRepo;
import tn.coconsultbackend.QualityManagementProcess.Repositories.CorrectiveActionsRepo;
import tn.coconsultbackend.QualityManagementProcess.Repositories.NonConformanceReportRepo;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class QualityManagementProcessService implements IQualityManagementProcessService {
    @Autowired
    AuditRepo auditRepo;
    @Autowired
    CorrectionEfficiencyRepo correctionEfficiencyRepo;
    @Autowired
    CorrectiveActionsRepo correctiveActionsRepo;
    @Autowired
    NonConformanceReportRepo nonConformanceReport;
    @Autowired
    NonConformanceReportRepo nonConformanceReportRepo;

    //Audit
    @Override
    public Audit addAudit(Audit audit) {
        return auditRepo.save(audit);
    }

    @Override
    public Audit getAudit(long id) {
        return auditRepo.findById(id).orElse(null);
    }

    @Override
    public Audit updateAudit(Audit audit) {
        Audit audit1= auditRepo.findById(audit.getAuditId()).orElse(null);
        if(audit1!=null){
            audit1.setScope(audit.getScope());
            audit1.setAuditStatus(audit.getAuditStatus());
            audit1.setAudit_date(audit.getAudit_date());
            return auditRepo.save(audit1);
        }
        return null;
    }

    @Override
    public void deleteAudit(long id) {
        Audit audit1= auditRepo.findById(id).orElse(null);
        if(audit1!=null){
            auditRepo.delete(audit1);
        }
    }

    @Override
    public List<Audit> getAllAudit() {
        return auditRepo.findAll();
    }

    //CorrectiveActions
    @Override
    public List<CorrectiveActions> addCorrectiveActions(List<CorrectiveActions> Actions) {
        return correctiveActionsRepo.saveAll(Actions);
    }

    @Override
    public CorrectiveActions getCorrectiveActions(long id) {
        return correctiveActionsRepo.findById(id).orElse(null);
    }

    @Override
    public CorrectiveActions updateCorrectiveActions(CorrectiveActions correctiveActions) {
        CorrectiveActions correction =  correctiveActionsRepo.findById(correctiveActions.getCaId()).orElse(null);
        if(correction!=null){
            correction.setDescription(correctiveActions.getDescription());
            correction.setPlanning_manager(correctiveActions.getPlanning_manager());
            correction.setRealization_manager(correctiveActions.getRealization_manager());
            correction.setTreatement_manager(correctiveActions.getTreatement_manager());
            correction.setPlanning_date(correctiveActions.getPlanning_date());
            correction.setTreatement_date(correctiveActions.getTreatement_date());
            correction.setRealization_date(correctiveActions.getRealization_date());
            correction.setVerifictation_date(correctiveActions.getVerifictation_date());
            return correctiveActionsRepo.save(correction);
        }
        return null;
    }

    @Override
    public void deleteCorrectiveActions(long id) {
        CorrectiveActions correction =  correctiveActionsRepo.findById(id).orElse(null);
        if(correction!=null) {
            correctiveActionsRepo.delete(correction);
        }
    }

    @Override
    public List<CorrectiveActions> getAllCorrectiveActions() {
        return List.of();
    }

    //CorrectionEfficiency
    @Override
    public CorrectionEfficiency createCorrectionEfficiency(CorrectionEfficiency correctionEfficiency) {
        return null;
    }

    @Override
    public CorrectionEfficiency updateCorrectionEfficiencies(CorrectionEfficiency correctionEfficiency) {
        return null;
    }

    @Override
    public CorrectionEfficiency deleteCorrectionEfficiencies(long id) {
        return null;
    }

    //NonConformance
    @Override
    public NonConformance addNonConformance(NonConformance nonConformance) {
        return null;
    }

    @Override
    public NonConformance getNonConformance(long id) {
        return null;
    }

    @Override
    public NonConformance updateNonConformance(NonConformance nonConformance) {
        return null;
    }

    @Override
    public NonConformance deleteNonConformance(long id) {
        return null;
    }

    //NonConformanceReport
    @Override
    public NonConformanceReport addNonConformanceReport(NonConformanceReport nonConformanceReport) {
        return null;
    }

    @Override
    public NonConformanceReport getNonConformanceReport(long id) {
        return null;
    }

    @Override
    public NonConformance updateNonConformanceReport(NonConformanceReport nonConformanceReport) {
        return null;
    }

    @Override
    public NonConformanceReport deleteNonConformanceReport(long id) {
        return null;
    }

    //Indicator

}
