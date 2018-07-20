package com.example.demo.Service;

import com.example.demo.Entity.FileModel;
import com.example.demo.Exception.FileStorageException;
import com.example.demo.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Cloie Andrea on 16/07/2018.
 */
@Service
public class DBFileStorageService {

    @Autowired
    FileRepository fileRepository;

    public FileModel storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            FileModel fileModel = new FileModel(fileName, file.getContentType(), file.getBytes());

            return fileRepository.save(fileModel);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

}
