package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final PasswordEncoder encoder;
    private final UserService userService;
    private final AuthorityService authorityService;

    @Autowired
    public RegControl(UserService userService, AuthorityService authorityService,
                      PasswordEncoder encoder) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.encoder = encoder;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        User userInDB = userService.findByUsername(user.getUsername());
        if (userInDB != null) {
            model.addAttribute("errorMessage", "Username is busy");
            return "reg";
        }
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityService.findByAuthority("ROLE_USER"));
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}