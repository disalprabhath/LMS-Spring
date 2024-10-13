package com.project.lms.service;

import com.project.lms.dto.request.PaymentDto;
import com.project.lms.dto.response.PaymentDetailsDto;

import java.util.List;

public interface PaymentService {
    String addPayment(PaymentDto paymentDto);

    String updatePayment(int id, PaymentDto paymentDto);

    List<PaymentDetailsDto> getAllPayments();

    PaymentDetailsDto getPaymentById(int id);
}
