package com.github.khananamiti.umi.service;

import com.github.khananamiti.umi.api.dto.AuthRequest;

public interface UserService {

    boolean checkAuthentication(AuthRequest authRequest);
}
