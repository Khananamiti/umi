package com.github.khananamiti.umi.api;

import com.github.khananamiti.umi.api.dto.AuthRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String main() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/authorization")
    public String authorization(Model model) {
        model.addAttribute("authRequest", new AuthRequest());
        return "authorization";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/guarantee")
    public String guarantee() {
        return "guarantee";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/shipping_payment")
    public String shippingAndPayment() {
        return "shipping_payment";
    }
}
