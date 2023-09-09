package com.stackroute.User.service;

import com.stackroute.User.exception.UserAlreadyExistException;
import com.stackroute.User.model.User;
import com.stackroute.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUser(User user)throws UserAlreadyExistException {
        if (userRepository.findById(user.getEmailId()).isPresent()){
            throw new UserAlreadyExistException();
        }
       else

        return userRepository.save(user);
    }

    @Override
    public User loginCheck(String eId,String pwd) {

        return userRepository.findByEmailIdAndPassword(eId,pwd);
    }
}
