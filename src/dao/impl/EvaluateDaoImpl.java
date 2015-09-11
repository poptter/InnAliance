package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.net.aso.e;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.Evaluate;
import util.SpringUtil;
import dao.EvaluateDao;

public class EvaluateDaoImpl extends HibernateDaoSupport  implements EvaluateDao {

	@Override
	public void addEvaluate(Evaluate evaluate) {
		this.getHibernateTemplate().save(evaluate);
	}

	@Override
	public void deleteEvaluateById(int id) {
		this.getHibernateTemplate().delete(queryEvaluateById(id));
	}

	@Override
	public void deleteEvaluate(Evaluate evaluate) {
		this.getHibernateTemplate().delete(evaluate);
	}

	@Override
	public void updateEvaluate(Evaluate evaluate) {
		this.getHibernateTemplate().update(evaluate);
	}

	@Override
	public Evaluate queryEvaluateById(int id) {
		//return (Evaluate)this.getHibernateTemplate().load(Evaluate.class, id);
		return (Evaluate)this.getHibernateTemplate().get(Evaluate.class, id);
	}

	@Override
	public List<Evaluate> queryAllEvaluate() {
		List<Evaluate> list = this.getHibernateTemplate().find("from Evaluate");
		return list;
	}
	
	//浏览评论（通过审核）
	@Override
	public List<Evaluate> queryAllPassEvaluate() {
		List<Evaluate> list = this.getHibernateTemplate().find("from Evaluate e where e.evaluateState='通过'");
		return list;
	}
	
	//模糊查询浏览评论（通过审核）
	@Override
	public List<Evaluate> queryAllPassEvaluateByContent(String content) {
		ArrayList<String> params = new ArrayList<String>();
		params.add("%"+content+"%");
		params.add("%"+content+"%");
		List<Evaluate> list = this.getHibernateTemplate().find("from Evaluate e where e.evaluateState='通过' and (e.inn.innName like ? or e.evaluateContent like ?)",params.toArray());
		return list;
	}

	@Ignore
	@Test
	public void test_add(){
		EvaluateDao evaluateDao = (EvaluateDao) SpringUtil.getBean("evaluateDao");
		Evaluate evaluate = new Evaluate();
		evaluate.setEvaluateContent("哈哈");
		evaluate.setEvaluateTime(new Date());
		evaluate.setEvaluateState("已提交");
		evaluateDao.addEvaluate(evaluate);
		System.out.println("==================>");
		List<Evaluate> list=evaluateDao.queryAllEvaluate();
		for (Evaluate e : list) {
			System.out.println(e.getEvaluateId()+"\t"+e.getEvaluateContent()+"\t"+e.getEvaluateTime()+"\t"+e.getEvaluateState());
		}
	}
	
	@Ignore
	@Test
	public void test_del(){
		EvaluateDao evaluateDao = (EvaluateDao) SpringUtil.getBean("evaluateDao");
		Evaluate evaluate = new Evaluate();
		evaluate.setEvaluateId(4);
		evaluate.setEvaluateContent("哈哈");
		evaluate.setEvaluateTime(new Date());
		evaluate.setEvaluateState("已提交");
		evaluateDao.deleteEvaluate(evaluate);
		evaluateDao.deleteEvaluateById(5);
		System.out.println("==================>");
		List<Evaluate> list=evaluateDao.queryAllEvaluate();
		for (Evaluate e : list) {
			System.out.println(e.getEvaluateId()+"\t"+e.getEvaluateContent()+"\t"+e.getEvaluateTime()+"\t"+e.getEvaluateState());
		}
	}
	
	@Ignore
	@Test
	public void test_query(){
		EvaluateDao evaluateDao = (EvaluateDao) SpringUtil.getBean("evaluateDao");
		Evaluate evaluate = evaluateDao.queryEvaluateById(6);
		System.out.println(evaluate.toString());
		System.out.println("==================>");
		List<Evaluate> list=evaluateDao.queryAllEvaluate();
		for (Evaluate e : list) {
			System.out.println(e.getEvaluateId()+"\t"+e.getEvaluateContent()+"\t"+e.getEvaluateTime()+"\t"+e.getEvaluateState());
		}
	}
	
	@Ignore
	@Test
	public void test_update(){
		EvaluateDao evaluateDao = (EvaluateDao) SpringUtil.getBean("evaluateDao");
		Evaluate evaluate = new Evaluate();
		evaluate.setEvaluateContent("霍霍");
		evaluate.setEvaluateTime(new Date());
		evaluate.setEvaluateState("通过");
		evaluateDao.updateEvaluate(evaluate);
		System.out.println("==================>");
		List<Evaluate> list=evaluateDao.queryAllEvaluate();
		for (Evaluate e : list) {
			System.out.println(e.getEvaluateId()+"\t"+e.getEvaluateContent()+"\t"+e.getEvaluateTime()+"\t"+e.getEvaluateState());
		}
	}
}
