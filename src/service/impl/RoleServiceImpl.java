package service.impl;

import java.util.List;

import po.Role;
import service.RoleService;
import dao.RoleDao;

public class RoleServiceImpl implements RoleService {

	RoleDao roleDao;
	
	/**
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	@Override
	public void deleteRoleById(int id) {
		roleDao.deleteRoleById(id);
	}

	@Override
	public void deleteRole(Role role) {
		roleDao.deleteRole(role);
	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	@Override
	public Role queryRoleById(int id) {
		return roleDao.queryRoleById(id);
	}

	@Override
	public List<Role> queryAllRole() {
		return roleDao.queryAllRole();
	}

}
