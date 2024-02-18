package com.busRev.controller;

import com.busRev.exception.LoginException;
import com.busRev.model.CurrentUserSession;
import com.busRev.model.UserLoginDTO;
import com.busRev.service.UserLoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/busRev/")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("user/login")
    public ResponseEntity<CurrentUserSession> logInUser(@Valid @RequestBody UserLoginDTO loginDTO) throws LoginException {
        CurrentUserSession currentUserSession = userLoginService.userLogin(loginDTO);
        return new ResponseEntity<CurrentUserSession>(currentUserSession, HttpStatus.ACCEPTED );
    }

    @PostMapping("user/logout")
    public String logoutUser(@RequestParam(required = false) String key) throws LoginException {
        return userLoginService.userLogout(key);
    }

}
