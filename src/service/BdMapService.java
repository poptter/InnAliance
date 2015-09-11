package service;

import java.util.List;

import po.BdMap;

public interface BdMapService {

	/**
	 * 增加
	 * @param BdMap
	 */
	public void addBdMap(BdMap bdMap);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteBdMapById(int id);
	
	public void deleteBdMap(BdMap bdMap);
	
	/**
	 * 修改
	 * @param BdMap
	 */
	public void updateBdMap(BdMap bdMap);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public BdMap queryBdMapById(int id);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<BdMap> queryAllBdMap();
	
	/**
	 * 通过客栈ID查询地图信息
	 * @return
	 */
	public BdMap queryBdMapByInnId(int innId);
}
