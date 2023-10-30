//package com.example.hookah.in;
//
//import com.example.hookah.model.Coals;
//import com.example.hookah.model.Tobacco;
//import com.example.hookah.service.AdminServiceImpl;
//import com.example.hookah.service.HookahBaseServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
/*
*class for autocomplete initial table
*/
//@Component
//public class In implements CommandLineRunner {
//    private final AdminServiceImpl service;
//    private final HookahBaseServiceImpl hookahBaseService;
//
//    @Autowired
//    public In(AdminServiceImpl service, HookahBaseServiceImpl hookahBaseService) {
//        this.service = service;
//        this.hookahBaseService = hookahBaseService;
//    }
//
//    public void run(String... arg) throws Exception {
//        Admin admin = new Admin("admin", "admin");
//        service.addUser(admin);
//        hookahBaseService.addNewTobacco(new Tobacco("Darkside blackberry", 250));
//        hookahBaseService.addNewCoals(new Coals("Piece coals", 70));
//        hookahBaseService.addNewCoals(new Coals("Pack of 12 coals", 0));
//        hookahBaseService.addNewCoals(new Coals("Pack of 72 coals", 0));
//    }
//}
