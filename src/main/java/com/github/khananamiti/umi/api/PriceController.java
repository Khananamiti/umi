package com.github.khananamiti.umi.api;

import com.github.khananamiti.umi.api.dto.ResolvePriceRequest;
import com.github.khananamiti.umi.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @PostMapping("/resolvePrice")
    public String resolvePrice(
            @ModelAttribute("resolvePriceRequest") ResolvePriceRequest resolvePriceRequest,
            RedirectAttributes redirectAttributes
    ) {
        final BigDecimal price = priceService.resolvePrice(resolvePriceRequest);
        redirectAttributes.addFlashAttribute("price", price);
        redirectAttributes.addFlashAttribute("resolvePriceRequest", resolvePriceRequest);
        return "redirect:/";
    }
}
