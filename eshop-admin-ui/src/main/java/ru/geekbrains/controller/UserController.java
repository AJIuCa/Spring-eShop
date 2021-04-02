package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.service.users.UserDTO;
import ru.geekbrains.service.users.UserService;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String usersPage(Model model,
                           @RequestParam("userLoginFilter") Optional<String> userLoginFilter,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("tableSize") Optional<Integer> tableSize,
                           @RequestParam("sort") Optional<String> sort) {

        Page<UserDTO> users = userService.findWithFilter(
                userLoginFilter.orElse(null),
                page.orElse(1) - 1,
                tableSize.orElse(5),
                sort.orElse(null)
        );
        model.addAttribute("users", users);
        return "users";
    }
}
