package com.micro.school.client;

import com.micro.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.student-service}")
public interface StudentClient {

    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentBySchool(@PathVariable(name = "school-id") Long schoolId);
}
