package kg.itschool.ideas.ideasproject.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDtoForLogin {
    String phone;
    String code;
}
