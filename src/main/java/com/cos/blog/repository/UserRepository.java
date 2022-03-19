package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 자동으로 bean 등록
public interface UserRepository extends JpaRepository<User, Integer> {
}
