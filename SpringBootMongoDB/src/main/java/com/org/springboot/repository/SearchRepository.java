package com.org.springboot.repository;

import com.org.springboot.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository {
    List<JobPost> searchAll(String text);
}
