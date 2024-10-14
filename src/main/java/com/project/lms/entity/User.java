package com.project.lms.entity;

import com.project.lms.entity.enums.Role;
import com.project.lms.entity.tests.results.EssayResults;
import com.project.lms.entity.tests.results.QuizResults;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "user_name" , nullable = false , length = 500)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role role = Role.Student;

    @Type(type = "json")
    @Column(name = "phone_number",columnDefinition = "json", nullable = false)
    private ArrayList<String> phoneNumber;

    @Column(name = "address")
    private String address;

    //for lectures
    @OneToMany(mappedBy="lecture")
    private Set<Course> courses;

    //for student enrollment
    @OneToMany(mappedBy="student")
    private Set<StudentEnrollment> studentEnrollments;

    //for student payment
    @OneToMany(mappedBy="student")
    private Set<Payments> payments;

    //for student quiz result
    @OneToMany(mappedBy="student")
    private Set<QuizResults> quizResults;

    //for student essay result
    @OneToMany(mappedBy="student")
    private Set<EssayResults> essayResults;

    public User(int userId) {
        this.userId = userId;
    }
}
