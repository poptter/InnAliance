package service;

import java.util.List;

import po.Guest;
import po.UserInfo;

public interface UserInfoService {

	/**
	 * ����
	 * @param UserInfo
	 */
	public void addUserInfo(UserInfo userInfo);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteUserInfoById(int id);
	
	public void deleteUserInfo(UserInfo userInfo);
	
	/**
	 * �޸�
	 * @param UserInfo
	 */
	public void updateUserInfo(UserInfo userInfo);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public UserInfo queryUserInfoById(int id);
	
	/**
	 * ������ѯNo
	 * @param no
	 * @return
	 */
	public UserInfo queryUserInfoByNo(String no);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<UserInfo> queryAllUserInfo();
	
	/**
	 * ��ѯ�����û������ֲ�
	 * @return
	 */
	public int[] queryUserState();
}
