package com.org.springboot.repository;

import com.org.springboot.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost,String> {
}
