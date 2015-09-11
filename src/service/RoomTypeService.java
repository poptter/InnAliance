package service;

import java.util.List;

import po.RoomType;

public interface RoomTypeService {

	/**
	 * 增加
	 * @param RoomType
	 */
	public void addRoomType(RoomType roomType);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteRoomTypeById(int id);
	
	public void deleteRoomType(RoomType roomType);
	
	/**
	 * 修改
	 * @param RoomType
	 */
	public void updateRoomType(RoomType roomType);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public RoomType queryRoomTypeById(int id);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<RoomType> queryAllRoomType();
}
