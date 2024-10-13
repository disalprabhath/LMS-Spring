package com.project.lms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {

    private String courseTitle;

    private String courseDec;

    private int lecture;

    private Date date;

    private double price;

}
