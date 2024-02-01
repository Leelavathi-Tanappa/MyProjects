package com.org.springboot.controller;

import com.org.springboot.model.JobPost;
import com.org.springboot.repository.JobPostRepository;
import com.org.springboot.repository.SearchRepository;
import com.org.springboot.repository.SearchRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    JobPostRepository repo;
    @Autowired
    SearchRepositoryImpl srepo;
    @ApiIgnore
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/posts")
    public List<JobPost> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> searchPosts(@PathVariable String text){
        return srepo.searchAll(text);
    }
    @PostMapping("/addpost")
    public JobPost addPost(@RequestBody JobPost jobpost){
        return repo.save(jobpost);
    }
}
