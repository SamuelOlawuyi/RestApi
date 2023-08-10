package com.example.classactivity.repositories;


import com.example.classactivity.entities.FacebookUser;
import com.example.classactivity.entities.Likes;
import com.example.classactivity.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    boolean existsByPostAndUser(Post post, FacebookUser currentUsername);
    Integer deleteByPostAndUser(Post post, FacebookUser currentUsername);
}
