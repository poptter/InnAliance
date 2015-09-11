package dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.OrderRoom;
import util.SpringUtil;
import dao.OrderRoomDao;

public class OrderRoomDaoImpl extends HibernateDaoSupport implements
		OrderRoomDao {

	@Override
	public void addOrderRoom(OrderRoom orderRoom) {
		this.getHibernateTemplate().save(orderRoom);
	}

	@Override
	public void deleteOrderRoomById(int id) {
		this.getHibernateTemplate().delete(queryOrderRoomById(id));
	}

	@Override
	public void deleteOrderRoom(OrderRoom orderRoom) {
		this.getHibernateTemplate().delete(orderRoom);
	}

	@Override
	public void updateOrderRoom(OrderRoom orderRoom) {
		this.getHibernateTemplate().update(orderRoom);
	}

	@Override
	public OrderRoom queryOrderRoomById(int id) {
		//return (OrderRoom)this.getHibernateTemplate().load(OrderRoom.class, id);
		return (OrderRoom)this.getHibernateTemplate().get(OrderRoom.class, id);
	}

	@Override
	public List<OrderRoom> queryAllOrderRoom() {
		List<OrderRoom> list =this.getHibernateTemplate().find("from OrderRoom");
		return list;
	}
	
	@Override
	public List<OrderRoom> queryAllScheduleOrderRoomByUserInfoId(int userId) {
		List<OrderRoom> list =this.getHibernateTemplate().find("from OrderRoom o where o.orderRoomState='Ô¤¶¨' and o.guest.userInfo.userId=?",userId);
		return list;
	}
	
	@Override
	public List<OrderRoom> queryAllOrderRoomByInnId(int innId) {
		List<OrderRoom> list =this.getHibernateTemplate().find("from OrderRoom o where o.orderRoomState='Ô¤¶¨' and o.inn.innId=?",innId);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> OrderMonthlyReport(){
		String hql = ""
				+ "select "
					+ "new Map( "
						+ "to_char(o.orderRoomBeginTime,'yyyy-MM') as month,"
						+ "sum(o.orderRoomPeopleNumber) as value"
					+ ") "
				+ "from "
					+ "OrderRoom o "
				+ "group by to_char(o.orderRoomBeginTime,'yyyy-MM') "
				+ "order by to_char(o.orderRoomBeginTime,'yyyy-MM') ";
		List<Map<String, Object>> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> OrderMonthlyReportByInnId(int innId){
		String hql = ""
				+ "select "
					+ "new Map( "
						+ "to_char(o.orderRoomBeginTime,'yyyy-MM') as month,"
						+ "sum(o.orderRoomPeopleNumber) as value"
					+ ") "
				+ "from "
					+ "OrderRoom o "
				+ "where o.inn.innId='"+innId+"' "
				+ "group by to_char(o.orderRoomBeginTime,'yyyy-MM') "
				+ "order by to_char(o.orderRoomBeginTime,'yyyy-MM') ";
		List<Map<String, Object>> list = this.getHibernateTemplate().find(hql);
		return list;
	}
}
