package dao;

import java.util.List;

import po.Evaluate;

public interface EvaluateDao {

	/**
	 * ����
	 * @param Evaluate
	 */
	public void addEvaluate(Evaluate evaluate);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteEvaluateById(int id);
	
	public void deleteEvaluate(Evaluate evaluate);
	
	/**
	 * �޸�
	 * @param Evaluate
	 */
	public void updateEvaluate(Evaluate evaluate);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public Evaluate queryEvaluateById(int id);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<Evaluate> queryAllEvaluate();

	/**
	 * ������ۣ�ͨ����ˣ�
	 * @return
	 */
	public List<Evaluate> queryAllPassEvaluate();

	/**
	 * ģ����ѯ������ۣ�ͨ����ˣ�
	 * @return
	 */
	public List<Evaluate> queryAllPassEvaluateByContent(String content);
}
