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

	// 增加
	public String addRole() {
		roleService.addRole(role);
		return "success";
	}

	// 删除
	public String deleteRole() {
		System.out.println("id : " + roleId);
		roleService.deleteRoleById(roleId);
		return "success";
	}

	// 查询Id
	public String queryRoleById() {
		List<Role> list = new ArrayList<Role>();
		role = roleService.queryRoleById(roleId);
		list.add(role);
		ActionContext.getContext().getSession().put("roles", list);
		return "success";
	}

	// 全查询
	public String queryAllRole() {
		List<Role> list = roleService.queryAllRole();
		ActionContext.getContext().getSession().put("roles", list);
		return "success";
	}

	// 修改
	public String updateRole() {
		roleService.updateRole(role);
		return "success";
	}

}
