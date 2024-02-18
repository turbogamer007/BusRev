package com.busRev.service;

import com.busRev.exception.LoginException;
import com.busRev.model.CurrentUserSession;
import com.busRev.model.UserLoginDTO;

public interface UserLoginService {
    public CurrentUserSession userLogin(UserLoginDTO userLoginDTO) throws LoginException;
    public String userLogout(String key) throws LoginException;
}
