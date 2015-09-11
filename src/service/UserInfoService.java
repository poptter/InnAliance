package service;

import java.util.List;

import po.Guest;
import po.UserInfo;

public interface UserInfoService {

	/**
	 * 增加
	 * @param UserInfo
	 */
	public void addUserInfo(UserInfo userInfo);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteUserInfoById(int id);
	
	public void deleteUserInfo(UserInfo userInfo);
	
	/**
	 * 修改
	 * @param UserInfo
	 */
	public void updateUserInfo(UserInfo userInfo);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public UserInfo queryUserInfoById(int id);
	
	/**
	 * 条件查询No
	 * @param no
	 * @return
	 */
	public UserInfo queryUserInfoByNo(String no);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<UserInfo> queryAllUserInfo();
	
	/**
	 * 查询所有用户数量分布
	 * @return
	 */
	public int[] queryUserState();
}
