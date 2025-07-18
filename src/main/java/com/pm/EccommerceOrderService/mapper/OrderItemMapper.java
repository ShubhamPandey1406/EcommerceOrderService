package com.pm.EccommerceOrderService.mapper;

import com.pm.EccommerceOrderService.dto.OrderItemDTO;
import com.pm.EccommerceOrderService.entity.Order;
import com.pm.EccommerceOrderService.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItem toEntity(OrderItemDTO itemDTO, Order order, double pricePerUnit, double totalPrice) {
        return OrderItem.builder()
                .productId(itemDTO.getProductId())
                .quantity(itemDTO.getQuantity())
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }

}
