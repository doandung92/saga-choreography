package com.javatechie.saga.order.config;

import com.javatechie.saga.commons.dto.OrderRequestDto;
import com.javatechie.saga.commons.enums.OrderStatus;
import com.javatechie.saga.commons.enums.PaymentStatus;
import com.javatechie.saga.order.entity.PurchaseOrder;
import com.javatechie.saga.order.repository.OrderRepository;
import com.javatechie.saga.order.service.OrderStatusPublisher;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class OrderStatusUpdateHandler {
    private final OrderRepository orderRepository;
    private final OrderStatusPublisher publisher;
    private final MapperFacade mapper;

    @Transactional
    public void updateOrder(int orderId, Consumer<PurchaseOrder> consumer) {
        orderRepository.findById(orderId).ifPresent(consumer.andThen(this::updateOrder));
    }

    private void updateOrder(PurchaseOrder purchaseOrder) {
        boolean isPaymentComplete = PaymentStatus.PAYMENT_COMPLETED.equals(purchaseOrder.getPaymentStatus());
        OrderStatus orderStatus = isPaymentComplete ? OrderStatus.ORDER_COMPLETED : OrderStatus.ORDER_CANCELLED;
        purchaseOrder.setOrderStatus(orderStatus);
        if (!isPaymentComplete) {
            publisher.publishOrderEvent(mapper.map(purchaseOrder, OrderRequestDto.class), orderStatus);
        }
    }
}
