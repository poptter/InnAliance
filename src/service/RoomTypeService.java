package service;

import java.util.List;

import po.RoomType;

public interface RoomTypeService {

	/**
	 * ����
	 * @param RoomType
	 */
	public void addRoomType(RoomType roomType);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteRoomTypeById(int id);
	
	public void deleteRoomType(RoomType roomType);
	
	/**
	 * �޸�
	 * @param RoomType
	 */
	public void updateRoomType(RoomType roomType);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public RoomType queryRoomTypeById(int id);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<RoomType> queryAllRoomType();
}
