package com.example.demo.Controller;

import com.example.demo.Entity.Complaint;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ComplaintRepository;
import org.apache.catalina.connector.Request;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.jni.File;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
import java.util.List;

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

    public static byte[] readFileToByteArray(File file) throws IOException {
        return null;
    }
//    @PostMapping("/complaints")
//    @CrossOrigin(origins = {"http://192.168.1.4","file://"})
//    public Complaint createComplaint(@RequestBody @Valid Complaint complaint){
//        System.out.println("I GOT IN THE COMPLAINT CONTROLLER");
//        return complaintRepository.save(complaint);
//    }

//    @PostMapping(value="/complaints")
//    public Complaint createComplaint(@RequestParam(value ="file") MultipartFile fileone,@RequestBody @Valid Complaint complaint) {
//        try {
//            System.out.println("got inside the create complaint controller!");
//            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
////            int size = fileone.getBytes();
////            byte[] array = Files.readAllBytes((Path) fileone);
//            byte[] arrayPic = new byte[(int) fileone.getSize()];
////            Blob blob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(arrayPic);
////            complaint.setContent(blob);
////            byte[] arraypictwo = fileone.getBytes();
//
//            return complaintRepository.save(complaint);
//        }
//        catch (RuntimeException e){
//            System.out.println("ERROR");
//            return null;
//
//        }
//    }

//    @PostMapping(value="/complaints")
//    public Complaint createComplaint(@RequestParam(value ="content") MultipartFile fileone,@RequestBody @Valid Complaint complaint){
//        byte[] arrayPic = new byte[(int) fileone.getSize()];
//        fileone.getInputStream().read(arrayPic);
//    }

    @PostMapping(value = "/complaints")
    public Complaint createComplaint(@RequestParam(value = "file") MultipartFile fileone, @RequestBody @Valid Complaint complaint) throws Exception {

//        complaint.setContent(fileone.getBytes());
        return complaintRepository.save(complaint);
    }

    // Get Complaints
    @GetMapping("/complaints/{user_id}")
    public List<Complaint> getComplaintById(@PathVariable(value = "user_id") Long user_id) {

            return complaintRepository.findByUserId(user_id);

    }

//    // Get a Single User
//    @GetMapping("/complaints/{user_id}")
//    public Complaint getUserById(@PathVariable(value = "user_id") Long user_id) {
//        return complaintRepository.findByUserId(user_id);
//
//    }

//    @CrossOrigin(origins = {"http://localhost:8100"})
//    @RequestMapping("/getcomplaint")
//    public Complaint getcomplaint(@Valid @RequestBody Complaint complaint){
//        System.out.println("I GOT INSIDE THE LOGIN");
//        complaint = complaintRepository.findByUserId(complaint.getUser_id());
//        if(complaintRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()) == null) {
//            return null;
//        }
//
//        return user;
//    }
//    public Complaint getUserById(@PathVariable(value = "user_id") Long user_id){
//    List<Complaint>complaint =
//            complaintRepository.findByUserId(
//                    Request.getUserId());
//    for (int i = 0; i < studentDetails.size(); i++) {
//        logger.info("entries: " + studentDetails.get(i).getName());
//    }
//
//    return request;
//    }
}


