package ecommerce.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.User;
import ecommerce.repository.UserRepository;
import ecommerce.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void saveUser(User user) {
		userRepo.save(user);
	}

	@Override
	public Iterable<User> findAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepo.deleteById(id);
	}

	@Override
	public User findUserByName(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public void updateUser(Integer id, String username, String password) {
		userRepo.updateUser(id, username, password);
	}

	@Override
	public List<User> findAllSeller() {
		return userRepo.findAllSeller();
	}

	@Override
	public void approveSeller(Integer id) {
		userRepo.approveSeller(id);
	}

	@Override
	public void updatePoint(Integer userId, Double point) {
		userRepo.updatePoint(userId, point);
	}
}
