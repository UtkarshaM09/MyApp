package com.stackroute.User.service;

import com.stackroute.User.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JWTTokenGeneratorImpl implements JWTTokenGenerator{
    @Override
    public Map<String, String> generateJwt(User user) {
//        String jwtExpirationInMs= String.valueOf(10);
        Map<String,String> result=new HashMap<String,String>();
        Map<String,Object> userData=new HashMap<>();
        userData.put("emilId",user.getEmailId());
        userData.put("password",user.getPassword());

        String jwt= Jwts.builder()
                .setClaims(userData)
                .setIssuedAt(new Date())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 25000))
                .setIssuer("MyCompany")
                .signWith(SignatureAlgorithm.HS512,"idontsay")
                .compact();
        result.put("token",jwt);
        result.put("message","Login Success,Token Generated");
        return result;
    }
}
