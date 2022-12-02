package com.simpleform.simpleform.repository;

import com.simpleform.simpleform.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminsRepository extends JpaRepository<AdminModel, Integer> {
    Optional<AdminModel> findByLoginAndPassword(String login, String password);
    Optional<AdminModel> findFirstByLogin(String login);
}
