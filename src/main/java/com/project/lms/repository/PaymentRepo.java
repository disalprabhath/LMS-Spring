package com.project.lms.repository;

import com.project.lms.entity.Payments;
import com.project.lms.entity.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface PaymentRepo extends JpaRepository<Payments,Integer> {

    PaymentStatus findPaymentsByPaymentStatus(PaymentStatus paymentStatus);
}
