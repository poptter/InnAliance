package dao.impl;

import java.util.HashMap;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.Inn;
import util.SpringUtil;
import dao.InnDao;

public class InnDaoImpl extends HibernateDaoSupport implements InnDao {

	@Override
	public void addInn(Inn inn) {
		this.getHibernateTemplate().save(inn);
	}

	@Override
	public void deleteInnById(int id) {
		this.getHibernateTemplate().delete(queryInnById(id));
	}

	@Override
	public void deleteInn(Inn inn) {
		this.getHibernateTemplate().delete(inn);
	}

	@Override
	public void updateInn(Inn inn) {
		this.getHibernateTemplate().update(inn);
	}

	@Override
	public Inn queryInnById(int id) {
		//return (Inn)this.getHibernateTemplate().load(Inn.class, id);
		return (Inn)this.getHibernateTemplate().get(Inn.class, id);
	}

	@Override
	public List<Inn> queryAllInn() {
		List<Inn> list = this.getHibernateTemplate().find("from Inn");
		return list;
	}
	
	@Override
	public List<Inn> queryInnInExamineByInnName(String innName) {
		List<Inn> list=this.getHibernateTemplate().find("from Inn i where i.state in ('已审核') and i.innName like ?","%"+innName+"%");
		return list;
	}
	
	//通过店家Id来查询客栈
	@Override
	public Inn queryInnByUserInfoId(int userId){
		return (Inn)this.getHibernateTemplate().find("from Inn i where i.userInfo.userId=?",userId).get(0);
	}
	
	//查询未通过审核的店家
	@Override
	public List<Inn> queryInnInNotExamine(){
		List<Inn> list=this.getHibernateTemplate().find("from Inn i where i.state not in ('已审核')");
		return list;
	}
	
	//查询通过审核的店家
	@Override
	public List<Inn> queryInnInExamine(){
		List<Inn> list=this.getHibernateTemplate().find("from Inn i where i.state in ('已审核')");
		return list;
	}
	
	//查询所有店家状态
	@Override
	public int[] queryInnsState(){
		int[] count =new int[3];
		count[0]= this.getHibernateTemplate().find("from Inn i where i.state = '已提交'").size();
		count[1]= this.getHibernateTemplate().find("from Inn i where i.state = '已审核'").size();
		count[2]= this.getHibernateTemplate().find("from Inn i where i.state = '黑名单'").size();
		return count;
	}
	
	@Ignore
	@Test
	public void test_add(){
		InnDao innDao = (InnDao)SpringUtil.getBean("innDao");
		Inn inn = new Inn();
		inn.setInnName("啊偶");
		inn.setInnIdCard("546164816848");
		inn.setInnPrimitId("456789146");
		inn.setInnAddress("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		inn.setInnIntroduction("YYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		inn.setInnValuation("ZZZZZZZZZZ");
		inn.setState("已提交");
		
		innDao.addInn(inn);
		System.out.println("======>");
		List<Inn> list =innDao.queryAllInn();
		for (Inn i : list) {
			System.out.println(i.toString());
		}
	}
	
	@Ignore
	@Test
	public void test_del(){
		InnDao innDao = (InnDao)SpringUtil.getBean("innDao");
		Inn inn = new Inn();
		inn.setInnId(12);
		inn.setInnName("啊偶");
		inn.setInnIdCard("546164816848");
		inn.setInnPrimitId("456789146");
		inn.setInnAddress("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		inn.setInnIntroduction("YYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		inn.setInnValuation("ZZZZZZZZZZ");
		inn.setState("已提交");
		
		innDao.deleteInn(inn);
		innDao.deleteInnById(13);
		
		System.out.println("======>");
		List<Inn> list =innDao.queryAllInn();
		for (Inn i : list) {
			System.out.println(i.toString());
		}
	}

	@Ignore
	@Test
	public void test_query(){
		InnDao innDao = (InnDao)SpringUtil.getBean("innDao");
		Inn inn = innDao.queryInnById(11);
		System.out.println(inn.toString());
		System.out.println("======>");
		List<Inn> list =innDao.queryAllInn();
		for (Inn i : list) {
			System.out.println(i.toString());
		}
	}
	
	@Ignore
	@Test
	public void test_update(){
		InnDao innDao = (InnDao)SpringUtil.getBean("innDao");
		Inn inn = new Inn();
		inn.setInnId(11);
		inn.setInnName("啊偶");
		inn.setInnIdCard("546164816848");
		inn.setInnPrimitId("456789146");
		inn.setInnAddress("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		inn.setInnIntroduction("YYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		inn.setInnValuation("ZZZZZZZZZZ");
		inn.setState("通过");
		innDao.updateInn(inn);
		System.out.println("======>");
		List<Inn> list =innDao.queryAllInn();
		for (Inn i : list) {
			System.out.println(i.toString());
		}
	}
}
