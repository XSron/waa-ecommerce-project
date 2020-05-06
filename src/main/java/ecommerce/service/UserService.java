package ecommerce.service;

import ecommerce.model.User;

public interface UserService {
	public void saveCategory(User user);
	public Iterable<User> findAllUser();
	public User findUserById(Integer id);
	public void deleteUserById(Integer id);
}
