package com.zosh.Online.Food.Ordering.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zosh.Online.Food.Ordering.dto.RestaurantDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  //It will automatically generate id in our springboot.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;

    private String password;

    private  USER_ROLE role;



    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();



    @ElementCollection
    private  List<RestaurantDto> Favorites = new ArrayList();

    // This means if you delete a User, all associated Address entries will also be deleted.
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address> addresses = new ArrayList();




}
