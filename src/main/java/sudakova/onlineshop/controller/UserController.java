package sudakova.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sudakova.onlineshop.dto.request.UserRequest;
import sudakova.onlineshop.dto.response.UserResponse;
import sudakova.onlineshop.service.UserService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public UserResponse login(@RequestBody @Valid UserRequest userRequest) {
        return userService.login(userRequest);
    }

    @PostMapping(value = "/register")
    public UserResponse register(@RequestBody @Valid UserRequest userRequest) {
        return userService.save(userRequest);
    }
}
