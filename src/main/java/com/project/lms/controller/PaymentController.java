package com.project.lms.controller;

import com.project.lms.dto.request.CourseDTO;
import com.project.lms.dto.request.PaymentDto;
import com.project.lms.dto.response.PaymentDetailsDto;
import com.project.lms.dto.response.UserGetDto;
import com.project.lms.service.PaymentService;
import com.project.lms.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "add_payment")
    public ResponseEntity<StandardResponse> addPayment(@RequestBody PaymentDto paymentDto){
        String add=paymentService.addPayment(paymentDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", add),
                HttpStatus.CREATED
        );
    }
    @PostMapping(path = "update_payment/{id}")
    public ResponseEntity<StandardResponse> updatePayment(@PathVariable int id, @RequestBody PaymentDto paymentDto){
        String update=paymentService.updatePayment(id,paymentDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", update),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "get_all_payments")
    public ResponseEntity<StandardResponse> getPayemntDetails(){
        List<PaymentDetailsDto> payments = paymentService.getAllPayments();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", payments),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get_payment_by_id",
                params = "id")
    public ResponseEntity<StandardResponse> getPaymentById(@RequestParam int id){
        PaymentDetailsDto payment=paymentService.getPaymentById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", payment),
                HttpStatus.OK
        );
    }
}
