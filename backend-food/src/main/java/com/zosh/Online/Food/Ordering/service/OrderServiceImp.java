package com.zosh.Online.Food.Ordering.service;

import com.zosh.Online.Food.Ordering.Repository.AddressRepository;
import com.zosh.Online.Food.Ordering.Repository.OrderItemRepository;
import com.zosh.Online.Food.Ordering.Repository.OrderRepository;
import com.zosh.Online.Food.Ordering.Repository.UserRepository;
import com.zosh.Online.Food.Ordering.model.*;
import com.zosh.Online.Food.Ordering.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CartService cartService;

    @Override
    public Order createOrder(OrderRequest order, User user) throws Exception {

        Address shippAddress = order.getDeliveryAddress();
        shippAddress.setUser(user);//SAVEDSOMETHIUNG
        Address savedAddress = addressRepository.save(shippAddress);
//        Address shippAddress = order.getDeliveryAddress();
//        Address orderAddress = new Address();
//        orderAddress.setStreetAddress(shippAddress.getStreetAddress());
//        orderAddress.setCity(shippAddress.getCity());
//        orderAddress.setState(shippAddress.getState());
//        orderAddress.setCountry(shippAddress.getCountry());
//        orderAddress.setPostalCode(shippAddress.getPostalCode());
// You can optionally attach it to the user if you want tracking
        //    orderAddress.setUser(user);

        //    Address savedAddress = addressRepository.save(orderAddress);


        if(!user.getAddresses().contains(savedAddress)) {
            user.getAddresses().add(savedAddress);
            userRepository.save(user);
        }

        Restaurant restaurant = restaurantService.findRestaurantById(order.getRestaurantId());

        Order createdOrder = new Order();
        createdOrder.setCustomer(user);
        createdOrder.setCreateAt(new Date());
        createdOrder.setOrderStatus("PENDING");
        createdOrder.setDeliveryAddress(savedAddress);
        createdOrder.setRestaurant(restaurant);

        Cart cart = cartService.findCartByUserId(user.getId());

        List<Orderitem> orderItems = new ArrayList<>();

        for(CartItem cartItem : cart.getItem()) {
            Orderitem orderItem = new Orderitem();
            orderItem.setFood(cartItem.getFood());
            orderItem.setIngredients(cartItem.getIngredients());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotalPrice(cartItem.getTotalPrice());

            Orderitem savedOrderItem = orderItemRepository.save(orderItem);
            orderItems.add(savedOrderItem);
        }

        Long totalPrice = cartService.calculateCartTotals(cart);

        createdOrder.setItems(orderItems);
        createdOrder.setTotalPrice(totalPrice);

        Order savedOrder = orderRepository.save(createdOrder);
        restaurant.getOrders().add(savedOrder);

        return createdOrder;
    }

    @Override
    public Order updateOrder(Long orderId, String orderStatus) throws Exception {

        Order order = findOrderById(orderId);
        if(orderStatus.equals("OUT_FOR_DELIVERY")
                || orderStatus.equals("DELIVERED")
                || orderStatus.equals("COMPLETED")
                || orderStatus.equals("PENDING")
        ) {
            order.setOrderStatus(orderStatus);
            return orderRepository.save(order);
        }

        throw new Exception("Please select a valid order status");
    }

    @Override
    public void cancelOrder(Long orderId) throws Exception {

        Order order = findOrderById(orderId);
        orderRepository.deleteById(orderId);

    }

    @Override
    public List<Order> getUserOrder(Long userId) throws Exception {
        return orderRepository.findByCustomerId(userId);
    }

    @Override
    public List<Order> getRestaurantOrder(Long restaurantId, String orderStatus) throws Exception {
        List<Order> orders = orderRepository.findByRestaurantId(restaurantId);

        if(orderStatus!=null) {
            orders = orders.stream().filter(order ->
                    order.getOrderStatus().equals(orderStatus)).toList();
        }

        return orders;
    }

    @Override
    public Order findOrderById(Long orderId) throws Exception {

        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if(optionalOrder.isEmpty()) {
            throw new Exception("order not found");
        }

        return optionalOrder.get();
    }
}
