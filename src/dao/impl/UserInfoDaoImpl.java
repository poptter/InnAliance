package dao.impl;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.UserInfo;
import util.SpringUtil;
import dao.UserInfoDao;

public class UserInfoDaoImpl extends HibernateDaoSupport implements UserInfoDao {

	@Override
	public void addUserInfo(UserInfo userInfo) {
		this.getHibernateTemplate().save(userInfo);
	}

	@Override
	public void deleteUserInfoById(int id) {
		this.getHibernateTemplate().delete(queryUserInfoById(id));
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		this.getHibernateTemplate().delete(userInfo);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		this.getHibernateTemplate().update(userInfo);
	}

	@Override
	public UserInfo queryUserInfoById(int id) {
		//return (UserInfo)this.getHibernateTemplate().load(UserInfo.class, id);
		return (UserInfo)this.getHibernateTemplate().get(UserInfo.class, id);
	}
	
	@Override
	public UserInfo queryUserInfoByNo(String no) {
		List<UserInfo> list =this.getHibernateTemplate().find("from UserInfo u where u.userNo = ?",no);
		return list.size()==1?list.get(0):null;
	}

	@Override
	public List<UserInfo> queryAllUserInfo() {
		List<UserInfo> list =this.getHibernateTemplate().find("from UserInfo ui where ui.role.roleId<>'1'");
		return list;
	}

	//查询所有用户数量分布
	@Override
	public int[] queryUserState(){
		int[] count =new int[3];
		count[0]= this.getHibernateTemplate().find("from UserInfo ui where ui.role.roleId = '1'").size();
		count[1]= this.getHibernateTemplate().find("from UserInfo ui where ui.role.roleId = '2'").size();
		count[2]= this.getHibernateTemplate().find("from UserInfo ui where ui.role.roleId = '3'").size();
		return count;
	}
		
	@Test
	public void test_add(){
		UserInfoDao userInfoDao = (UserInfoDao) SpringUtil.getBean("userInfoDao");
		UserInfo userInfo =new UserInfo();
		userInfo.setUserNo("9529");
		userInfo.setUserPwd("123456");
		userInfo.setUserName("哈哈");
		userInfo.setUserPhone("124516");
		userInfo.setUserEmail("654153@qq.com");
		userInfo.setUserQq("3564561");
		userInfo.setUserWeixin("654165468");
		userInfoDao.addUserInfo(userInfo);
		System.out.println("======>");
		List<UserInfo> list =userInfoDao.queryAllUserInfo();
		System.out.println(list.size());
//		for (UserInfo ui : list) {
//			System.out.println(ui.toString());
//		}
	}
	
	@Ignore
	@Test
	public void test_del(){
		UserInfoDao userInfoDao = (UserInfoDao) SpringUtil.getBean("userInfoDao");
		UserInfo userInfo =new UserInfo();
		userInfo.setUserId(27);
		userInfo.setUserNo("9529");
		userInfo.setUserPwd("123456");
		userInfo.setUserName("哈哈");
		userInfo.setUserPhone("124516");
		userInfo.setUserEmail("654153@qq.com");
		userInfo.setUserQq("3564561");
		userInfo.setUserWeixin("654165468");
		userInfoDao.deleteUserInfo(userInfo);
		userInfoDao.deleteUserInfoById(28);
		
		System.out.println("======>");
		List<UserInfo> list =userInfoDao.queryAllUserInfo();
		for (UserInfo ui : list) {
			System.out.println(ui.toString());
		}
	}

	@Ignore
	@Test
	public void test_query(){
		UserInfoDao userInfoDao = (UserInfoDao) SpringUtil.getBean("userInfoDao");
		//UserInfo userInfo =userInfoDao.queryUserInfoById(26);
		//System.out.println(userInfo.toString());
		//System.out.println("<=<=========>=>");
		UserInfo userInfo = userInfoDao.queryUserInfoByNo("耶耶");
		System.out.println("======>");
		List<UserInfo> list =userInfoDao.queryAllUserInfo();
		for (UserInfo ui : list) {
			System.out.println(ui.toString());
		}
	}
	
	@Ignore
	@Test
	public void test_update(){
		UserInfoDao userInfoDao = (UserInfoDao) SpringUtil.getBean("userInfoDao");
		UserInfo userInfo =new UserInfo();
		userInfo.setUserId(26);
		userInfo.setUserNo("9529");
		userInfo.setUserPwd("123456");
		userInfo.setUserName("耶耶");
		userInfo.setUserPhone("124516");
		userInfo.setUserEmail("654153@qq.com");
		userInfo.setUserQq("3564561");
		userInfo.setUserWeixin("654165468");
		userInfoDao.updateUserInfo(userInfo);
		System.out.println("======>");
		List<UserInfo> list =userInfoDao.queryAllUserInfo();
		for (UserInfo ui : list) {
			System.out.println(ui.toString());
		}
	}
}
