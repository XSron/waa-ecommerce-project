package ecommerce.service;

import java.util.List;

import ecommerce.model.User;

public interface UserService {
	public void saveCategory(User user);
	public List<User> findAllUser();
	public User findUserById(Integer id);
	public void deleteUserById(Integer id);
}
