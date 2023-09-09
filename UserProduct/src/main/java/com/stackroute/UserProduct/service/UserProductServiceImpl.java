package com.stackroute.UserProduct.service;

import com.stackroute.UserProduct.exception.UserAlreadyExistException;
import com.stackroute.UserProduct.model.Product;
import com.stackroute.UserProduct.model.User;
import com.stackroute.UserProduct.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductServiceImpl implements UserProductService{
    @Autowired
    private UserProductRepository userProductRepository;
    @Override
    public User addUserProduct(User user)throws UserAlreadyExistException {
        if (userProductRepository.findById(user.getEmailId()).isPresent()){
            throw new UserAlreadyExistException();
        }
        return userProductRepository.save(user);
    }

//    @Override
//    public List<User> getUserDetails() {
//        return userProductRepository.findAll();
//    }

    @Override
    public User getUserByEmail(String eid) {
        return userProductRepository.findById(eid).get();
    }

    @Override
    public User addProductByEmail(Product product, String eid) {
        User user=userProductRepository.findById(eid).get();
        // add product object into current logged in user.prodcuts
        // update user back to db
        user.getProducts().add(product);
        return userProductRepository.save(user);
    }


}
