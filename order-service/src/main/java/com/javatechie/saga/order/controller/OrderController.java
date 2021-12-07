package com.javatechie.saga.order.controller;

import com.javatechie.saga.commons.dto.OrderRequestDto;
import com.javatechie.saga.order.entity.PurchaseOrder;
import com.javatechie.saga.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto res) {
        return orderService.createOrder(res);
    }

    @GetMapping
    public List<PurchaseOrder> getOrders() {
        return orderService.getAllOrders();
    }
}
