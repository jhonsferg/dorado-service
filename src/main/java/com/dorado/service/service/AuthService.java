package com.dorado.service.service;

import com.dorado.service.dto.auth.JwtResponse;
import com.dorado.service.dto.auth.LoginRequest;
import com.dorado.service.model.security.User;
import com.dorado.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<JwtResponse> login(LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByUsername(loginRequest.getUsername());

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (user.isActive() && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                String token = jwtService.generateToken(user.getUsername());
                userRepository.updateLastLogin(user.getUsername());

                return Optional.of(new JwtResponse(
                        token,
                        user.getId(),
                        user.getUsername(),
                        user.getFullName(),
                        user.getEmail(),
                        user.getRoles(),
                        user.getBranchId()
                ));
            }
        }

        return Optional.empty();
    }

    public Optional<User> getCurrentUser(String username) {
        return userRepository.findByUsername(username);
    }
}
