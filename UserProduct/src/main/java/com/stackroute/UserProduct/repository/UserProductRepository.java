package com.stackroute.UserProduct.repository;

import com.stackroute.UserProduct.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProductRepository extends MongoRepository<User,String> {
}
