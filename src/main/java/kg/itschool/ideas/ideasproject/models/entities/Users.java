package kg.itschool.ideas.ideasproject.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_user;

    String name;

    String phone;

    @JsonFormat(pattern = "dd.mm.yyyy hh:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDate add_date;

    Integer code;

    Boolean activated;



}
