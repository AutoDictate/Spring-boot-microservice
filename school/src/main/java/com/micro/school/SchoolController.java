package com.micro.school;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public void addStudent(
            @RequestBody School school
    ) {
        schoolService.save(school);
    }

    @GetMapping
    public List<School> getAllStudents() {
       return schoolService.getAllSchools();
    }

    @GetMapping("with-students/{school-id}")
    public FullSchoolResponse findAllSchools(
            @PathVariable(name = "school-id") Long schoolId
    ) {
        return schoolService.findSchoolsWithStudents(schoolId);
    }
}
