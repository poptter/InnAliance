package service;

import java.util.List;

import po.BdMap;

public interface BdMapService {

	/**
	 * ����
	 * @param BdMap
	 */
	public void addBdMap(BdMap bdMap);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteBdMapById(int id);
	
	public void deleteBdMap(BdMap bdMap);
	
	/**
	 * �޸�
	 * @param BdMap
	 */
	public void updateBdMap(BdMap bdMap);
	
	/**
	 * ������ѯID
	 * @param id
	 * @return
	 */
	public BdMap queryBdMapById(int id);
	
	/**
	 * ȫ��ѯ
	 * @return
	 */
	public List<BdMap> queryAllBdMap();
	
	/**
	 * ͨ����ջID��ѯ��ͼ��Ϣ
	 * @return
	 */
	public BdMap queryBdMapByInnId(int innId);
}
