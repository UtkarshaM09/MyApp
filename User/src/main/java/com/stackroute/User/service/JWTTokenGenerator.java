package com.stackroute.User.service;

import com.stackroute.User.model.User;

import java.util.Map;

public interface JWTTokenGenerator {
    public abstract Map<String,String> generateJwt(User user);
}
