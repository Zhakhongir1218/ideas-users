package kg.itschool.ideas.ideasproject.mappers;

import kg.itschool.ideas.ideasproject.models.dto.IdeaDTO;
import kg.itschool.ideas.ideasproject.models.entities.Ideas;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdeaMapper {
    IdeaMapper INSTANCE = Mappers.getMapper(IdeaMapper.class);
    Ideas IdeaDTOToIdea(IdeaDTO ideaDTO);
    IdeaDTO ideaToIdeaDTO(Ideas ideas);

}
