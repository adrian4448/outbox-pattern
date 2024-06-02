package com.adrianm.random_project.resource;

import com.adrianm.random_project.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserResource {
    @PostMapping
    User create(@RequestBody User user);
}
