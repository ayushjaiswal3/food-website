package com.zosh.Online.Food.Ordering.controller;


import com.zosh.Online.Food.Ordering.Repository.AddressRepository;
import com.zosh.Online.Food.Ordering.model.Address;
import com.zosh.Online.Food.Ordering.model.User;
import com.zosh.Online.Food.Ordering.service.AddressService;
import com.zosh.Online.Food.Ordering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping()
    public ResponseEntity<List<Address>> getUserAddresses(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Address> addresses = addressService.getUserAddresses(user);
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        address.setUser(user);
        Address saved = addressRepository.save(address);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        addressService.deleteAddress(id, user);
        return new ResponseEntity<>("Address deleted successfully", HttpStatus.OK);
    }


}
