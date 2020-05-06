package ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.User;
import ecommerce.repository.UserRepository;
import ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void saveCategory(User user) {
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
}