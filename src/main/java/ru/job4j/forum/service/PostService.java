package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        postRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post findById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public void create(Post post) {
        if (post.getCreated() == null) {
            post.setCreated(new GregorianCalendar());
        }
        postRepository.save(post);
    }
}