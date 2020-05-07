package ecommerce.service;

import ecommerce.model.User;

public interface UserService {
	public void saveUser(User user);
	public Iterable<User> findAllUser();
	public User findUserById(Integer id);
	public User findUserByName(String username);
	public void deleteUserById(Integer id);
	public void updateUser(Integer id, String username, String password);
}
