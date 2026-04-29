package com.healthcare.application.controller;

import com.healthcare.application.entity.Patient;
import com.healthcare.application.service.AdminService;
import com.healthcare.application.service.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }
    @GetMapping("/all-patients")
    public List<Patient> getAllPatients(){
        return adminService.findAll();
    }
}
