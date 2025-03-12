package com.dtech.blog.blog_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dtech.blog.blog_api.model.Blog;
import com.dtech.blog.blog_api.repository.BlogRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BlogService {

    
    private final BlogRepository blogRepository;
    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        Blog newBlog = blogRepository.save(blog);
        return ResponseEntity.ok(newBlog);
    }

    public ResponseEntity<List<Blog>> fetchAllBlogs() {
        return ResponseEntity.ok(blogRepository.findAll());
    }

    public ResponseEntity<Optional<Blog>> fetchBlogById(Long id) {
        Optional<Blog> Blog = blogRepository.findById(id);
        if (Blog.isPresent()) {
            return ResponseEntity.ok(Blog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Blog> updateBlog(Long id, Blog updatedBlog) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "ID cannot be null");
        }
        Blog ExistingBlog = blogRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        String.valueOf(id)));
        ExistingBlog.setTitle(updatedBlog.getTitle());
        ExistingBlog.setAuthor(updatedBlog.getAuthor());
        ExistingBlog.setContent(updatedBlog.getContent());
        ExistingBlog.setCreatedAt(updatedBlog.getCreatedAt());
        Blog savedEntity = blogRepository.save(ExistingBlog);
        return ResponseEntity.ok(savedEntity);
    }

    public ResponseEntity<String> deleteBlog(Long id) {
        blogRepository.deleteById(id);
        return ResponseEntity.ok(
                "Blog Deleted Successfully");
    }

}
