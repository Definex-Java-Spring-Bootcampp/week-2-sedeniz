package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.service.ApplicationService;
import com.patika.kredinbizdeservice.service.IApplicationService;
import com.patika.kredinbizdeservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService; // Implement this service

    @Autowired
    private IUserService userService;

    /*@PostMapping("/{email}")
    public ResponseEntity<Application> createApplicationForUser(@PathVariable String email, @RequestBody Application application) {
        User user = userService.getByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println("Creating application for: " + user.getName());

        // Set the application's user to the user from the email in the endpoint
        application.setUser(user);

        // Save the application
        Application savedApplication = applicationService.save(application);

        // Add the application to the user's list of applications
        List<Application> applications = user.getApplicationList();
        if (applications == null) {
            applications = new ArrayList<>();
            user.setApplicationList(applications);
        }
        applications.add(savedApplication);
        userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplication);
    }*/
}

