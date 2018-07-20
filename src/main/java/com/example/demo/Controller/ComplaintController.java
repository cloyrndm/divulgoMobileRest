package com.example.demo.Controller;

import com.example.demo.Entity.Complaint;
import com.example.demo.Repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping("/complaints")
    @CrossOrigin(origins = {"http://192.168.1.4","file://"})
    public Complaint createComplaint(@RequestBody @Valid Complaint complaint){
        System.out.println("I GOT IN THE COMPLAINT CONTROLLER");
        return complaintRepository.save(complaint);
    }
}
