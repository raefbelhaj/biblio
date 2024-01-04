package tech.getarrays.bibliotheque.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.User;
import tech.getarrays.bibliotheque.service.UserService;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/list"; // Créez un fichier HTML 'list.html' dans le dossier src/main/resources/templates/user/
    }


    @GetMapping("/{userId}")
    public String getUserById(@PathVariable Long userId, Model model) {
        Optional<User> user = userService.getUserById(userId);
        user.ifPresent(value -> model.addAttribute("user", value));
        return "user/details"; // Créez un fichier HTML 'details.html' dans le dossier src/main/resources/templates/user/
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add"; // Créez un fichier HTML 'add.html' dans le dossier src/main/resources/templates/user/
    }


    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users/all";
    }


    @GetMapping("/edit/{userId}")
    public String showEditForm(@PathVariable Long userId, Model model) {
        Optional<User> user = userService.getUserById(userId);
        user.ifPresent(value -> model.addAttribute("user", value));
        return "user/edit"; // Créez un fichier HTML 'edit.html' dans le dossier src/main/resources/templates/user/
    }


    @PostMapping("/edit/{userId}")
    public String updateUser(@PathVariable Long userId, @ModelAttribute User updatedUser) {
        userService.updateUser(userId, updatedUser);
        return "redirect:/users/all";
    }


    @PostMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users/all";
    }
}

