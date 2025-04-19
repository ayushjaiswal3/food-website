package com.zosh.Online.Food.Ordering.response;

import com.zosh.Online.Food.Ordering.model.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;

    private String message;

    private USER_ROLE role;
}
