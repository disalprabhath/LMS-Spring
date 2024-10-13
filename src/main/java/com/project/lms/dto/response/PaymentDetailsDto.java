package com.project.lms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDetailsDto {

    private int paymentId;
    private String userName;
    private String courseName;
    private double amount;
    private Date date;

}
