package tn.coconsultbackend.CustomerOperationProcess.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.CustomerOperationProcess.Repositories.DocumentRepository;
import tn.coconsultbackend.Model.Contract;
import tn.coconsultbackend.Model.Document;

import java.util.List;
import java.util.Optional;


@Service
public class DocumentService implements IDocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document createContract(Document document) {
        // Save the new contract in the database
        return documentRepository.save(document);
    }


    @Override
    public Document createDocument(Document document) {
        return null;
    }

    @Override
    public boolean deleteDocument(Long id) {
        // Vérifier si la plainte existe
        if (documentRepository.existsById(id)) {
            documentRepository.deleteById(id);  // Supprime bel ID
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document updateDocument(Long id, Document documentDetails) {
        return null;
    }


}
