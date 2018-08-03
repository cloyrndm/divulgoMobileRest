package com.example.demo.Controller;

import com.example.demo.Entity.Complaint;
import com.example.demo.Repository.ComplaintRepository;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;

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

    public static byte[] readFileToByteArray(File file) throws IOException {
        return null;
    }
//    @PostMapping("/complaints")
//    @CrossOrigin(origins = {"http://192.168.1.4","file://"})
//    public Complaint createComplaint(@RequestBody @Valid Complaint complaint){
//        System.out.println("I GOT IN THE COMPLAINT CONTROLLER");
//        return complaintRepository.save(complaint);
//    }

//    @RequesMapping(value = "/submitComplaints",consumes = {"multipart/form-data"},method = RequestMethod.POST)
//    @ResponseBody
//    public Complaint uploadFile(
//            @RequestParam("uploadfile") MultipartFile uploadfile, @RequestBody @Valid Complaint complaint) {
//        try {
//            System.out.println("GOT INSIDE THE SUBMIT COMPLAINTS");
//            // Get the filename and build the local file path (be sure that the
//            // application have write permissions on such directory)
//            String filename = uploadfile.getOriginalFilename();
//            String directory = "/var/divulgo/uploads";
//            String filepath = Paths.get(directory, filename).toString();
//            complaint.setFile_path(filepath);
//            // Save the file locally
//            BufferedOutputStream stream =
//                    new BufferedOutputStream(new FileOutputStream(filepath));
//            stream.write(uploadfile.getBytes());
//            stream.close();
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return complaintRepository.save(complaint);
//    } // method uploadFile

    @RequestMapping(value = "/uploadSingleFile", method = RequestMethod.POST)
    public String uploadSingleFileHandler(@RequestParam("file") MultipartFile file, @RequestBody @Valid Complaint complaint) {
        //file handling to upload it in the server path
        String filename = file.getOriginalFilename();
        String directory = "/var/divulgo/uploads";
        String filepath = Paths.get(directory, filename).toString();
//        complaint.setFile_path(filepath);

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(filepath)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + filename + "!";
            } catch (Exception e) {
                return "You failed to upload " + filename + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + filename + " because the file was empty.";
        }

    }

//    @RequestMapping(value = "/complaints", method=RequestMethod.GET, produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
//    public Complaint createComplaint(@RequestParam(value = "file") MultipartFile fileone, HttpServletResponse response, @RequestBody @Valid Complaint complaint) throws Exception {
////        ClassPathResource imgFile = new ClassPathResource("image/file");
////        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//////        complaint.setContentType(fileone.getBytes());
////        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
//        return complaintRepository.save(complaint);
//    }

    // Get Complaints
//    @GetMapping("/complaints/{user_id}")
//    public List<Complaint> getComplaintById(@PathVariable(value = "user_id") Long user_id) {
//
//            return complaintRepository.findByUserId(user_id);
//
//    }

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


