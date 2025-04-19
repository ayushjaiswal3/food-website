package com.zosh.Online.Food.Ordering.service;

import com.zosh.Online.Food.Ordering.model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;
}
