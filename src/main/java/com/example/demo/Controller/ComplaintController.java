package com.example.demo.Controller;

import com.example.demo.Entity.Complaint;
import com.example.demo.Repository.ComplaintRepository;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.jni.File;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;

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

    public static byte[] readFileToByteArray(File file) throws IOException{
        return null;
    }
//    @PostMapping("/complaints")
//    @CrossOrigin(origins = {"http://192.168.1.4","file://"})
//    public Complaint createComplaint(@RequestBody @Valid Complaint complaint){
//        System.out.println("I GOT IN THE COMPLAINT CONTROLLER");
//        return complaintRepository.save(complaint);
//    }

    @PostMapping(value="/complaints")
    public Complaint createComplaint(@RequestParam(value ="content") MultipartFile fileone,@RequestBody @Valid Complaint complaint) throws IOException{
        try {
            System.out.println("got inside the create complaint controller!");
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            byte[] array = Files.readAllBytes((Path) fileone);
            Blob blob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(array);
            complaint.setContent(blob);
            return complaintRepository.save(complaint);
        }
        catch (RuntimeException e){
            System.out.println("ERROR");
            return null;

        }
    }
}
