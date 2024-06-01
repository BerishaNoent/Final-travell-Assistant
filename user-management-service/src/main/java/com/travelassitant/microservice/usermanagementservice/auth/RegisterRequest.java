package com.travelassitant.microservice.usermanagementservice.auth;

import com.travelassitant.microservice.usermanagementservice.bean.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private Role role;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String country;
    private String city;
    private String address;
    private String DateOfBirth;

}
