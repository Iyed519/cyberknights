package tn.coconsultbackend.CustomerOperationProcess.Services;

import tn.coconsultbackend.Model.Document;

import java.util.List;
import java.util.Optional;

public interface IDocumentService {


    Document createContract(Document document);

    Document createDocument(Document document);
    boolean deleteDocument(Long id);

    Optional<Document> getDocumentById(Long id);
    List<Document> getAllDocuments();
    Document updateDocument(Long id, Document documentDetails);

}
