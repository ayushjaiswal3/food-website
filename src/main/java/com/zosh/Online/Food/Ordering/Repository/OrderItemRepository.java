package com.zosh.Online.Food.Ordering.Repository;

import com.zosh.Online.Food.Ordering.model.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Orderitem,Long> {
}
