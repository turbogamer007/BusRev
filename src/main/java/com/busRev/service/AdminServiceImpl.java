package com.busRev.service;

import com.busRev.exception.AdminException;
import com.busRev.model.Admin;
import com.busRev.model.CurrentAdminSession;
import com.busRev.repository.AdminRepository;
import com.busRev.repository.CurrentAdminSessionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CurrentAdminSessionRepository adminSessionRepository;

    @Override
    public Admin createAdmin(Admin admin) throws AdminException{
//        Admin a = adminRepository.findByEmail(admin.getEmail());
        List<Admin> admins = adminRepository.findByEmail(admin.getEmail());
        
        if(!admins.isEmpty()) throw new AdminException("Admin already present with the given email: " + admin.getEmail());
        
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin, String key) throws AdminException {
        CurrentAdminSession adminSession = adminSessionRepository.findByaid(key);
        if(adminSession == null) throw new AdminException("Please enter valid key or login first!");
        if(admin.getAdminID() != adminSession.getAdminID()) throw new AdminException("Invalid admin details, please login for updating admin!");
        return adminRepository.save(admin);
    }
    	
}
