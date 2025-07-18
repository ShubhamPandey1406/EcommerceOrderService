package com.pm.EccommerceOrderService.service;

import com.pm.EccommerceOrderService.dto.CreateOrderResponseDTO;
import com.pm.EccommerceOrderService.dto.OrderRequestDTO;

public interface IOrderService {

    CreateOrderResponseDTO createOrder(OrderRequestDTO dto);
}
