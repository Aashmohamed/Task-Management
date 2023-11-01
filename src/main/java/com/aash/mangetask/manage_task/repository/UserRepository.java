package com.aash.mangetask.manage_task.repository;

import com.aash.mangetask.manage_task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
