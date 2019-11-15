package sudakova.onlineshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sudakova.onlineshop.dto.request.DiscountRequest;
import sudakova.onlineshop.dto.response.DiscountResponse;
import sudakova.onlineshop.service.DiscountService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;


    @GetMapping("/{id}")
    public DiscountResponse getById(@PathVariable Long id) {
        return discountService.getById(id);
    }

    @PostMapping
    public DiscountResponse save(@RequestBody @Valid DiscountRequest discountRequest) {
        return discountService.save(discountRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody DiscountRequest discountRequest) {
        discountService.update(id, discountRequest);
    }

    @DeleteMapping
    public boolean delete(@RequestParam Long id) {
        return discountService.delete(id);
    }
}
