package com.shtek.testProject.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
}
