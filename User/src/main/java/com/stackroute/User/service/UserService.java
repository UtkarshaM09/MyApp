package com.stackroute.User.service;

import com.stackroute.User.exception.UserAlreadyExistException;
import com.stackroute.User.model.User;

public interface UserService {
    public abstract User registerUser(User user)throws UserAlreadyExistException;
    public abstract User loginCheck(String eId,String pwd);
}
