package com.example.restwebservice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Users {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private Integer age;

}
