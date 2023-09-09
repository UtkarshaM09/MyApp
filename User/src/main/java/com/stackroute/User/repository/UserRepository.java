package com.stackroute.User.repository;

import com.stackroute.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    public abstract User findByEmailIdAndPassword(String eId,String pwd);
}
