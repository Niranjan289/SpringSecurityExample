package com.niru.service;

import com.niru.model.Users;
import com.niru.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);  //strength / round value = 12 giving. go to constructor check for it.

    public Users saveRegister(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));  // doing password encode with 12 rounds n 12 square time.
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(user.getUserName());
        }
         return "Fail";
    }
}
