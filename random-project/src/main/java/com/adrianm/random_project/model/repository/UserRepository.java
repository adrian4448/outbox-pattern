package com.adrianm.random_project.model.repository;

import com.adrianm.random_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
