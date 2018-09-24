package com.example.demo.Controller;

import com.atlis.location.model.impl.Address;
import com.atlis.location.model.impl.MapPoint;
import com.atlis.location.nominatim.NominatimAPI;
import com.example.demo.Entity.Complaint;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ComplaintRepository;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.catalina.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    //Save the uploaded file to this folder

    private static String UPLOADED_FOLDER = "C://School//Divulgo_Uploads//";

    public static byte[] readFileToByteArray(File file) throws IOException {
        return null;
    }

    @CrossOrigin(origins = {"http://192.168.1.2:8100","file://"})
    @PostMapping(value="/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam(name="ionicfile") MultipartFile file,
                                   @RequestParam(name="user_id") Long user_id,
                                   @RequestParam(name="user_complaint") String user_complaint,
                                   @RequestParam(name="lat") Double lat,
                                   @RequestParam(name="long") Double lng,
                                   Complaint complaint,
                                   RedirectAttributes redirectAttributes) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
//        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String dateee = formatter.format(date);
        String time = formatter2.format(date);
        System.out.println("-----------------FILE UPLOAD-----------------");

        complaint.setUserId(user_id);
        complaint.setDate(dateee);
        complaint.setTime(time);
        complaint.setUser_complaint(user_complaint);
        complaint.setUser_lat(lat);
        complaint.setUser_long(lng);
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return null;
        }

        try {

            byte[] bytes = file.getBytes();
            String filepath = "C:/School/Divulgo_Uploads/"+file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            complaint.setFile_path(filepath);
            complaintRepository.save(complaint);
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            System.out.println("File Path: "+complaint.getFile_path());
            System.out.println("Complaint Id: "+complaint.getComplaint_id());
            System.out.println("Date: "+complaint.getDate());
            System.out.println("Time: "+complaint.getTime());
            System.out.println("Complaint: "+complaint.getUser_complaint());
            System.out.println("User Latitude: "+complaint.getUser_lat());
            System.out.println("User Longitude: "+complaint.getUser_long());
            System.out.println("User Id: "+complaint.getUserId());
            System.out.println("---------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Get Complaints
    @CrossOrigin(origins = {"http://192.168.1.2:8100","file://"})
    @GetMapping("/complaints/{user_id}")
    public List<Complaint> getComplaintById(@PathVariable(value = "user_id") Long user_id) {
        System.out.println("------------DISPLAYING COMPLAINT-------------");
        System.out.println("RESULT: SUCCESSFULLY DISPLAYED");
        System.out.println("---------------------------------------------");
        return complaintRepository.findByUserId(user_id);
    }


}


