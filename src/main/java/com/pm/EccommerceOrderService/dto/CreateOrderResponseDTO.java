package com.pm.EccommerceOrderService.dto;

import com.pm.EccommerceOrderService.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderResponseDTO {

    private Long orderId;
    private OrderStatus status;

}
