package com.github.khananamiti.umi.api;

import com.github.khananamiti.umi.api.dto.AuthRequest;
import com.github.khananamiti.umi.service.CityService;
import com.github.khananamiti.umi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;
    private final CityService cityService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("productGroups", productService.productGroups());
        model.addAttribute("cities", cityService.allCities());
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
