package ru.job4j.forum.control;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.PostService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class IndexControl {

    private final PostService posts;

    @GetMapping({"/", "/index"})
    public String index(Model model, Principal principal) {
        model.addAttribute("posts", posts.getAll());
        model.addAttribute("username", principal.getName());
        return "index";
    }
}