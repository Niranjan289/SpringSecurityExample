package com.niru.service;

import com.niru.model.UserPrincipal;
import com.niru.model.Users;
import com.niru.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUserName(username);

        if(user == null) {
            System.out.println("User not found.!");
            throw new UsernameNotFoundException("User Not Found.!");
        } 

        return new UserPrincipal(user);
    }
}
