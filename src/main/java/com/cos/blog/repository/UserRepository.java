package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 자동으로 bean 등록
public interface UserRepository extends JpaRepository<User, Integer> {

    // SELECT * FROM user WHERE joinId = ? AND password = ?;
    User findByJoinIdAndPassword(String joinId, String password);

    // 혹은 native query 사용
//    @Query(value = "SELECT * FROM user WHERE joinId = ? AND password = ?;", nativeQuery = true)
//    User login(String joinId, String password);
}
