package dao.impl;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.BdMap;
import util.SpringUtil;
import dao.BdMapDao;

public class BdMapDaoImpl extends HibernateDaoSupport implements BdMapDao {

	@Override
	public void addBdMap(BdMap bdMap) {
		this.getHibernateTemplate().save(bdMap);
	}

	@Override
	public void deleteBdMapById(int id) {
		this.getHibernateTemplate().delete(queryBdMapById(id));
	}

	@Override
	public void deleteBdMap(BdMap bdMap) {
		this.getHibernateTemplate().delete(bdMap);
	}

	@Override
	public void updateBdMap(BdMap bdMap) {
		this.getHibernateTemplate().update(bdMap);
	}

	@Override
	public BdMap queryBdMapById(int id) {
		//return (BdMap) this.getHibernateTemplate().load(BdMap.class, id);
		return (BdMap) this.getHibernateTemplate().get(BdMap.class, id);
	}
	
	@Override
	public BdMap queryBdMapByInnId(int innId) {
		return (BdMap) this.getHibernateTemplate().find("from BdMap b where b.inn.innId=?",innId).get(0);
	}

	@Override
	public List<BdMap> queryAllBdMap() {
		List<BdMap> list = this.getHibernateTemplate().find("from BdMap");
		return list;
	}
	
	@Ignore
	@Test
	public void Test_add(){
		BdMapDao bdMapDao = (BdMapDao) SpringUtil.getBean("bdMapDao");
		BdMap bdMap=new BdMap();
		bdMap.setInn(null);
		bdMap.setMapX("22.123456");
		bdMap.setMapY("30.123456");
		bdMapDao.addBdMap(bdMap);
		System.out.println("<=================================>");
		List<BdMap> list = bdMapDao.queryAllBdMap();
		for (BdMap map : list) {
			System.out.println(map.toString());
		}
	}
	@Ignore
	@Test
	public void test_add2(){
		BdMapDao bdMapDao = (BdMapDao) SpringUtil.getBean("bdMapDao");
		BdMap map = bdMapDao.queryBdMapById(1);
		System.out.println(map.getMapX());
	}
	
	@Ignore
	@Test
	public void Test_del(){
		BdMapDao bdMapDao = (BdMapDao) SpringUtil.getBean("bdMapDao");
		BdMap bdMap=new BdMap();
		bdMap.setMapId(1);
		bdMap.setMapX("22.123456");
		bdMap.setMapY("30.123456");
		bdMapDao.deleteBdMap(bdMap);
		bdMapDao.deleteBdMapById(2);
		System.out.println("<=================================>");
		List<BdMap> list = bdMapDao.queryAllBdMap();
		for (BdMap map : list) {
			System.out.println(map.toString());
		}
	}
	
	@Ignore
	@Test
	public void Test_query(){
		BdMapDao bdMapDao = (BdMapDao) SpringUtil.getBean("bdMapDao");
		BdMap bdMap=bdMapDao.queryBdMapById(3);
		System.out.println(bdMap.toString());
		System.out.println("<=================================>");
		List<BdMap> list = bdMapDao.queryAllBdMap();
		for (BdMap map : list) {
			System.out.println(map.toString());
		}
	}

	@Ignore
	@Test
	public void Test_update(){
		BdMapDao bdMapDao = (BdMapDao) SpringUtil.getBean("bdMapDao");
		BdMap bdMap=new BdMap();
		bdMap.setMapId(3);
		bdMap.setMapX("110.123");
		bdMap.setMapY("111.456");
		bdMapDao.updateBdMap(bdMap);
		
		System.out.println("<=================================>");
		
		List<BdMap> list = bdMapDao.queryAllBdMap();
		for (BdMap map : list) {
			System.out.println(map.toString());
		}
	}
}
