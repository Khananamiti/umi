package com.github.khananamiti.umi.api;

import com.github.khananamiti.umi.api.dto.AuthRequest;
import com.github.khananamiti.umi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {
    private final UserService userService;

    @PostMapping("/login")
    public String authRequest(
        @ModelAttribute("authRequest") AuthRequest authRequest,
        RedirectAttributes redirectAttributes
    ) {
        if (userService.checkAuthentication(authRequest)) {
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("isLoginFailed", true);
            return "redirect:/authorization";
        }
    }
}
