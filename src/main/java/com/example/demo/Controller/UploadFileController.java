package com.example.demo.Controller;

import com.example.demo.Entity.FileModel;
import com.example.demo.Repository.FileRepository;
import com.example.demo.Service.DBFileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Cloie Andrea on 16/07/2018.
 */
@RestController
public class UploadFileController {

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(UploadFileController.class);


    @Autowired
    FileRepository fileRepository;

    @Autowired
    private DBFileStorageService DBFileStorageService;

    /*
     * MultipartFile Upload
     */
    @PostMapping("/apifour/uploadFile")
    public String uploadMultipartFile(@RequestParam("image") MultipartFile file) {
        FileModel fileModel = null;
        try {
            fileModel = new FileModel();
            fileModel.setFileName(file.getOriginalFilename());
            fileModel.setFileType(file.getContentType());
            fileModel.setData(file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        fileRepository.save(fileModel);
            return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
    }

//    @PostMapping("apifour/uploadFile")
//    public UploadFileResponse uploadFile(MultipartFile file) {
//       FileModel fileModel = DBFileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileModel.getId())
//                .toUriString();
//
//        return new UploadFileResponse(fileModel.getFileName(), fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
}
