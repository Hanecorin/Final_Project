package pdt.service;

import java.util.List;

import pdt.dto.UserDTO;
import pdt.entity.User;

public interface UserService {
	
	List<User> getUserList(User user);

	void insertUser(User user);

	User getUser(String userId);

	void updateUser(UserDTO userDTO);

	void deleteUser(User user);

}
