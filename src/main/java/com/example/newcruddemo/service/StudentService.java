package com.example.newcruddemo.service;


import com.example.newcruddemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private Long nextId = 1L;

    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }

    public Student getById(Long id) {
        return studentMap.get(id);
    }

    public Student create(Student student) {
        student.setId(nextId++);
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student update(Long id, Student updated) {
        if (studentMap.containsKey(id)) {
            updated.setId(id);
            studentMap.put(id, updated);
            return updated;
        }
        return null;
    }

    public boolean delete(Long id) {
        return studentMap.remove(id) != null;
    }
}

