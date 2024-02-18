package com.busRev.controller;

import com.busRev.exception.AdminException;
import com.busRev.exception.LoginException;
import com.busRev.model.AdminLoginDTO;
import com.busRev.model.CurrentAdminSession;
import com.busRev.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/busRev/")
public class AdminLoginController {

    @Autowired
    private AdminLoginService loginService;

    @PostMapping("admin/login")
    public ResponseEntity<CurrentAdminSession> loginAdmin(@RequestBody AdminLoginDTO loginDTO) throws AdminException, LoginException {
//        System.out.println(loginDTO);
    	CurrentAdminSession currentAdminSession = loginService.adminLogin(loginDTO);
        return new ResponseEntity<>(currentAdminSession, HttpStatus.ACCEPTED);
    }

    @PostMapping("admin/logout")
    public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
        return loginService.adminLogout(key);
    }
}
