package com.proacscent.demo.controllers;

import com.proacscent.demo.entities.ApplicationUser;
import com.proacscent.demo.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @PostMapping()
    public String registerUser(@RequestBody ApplicationUser applicationUser) {

        ApplicationUser user = applicationUserRepository.findByEmail(applicationUser.getEmail());
        if (user == null) {
            applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
            applicationUserRepository.save(applicationUser);
            return applicationUser.getFirstName() + " " + applicationUser.getLastName() + " registered successfully";
        }
        else {
            return null;
        }

    }
}
