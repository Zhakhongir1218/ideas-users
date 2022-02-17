package kg.itschool.ideas.ideasproject.repository;

import kg.itschool.ideas.ideasproject.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
   String findUsersByPhoneContaining(String phone);
   Users findUsersByCode(Integer code);
}
