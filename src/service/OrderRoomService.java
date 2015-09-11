package service;

import java.util.List;
import java.util.Map;

import po.OrderRoom;

public interface OrderRoomService {

	/**
	 * ����
	 * @param OrderRoom
	 */
	public void addOrderRoom(OrderRoom orderRoom);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteOrderRoomById(int id);
	
	public void deleteOrderRoom(OrderRoom orderRoom);
	
	/**
	 * �޸�
	 * @param OrderRoom
	 */
	public void updateOrderRoom(OrderRoom orderRoom);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public OrderRoom queryOrderRoomById(int id);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<OrderRoom> queryAllOrderRoom();
	
	/**
	 * ��ѯ�ÿ͡�Ԥ�����Ķ�����
	 * @return
	 */
	public List<OrderRoom> queryAllScheduleOrderRoomByUserInfoId(int userId);
	
	/**
	 * ��ѯId��ջ�µ����ж���
	 * @param innId
	 * @return
	 */
	public List<OrderRoom> queryAllOrderRoomByInnId(int innId);
	
	/**
	 * ͳ������ס����
	 * @param innId
	 * @return
	 */
	public List<Map<String, Object>> OrderMonthlyReport();
	
	/**
	 * ͨ����ջIDͳ������ס����
	 * @param innId
	 * @return
	 */
	public List<Map<String, Object>> OrderMonthlyReportByInnId(int innId);
}
