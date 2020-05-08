package ecommerce.service;

import java.util.List;

import ecommerce.model.User;

public interface UserService {
	public void saveUser(User user);
	public Iterable<User> findAllUser();
	public User findUserById(Integer id);
	public User findUserByName(String username);
	public List<User> findAllSeller();
	public void deleteUserById(Integer id);
	public void updateUser(Integer id, String username, String password);
	public void approveSeller(Integer id);
}
