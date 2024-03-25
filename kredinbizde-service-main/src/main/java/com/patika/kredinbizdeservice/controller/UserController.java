package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.service.IApplicationService;
import com.patika.kredinbizdeservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IApplicationService applicationService;

    @Autowired
    public UserController(IUserService userService, IApplicationService applicationService) {

        this.userService = userService;
        this.applicationService = applicationService;
    }

    // create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        System.out.println("userService: " + userService.hashCode());
        return userService.save(user);
    }
    /*
    {
        "name": "John",
        "surname": "Doe",
        "email": "john.doe@example.com",
        "password": "password123",
        "phoneNumber": "12345",
    }
     */

    /*
    get all users
     */
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> update(@PathVariable String email, @RequestBody User user) {

        User user1 = userService.update(email, user);

        if (user1 != null){
            return ResponseEntity.ok().body(user1);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{email}/applications")
    public ResponseEntity<List<Application>> getApplicationsByEmail(@PathVariable String email) {
        User user1 = userService.getByEmail(email);

        if (user1 == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(user1.getApplicationList());
        }

    }

    @PostMapping("/{email}/applications")
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
    }


   /* @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }*/
}
