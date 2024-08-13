package com.niit.UserAuthenticationService.service;

import com.niit.UserAuthenticationService.domain.User;
import com.niit.UserAuthenticationService.exception.InvalidCredentialsException;
import com.niit.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.UserAuthenticationService.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    IUserRepository iUserRepository;

    @Autowired
    public UserServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if (iUserRepository.findById(user.getUserId()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        return iUserRepository.save(user);
    }

    @Override
    public User getUserByUserIdAndPassword(String userId, String password) throws InvalidCredentialsException {
        User user=iUserRepository.findByUserIdAndPassword(userId, password);
        if (user==null){
            throw new InvalidCredentialsException();
        }
        return user;
    }
}
