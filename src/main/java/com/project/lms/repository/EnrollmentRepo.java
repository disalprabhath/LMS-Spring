package com.project.lms.repository;

import com.project.lms.entity.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EnrollmentRepo extends JpaRepository<StudentEnrollment, Integer> {
}