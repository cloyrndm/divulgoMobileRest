//package com.example.demo.Controller;
//
//import com.example.demo.Entity.FileModel;
//import com.example.demo.Repository.FileDAO;
//import com.example.demo.Repository.FileRepository;
////import com.example.demo.Service.FileStorageService;
//import com.example.demo.payload.UploadFileResponse;
//import org.hibernate.Hibernate;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.io.IOException;
//import java.sql.Blob;
//
///**
// * Created by Cloie Andrea on 16/07/2018.
// */
//@RestController
//@RequestMapping("/apithree")
//public class UploadFileController {
//
//    @Autowired
//    private FileDAO documentDao;
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute("document") FileModel document,
////                       @RequestParam("file") MultipartFile file) {
////        SessionFactory sessionfactory;
////        sessionfactory = new Configuration().configure()
////                .buildSessionFactory();
////        System.out.println("Name:" + document.getFileName());
//////        System.out.println("Desc:" + document.getDescription());
//////        System.out.println("File:" + file.getName());
//////        System.out.println("ContentType:" + file.getContentType());
////
////        try {
////            Blob blob = Hibernate.getLobCreator(sessionfactory.getCurrentSession()).createBlob(file.getInputStream());
////
////            document.setFileName(file.getOriginalFilename());
////            document.setFileType(file.getContentType());
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        try {
////            documentDao.save(document);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        return "redirect:/index.html";
////    }
////       @PostMapping
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        Account account = accountRepository.findByUsername(username);
////        if(account != null) {
////            return new User(account.getUsername(), account.getPassword(), true, true, true, true,
////                    AuthorityUtils.createAuthorityList("USER"));
////        } else {
////            throw new UsernameNotFoundException("could not find the user '"
////                    + username + "'");
////        }
////    }
//
//}
