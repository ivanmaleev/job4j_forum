package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}