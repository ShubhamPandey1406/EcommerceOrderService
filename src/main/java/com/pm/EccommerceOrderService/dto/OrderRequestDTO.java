package com.pm.EccommerceOrderService.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDTO {
    private Long userId;
    private List<OrderItemDTO> items;

}
