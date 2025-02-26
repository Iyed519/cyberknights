package tn.coconsultbackend.CustomerOperationProcess.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.CustomerOperationProcess.Services.ComplaintService;
import tn.coconsultbackend.Model.Complaint;


@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {


    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/createComplaint")
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        Complaint createdComplaint = complaintService.createComplaint(complaint);
        return ResponseEntity.ok(createdComplaint);
    }

    @DeleteMapping("/deleteComplaint/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
        boolean isDeleted = complaintService.deleteComplaint(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Mettre à jour une plainte",
            description = "Cette méthode met à jour une plainte existante avec les nouvelles informations.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Plainte mise à jour avec succès"),
                    @ApiResponse(responseCode = "404", description = "Plainte non trouvée")
            }
    )
    @PutMapping("/updateComplaint/{id}")
    public ResponseEntity<Complaint> updateComplaint(@PathVariable Long id, @RequestBody Complaint complaintDetails) {
        Complaint updatedComplaint = complaintService.updateComplaint(id, complaintDetails);
        if (updatedComplaint != null) {
            return ResponseEntity.ok(updatedComplaint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(
            summary = "Récupérer une plainte par son ID",
            description = "Cette méthode permet de récupérer les détails d'une plainte en fonction de son ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Plainte récupérée avec succès"),
                    @ApiResponse(responseCode = "404", description = "Plainte non trouvée")
            }
    )
    @GetMapping("/getComplaint/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        Complaint complaint = complaintService.getComplaintById(id);
        if (complaint != null) {
            return ResponseEntity.ok(complaint); // mawjouda wwale
        } else {
            return ResponseEntity.notFound().build(); // 404 ken mafamech hehe
        }
    }

}
