package com.stackroute.User.controller;

import com.stackroute.User.exception.UserAlreadyExistException;
import com.stackroute.User.model.User;
import com.stackroute.User.service.JWTTokenGenerator;
import com.stackroute.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-app")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTTokenGenerator jwtTokenGenerator;

    //http://localhost:0101/auth-app/register-user
    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistException {
        user.setRole("ROLE_USER");
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
    }

    //http://localhost:1010/auth-app/check-login
    @PostMapping("/check-login")
    private ResponseEntity<?> loginUser(@RequestBody User user){
        User result=userService.loginCheck(user.getEmailId(), user.getPassword());
        System.out.println(result);
        if (result!=null){
            result.setPassword("");
//            return new ResponseEntity<>(result,HttpStatus.OK);
            return new ResponseEntity<>(jwtTokenGenerator.generateJwt(result),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Login failed",HttpStatus.OK);
        }
    }
}
