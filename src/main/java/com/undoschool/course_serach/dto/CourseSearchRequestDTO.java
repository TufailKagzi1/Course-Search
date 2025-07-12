package com.undoschool.course_serach.dto;

import lombok.Data;

@Data
public class CourseSearchRequestDTO {
    // search keyword
    private String q;
    private Integer minAge;
    private Integer maxAge;
    private Double minPrice;
    private Double maxPrice;
    private String category;
    private String type;
    private String startDate; // ISO-8601
    private String sort; // priceAsc, priceDesc, upcoming
    private Integer page = 0;
    private Integer size = 10;
}
