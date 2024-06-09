package com.adrianm.random_project.resource;

import com.adrianm.random_project.model.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserResource {
    @PostMapping
    User create(@RequestBody User user);

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id);
}
