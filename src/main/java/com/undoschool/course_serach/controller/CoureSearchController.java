package com.undoschool.course_serach.controller;

import com.undoschool.course_serach.document.Course;
import com.undoschool.course_serach.dto.CourseSearchRequestDTO;
import com.undoschool.course_serach.service.CourseSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class CoureSearchController {

    private final CourseSearchService searchService;

    @GetMapping
    public Map<String,Object> search(CourseSearchRequestDTO requestDTO){
        List<Course> result = searchService.searchCourse(requestDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("total", result.size());
        response.put("courses", result);
        return response;
    }

}
