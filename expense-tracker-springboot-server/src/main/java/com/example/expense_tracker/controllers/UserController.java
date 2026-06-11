package com.example.expense_tracker.controllers;

import com.example.expense_tracker.entities.User;
import com.example.expense_tracker.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam int userId){
        logger.info("Getting user by id: " + userId);

        Optional<User> userOptional = userService.getUserById(userId);
        if(userOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }
}