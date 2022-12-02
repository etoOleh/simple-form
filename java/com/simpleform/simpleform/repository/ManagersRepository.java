package com.simpleform.simpleform.repository;

import com.simpleform.simpleform.model.ManegersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagersRepository extends JpaRepository<ManegersModel, Integer> {
    Optional<ManegersModel> findByLoginAndPassword(String login, String password);
    Optional<ManegersModel> findFirstByLogin(String login);
}
