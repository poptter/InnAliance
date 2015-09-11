package service.impl;

import java.util.List;

import org.junit.Test;

import po.Guest;
import po.UserInfo;
import service.UserInfoService;
import util.Md5Util;
import util.SpringUtil;
import dao.UserInfoDao;

public class UserInfoServiceImpl implements UserInfoService {

	UserInfoDao userInfoDao;

	/**
	 * @return the userInfoDao
	 */
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	/**
	 * @param userInfoDao
	 *            the userInfoDao to set
	 */
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void addUserInfo(UserInfo userInfo) {
		// ¶ÔÃÜÂë×Ö¶Î½øÐÐMD5¼ÓÃÜ
		userInfo.setUserPwd(Md5Util.enCode2(userInfo.getUserPwd()));
		userInfoDao.addUserInfo(userInfo);
	}

	@Test
	// ok
	public void addUserInfoTest() {
		UserInfoService userInfoService = (UserInfoService) SpringUtil
				.getBean("userInfoService");
		UserInfo userInfo = new UserInfo();
		userInfo.setUserNo("111111");
		userInfo.setUserPwd("111111");
		userInfo.setUserName("¹þ¹þsdfsdfdsf");
		userInfo.setUserPhone("124516");
		userInfo.setUserEmail("654153@qq.com");
		userInfo.setUserQq("3564561");
		userInfo.setUserWeixin("654165468");
		userInfoService.addUserInfo(userInfo);
		System.out.println("======>");
		userInfoService.addUserInfo(userInfo);
	}

	@Override
	public void deleteUserInfoById(int id) {
		userInfoDao.deleteUserInfoById(id);
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		userInfoDao.deleteUserInfo(userInfo);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		userInfoDao.updateUserInfo(userInfo);
	}

	@Override
	public UserInfo queryUserInfoById(int id) {
		return userInfoDao.queryUserInfoById(id);
	}

	@Override
	public UserInfo queryUserInfoByNo(String no) {
		return userInfoDao.queryUserInfoByNo(no);
	}

	@Override
	public List<UserInfo> queryAllUserInfo() {
		return userInfoDao.queryAllUserInfo();
	}

	@Override
	public int[] queryUserState() {
		return userInfoDao.queryUserState();
	}

}
