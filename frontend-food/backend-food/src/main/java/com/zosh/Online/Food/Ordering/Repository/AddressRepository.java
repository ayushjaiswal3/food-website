package com.zosh.Online.Food.Ordering.Repository;

import com.zosh.Online.Food.Ordering.model.Address;
import com.zosh.Online.Food.Ordering.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByUser(User user);

}
