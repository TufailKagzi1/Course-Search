package com.undoschool.course_serach.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.undoschool.course_serach.document.Course;
import com.undoschool.course_serach.repository.CourseRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseIndexService {

    private final CourseRepository courseRepository;
    private final ObjectMapper objectMapper;

    public void indexCourses(){
        try {
            InputStream inputStream = new ClassPathResource("sample-courses.json").getInputStream();
            List<Course> courses = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            courseRepository.saveAll(courses);
            System.out.println("Indexed "+courses.size()+" courses");
        } catch (Exception e) {
            System.out.println("Failed to index course : "+e.getMessage());
        }
    }
}
