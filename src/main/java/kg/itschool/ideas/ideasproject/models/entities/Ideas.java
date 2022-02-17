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
public class Ideas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    String text;
    @JsonFormat(pattern = "dd.mm.yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)

    LocalDate add_date;

    Boolean contact_with_me;

    @ManyToOne
    Users id_user;
}
