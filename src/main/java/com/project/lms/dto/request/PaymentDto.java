package com.project.lms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {

    private int student;

    private int course;

    private Date date;

    private double amount;
}
