package com.undoschool.course_serach;

import com.undoschool.course_serach.service.CourseIndexService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseSerachApplication implements CommandLineRunner {

	private final CourseIndexService courseIndexService;

	public CourseSerachApplication(CourseIndexService courseIndexService) {
		this.courseIndexService = courseIndexService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseSerachApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		courseIndexService.indexCourses();
	}
}
