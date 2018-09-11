package com.example.demo.Controller;

import com.atlis.location.model.impl.Address;
import com.atlis.location.model.impl.MapPoint;
import com.atlis.location.nominatim.NominatimAPI;
import com.example.demo.Entity.Complaint;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ComplaintRepository;
import java.io.File;


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
    private static String UPLOADED_FOLDER = "C://School//Ionic_Projects//divulgo//www//assets//divulgo_uploads//";
//    private static String UPLOADED_FOLDER = "C://divulgo_uploads//";

    public static byte[] readFileToByteArray(File file) throws IOException {
        return null;
    }

    @CrossOrigin(origins = {"http://192.168.1.4:8100","file://"})
    @PostMapping(value="/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam(name="ionicfile") MultipartFile file,
                                   @RequestParam(name="user_id") Long user_id,
                                   @RequestParam(name="user_complaint") String user_complaint,
                                   @RequestParam(name="lat") Double lat,
                                   @RequestParam(name="long") Double lng,
                                   Complaint complaint,
                                   RedirectAttributes redirectAttributes) {
//SUCCEFUL
        System.out.println("HEYYY I GOT INSIDE LE UPLOAAD");

        complaint.setUserId(user_id);
        complaint.setUser_complaint(user_complaint);
        complaint.setUser_lat(lat);
        complaint.setUser_long(lng);
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return null;
        }

        try {

            byte[] bytes = file.getBytes();
            String filepath = "assets/divulgo_uploads/"+file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            complaint.setFile_path(filepath);
            complaintRepository.save(complaint);
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            System.out.println(complaint.getFile_path());
            System.out.println(complaint.getComplaint_id());
            System.out.println(complaint.getUser_complaint());
            System.out.println(complaint.getUser_lat());
            System.out.println(complaint.getUser_long());
            System.out.println(complaint.getUserId());
            System.out.println("---------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

//        @CrossOrigin(origins = {"http://172.20.10.13:8100","file://"})
//    @PostMapping(value="/upload") // //new annotation since 4.3
//    public String singleFileUpload(@RequestParam(name="imggg") MultipartFile file,@Valid @RequestBody Complaint complaint,
//                                   RedirectAttributes redirectAttributes
//    ) {
////
//        System.out.println("HEYYY I GOT INSIDE LE UPLOAAD");
////        Double lat = new Double("10.279802");
////        Double lng = new Double ("123.851613");
////        String endpointUrl = "https://nominatim.openstreetmap.org/";
////        complaint.setUser_lat(lat);
////        complaint.setUser_long(lng);
////        complaint.setUser_location("cebu");
////        MapPoint mapPoint = new MapPoint().buildMapPoint(lat, lng);
////        Address address = NominatimAPI.with(endpointUrl).getAddressFromMapPoint(mapPoint);
////        System.out.printlnionic cordova("THIS IS TH EADDRE"+address.getCity());
////        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
////        try {
////            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
////            Address obj = addresses.get(0);
////
////            String add = obj.getAddressLine(0);
////            add = add + "," + obj.getAdminArea();
////            add = add + "," + obj.getCountryName();
////
////            return add;
////        } catch (IOException e) {
////            e.printStackTrace();
////            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
////            return null;
////        }
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return null;
//        }
//
//        try {
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            String filepath = "assets/divulgo_uploads/"+file.getOriginalFilename();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//            complaint.setFile_path(filepath);
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//            //reverse geocoding
////          complaint.setUser_lat(lat);
////          complaint.setUser_long(lng);
//            complaintRepository.save(complaint);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    // Get Complaints
    @CrossOrigin(origins = {"http://192.168.1.4:8100","file://"})
    @GetMapping("/complaints/{user_id}")
    public List<Complaint> getComplaintById(@PathVariable(value = "user_id") Long user_id) {
        System.out.println("Got complaint by Id");
        System.out.println("---------------------------------------------");
        return complaintRepository.findByUserId(user_id);
    }


}


