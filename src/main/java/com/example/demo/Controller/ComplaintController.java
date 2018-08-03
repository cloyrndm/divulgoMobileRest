package com.example.demo.Controller;

import com.example.demo.Entity.Complaint;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ComplaintRepository;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletContext;

/**
 * Created by Cloie Andrea on 15/07/2018.
 */

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/apithree")
@ResponseBody
public class ComplaintController {

    @Autowired
    ComplaintRepository complaintRepository;

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://divulgo_uploads//";

    public static byte[] readFileToByteArray(File file) throws IOException {
        return null;
    }
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestPart Complaint complaint,@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes
                                      ) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return null;
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String filepath = UPLOADED_FOLDER+file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            complaint.setFile_path(filepath);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            complaintRepository.save(complaint);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}


