package com.university.service;

import com.university.entity.Professor;
import com.university.entity.Student;
import com.university.entity.University;
import com.university.repository.ProfessorRepository;
import com.university.repository.StudentRepository;
import com.university.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository, ProfessorRepository professorRepository, StudentRepository studentRepository) {
        this.universityRepository = universityRepository;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    public University getUniversityById(Long universityId) {
        return universityRepository.findById(universityId).orElse(null);
    }

    public Professor createProfessor(Long universityId, Professor professor) {
        University university = universityRepository.findById(universityId).orElse(null);
        if (university == null) {
            // Handle the case where the university doesn't exist.
            return null;
        }
        professor.setUniversity(university);
        return professorRepository.save(professor);
    }

    public List<Professor> getAllProfessorsByUniversity(Long universityId) {
        University university = universityRepository.findById(universityId).orElse(null);
        if (university == null) {
            // Handle the case where the university doesn't exist.
            return null;
        }
        return university.getProfessors();
    }

    public Student createStudent(Long universityId, Student student) {
        University university = universityRepository.findById(universityId).orElse(null);
        if (university == null) {
            // Handle the case where the university doesn't exist.
            return null;
        }
        student.setUniversity(university);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudentsByUniversity(Long universityId) {
        University university = universityRepository.findById(universityId).orElse(null);
        if (university == null) {
            // Handle the case where the university doesn't exist.
            return null;
        }
        return university.getStudents();
    }
}

