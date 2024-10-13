package com.project.lms.entity;

import com.project.lms.entity.enums.ContentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course_content")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseContent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "content_id")
    private int ContentId;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type")
    private ContentType contentType = ContentType.STUDY_MATERIAL;

    @Column(name = "content_title",nullable = false)
    private String contentTitle;

    @Column(name = "file_path", nullable = true)
    private String filePath;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date", columnDefinition = "DATETIME")
    private Date date;

    public CourseContent(Course course, ContentType contentType, String contentTitle, String filePath, String description) {
        this.course = course;
        this.contentType = contentType;
        this.contentTitle = contentTitle;
        this.filePath = filePath;
        this.description = description;
    }
}
