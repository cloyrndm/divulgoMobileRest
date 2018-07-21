//package com.example.demo.Service;
//
//import com.example.demo.Repository.FileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
///**
// * Created by Cloie Andrea on 21/07/2018.
// */
//@Service
//public class DocumentServiceImpl implements DocumentService {
//
//    @Autowired
//    private FileRepository fileRepository;
//
//    @Override
//    public ResponseMetadata save(MultipartFile file) throws IOException {
//
//        Document doc = new Document();
//        doc.setDocName(file.getOriginalFilename());
//        doc.setFile(file.getBytes());
//        documentDao.save(doc);
//        ResponseMetadata metadata = new ResponseMetadata();
//        metadata.setMessage("success");
//        metadata.setStatus(200);
//        return metadata;
//    }
//
//    @Override
//    public byte[] getDocumentFile(Long id) {
//        return documentDao.findOne(id).getFile();
//    }
//
//    @Override
//    public List<Document> findAll() {
//        return (List<Document>) documentDao.findAll();
//    }
//}
