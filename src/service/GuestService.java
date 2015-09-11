package service;

import java.util.List;

import po.Guest;

public interface GuestService {
	
	/**
	 * 增加
	 * @param Guest
	 */
	public void addGuest(Guest guest);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteGuestById(int id);
	
	public void deleteGuest(Guest guest);
	
	/**
	 * 修改
	 * @param Guest
	 */
	public void updateGuest(Guest guest);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public Guest queryGuestById(int id);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<Guest> queryAllGuest();
	
	/**
	 * 通过用户Id查询对应的旅客
	 * @param userId
	 * @return
	 */
	public Guest queryGuestByUseInfoId(int userId);
}
