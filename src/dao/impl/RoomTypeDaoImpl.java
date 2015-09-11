package dao.impl;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.RoomType;
import util.SpringUtil;
import dao.RoomTypeDao;

public class RoomTypeDaoImpl extends HibernateDaoSupport implements RoomTypeDao {

	@Override
	public void addRoomType(RoomType roomType) {
		this.getHibernateTemplate().save(roomType);
	}

	@Override
	public void deleteRoomTypeById(int id) {
		this.getHibernateTemplate().delete(queryRoomTypeById(id));
	}

	@Override
	public void deleteRoomType(RoomType roomType) {
		this.getHibernateTemplate().delete(roomType);
	}

	@Override
	public void updateRoomType(RoomType roomType) {
		this.getHibernateTemplate().update(roomType);
	}

	@Override
	public RoomType queryRoomTypeById(int id) {
		//return (RoomType)this.getHibernateTemplate().load(RoomType.class, id);
		return (RoomType)this.getHibernateTemplate().get(RoomType.class, id);
	}

	@Override
	public List<RoomType> queryAllRoomType() {
		List<RoomType> list = this.getHibernateTemplate().find("from RoomType");
		return list;
	}

	@Ignore
	@Test
	public void test_add(){
		RoomTypeDao roomTypeDao =(RoomTypeDao) SpringUtil.getBean("roomTypeDao");
		RoomType roomType =new RoomType();
		roomType.setRoomTypeName("标间");
		roomType.setRoomTypeStandard("标准");
		roomType.setRoonTypeBedNumber(2);
		roomTypeDao.addRoomType(roomType);
		System.out.println("=============>");
		List<RoomType> list = roomTypeDao.queryAllRoomType();
		for (RoomType rt : list) {
			System.out.println(rt.toString());
		}		
	}
	
	@Ignore
	@Test
	public void test_del(){
		RoomTypeDao roomTypeDao =(RoomTypeDao) SpringUtil.getBean("roomTypeDao");
		RoomType roomType =new RoomType();
		roomType.setRoomTypeId(24);
		roomType.setRoomTypeName("大床房");
		roomType.setRoomTypeStandard("豪华");
		roomType.setRoonTypeBedNumber(2);
		roomTypeDao.deleteRoomType(roomType);
		roomTypeDao.deleteRoomTypeById(23);
		System.out.println("=============>");
		List<RoomType> list = roomTypeDao.queryAllRoomType();
		for (RoomType rt : list) {
			System.out.println(rt.toString());
		}		
	}
	
	@Ignore
	@Test
	public void test_query(){
		RoomTypeDao roomTypeDao =(RoomTypeDao) SpringUtil.getBean("roomTypeDao");
		RoomType roomType =roomTypeDao.queryRoomTypeById(25);
		System.out.println(roomType.toString());
		System.out.println("=============>");
		List<RoomType> list = roomTypeDao.queryAllRoomType();
		for (RoomType rt : list) {
			System.out.println(rt.toString());
		}		
	}
	
	@Ignore
	@Test
	public void test_update(){
		RoomTypeDao roomTypeDao =(RoomTypeDao) SpringUtil.getBean("roomTypeDao");
		RoomType roomType =new RoomType();
		roomType.setRoomTypeId(25);
		roomType.setRoomTypeName("大床房");
		roomType.setRoomTypeStandard("豪华");
		roomType.setRoonTypeBedNumber(2);
		roomTypeDao.updateRoomType(roomType);
		System.out.println("=============>");
		List<RoomType> list = roomTypeDao.queryAllRoomType();
		for (RoomType rt : list) {
			System.out.println(rt.toString());
		}		
	}
}
