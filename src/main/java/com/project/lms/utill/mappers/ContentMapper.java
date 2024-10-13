package com.project.lms.utill.mappers;

import com.project.lms.dto.request.CourseContentDTO;
import com.project.lms.entity.CourseContent;
import com.project.lms.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContentMapper {

    CourseContentDTO toCourseContentDTO(CourseContent content);

    CourseContentDTO toCourseDTO(CourseContent content);

    default int map(CourseContent content) {
        return content.getContentId();
    }
}
