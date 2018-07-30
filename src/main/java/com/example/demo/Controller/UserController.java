package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
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
    // @CrossOrigin(origins = {"http://172.17.1.237","file://"})
    //testing purposes only
    @CrossOrigin(origins = {"http://localhost:8100","file://"})
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        System.out.println("I GOT INSIDE THE CREATE USER");
        return userRepository.save(user);
    }

//    @CrossOrigin(origins = {"http://172.17.1.237","file://"})
    //testing purposes only
    @CrossOrigin(origins = {"http://localhost:8100","file://"})
    @RequestMapping("/login")
    public User login(@Valid @RequestBody User user){
        System.out.println("I GOT INSIDE THE LOGIN");

        user = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()) == null) {
            return null;
        }
        return user;
    }


//    @CrossOrigin(origins = {"http://localhost:8100"})
//    @GetMapping("/login")
//    public User login(@Valid @RequestBody User user){
//        System.out.println("I GOT INSIDE THE GET LOGIN");
//        user = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//        if(userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()) == null) {
//            return null;
//        }
//        return user;
//    }
//
//    @GetMapping("/login")
//    public User login(@Valid @RequestBody User user){
//        System.out.println("I GOT IN THE LOGIN");
//
//    }

    // Get a Single User
//    @GetMapping("/users/{id}")
//    public User getUserById(@PathVariable(value = "id") Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//    }

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
