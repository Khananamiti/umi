package com.github.khananamiti.umi.api;

import com.github.khananamiti.umi.api.dto.AuthRequest;
import com.github.khananamiti.umi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpStatusCodeException;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {
    private final UserService userService;

    @PostMapping("/login")
    public String authRequest(@ModelAttribute("authRequest") AuthRequest authRequest) {
        if (userService.checkAuthentication(authRequest)) {
            return "redirect:/";
        } else {
            // TODO добавить обработку ошибки авторизации
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED) {
                @Override
                public HttpStatusCode getStatusCode() {
                    return super.getStatusCode();
                }
            };
        }
    }
}
