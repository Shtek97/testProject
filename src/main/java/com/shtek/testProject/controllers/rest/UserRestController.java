package com.shtek.testProject.controllers.rest;

import com.shtek.testProject.controllers.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private List<User> USERS = Stream.of(
            new User(1L,"Ivan", "Ivanov"),
            new User(2L,"Sergey", "Sergeev"),
            new User(3L,"Petr", "Petrov")
    ).collect(Collectors.toList());

    @GetMapping
    public List
}
