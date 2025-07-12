package com.undoschool.course_serach.repository;

import com.undoschool.course_serach.document.Course;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends ElasticsearchRepository<Course, String> {
}
