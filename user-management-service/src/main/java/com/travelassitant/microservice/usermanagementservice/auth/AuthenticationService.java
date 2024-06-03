package com.travelassitant.microservice.usermanagementservice.auth;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.travelassitant.microservice.usermanagementservice.bean.Role;
import com.travelassitant.microservice.usermanagementservice.bean.User;
import com.travelassitant.microservice.usermanagementservice.config.JwtService;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

  private final UserRepository repository;

  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;

  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    Optional<User> existingUser = repository.findByUsername(request.getUsername());
    if (existingUser.isPresent()) {
      throw new RuntimeException("Username already taken");
    }
    var user = User.builder()
        .username(request.getUsername())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .name(request.getName())
        .surname(request.getSurname())
        .phoneNumber(request.getPhoneNumber())
        .country(request.getCountry())
        .city(request.getCity())
        .address(request.getAddress())
        .DateOfBirth(request.getDateOfBirth())
        .role(Role.ADMIN)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(jwtToken)
        .userId(user.getId())
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    User user = repository.findByUsername(request.getUsername())
        .orElseThrow(() -> new IllegalStateException("User not found"));
    String jwtToken = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(jwtToken)
        .userId(user.getId())
        .role(user.getRole().name())
        .email(user.getEmail())
        .username(user.getUsername())
        .phoneNumber(user.getPhoneNumber())
        .country(user.getCountry())
        .city(user.getCity())
        .address(user.getAddress())
        .DateOfBirth(user.getDateOfBirth())
        .name(user.getName())
        .surname(user.getSurname())
        .build();
  }
}
