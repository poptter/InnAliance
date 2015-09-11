package dao.impl;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.Role;
import util.SpringUtil;
import dao.RoleDao;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	@Override
	public void addRole(Role role) {
		this.getHibernateTemplate().save(role);
	}

	@Override
	public void deleteRoleById(int id) {
		this.getHibernateTemplate().delete(queryRoleById(id));
	}

	@Override
	public void deleteRole(Role role) {
		this.getHibernateTemplate().delete(role);
	}

	@Override
	public void updateRole(Role role) {
		this.getHibernateTemplate().update(role);
	}

	@Override
	public Role queryRoleById(int id) {
		//return (Role)this.getHibernateTemplate().load(Role.class, id);
		return (Role)this.getHibernateTemplate().get(Role.class, id);
	}

	@Override
	public List<Role> queryAllRole() {
		List<Role> list = this.getHibernateTemplate().find("from Role");
		return list;
	}

	@Ignore
	@Test
	public void test_add(){
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		Role role =new Role();
		role.setRoleName("ÂÃ¿Í");
		roleDao.addRole(role);
		System.out.println("================>");
		List<Role> list = roleDao.queryAllRole();
		for (Role r : list) {
			System.out.println(r.toString());
		}		
	}
	
	@Ignore
	@Test
	public void test_del(){
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		Role role =new Role();
		role.setRoleId(19);
		role.setRoleName("ÂÃ¿Í");
		roleDao.deleteRole(role);
		roleDao.deleteRoleById(18);
		System.out.println("================>");
		List<Role> list = roleDao.queryAllRole();
		for (Role r : list) {
			System.out.println(r.toString());
		}		
	}

	@Ignore
	@Test
	public void test_query(){
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		Role role =roleDao.queryRoleById(17);
		System.out.println(role.toString());
		System.out.println("================>");
		List<Role> list = roleDao.queryAllRole();
		for (Role r : list) {
			System.out.println(r.toString());
		}		
	}
	
	@Test
	public void test_update(){
		RoleDao roleDao = (RoleDao) SpringUtil.getBean("roleDao");
		Role role =new Role();
		role.setRoleId(17);
		role.setRoleName("ÂÃ¿Í");
		roleDao.updateRole(role);
		
		System.out.println("================>");
		List<Role> list = roleDao.queryAllRole();
		for (Role r : list) {
			System.out.println(r.toString());
		}		
	}
}
