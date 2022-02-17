package kg.itschool.ideas.ideasproject.services.impl;

import kg.itschool.ideas.ideasproject.mappers.IdeaMapper;
import kg.itschool.ideas.ideasproject.models.dto.IdeaDTO;
import kg.itschool.ideas.ideasproject.models.entities.Ideas;
import kg.itschool.ideas.ideasproject.models.entities.Users;
import kg.itschool.ideas.ideasproject.repository.IdeaRepo;
import kg.itschool.ideas.ideasproject.repository.UserRepo;
import kg.itschool.ideas.ideasproject.services.IdeaService;
import kg.itschool.ideas.ideasproject.services.UserAlredyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class IdeaServiceImpl implements IdeaService {
    @Autowired
    private IdeaRepo ideaRepo;

    @Autowired
    private UserRepo userRepo;




    @Override
    public Ideas save(IdeaDTO ideaDTO) {
        Users user = userRepo.findUsersByPhone(ideaDTO.getPhone());
        if(!user.getActivated()){
            throw new UserAlredyExists("you need to activate your account");
        }
        Ideas ideas = IdeaMapper.INSTANCE.IdeaDTOToIdea(ideaDTO);
        ideas.setId_user(user);
        ideas.setAdd_date(LocalDate.now());
        ideas = ideaRepo.save(ideas);
        return ideas;
    }
}
