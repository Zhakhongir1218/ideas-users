package kg.itschool.ideas.ideasproject.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults (level = AccessLevel.PRIVATE)
public class UserDTO {

    Integer id;

    String name;

    String phone;

    LocalDate add_date;

    Integer code;

    Boolean activated;
}
