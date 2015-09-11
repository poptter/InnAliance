package service;

import java.util.List;

import po.Guest;

public interface GuestService {
	
	/**
	 * ����
	 * @param Guest
	 */
	public void addGuest(Guest guest);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteGuestById(int id);
	
	public void deleteGuest(Guest guest);
	
	/**
	 * �޸�
	 * @param Guest
	 */
	public void updateGuest(Guest guest);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public Guest queryGuestById(int id);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<Guest> queryAllGuest();
	
	/**
	 * ͨ���û�Id��ѯ��Ӧ���ÿ�
	 * @param userId
	 * @return
	 */
	public Guest queryGuestByUseInfoId(int userId);
}
