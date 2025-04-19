package com.zosh.Online.Food.Ordering.service;

import com.zosh.Online.Food.Ordering.model.Address;
import com.zosh.Online.Food.Ordering.model.User;

import java.util.List;

public interface AddressService {

    List<Address> getUserAddresses(User user);
    void deleteAddress(Long addressId, User user) throws Exception;

}
