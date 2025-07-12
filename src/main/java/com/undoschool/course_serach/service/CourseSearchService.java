package com.undoschool.course_serach.service;

import com.undoschool.course_serach.document.Course;
import com.undoschool.course_serach.dto.CourseSearchRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseSearchService {

    private final ElasticsearchTemplate elasticsearchTemplate;

    public List<Course> searchCourse(CourseSearchRequestDTO req){
        Criteria criteria = new Criteria();

        if (req.getQ() != null && !req.getQ().isEmpty()) {
            criteria = criteria.and(new Criteria("title").matches(req.getQ()))
                    .or(new Criteria("description").matches(req.getQ()));
        }

        if (req.getCategory() != null) {
            criteria = criteria.and(new Criteria("category").is(req.getCategory()));
        }

        if (req.getType() != null) {
            criteria = criteria.and(new Criteria("type").is(req.getType()));
        }

        if (req.getMinPrice() != null || req.getMaxPrice() != null) {
            Criteria priceCriteria = new Criteria("price");
            if (req.getMinPrice() != null) priceCriteria = priceCriteria.greaterThanEqual(req.getMinPrice());
            if (req.getMaxPrice() != null) priceCriteria = priceCriteria.lessThanEqual(req.getMaxPrice());
            criteria = criteria.and(priceCriteria);
        }

        PageRequest page = PageRequest.of(req.getPage(), req.getSize());
        CriteriaQuery query = new CriteriaQuery(criteria,page);

        SearchHits<Course> hits = elasticsearchTemplate.search(query, Course.class);
        return hits.getSearchHits().stream().map(hit->hit   .getContent()).collect(Collectors.toList());
    }
}
