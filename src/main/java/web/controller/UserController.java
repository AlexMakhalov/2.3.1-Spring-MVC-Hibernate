package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("name", "User");
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute("id") int id, Model model, User user) {
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String drop(@ModelAttribute("id") int id, Model model, User user) {
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "delete";
    }

    @PostMapping("delete")
    public String delete(@ModelAttribute("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
