package com.project.lms.entity.tests.quiz;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(nullable = false, length = 1000)
    private String questionText;

    @Type(type = "json")
    @Column(name = "answer_options", columnDefinition = "json")
    private String answerOptions;

    @Column(name = "correct_answer")
    private String corrrectanswer;
}
