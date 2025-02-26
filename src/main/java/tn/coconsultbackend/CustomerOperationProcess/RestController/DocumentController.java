package tn.coconsultbackend.CustomerOperationProcess.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.CustomerOperationProcess.Services.IDocumentService;
import tn.coconsultbackend.Model.Document;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    public DocumentController(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("createDocument")
    public Document createDocument(@RequestBody Document document) {
        return documentService.createDocument(document);
    }

    @DeleteMapping("/deleteDocument/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        boolean isDeleted = documentService.deleteDocument(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();  //  204
        } else {
            return ResponseEntity.notFound().build();  // 404
        }
    }


    @GetMapping("/getDocumentById/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Optional<Document> document = documentService.getDocumentById(id);
        if (document.isPresent()) {
            return ResponseEntity.ok(document.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getAllContracts")
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        if (documents.isEmpty()) {  //fergha wale
            return ResponseEntity.noContent().build();  //  204 ken famech contracts
        } else {
            return ResponseEntity.ok(documents);  //200 ken fama contracts
        }
    }


    @Autowired
    private IDocumentService documentService;
}
