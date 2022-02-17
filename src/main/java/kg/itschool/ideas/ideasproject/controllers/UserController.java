package kg.itschool.ideas.ideasproject.controllers;

import kg.itschool.ideas.ideasproject.models.dto.UserDTO;
import kg.itschool.ideas.ideasproject.services.UserAlredyExists;
import kg.itschool.ideas.ideasproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public UserDTO registration(@RequestBody UserDTO userDTO) throws UserAlredyExists {
        return userService.registration(userDTO);
    }
    @GetMapping("/login")
    public UserDTO loginByCode(@RequestParam int code) throws UserAlredyExists {
        return userService.login(code);
    }
}
