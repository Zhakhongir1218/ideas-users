package kg.itschool.ideas.ideasproject.services.impl;

import kg.itschool.ideas.ideasproject.mappers.IdeaMapper;
import kg.itschool.ideas.ideasproject.models.dto.IdeaDTO;
import kg.itschool.ideas.ideasproject.models.entities.Ideas;
import kg.itschool.ideas.ideasproject.repository.IdeaRepo;
import kg.itschool.ideas.ideasproject.services.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class IdeaServiceImpl implements IdeaService {
    @Autowired
    private IdeaRepo ideaRepo;




    @Override
    public IdeaDTO save(IdeaDTO ideaDTO) {
        Ideas ideas = IdeaMapper.INSTANCE.IdeaDTOToIdea(ideaDTO);
        ideas.setAdd_date(LocalDate.now());
        ideas = ideaRepo.save(ideas);
        return IdeaMapper.INSTANCE.ideaToIdeaDTO(ideas);
    }
}
