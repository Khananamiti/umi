package com.github.khananamiti.umi.api;

import com.github.khananamiti.umi.api.dto.AuthRequest;
import com.github.khananamiti.umi.api.dto.ResolvePriceRequest;
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
        final String resolvePriceRequestAttribute = "resolvePriceRequest";
        if (model.getAttribute(resolvePriceRequestAttribute) == null) {
            model.addAttribute("resolvePriceRequest", new ResolvePriceRequest());
        }
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String guarantee() {
        return "services";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/authorization")
    public String authorization(Model model) {
        model.addAttribute("authRequest", new AuthRequest());
        return "authorization";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
}
