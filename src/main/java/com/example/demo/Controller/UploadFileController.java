package com.example.demo.Controller;

import com.example.demo.Repository.FileRepository;
import com.example.demo.Service.FileStorageService;
import com.example.demo.payload.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Created by Cloie Andrea on 16/07/2018.
 */
@RestController
public class UploadFileController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UploadFileController.class);


    @Autowired
    FileRepository fileRepository;

    @Autowired
    private FileStorageService fileStorageService;

    /*
     * MultipartFile Upload
     */
//    @PostMapping("/apifour/uploadFile")
//    public String uploadMultipartFile(@RequestParam("image") MultipartFile file) {
//        FileModel fileModel = null;
//        try {
//            fileModel = new FileModel();
//            fileModel.setFileName(file.getOriginalFilename());
//            fileModel.setFileType(file.getContentType());
//            fileModel.setData(file.getBytes());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        fileRepository.save(fileModel);
//            return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
//    }

    @PostMapping("apifour/uploadFile")
        public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
            String fileName = fileStorageService.storeFile(file);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();

            return new UploadFileResponse(fileName, fileDownloadUri,
                    file.getContentType(), file.getSize());
        }
}
