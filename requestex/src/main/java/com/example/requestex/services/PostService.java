package com.example.requestex.services;

import com.example.requestex.models.PostModel;
import com.example.requestex.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostModel> getPostByViewsGreaterThan(Integer views){
        return postRepository.findByViewsGreaterThan(views);
    }

    public List<PostModel> getAllPosts(){
        return postRepository.findAll();
    }

    public List<PostModel> getPostByViewsLessThan(Integer views){
        return postRepository.findByViewsGreaterThan(views);
    }

    public List<PostModel> getPosts(Specification<PostModel> spec){
        return postRepository.findAll(spec);
    }

    public List<PostModel> getPosts(Specification<PostModel> spec, int start, int end){
        return postRepository.findAll(spec);
    }
}
