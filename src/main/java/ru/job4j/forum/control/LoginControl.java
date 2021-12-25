package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginControl {

    private UserService userService = new UserService();

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMessage = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model, HttpServletRequest request) {
        User userinDB = userService.findByUsername(user.getUsername());
        String errorMessage = null;
        if (userinDB == null || !userinDB.getPassword().equals(userinDB.getPassword())) {
            errorMessage = "Wrong username or password";
            model.addAttribute("errorMessage", errorMessage);
            return "login";
        }
        request.getSession().setAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login?logout=true";
    }
}