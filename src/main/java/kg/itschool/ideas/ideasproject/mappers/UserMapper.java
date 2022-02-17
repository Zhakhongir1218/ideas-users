package kg.itschool.ideas.ideasproject.mappers;

import kg.itschool.ideas.ideasproject.models.dto.UserDTO;
import kg.itschool.ideas.ideasproject.models.entities.Users;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    Users userDTOToUser(UserDTO userDTO);
    UserDTO userToUserDTO(Users user);
}
