package ecommerce.service;

import ecommerce.model.Role;

public interface RoleService {
	public void saveRole(Role role);
	public Iterable<Role> findAllRoleExceptAdmin();
}
