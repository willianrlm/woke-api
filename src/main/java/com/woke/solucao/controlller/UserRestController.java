package com.woke.solucao.controlller;

import com.woke.solucao.model.User;
import com.woke.solucao.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/api/user/{login}")
    public User getUser(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @PutMapping(value = "api/user/update")
    public User update(@Valid @RequestBody User user){
        return userService.save(user);
    }
}