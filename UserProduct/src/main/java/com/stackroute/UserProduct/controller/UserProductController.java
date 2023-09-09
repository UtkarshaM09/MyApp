package com.stackroute.UserProduct.controller;

import com.stackroute.UserProduct.exception.UserAlreadyExistException;
import com.stackroute.UserProduct.model.Product;
import com.stackroute.UserProduct.model.User;
import com.stackroute.UserProduct.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/product-app")
public class UserProductController {
    @Autowired
    private UserProductService userProductService;

    //http://localhost:1111/product-app/add-user
    @PostMapping("/add-user")
    public ResponseEntity<?> addProduct(@RequestBody User user) throws UserAlreadyExistException {
        user.setProducts(new ArrayList<Product>());
        return new ResponseEntity<>(userProductService.addUserProduct(user), HttpStatus.OK);
    }
//    //http://localhost:1111/get-user-details
//    @GetMapping("/get-user-details")
//    public ResponseEntity<?> getUserDetails(){
//        return new ResponseEntity<>(userProductService.getUserDetails(),HttpStatus.OK);
//    }
    //http://localhost:1111/product-app/get-login-user-details
    @GetMapping("/get-login-user-details")
    public ResponseEntity<?> getUserByEmailId(HttpServletRequest httpServletRequest){

        String current_user_emailid=(String)httpServletRequest.getAttribute("curr_user_emailid");
        System.out.println(current_user_emailid);
        return new ResponseEntity<>(userProductService.getUserByEmail(current_user_emailid),HttpStatus.OK);
    }
    //http://localhost:1111/product-app/add-product-by-login-user
    @PostMapping("/add-product-by-login-user")
    public ResponseEntity<?> addProductByEmail(@RequestBody Product product,HttpServletRequest request){
        String current_user_emailid=(String)request.getAttribute("curr_user_emailid");
        System.out.println(current_user_emailid);
        return new ResponseEntity<>(userProductService.addProductByEmail(product,current_user_emailid),HttpStatus.OK);
    }

}
