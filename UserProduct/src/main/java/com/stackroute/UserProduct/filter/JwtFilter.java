package com.stackroute.UserProduct.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //downcast request and response
        //check authHeader in request
        //get token from authHeader
        //try to parse token: checking whether token valid or not based on shared key (idontsay)
        //parsing gets failed if token is invalid(tampered/expired)/key mismatch
        //if not throwing any exception (parsing is success): forward req to next level

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String authHeader= request.getHeader("authorization");
        //if authHeader is not existing or not carrying Bearer type of token: throw exception saying token missing
        if (authHeader==null || !authHeader.startsWith("Bearer")){
            throw new ServletException("Invalid Exception");
        }else {
            //authHeader existing and carrying the Bearer token
            //authHeader:Bearer hgfrtcytvghjvgugtfuyghjnjh.okijugyf (token)
           String token= authHeader.substring(7);
           //above parsing fails if key is wrong/missing or expired
            //if success then claims variable gets user details
            Claims claims=Jwts.parser().setSigningKey("idontsay").parseClaimsJws(token).getBody();
            System.out.println("\nIn filter,claims "+ claims);
            request.setAttribute("curr_user_emailid",claims.get("emilId"));
            filterChain.doFilter(request,response);

        }
    }
}
