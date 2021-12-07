package com.javatechie.saga.commons.event;

import com.javatechie.saga.commons.dto.OrderRequestDto;
import com.javatechie.saga.commons.enums.OrderStatus;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEvent extends Event {

    private OrderRequestDto orderRequestDto;
    private OrderStatus orderStatus;
}
