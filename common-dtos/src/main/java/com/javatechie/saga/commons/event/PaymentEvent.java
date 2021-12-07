package com.javatechie.saga.commons.event;

import com.javatechie.saga.commons.dto.PaymentRequestDto;
import com.javatechie.saga.commons.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentEvent extends Event {

    private PaymentRequestDto paymentRequestDto;
    private PaymentStatus paymentStatus;
}
