package com.busRev.service;

import com.busRev.exception.AdminException;
import com.busRev.exception.LoginException;
import com.busRev.model.AdminLoginDTO;
import com.busRev.model.CurrentAdminSession;

public interface AdminLoginService {
    public CurrentAdminSession adminLogin(AdminLoginDTO loginDTO) throws LoginException, AdminException;
    public String adminLogout(String key) throws LoginException;
}
