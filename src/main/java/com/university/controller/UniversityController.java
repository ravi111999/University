package com.university.controller;

import com.university.entity.Professor;
import com.university.entity.Student;
import com.university.entity.University;
import com.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping
    public University createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @GetMapping
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{universityId}")
    public University getUniversityById(@PathVariable Long universityId) {
        return universityService.getUniversityById(universityId);
    }

    @PostMapping("/{universityId}/professors")
    public Professor createProfessor(@PathVariable Long universityId, @RequestBody Professor professor) {
        return universityService.createProfessor(universityId, professor);
    }

    @GetMapping("/{universityId}/professors")
    public List<Professor> getAllProfessorsByUniversity(@PathVariable Long universityId) {
        return universityService.getAllProfessorsByUniversity(universityId);
    }

    @PostMapping("/{universityId}/students")
    public Student createStudent(@PathVariable Long universityId, @RequestBody Student student) {
        return universityService.createStudent(universityId, student);
    }

    @GetMapping("/{universityId}/students")
    public List<Student> getAllStudentsByUniversity(@PathVariable Long universityId) {
        return universityService.getAllStudentsByUniversity(universityId);
    }
}

