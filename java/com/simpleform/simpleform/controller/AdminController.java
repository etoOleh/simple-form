package com.simpleform.simpleform.controller;

import com.simpleform.simpleform.model.AdminModel;
import com.simpleform.simpleform.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model){
        model.addAttribute("adminRequest",new AdminModel());
        return "admin/admins";
    }

    @PostMapping("/admin")
    public String login(@ModelAttribute AdminModel adminModel, Model model){
        System.out.println("admin request: " + adminModel);
        AdminModel authenticated =  adminService.authenticate(adminModel.getLogin(), adminModel.getPassword());
        if (authenticated != null){
            model.addAttribute("userLogin", authenticated.getLogin());
            return "admin/admins_page";
        }else{
            return "error/error_page";
        }
    }
}
