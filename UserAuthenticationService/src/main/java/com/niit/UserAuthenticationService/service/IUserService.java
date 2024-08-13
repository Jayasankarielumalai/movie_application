package com.niit.UserAuthenticationService.service;


import com.niit.UserAuthenticationService.domain.User;
import com.niit.UserAuthenticationService.exception.InvalidCredentialsException;
import com.niit.UserAuthenticationService.exception.UserAlreadyExistsException;

public interface IUserService {
    User saveUser(User user) throws UserAlreadyExistsException;
    User getUserByUserIdAndPassword(String userId, String password) throws InvalidCredentialsException;
}
