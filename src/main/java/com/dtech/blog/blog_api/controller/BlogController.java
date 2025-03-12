package com.dtech.blog.blog_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dtech.blog.blog_api.model.Blog;
import com.dtech.blog.blog_api.services.BlogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService  blogService) {
        this.blogService=blogService;
    }

    /**
     * Create a new blog.
     *
     * @param blog the blog to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new blog
     */
    @PostMapping("/blog")
    public ResponseEntity<ResponseEntity<Blog>> saveblog(@RequestBody  Blog blog) {
        ResponseEntity<Blog> newBlog = blogService.saveBlog(blog);
        return ResponseEntity.ok(newBlog);
    }

    /**
     * Get all blogs.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of blogs
     */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllblogs() {
        return blogService.fetchAllBlogs();
    }

    /**
     * Get a blog by ID.
     *
     * @param id the ID of the blog to get
     * @return the ResponseEntity with status 200 (OK) and with body of the blog, or with status 404 (Not Found) if the blog does not exist
     */
    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        ResponseEntity<Optional<Blog>> responseEntity = blogService.fetchBlogById(id);
        Optional<Blog> blog = responseEntity.getBody();
        return blog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a blog by ID.
     *
     * @param id the ID of the blog to update
     * @param blog the updated blog
     * @return the ResponseEntity with status 200 (OK) and with body of the updated blog, or with status 404 (Not Found) if the blog does not exist
     */
    @PutMapping("/blogs/{id}")
    public ResponseEntity<ResponseEntity<Blog>> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
       ResponseEntity<Blog>  updatedBlog = blogService.updateBlog(id, blog);
        return ResponseEntity.ok(updatedBlog);
    }

    /**
     * Delete a blog by ID.
     *
     * @param id the ID of the blog to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "blog deleted successfully"
     */
    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<String> deleteblog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully");
    }
}
