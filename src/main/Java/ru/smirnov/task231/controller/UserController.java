package ru.smirnov.task231.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.smirnov.task231.model.User;
import ru.smirnov.task231.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(final Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users_get";
    }

    @GetMapping("/new")
    public String showUserAdd() {
        return "add_user";
    }

    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") final User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showUserEdit(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") final User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") final Long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

}
