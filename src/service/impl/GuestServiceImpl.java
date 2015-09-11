package service.impl;

import java.util.List;

import po.Guest;
import service.GuestService;
import dao.GuestDao;

public class GuestServiceImpl implements GuestService {

	GuestDao guestDao;
	
	/**
	 * @return the guestDao
	 */
	public GuestDao getGuestDao() {
		return guestDao;
	}

	/**
	 * @param guestDao the guestDao to set
	 */
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	@Override
	public void addGuest(Guest guest) {
		guestDao.addGuest(guest);
	}

	@Override
	public void deleteGuestById(int id) {
		guestDao.deleteGuestById(id);
	}

	@Override
	public void deleteGuest(Guest guest) {
		guestDao.deleteGuest(guest);
	}

	@Override
	public void updateGuest(Guest guest) {
		guestDao.updateGuest(guest);
	}

	@Override
	public Guest queryGuestById(int id) {
		return guestDao.queryGuestById(id);
	}

	@Override
	public List<Guest> queryAllGuest() {
		return guestDao.queryAllGuest();
	}

	@Override
	public Guest queryGuestByUseInfoId(int userId) {
		return guestDao.queryGuestByUseInfoId(userId);
	}

}
