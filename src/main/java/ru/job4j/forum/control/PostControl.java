package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import javax.validation.Valid;


@Controller
public class PostControl {
    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String getRead(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post/post";
    }

    @GetMapping("/post/edit")
    public String getEdit(@RequestParam("id") int id, Model model) {
        if (id == 0) {
            return "post/edit";
        }
        model.addAttribute("post", postService.findById(id));
        return "post/edit";
    }

    @PostMapping("/post/create")
    public String save(@ModelAttribute Post post) {
        postService.create(post);
        return "redirect:/post?id=" + post.getId();
    }
}