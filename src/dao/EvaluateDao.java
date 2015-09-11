package dao;

import java.util.List;

import po.Evaluate;

public interface EvaluateDao {

	/**
	 * 增加
	 * @param Evaluate
	 */
	public void addEvaluate(Evaluate evaluate);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteEvaluateById(int id);
	
	public void deleteEvaluate(Evaluate evaluate);
	
	/**
	 * 修改
	 * @param Evaluate
	 */
	public void updateEvaluate(Evaluate evaluate);
	
	/**
	 * 条件查询ID
	 * @param id
	 * @return
	 */
	public Evaluate queryEvaluateById(int id);
	
	/**
	 * 全查询
	 * @return
	 */
	public List<Evaluate> queryAllEvaluate();

	/**
	 * 浏览评论（通过审核）
	 * @return
	 */
	public List<Evaluate> queryAllPassEvaluate();

	/**
	 * 模糊查询浏览评论（通过审核）
	 * @return
	 */
	public List<Evaluate> queryAllPassEvaluateByContent(String content);
}
