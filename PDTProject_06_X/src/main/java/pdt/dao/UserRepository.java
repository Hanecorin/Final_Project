package pdt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pdt.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
