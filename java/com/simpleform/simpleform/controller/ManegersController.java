package com.simpleform.simpleform.controller;


import com.simpleform.simpleform.model.ManegersModel;
import com.simpleform.simpleform.service.ManegersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManegersController {
    @Autowired
    private final ManegersService manegersService;


    public ManegersController(ManegersService manegersService) {
        this.manegersService = manegersService;
    }

    @GetMapping("/manegers")
    public String getManegersPage(Model model){
        model.addAttribute("manegersRequest",new ManegersModel());
        return "maneger/manegers";
    }

    @PostMapping("/manegers")
    public String login(@ModelAttribute ManegersModel manegersModel, Model model){
        System.out.println("maneger request: " + manegersModel);
        ManegersModel authenticated =  manegersService.authenticate(manegersModel.getLogin(), manegersModel.getPassword());
        if (authenticated != null){
            model.addAttribute("userLogin", authenticated.getLogin());
            return "maneger/manegers_page";
        }else{
            return "error/error_page";
        }
    }
}
