package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.Room;
import util.SpringUtil;
import dao.RoomDao;

public class RoomDaoImpl extends HibernateDaoSupport implements RoomDao {

	@Override
	public void addRoom(Room room) {
		this.getHibernateTemplate().save(room);
	}

	@Override
	public void deleteRoomById(int id) {
		this.getHibernateTemplate().delete(queryRoomById(id));
	}

	@Override
	public void deleteRoom(Room room) {
		this.getHibernateTemplate().delete(room);
	}

	@Override
	public void updateRoom(Room room) {
		this.getHibernateTemplate().update(room);
	}

	@Override
	public Room queryRoomById(int id) {
		//return (Room)this.getHibernateTemplate().load(Room.class, id);
		return (Room)this.getHibernateTemplate().get(Room.class, id);
	}

	@Override
	public List<Room> queryAllRoom() {
		List<Room> list = this.getHibernateTemplate().find("from Room");
		return list;
	}
	
	@Override
	public List<Room> queryAllRoomByUserInfoId(int userId) {
		List<Room> list = this.getHibernateTemplate().find("from Room r where r.inn.userInfo.userId=?",userId);
		return list;
	}
	
	@Override
	public List<Room> queryAllAvailableRoom() {
		List<Room> list = this.getHibernateTemplate().find("from Room r where r.roomState in ('����')");
		return list;
	}
	
	@Override
	public List<Room> queryAllAvailableRoomByInnId(int innId) {
		List<Room> list = this.getHibernateTemplate().find("from Room r where r.inn.innId=? and r.roomState in ('����')",innId);
		return list;
	}
	
	@Override
	public List<String[]> queryRoomUseState(int userId){
		String[] roomType={"���","����","�׼�","�󴲷�","�ӵ㷿","��ͳ�׷�"};
		String[] roomState={"����","ά��","ͣ��"};
		List<String[]> list=new ArrayList<String[]>(); 
		for (int i = 0; i <roomType.length; i++) {
			for (int j = 0; j < roomState.length; j++) {
				String hql=""
						+ "select "
								+ "count(*) as value "
						+ "from Room r "
						+ "where "
							+ "r.inn.userInfo.userId='"+userId+"' and "
							+ "r.roomType.roomTypeName='"+roomType[i]+"' and "
							+ "r.roomState='"+roomState[j]+"'";
				int value=Integer.valueOf(this.getHibernateTemplate().find(hql).get(0).toString());
				String[] result=new String[3];
				result[0]=String.valueOf(value);
				result[1]=roomType[i];
				result[2]=roomState[j];
				list.add(result);
			}
		}
		return list;
	}

	@Ignore
	@Test
	public void test_add(){
		RoomDao roomDao =(RoomDao) SpringUtil.getBean("roomDao");
		Room room=new Room();
		room.setRoomName("99");
		room.setRoomRates(120.00);
		room.setRoomState("��ͳ�׷�");
		roomDao.addRoom(room);
		System.out.println("======>");
		List<Room> list =roomDao.queryAllRoom();
		for (Room r : list) {
			System.out.println(r.toString());
		}
	}
	
	@Ignore
	@Test
	public void test_del(){
		RoomDao roomDao =(RoomDao) SpringUtil.getBean("roomDao");
		Room room=new Room();
		room.setRoomId(22);
		room.setRoomName("99");
		room.setRoomRates(120.00);
		room.setRoomState("��ͳ�׷�");
		roomDao.deleteRoom(room);
		roomDao.deleteRoomById(21);
		System.out.println("======>");
		List<Room> list =roomDao.queryAllRoom();
		for (Room r : list) {
			System.out.println(r.toString());
		}
	}

	@Ignore
	@Test
	public void test_query(){
		RoomDao roomDao =(RoomDao) SpringUtil.getBean("roomDao");
		Room room=roomDao.queryRoomById(20);
		System.out.println(room.toString());
		System.out.println("======>");
		List<Room> list =roomDao.queryAllRoom();
		for (Room r : list) {
			System.out.println(r.toString());
		}
	}
	
	@Ignore
	@Test
	public void test_update(){
		RoomDao roomDao =(RoomDao) SpringUtil.getBean("roomDao");
		Room room=new Room();
		room.setRoomId(20);
		room.setRoomName("99");
		room.setRoomRates(120.00);
		room.setRoomState("��ͳ�׷�");
		roomDao.updateRoom(room);
		System.out.println("======>");
		List<Room> list =roomDao.queryAllRoom();
		for (Room r : list) {
			System.out.println(r.toString());
		}
	}
}
