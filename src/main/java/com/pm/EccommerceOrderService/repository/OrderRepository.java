package com.pm.EccommerceOrderService.repository;

import com.pm.EccommerceOrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {
}
