package service.impl;

import java.util.List;

import org.junit.Test;

import po.Room;
import service.RoomService;
import util.SpringUtil;
import dao.RoomDao;

public class RoomServiceImpl implements RoomService {

	RoomDao roomDao;

	/**
	 * @return the roomDao
	 */
	public RoomDao getRoomDao() {
		return roomDao;
	}

	/**
	 * @param roomDao the roomDao to set
	 */
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public void addRoom(Room room) {
		roomDao.addRoom(room);
	}

	@Override
	public void deleteRoomById(int id) {
		roomDao.deleteRoomById(id);
	}

	@Override
	public void deleteRoom(Room room) {
		roomDao.deleteRoom(room);
	}

	@Override
	public void updateRoom(Room room) {
		roomDao.updateRoom(room);
	}

	@Override
	public Room queryRoomById(int id) {
		return roomDao.queryRoomById(id);
	}

	@Override
	public List<Room> queryAllRoom() {
		return roomDao.queryAllRoom();
	}

	@Override
	public List<Room> queryAllAvailableRoom() {
		return roomDao.queryAllAvailableRoom();
	}

	@Override
	public List<Room> queryAllAvailableRoomByInnId(int innId) {
		return roomDao.queryAllAvailableRoomByInnId(innId);
	}

	@Override
	public List<Room> queryAllRoomByUserInfoId(int userId) {
		return roomDao.queryAllRoomByUserInfoId(userId);
	}

	@Override
	public List<String[]> queryRoomUseState(int userId) {
		return roomDao.queryRoomUseState(userId);
	}
	
	@Test
	public void test(){
		RoomDao roomDao=(RoomDao)SpringUtil.getBean("roomDao");
		List<String[]> list=roomDao.queryRoomUseState(21);
		for (String[] strings : list) {
			System.out.println("客房数量 : "+strings[0]+"\t客房类型 ： "+strings[1]+"\t客房状态 ： "+strings[2]);
		}
	}

}
