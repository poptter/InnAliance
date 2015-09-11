package service;

import java.util.List;

import po.Role;

public interface RoleService {

	/**
	 * 增加
	 * @param Role
	 */
	public void addRole(Role role);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteRoleById(int id);
	
	public void deleteRole(Role role);
	
	/**
	 * 修改
	 * @param Role
	 */
	public void updateRole(Role role);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public Role queryRoleById(int id);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<Role> queryAllRole();
}
