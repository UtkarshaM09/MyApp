package com.stackroute.UserProduct.service;

import com.stackroute.UserProduct.exception.UserAlreadyExistException;
import com.stackroute.UserProduct.model.Product;
import com.stackroute.UserProduct.model.User;

import java.util.List;

public interface UserProductService {
    public abstract User addUserProduct(User user)throws UserAlreadyExistException;
//    public abstract List<User> getUserDetails();

    public abstract User getUserByEmail(String eid);

    public abstract User addProductByEmail(Product product,String eid);
    //add product in logged user only
}
