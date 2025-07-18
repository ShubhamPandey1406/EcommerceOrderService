package com.pm.EccommerceOrderService.service;

import com.pm.EccommerceOrderService.clients.ProductServiceClient;
import com.pm.EccommerceOrderService.dto.CreateOrderResponseDTO;
import com.pm.EccommerceOrderService.dto.OrderItemDTO;
import com.pm.EccommerceOrderService.dto.OrderRequestDTO;
import com.pm.EccommerceOrderService.dto.ProductDTO;
import com.pm.EccommerceOrderService.entity.Order;
import com.pm.EccommerceOrderService.entity.OrderItem;
import com.pm.EccommerceOrderService.enums.OrderStatus;
import com.pm.EccommerceOrderService.mapper.OrderItemMapper;
import com.pm.EccommerceOrderService.mapper.OrderMapper;
import com.pm.EccommerceOrderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;

    private final ProductServiceClient productServiceClient;

    public OrderService(OrderRepository orderRepository,ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient=productServiceClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO dto) {

        //Persist the order in OrderTable.

        Order order= OrderMapper.toEntity(dto);


//        Order order= new Order();
//        order.setUserId(dto.getUserId());
//        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> items= new ArrayList<>();

        //We will be getting OrderItemDto so we need to traverse on
        //them and convert them into entity and we need to calculate
        //price of the order

        for(OrderItemDTO itemDTO:dto.getItems())
        {
            ProductDTO product=productServiceClient.getProductById(itemDTO.getProductId());
            double pricePerUnit=product.getPrice();
            double totalPrice=pricePerUnit * itemDTO.getQuantity();
            OrderItem item= OrderItemMapper.toEntity(
                 itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );
            items.add(item);
        }

        order.setItems(items);
        Order createdOrder= orderRepository.save(order);

        return OrderMapper.toCreateOrderResponseDTO(createdOrder);






    }
}
