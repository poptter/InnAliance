package service.impl;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import po.Inn;
import service.InnService;
import util.SpringUtil;
import dao.InnDao;

public class InnServiceImpl implements InnService {

	InnDao innDao;
	
	/**
	 * @return the innDao
	 */
	public InnDao getInnDao() {
		return innDao;
	}

	/**
	 * @param innDao the innDao to set
	 */
	public void setInnDao(InnDao innDao) {
		this.innDao = innDao;
	}

	@Override
	public void addInn(Inn inn) {
		innDao.addInn(inn);
	}

	@Override
	public void deleteInnById(int id) {
		innDao.deleteInnById(id);
	}

	@Override
	public void deleteInn(Inn inn) {
		innDao.deleteInn(inn);
	}

	@Override
	public void updateInn(Inn inn) {
		innDao.updateInn(inn);
	}

	@Override
	public Inn queryInnById(int id) {
		return innDao.queryInnById(id);
	}

	@Override
	public List<Inn> queryAllInn() {
		return innDao.queryAllInn();
	}

	@Override
	public Inn queryInnByUserInfoId(int userId) {
		return innDao.queryInnByUserInfoId(userId);
	}
	
	@Override
	public List<Inn> queryInnInNotExamine() {
		return innDao.queryInnInNotExamine();
	}

	@Override
	public List<Inn> queryInnInExamine() {
		return innDao.queryInnInExamine();
	}
	
	@Override
	public List<Inn> queryInnInExamineByInnName(String innName) {
		return innDao.queryInnInExamineByInnName(innName);
	}

	@Override
	public int[] queryInnsState() {
		return innDao.queryInnsState();
	}

	@Test
	public void tet(){
		InnService innService = (InnService)SpringUtil.getBean("innService");
		int[] count =innService.queryInnsState();
		for (int i = 0; i < count.length; i++) {
			System.out.println("状态"+i+"有-->"+count[i]+"个");
		}
	}

	@Ignore
	@Test//无法初始化代理拥有会话已关闭
	public void tset(){
		InnService innService = (InnService)SpringUtil.getBean("innService");
		Inn inn=innService.queryInnByUserInfoId(5);
		System.out.println(inn.toString());
	}
}
