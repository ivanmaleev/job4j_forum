package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {

    private final UserService users = new UserService();
    private final AuthorityService authorities = new AuthorityService();

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        User userInDB = users.findByUsername(user.getUsername());
        if (userInDB != null) {
            model.addAttribute("errorMessage", "Username is busy");
            return "reg";
        }
        user.setEnabled(true);
        user.setPassword(user.getPassword());
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}