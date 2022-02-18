package kg.itschool.ideas.ideasproject.services.impl;

import kg.itschool.ideas.ideasproject.mappers.UserMapper;
import kg.itschool.ideas.ideasproject.models.dto.UserDTO;
import kg.itschool.ideas.ideasproject.models.dto.UserDtoForLogin;
import kg.itschool.ideas.ideasproject.models.entities.Users;
import kg.itschool.ideas.ideasproject.repository.UserRepo;
import kg.itschool.ideas.ideasproject.services.UserAlredyExists;
import kg.itschool.ideas.ideasproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO registration(UserDTO userDTO) throws UserAlredyExists {
        Users user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        String containsOrNot = userRepo.findUsersByPhoneContains(user.getPhone());
            if(containsOrNot==null){
                user.setAdd_date(LocalDate.now());
                user.setCode(randomNumberForCode());
                user.setActivated(false);
                user = userRepo.save(user);
                return UserMapper.INSTANCE.userToUserDTO(user);
            }else {

                throw new UserAlredyExists(user.getPhone() + "User already exists");
            }

    }

    @Override
    public String login(UserDtoForLogin userDtoForLogin) throws UserAlredyExists {
        Users user = userRepo.findUsersByPhoneAndCode(userDtoForLogin.getPhone(),userDtoForLogin.getCode());
        if(Objects.isNull(user)){
            throw new UserAlredyExists("User not found");
        }
        if(!user.getCode().equals(userDtoForLogin.getCode())){
            throw new UserAlredyExists("User not found");
        }else{
            user.setActivated(true);
            user = userRepo.save(user);
            return "We have found you, and now you are active!";
        }

    }


    public static String randomNumberForCode(){
        int min = 1000;
        int max = 9999;
        int range = max - min;
        int code = (int)(Math.random()*range)+min;

        return  String.valueOf(code);
    }


}
