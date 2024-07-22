package com.micro.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public void addStudent(
            @RequestBody Student student
    ) {
        studentService.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
       return studentService.getAllStudents();
    }

    @GetMapping("/school/{school-id}")
    public List<Student> findAllStudents(
            @PathVariable(name = "school-id") Long schoolId
    ) {
        return studentService.findAllStudentsBySchool(schoolId);
    }
}
