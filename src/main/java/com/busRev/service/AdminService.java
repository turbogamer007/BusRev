package com.busRev.service;

import com.busRev.exception.AdminException;
import com.busRev.model.Admin;

public interface AdminService {
    public Admin createAdmin(Admin admin) throws AdminException;
    public Admin updateAdmin(Admin admin, String key) throws AdminException;
}
