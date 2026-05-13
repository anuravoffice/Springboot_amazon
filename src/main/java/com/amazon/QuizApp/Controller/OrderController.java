package com.amazon.QuizApp.Controller;

import com.amazon.QuizApp.DTO.OrderRequest;
import com.amazon.QuizApp.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody OrderRequest request) {
        orderService.placeOrder(request.getUserId(), request.getProductIds());
        return "Order placed";
    }
}
