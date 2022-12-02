package com.simpleform.simpleform.service;

import com.simpleform.simpleform.model.AdminModel;
import com.simpleform.simpleform.model.ManegersModel;
import com.simpleform.simpleform.repository.AdminsRepository;
import com.simpleform.simpleform.repository.ManagersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private final AdminsRepository adminsRepository;

    public AdminService(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    public AdminModel registerUser(String email, String login, String password){
        if(login != null && password !=null){
            return null;
        }else{
            if (adminsRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate login");
                return null;
            }
            AdminModel adminModel = new AdminModel();
            adminModel.setEmail(email);
            adminModel.setLogin(login);
            adminModel.setPassword(password);
            return adminsRepository.save(adminModel);
        }
    }

    public AdminModel authenticate(String login, String password){
        return adminsRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
