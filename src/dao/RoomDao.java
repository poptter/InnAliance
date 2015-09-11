package dao;

import java.util.List;

import po.Room;

public interface RoomDao {

	/**
	 * ����
	 * @param RoomAction
	 */
	public void addRoom(Room room);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteRoomById(int id);
	
	public void deleteRoom(Room room);
	
	/**
	 * �޸�
	 * @param RoomAction
	 */
	public void updateRoom(Room room);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public Room queryRoomById(int id);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<Room> queryAllRoom();

	/**
	 * ��ѯ���õĿͷ���Ϣ
	 * @return
	 */
	public List<Room> queryAllAvailableRoom();

	/**
	 * ͨ����ջID��ѯ���õĿͷ���Ϣ
	 * @return
	 */
	public List<Room> queryAllAvailableRoomByInnId(int innId);

	/**
	 * ͨ�����ID��ѯ�ͷ��б�
	 * @return
	 */
	public List<Room> queryAllRoomByUserInfoId(int userId);

	/**
	 * �ͷ�ʹ�����
	 * @param userId
	 */
	public List<String[]> queryRoomUseState(int userId);
}
