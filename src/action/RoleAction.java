package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import po.Role;
import service.RoleService;

public class RoleAction {

	private int roleId;
	private Role role;
	private RoleService roleService;
	
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the roleService
	 */
	public RoleService getRoleService() {
		return roleService;
	}
	/**
	 * @param roleService the roleService to set
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	// ����
	public String addRole() {
		roleService.addRole(role);
		return "success";
	}

	// ɾ��
	public String deleteRole() {
		System.out.println("id : " + roleId);
		roleService.deleteRoleById(roleId);
		return "success";
	}

	// ��ѯId
	public String queryRoleById() {
		List<Role> list = new ArrayList<Role>();
		role = roleService.queryRoleById(roleId);
		list.add(role);
		ActionContext.getContext().getSession().put("roles", list);
		return "success";
	}

	// ȫ��ѯ
	public String queryAllRole() {
		List<Role> list = roleService.queryAllRole();
		ActionContext.getContext().getSession().put("roles", list);
		return "success";
	}

	// �޸�
	public String updateRole() {
		roleService.updateRole(role);
		return "success";
	}

}
