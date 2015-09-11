package dao.impl;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.Guest;
import util.SpringUtil;
import dao.GuestDao;

public class GuestDaoImpl extends HibernateDaoSupport implements GuestDao {

	@Override
	public void addGuest(Guest guest) {
		this.getHibernateTemplate().save(guest);
	}

	@Override
	public void deleteGuestById(int id) {
		this.getHibernateTemplate().delete(queryGuestById(id));
	}

	@Override
	public void deleteGuest(Guest guest) {
		this.getHibernateTemplate().delete(guest);
	}

	@Override
	public void updateGuest(Guest guest) {
		this.getHibernateTemplate().update(guest);
	}

	@Override
	public Guest queryGuestById(int id) {
		//return (Guest)this.getHibernateTemplate().load(Guest.class, id);
		return (Guest)this.getHibernateTemplate().get(Guest.class, id);
	}

	@Override
	public List<Guest> queryAllGuest() {
		List<Guest> list =this.getHibernateTemplate().find("from Guest");
		return list;
	}
	
	//通过用户Id查询对应的旅客
	@Override
	public Guest queryGuestByUseInfoId(int userId) {
		return (Guest) this.getHibernateTemplate().find("from Guest g where g.userInfo.userId=?",userId).get(0);
	}
	
	@Ignore
	@Test
	public void test_add(){
		GuestDao guestdao=(GuestDao)SpringUtil.getBean("guestDao");
		Guest guest = new Guest();
		guest.setGuestCredit("-1");
		guest.setGuestCreateDate(new Date());
		guestdao.addGuest(guest);
		System.out.println("==================>");
		List<Guest> list=guestdao.queryAllGuest();
		for (Guest g : list) {
			System.out.println(g.toString());
		}
	}
	
	@Ignore
	@Test
	public void test_del(){
		GuestDao guestdao=(GuestDao)SpringUtil.getBean("guestDao");
		Guest guest = new Guest();
		guest.setGuestId(9);
		guest.setGuestCredit("-1");
		guest.setGuestCreateDate(new Date());
		guestdao.deleteGuest(guest);
		guestdao.deleteGuestById(7);
		System.out.println("==================>");
		List<Guest> list=guestdao.queryAllGuest();
		for (Guest g : list) {
			System.out.println(g.toString());
		}
	}

	@Ignore
	@Test
	public void test_query(){
		GuestDao guestdao=(GuestDao)SpringUtil.getBean("guestDao");
		Guest guest = guestdao.queryGuestById(8);
		System.out.println(guest.toString());
		System.out.println("==================>");
		List<Guest> list=guestdao.queryAllGuest();
		for (Guest g : list) {
			System.out.println(g.toString());
		}
	}
	
	@Ignore
	@Test
	public void test_update(){
		GuestDao guestdao=(GuestDao)SpringUtil.getBean("guestDao");
		Guest guest = new Guest();
		guest.setGuestId(8);
		guest.setGuestCredit("0");
		guest.setGuestCreateDate(new Date());
		guestdao.updateGuest(guest);
		System.out.println("==================>");
		List<Guest> list=guestdao.queryAllGuest();
		for (Guest g : list) {
			System.out.println(g.toString());
		}
	}
}
