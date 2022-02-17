package kg.itschool.ideas.ideasproject.services.impl;

import kg.itschool.ideas.ideasproject.mappers.UserMapper;
import kg.itschool.ideas.ideasproject.models.dto.UserDTO;
import kg.itschool.ideas.ideasproject.models.entities.Users;
import kg.itschool.ideas.ideasproject.repository.UserRepo;
import kg.itschool.ideas.ideasproject.services.UserAlredyExists;
import kg.itschool.ideas.ideasproject.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO registration(UserDTO userDTO) throws UserAlredyExists {
        Users user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        String containsOrNot = userRepo.findUsersByPhoneContaining(user.getPhone());
            if(containsOrNot == null){
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
    public UserDTO login(Integer code) throws UserAlredyExists {
        Users user = userRepo.findUsersByCode(code);
        if(user.equals(null)){
            throw new UserAlredyExists("User not found");
        }else{
            user.setActivated(true);
            user = userRepo.save(user);
            return UserMapper.INSTANCE.userToUserDTO(user);
        }

    }


    public static int randomNumberForCode(){
        int min = 1000;
        int max = 9999;
        int range = max - min;
        int code = (int)(Math.random()*range)+min;
        return code;
    }


}
