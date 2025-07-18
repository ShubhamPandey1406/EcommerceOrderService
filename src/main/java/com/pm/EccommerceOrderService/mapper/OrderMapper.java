package com.pm.EccommerceOrderService.mapper;

import com.pm.EccommerceOrderService.dto.CreateOrderResponseDTO;
import com.pm.EccommerceOrderService.dto.OrderRequestDTO;
import com.pm.EccommerceOrderService.entity.Order;
import com.pm.EccommerceOrderService.enums.OrderStatus;

public class OrderMapper {

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order order) {
        return CreateOrderResponseDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }


   // Implement By Yourself

    public static Order toEntity(OrderRequestDTO dto)
    {
       return Order.builder()
               .userId(dto.getUserId())
               .status(OrderStatus.PENDING)
               .build();
    }
}
