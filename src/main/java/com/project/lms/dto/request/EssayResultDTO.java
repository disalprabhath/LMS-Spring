package com.project.lms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EssayResultDTO {
    private Long essayId;
    private Long userId;
    private Integer marksObtained;
}
