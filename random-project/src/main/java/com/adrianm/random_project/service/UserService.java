package com.adrianm.random_project.service;

import com.adrianm.random_project.model.User;
import com.adrianm.random_project.model.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser(final User user) {
        return userRepository.save(user);
    }
}
