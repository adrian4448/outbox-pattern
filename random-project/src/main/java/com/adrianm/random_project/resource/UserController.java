package com.adrianm.random_project.resource;

import com.adrianm.random_project.model.User;
import com.adrianm.random_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController implements UserResource {

    private final UserService userService;

    @Override
    public User create(User user) {
        return userService.createUser(user);
    }
}
