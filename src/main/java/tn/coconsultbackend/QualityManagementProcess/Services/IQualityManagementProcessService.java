package tn.coconsultbackend.QualityManagementProcess.Services;

import tn.coconsultbackend.Model.*;

import java.util.List;

public interface IQualityManagementProcessService {
    //Audit
    public Audit addAudit(Audit audit);
    public Audit getAudit(long id);
    public Audit updateAudit(Audit audit);
    public void deleteAudit(long id);
    public List<Audit> getAllAudit();
    //CorrectiveActions
    public List<CorrectiveActions> addCorrectiveActions(List<CorrectiveActions> Actions);
    public CorrectiveActions getCorrectiveActions(long id);
    public CorrectiveActions updateCorrectiveActions(CorrectiveActions correctiveActions);
    public void deleteCorrectiveActions(long id);
    public List<CorrectiveActions> getAllCorrectiveActions();
    //CorrectionEfficiency
    public CorrectionEfficiency createCorrectionEfficiency(CorrectionEfficiency correctionEfficiency);
    public CorrectionEfficiency updateCorrectionEfficiencies(CorrectionEfficiency correctionEfficiency);
    public CorrectionEfficiency deleteCorrectionEfficiencies(long id);
    //Indicator
    //NonConformance
    public NonConformance addNonConformance(NonConformance nonConformance);
    public NonConformance getNonConformance(long id);
    public NonConformance updateNonConformance(NonConformance nonConformance);
    public NonConformance deleteNonConformance(long id);
    //NonConformanceReport
    public NonConformanceReport addNonConformanceReport(NonConformanceReport nonConformanceReport);
    public NonConformanceReport getNonConformanceReport(long id);
    public NonConformance updateNonConformanceReport(NonConformanceReport nonConformanceReport);
    public NonConformanceReport deleteNonConformanceReport(long id);
}
