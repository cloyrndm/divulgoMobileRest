package com.example.demo.Controller;

import com.example.demo.Entity.Complaint;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ComplaintRepository;
import java.io.File;

import com.google.code.geocoder.Geocoder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.apache.catalina.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

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

/*    @CrossOrigin(origins = {"http://172.20.10.2:8100","file://"})*/
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestPart Complaint complaint,@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, Context context
                                      ) {
//
        System.out.println("HEYYY I GOT INSIDE LE UPLOAAD");
        Double lat = new Double("10.279802");
        Double lng = new Double ("123.851613");
        complaint.setUser_lat(lat);
        complaint.setUser_long(lng);
        complaint.setUser_location("cebu");

//        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
//        try {
//            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
//            Address obj = addresses.get(0);
//
//            String add = obj.getAddressLine(0);
//            add = add + "," + obj.getAdminArea();
//            add = add + "," + obj.getCountryName();
//
//            return add;
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            return null;
//        }
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return null;
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String filepath = "assets/divulgo_uploads/"+file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            complaint.setFile_path(filepath);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");


            //reverse geocoding
           complaint.setUser_lat(lat);
            complaint.setUser_long(lng);

            complaintRepository.save(complaint);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Get Complaints
    @CrossOrigin(origins = {"http://172.20.10.2:8100","file://"})
    @GetMapping("/complaints/{user_id}")
    public List<Complaint> getComplaintById(@PathVariable(value = "user_id") Long user_id) {
        return complaintRepository.findByUserId(user_id);
    }


}


