package com.project.lms.service.impl;

import com.project.lms.dto.request.PaymentDto;
import com.project.lms.dto.response.PaymentDetailsDto;
import com.project.lms.entity.Payments;
import com.project.lms.entity.User;
import com.project.lms.exception.NotFoundException;
import com.project.lms.repository.CourseRepo;
import com.project.lms.repository.PaymentRepo;
import com.project.lms.repository.UserRepo;
import com.project.lms.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentServiceIMPL implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addPayment(PaymentDto paymentDto) {

        Payments payments = new Payments();
        payments.setStudent(userRepo.getReferenceById(paymentDto.getStudent()));
        payments.setCourse(courseRepo.getReferenceById(paymentDto.getCourse()));
        payments.setDate(paymentDto.getDate());
        payments.setAmount(paymentDto.getAmount());

        paymentRepo.save(payments);

        return "Payment added successfully";
    }

    @Override
    public String updatePayment(int id, PaymentDto paymentDto) {
        Payments payments = paymentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));
        payments.setStudent(userRepo.getReferenceById(paymentDto.getStudent()));
        payments.setCourse(courseRepo.getReferenceById(paymentDto.getCourse()));
        payments.setDate(paymentDto.getDate());
        payments.setAmount(paymentDto.getAmount());

        paymentRepo.save(payments);
        return "Payment updated successfully";
    }

    @Override
    public List<PaymentDetailsDto> getAllPayments() {
        List<Payments> getAllPayments=paymentRepo.findAll();
        return getAllPayments.stream()
                .map(payments -> {
                    String userName = userRepo.findById(payments.getStudent().getUserId())
                            .map(user -> user.getUserName())
                            .orElse("Unknown User");

                    String courseName = courseRepo.findById(payments.getCourse().getCourseId())
                            .map(course -> course.getCourseTitle())
                            .orElse("Unknown Course");

                    return new PaymentDetailsDto(
                            payments.getPaymentId(),
                            userName,
                            courseName,
                            payments.getAmount(),
                            payments.getDate()
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDetailsDto getPaymentById(int id) {
        Optional<Payments> paymentOptional = paymentRepo.findById(id);

        if (paymentOptional.isPresent()) {
            Payments payment = paymentOptional.get();


            String userName = userRepo.findById(payment.getStudent().getUserId())
                    .map(user -> user.getUserName())
                    .orElse("Unknown User");

            String courseName = courseRepo.findById(payment.getCourse().getCourseId())
                    .map(course -> course.getCourseTitle())
                    .orElse("Unknown Course");
            return new PaymentDetailsDto(
                    payment.getPaymentId(),
                    userName,
                    courseName,
                    payment.getAmount(),
                    payment.getDate()
            );
        } else {
            throw new NotFoundException("Payment not found for ID: " + id);
    }
    }
}
