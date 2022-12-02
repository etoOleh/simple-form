package com.simpleform.simpleform.service;

import com.simpleform.simpleform.model.UsersModel;
import com.simpleform.simpleform.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String email, String login,  String password){
        if(login != null && password !=null){
            return null;
        }else{
            if (usersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate login");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setEmail(email);
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            return usersRepository.save(usersModel);
        }
    }

    public UsersModel authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
