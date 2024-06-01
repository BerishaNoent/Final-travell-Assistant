package com.travelassitant.microservice.usermanagementservice.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private String userId;
    private String role;
    private String email;
    private String username;
    private String phoneNumber;
    private String country;
    private String city;
    private String address;
    private String DateOfBirth;
    private String name;
    private String surname;

}
