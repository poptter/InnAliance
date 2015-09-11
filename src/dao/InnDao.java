package dao;

import java.util.List;

import po.Inn;

public interface InnDao {

	/**
	 * ����
	 * @param InnAction
	 */
	public void addInn(Inn inn);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteInnById(int id);
	
	public void deleteInn(Inn inn);
	
	/**
	 * �޸�
	 * @param InnAction
	 */
	public void updateInn(Inn inn);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public Inn queryInnById(int id);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<Inn> queryAllInn();

	/**
	 * ͨ�����Id����ѯ��ջ
	 * @return
	 */
	public Inn queryInnByUserInfoId(int userId);
	
	/**
	 * ��ѯδͨ����˵ĵ��
	 * @return
	 */
	public List<Inn> queryInnInNotExamine();
	
	/**
	 * ��ѯͨ����˵ĵ��
	 * @return
	 */
	public List<Inn> queryInnInExamine();

	/**
	 * ͨ����ջ���Ʋ�ѯͨ����˵ĵ�ң�ģ����ѯ��
	 * @param innName
	 * @return
	 */
	public List<Inn> queryInnInExamineByInnName(String innName);

	/**
	 * ��ѯ���е��״̬�ֲ�
	 * @return
	 */
	public int[] queryInnsState();
}
