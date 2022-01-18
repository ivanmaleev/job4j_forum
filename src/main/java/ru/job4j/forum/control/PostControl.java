package ru.job4j.forum.control;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
@RequiredArgsConstructor
public class PostControl {

    private final PostService postService;

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