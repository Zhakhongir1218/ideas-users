package kg.itschool.ideas.ideasproject.services;

import kg.itschool.ideas.ideasproject.models.dto.UserDTO;
import kg.itschool.ideas.ideasproject.models.dto.UserDtoForLogin;
import kg.itschool.ideas.ideasproject.models.entities.Users;

public interface UserService {
    UserDTO registration(UserDTO userDTO) throws UserAlredyExists;
    String login(UserDtoForLogin userDtoForLogin) throws UserAlredyExists;

}
