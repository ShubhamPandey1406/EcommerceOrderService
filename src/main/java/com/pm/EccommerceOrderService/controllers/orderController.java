package com.pm.EccommerceOrderService.controllers;

import com.pm.EccommerceOrderService.dto.CreateOrderResponseDTO;
import com.pm.EccommerceOrderService.dto.OrderRequestDTO;
import com.pm.EccommerceOrderService.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class orderController {

    private final IOrderService orderService;

    public orderController(IOrderService orderService)
    {
        this.orderService=orderService;
    }

    //Create order API
@PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request)
    {
        CreateOrderResponseDTO order=orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }
}
