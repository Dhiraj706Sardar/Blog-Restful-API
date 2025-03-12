package com.dtech.blog.blog_api.repository;

import org.springframework.stereotype.Repository;

import com.dtech.blog.blog_api.model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}


