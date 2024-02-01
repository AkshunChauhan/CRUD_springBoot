package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Import statements
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// Lombok annotations for generating getters, setters, constructors, and toString method
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    // Fields/attributes of the Employee class

    // Employee ID
    private int id;

    // Employee name
    private String name;

    // Employee address
    private String address;

    // Employee age
    private int age;

    // Since validation annotations are currently commented out,
    // there are no annotations for data validation such as @NotNull or @NotBlank.
}
