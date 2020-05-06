package ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.Role;
import ecommerce.repository.RoleRepository;
import ecommerce.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public void saveRole(Role role) {
		roleRepo.save(role);
	}

	@Override
	public Iterable<Role> findAllRoleExceptAdmin() {
		return roleRepo.findAllRoleExceptAdmin();
	}
}
