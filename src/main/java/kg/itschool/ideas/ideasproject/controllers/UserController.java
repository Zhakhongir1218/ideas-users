package kg.itschool.ideas.ideasproject.controllers;

import kg.itschool.ideas.ideasproject.models.dto.UserDTO;
import kg.itschool.ideas.ideasproject.models.dto.UserDtoForLogin;
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
    @PostMapping("/login")
    public String loginByCode(@RequestBody UserDtoForLogin userDtoForLogin) throws UserAlredyExists {
        return userService.login(userDtoForLogin);
    }
}
