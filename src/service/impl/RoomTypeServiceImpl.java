package service.impl;

import java.util.List;

import po.RoomType;
import service.RoomTypeService;
import dao.RoomTypeDao;

public class RoomTypeServiceImpl implements RoomTypeService {

	RoomTypeDao roomTypeDao;
	
	/**
	 * @return the roomTypeDao
	 */
	public RoomTypeDao getRoomTypeDao() {
		return roomTypeDao;
	}

	/**
	 * @param roomTypeDao the roomTypeDao to set
	 */
	public void setRoomTypeDao(RoomTypeDao roomTypeDao) {
		this.roomTypeDao = roomTypeDao;
	}

	@Override
	public void addRoomType(RoomType roomType) {
		roomTypeDao.addRoomType(roomType);
	}

	@Override
	public void deleteRoomTypeById(int id) {
		roomTypeDao.deleteRoomTypeById(id);
	}

	@Override
	public void deleteRoomType(RoomType roomType) {
		roomTypeDao.deleteRoomType(roomType);
	}

	@Override
	public void updateRoomType(RoomType roomType) {
		roomTypeDao.updateRoomType(roomType);
	}

	@Override
	public RoomType queryRoomTypeById(int id) {
		return roomTypeDao.queryRoomTypeById(id);
	}

	@Override
	public List<RoomType> queryAllRoomType() {
		return roomTypeDao.queryAllRoomType();
	}

}
