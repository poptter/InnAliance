package dao;

import java.util.List;

import po.Inn;

public interface InnDao {

	/**
	 * 增加
	 * @param InnAction
	 */
	public void addInn(Inn inn);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteInnById(int id);
	
	public void deleteInn(Inn inn);
	
	/**
	 * 修改
	 * @param InnAction
	 */
	public void updateInn(Inn inn);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public Inn queryInnById(int id);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<Inn> queryAllInn();

	/**
	 * 通过店家Id来查询客栈
	 * @return
	 */
	public Inn queryInnByUserInfoId(int userId);
	
	/**
	 * 查询未通过审核的店家
	 * @return
	 */
	public List<Inn> queryInnInNotExamine();
	
	/**
	 * 查询通过审核的店家
	 * @return
	 */
	public List<Inn> queryInnInExamine();

	/**
	 * 通过客栈名称查询通过审核的店家（模糊查询）
	 * @param innName
	 * @return
	 */
	public List<Inn> queryInnInExamineByInnName(String innName);

	/**
	 * 查询所有店家状态分布
	 * @return
	 */
	public int[] queryInnsState();
}
