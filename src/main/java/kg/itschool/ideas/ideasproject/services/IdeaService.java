package kg.itschool.ideas.ideasproject.services;

import kg.itschool.ideas.ideasproject.models.dto.IdeaDTO;
import kg.itschool.ideas.ideasproject.models.entities.Ideas;

public interface IdeaService {

    String save(IdeaDTO ideaDTO);
}
