package dao;

import java.util.List;

import po.Role;

public interface RoleDao {

	/**
	 * ����
	 * @param Role
	 */
	public void addRole(Role role);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteRoleById(int id);
	
	public void deleteRole(Role role);
	
	/**
	 * �޸�
	 * @param Role
	 */
	public void updateRole(Role role);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public Role queryRoleById(int id);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<Role> queryAllRole();
}
