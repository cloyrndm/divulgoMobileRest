package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Cloie Andrea on 15/07/2018.
 */

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/apitwo")
@ResponseBody
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Get All Users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create a new User
    @CrossOrigin(origins = {"http://192.168.1.4","file://"})
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        System.out.println("I GOT INSIDE THE CREATE USER");
        return userRepository.save(user);
    }

    // Get a Single User
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

//    public User logIn(User user) {
//        user.set
//        return Member;
//    }

//    // Update a User
//    @PutMapping("/users/{id}")
//    public User updateUser(@PathVariable(value = "id") Long userId,
//                           @Valid @RequestBody User userDetails) {
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//
//        user.setTitle(userDetails.getTitle());
//        user.setContent(userDetails.getContent());
//
//        Note updatedNote = userRepository.save(note);
//        return updatedNote;
//    }

//    // Delete a Note
//    @DeleteMapping("/notes/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
//        Note note = userRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        userRepository.delete(note);
//
//        return ResponseEntity.ok().build();
//    }
}
