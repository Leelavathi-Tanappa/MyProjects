package com.org.springboot.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.org.springboot.model.JobPost;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> searchAll(String text) {
        MongoDatabase database = mongoClient.getDatabase("mynosqldb");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        final List<JobPost> posts = new ArrayList<>();
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                new Document("index", "default")
                .append("text",
                new Document("query", text)
                .append("path", Arrays.asList("desc", "profile", "techs")))),
                new Document("$sort",
                new Document("experience", 1L)),
                new Document("$limit", 5L)));
        result.forEach(doc -> posts.add(converter.read(JobPost.class,doc)));
        return posts;
    }
}
