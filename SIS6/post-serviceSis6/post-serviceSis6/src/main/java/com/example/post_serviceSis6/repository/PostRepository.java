package com.example.post_serviceSis6.repository;

import com.example.post_serviceSis6.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}