package com.simpleform.simpleform.service;

import com.simpleform.simpleform.model.ManegersModel;
import com.simpleform.simpleform.repository.ManagersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManegersService {

    @Autowired
    private final ManagersRepository managersRepository;

    public ManegersService(ManagersRepository managersRepository) {
        this.managersRepository = managersRepository;
    }

    public ManegersModel registerUser(String email, String login, String password){
        if(login != null && password !=null){
            return null;
        }else{
            if (managersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate login");
                return null;
            }
            ManegersModel manegersModel = new ManegersModel();
            manegersModel.setEmail(email);
            manegersModel.setLogin(login);
            manegersModel.setPassword(password);
            return managersRepository.save(manegersModel);
        }
    }

    public ManegersModel authenticate(String login, String password){
        return managersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
