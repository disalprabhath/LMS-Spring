package com.project.lms.dto.request;

import com.project.lms.entity.enums.ContentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseContentDTO {

    private int courseId;
    private ContentType contentType;
    private String contentTitle;
    private String filePath;
    private String description;

}
