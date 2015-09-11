package service.impl;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import dao.OrderRoomDao;
import po.OrderRoom;
import service.InnService;
import service.OrderRoomService;
import util.SpringUtil;

public class OrderRoomServiceImpl implements OrderRoomService{

	OrderRoomDao orderRoomDao;
	
	/**
	 * @return the orderRoomDao
	 */
	public OrderRoomDao getOrderRoomDao() {
		return orderRoomDao;
	}

	/**
	 * @param orderRoomDao the orderRoomDao to set
	 */
	public void setOrderRoomDao(OrderRoomDao orderRoomDao) {
		this.orderRoomDao = orderRoomDao;
	}

	@Override
	public void addOrderRoom(OrderRoom orderRoom) {
		orderRoomDao.addOrderRoom(orderRoom);
	}

	@Override
	public void deleteOrderRoomById(int id) {
		orderRoomDao.deleteOrderRoomById(id);
	}

	@Override
	public void deleteOrderRoom(OrderRoom orderRoom) {
		orderRoomDao.deleteOrderRoom(orderRoom);
	}

	@Override
	public void updateOrderRoom(OrderRoom orderRoom) {
		orderRoomDao.updateOrderRoom(orderRoom);
	}

	@Override
	public OrderRoom queryOrderRoomById(int id) {
		return orderRoomDao.queryOrderRoomById(id);
	}

	@Override
	public List<OrderRoom> queryAllOrderRoom() {
		return orderRoomDao.queryAllOrderRoom();
	}

	@Override
	public List<OrderRoom> queryAllScheduleOrderRoomByUserInfoId(int userId) {
		return orderRoomDao.queryAllScheduleOrderRoomByUserInfoId(userId);
	}

	@Override
	public List<OrderRoom> queryAllOrderRoomByInnId(int innId) {
		return orderRoomDao.queryAllOrderRoomByInnId(innId);
	}

	@Override
	public List<Map<String, Object>> OrderMonthlyReport() {
		return orderRoomDao.OrderMonthlyReport();
	}
	
	@Override
	public List<Map<String, Object>> OrderMonthlyReportByInnId(int innId) {
		return orderRoomDao.OrderMonthlyReportByInnId(innId);
	}

	@Test
	public void test(){
		OrderRoomService orderRoomService = (OrderRoomService)SpringUtil.getBean("orderRoomService");
		List<Map<String, Object>> list =orderRoomService.OrderMonthlyReportByInnId(1);
		System.out.println("==>"+list.size());
		if(list!=null&&list.size()>0){
			String month = "";//年-月
			int person = 0;//入住人数
			for(Map<String, Object> map:list){
				month = (String) map.get("month");
				person = Integer.valueOf(map.get("value").toString());
				System.out.println("月份 ："+month+"\t人数 ："+person);
			}	
		}else{
			System.out.println("数据错误！");
		}
	}
}
