package kg.itschool.ideas.ideasproject.repository;

import kg.itschool.ideas.ideasproject.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
   Users findUsersByPhoneAndCode(String phone, String code);
   String findUsersByPhoneContains(String phone);
   Users findUsersByCode(String code);
   Users findUsersByPhone(String phone);
}
