package service;

import java.util.List;
import java.util.Map;

import po.OrderRoom;

public interface OrderRoomService {

	/**
	 * 增加
	 * @param OrderRoom
	 */
	public void addOrderRoom(OrderRoom orderRoom);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteOrderRoomById(int id);
	
	public void deleteOrderRoom(OrderRoom orderRoom);
	
	/**
	 * 修改
	 * @param OrderRoom
	 */
	public void updateOrderRoom(OrderRoom orderRoom);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public OrderRoom queryOrderRoomById(int id);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<OrderRoom> queryAllOrderRoom();
	
	/**
	 * 查询旅客“预定”的订订单
	 * @return
	 */
	public List<OrderRoom> queryAllScheduleOrderRoomByUserInfoId(int userId);
	
	/**
	 * 查询Id客栈下的所有订单
	 * @param innId
	 * @return
	 */
	public List<OrderRoom> queryAllOrderRoomByInnId(int innId);
	
	/**
	 * 统计月入住人数
	 * @param innId
	 * @return
	 */
	public List<Map<String, Object>> OrderMonthlyReport();
	
	/**
	 * 通过客栈ID统计月入住人数
	 * @param innId
	 * @return
	 */
	public List<Map<String, Object>> OrderMonthlyReportByInnId(int innId);
}
