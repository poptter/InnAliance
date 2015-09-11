package service.impl;

import java.util.List;

import po.Evaluate;
import service.EvaluateService;
import dao.EvaluateDao;

public class EvaluateServiceImpl implements EvaluateService {

	EvaluateDao evaluateDao;
	
	/**
	 * @return the evaluateDao
	 */
	public EvaluateDao getEvaluateDao() {
		return evaluateDao;
	}

	/**
	 * @param evaluateDao the evaluateDao to set
	 */
	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}

	@Override
	public void addEvaluate(Evaluate evaluate) {
		evaluateDao.addEvaluate(evaluate);
	}

	@Override
	public void deleteEvaluateById(int id) {
		evaluateDao.deleteEvaluateById(id);
	}

	@Override
	public void deleteEvaluate(Evaluate evaluate) {
		evaluateDao.deleteEvaluate(evaluate);
	}

	@Override
	public void updateEvaluate(Evaluate evaluate) {
		evaluateDao.updateEvaluate(evaluate);
	}

	@Override
	public Evaluate queryEvaluateById(int id) {
		return evaluateDao.queryEvaluateById(id);
	}

	@Override
	public List<Evaluate> queryAllEvaluate() {
		return evaluateDao.queryAllEvaluate();
	}

	@Override
	public List<Evaluate> queryAllPassEvaluate() {
		return evaluateDao.queryAllPassEvaluate();
	}

	@Override
	public List<Evaluate> queryAllPassEvaluateByContent(String content) {
		return evaluateDao.queryAllPassEvaluateByContent(content);
	}

}
