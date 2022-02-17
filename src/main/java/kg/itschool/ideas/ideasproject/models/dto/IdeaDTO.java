package kg.itschool.ideas.ideasproject.models.dto;

import kg.itschool.ideas.ideasproject.models.entities.Users;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IdeaDTO {

    Integer id;

    String title;

    String text;

    LocalDate add_date;

    Boolean contact_with_me;

    Integer id_user;
}
