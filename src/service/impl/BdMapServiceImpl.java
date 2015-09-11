package service.impl;

import java.util.List;

import org.junit.Test;

import dao.BdMapDao;
import po.BdMap;
import service.BdMapService;
import util.SpringUtil;


public class BdMapServiceImpl implements BdMapService {

	BdMapDao bdMapDao;
	
	/**
	 * @return the bdMapDao
	 */
	public BdMapDao getBdMapDao() {
		return bdMapDao;
	}

	/**
	 * @param bdMapDao the bdMapDao to set
	 */
	public void setBdMapDao(BdMapDao bdMapDao) {
		this.bdMapDao = bdMapDao;
	}

	@Override
	public void addBdMap(BdMap bdMap) {
		bdMapDao.addBdMap(bdMap);
	}

	@Override
	public void deleteBdMapById(int id) {
		bdMapDao.deleteBdMapById(id);
	}

	@Override
	public void deleteBdMap(BdMap bdMap) {
		bdMapDao.deleteBdMap(bdMap);
	}

	@Override
	public void updateBdMap(BdMap bdMap) {
		bdMapDao.updateBdMap(bdMap);
	}

	@Override
	public BdMap queryBdMapById(int id) {
		return bdMapDao.queryBdMapById(id);
	}

	@Override
	public List<BdMap> queryAllBdMap() {
		return bdMapDao.queryAllBdMap();
	}

	@Override
	public BdMap queryBdMapByInnId(int innId) {
		return bdMapDao.queryBdMapByInnId(innId);
	}
	
	@Test//error:LazyInintializationException
	public void test(){
		BdMapDao bdMapDao=(BdMapDao) SpringUtil.getBean("bdMapDao");
		BdMap bdMap=bdMapDao.queryBdMapByInnId(1);
		System.out.println(bdMap);
	}

}
