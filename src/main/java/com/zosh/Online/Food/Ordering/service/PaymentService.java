package com.zosh.Online.Food.Ordering.service;

import com.stripe.exception.StripeException;
import com.zosh.Online.Food.Ordering.model.Order;
import com.zosh.Online.Food.Ordering.response.PaymentResponse;

public interface PaymentService {

    public PaymentResponse createPaymentLink(Order order) throws StripeException;

}
