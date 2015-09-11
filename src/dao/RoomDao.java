package dao;

import java.util.List;

import po.Room;

public interface RoomDao {

	/**
	 * 增加
	 * @param RoomAction
	 */
	public void addRoom(Room room);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteRoomById(int id);
	
	public void deleteRoom(Room room);
	
	/**
	 * 修改
	 * @param RoomAction
	 */
	public void updateRoom(Room room);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public Room queryRoomById(int id);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<Room> queryAllRoom();

	/**
	 * 查询可用的客房信息
	 * @return
	 */
	public List<Room> queryAllAvailableRoom();

	/**
	 * 通过客栈ID查询可用的客房信息
	 * @return
	 */
	public List<Room> queryAllAvailableRoomByInnId(int innId);

	/**
	 * 通过店家ID查询客房列表
	 * @return
	 */
	public List<Room> queryAllRoomByUserInfoId(int userId);

	/**
	 * 客房使用情况
	 * @param userId
	 */
	public List<String[]> queryRoomUseState(int userId);
}
