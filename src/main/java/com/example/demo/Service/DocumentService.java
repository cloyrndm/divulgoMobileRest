package com.example.demo.Service;

import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import java.io.IOException;
import java.util.List;
/**
 * Created by Cloie Andrea on 21/07/2018.
 */
public interface DocumentService {
    ResponseMetadata save(MultipartFile multipartFile) throws IOException;

    byte[] getDocumentFile(Long id);

    List<Document> findAll();
}
