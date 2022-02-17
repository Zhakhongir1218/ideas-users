package kg.itschool.ideas.ideasproject.repository;

import kg.itschool.ideas.ideasproject.models.dto.IdeaDTO;
import kg.itschool.ideas.ideasproject.models.entities.Ideas;
import kg.itschool.ideas.ideasproject.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepo extends JpaRepository<Ideas, Integer> {


}
