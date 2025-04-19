package com.zosh.Online.Food.Ordering.service;

import com.zosh.Online.Food.Ordering.Repository.AddressRepository;
import com.zosh.Online.Food.Ordering.model.Address;
import com.zosh.Online.Food.Ordering.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getUserAddresses(User user) {
        return addressRepository.findByUser(user);
    }

    @Override
    public void deleteAddress(Long addressId, User user) throws Exception {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new Exception("Address not found with id: " + addressId));

        // Ensure the address belongs to the user
        if (!address.getUser().getId().equals(user.getId())) {
            throw new Exception("You are not authorized to delete this address.");
        }

        addressRepository.delete(address);
    }
}