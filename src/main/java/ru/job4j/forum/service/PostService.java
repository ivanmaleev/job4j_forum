package ru.job4j.forum.service;

import ru.job4j.forum.model.Post;

import java.util.List;

public interface PostService {

    public List<Post> getAll();

    public Post findById(int id);

    public void create(Post post);
}