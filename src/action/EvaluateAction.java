package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import po.Evaluate;
import po.Guest;
import po.Inn;
import po.UserInfo;
import service.EvaluateService;
import service.GuestService;
import service.InnService;
import service.UserInfoService;

import com.opensymphony.xwork2.ActionContext;

public class EvaluateAction {

	private int evaluateId;
	private int innId;
	private String content;
	private Evaluate evaluate;
	private EvaluateService evaluateService;
	private InnService innService;
	private UserInfoService userInfoService;
	private GuestService guestService;

	/**
	 * @return the evaluateId
	 */
	public int getEvaluateId() {
		return evaluateId;
	}

	/**
	 * @param evaluateId
	 *            the evaluateId to set
	 */
	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}

	/**
	 * @return the evaluate
	 */
	public Evaluate getEvaluate() {
		return evaluate;
	}

	/**
	 * @param evaluate
	 *            the evaluate to set
	 */
	public void setEvaluate(Evaluate evaluate) {
		this.evaluate = evaluate;
	}

	/**
	 * @return the evaluateService
	 */
	public EvaluateService getEvaluateService() {
		return evaluateService;
	}

	/**
	 * @param evaluateService
	 *            the evaluateService to set
	 */
	public void setEvaluateService(EvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}
	
	/**
	 * @return the innId
	 */
	public int getInnId() {
		return innId;
	}

	/**
	 * @param innId the innId to set
	 */
	public void setInnId(int innId) {
		this.innId = innId;
	}
	
	/**
	 * @return the innService
	 */
	public InnService getInnService() {
		return innService;
	}

	/**
	 * @param innService the innService to set
	 */
	public void setInnService(InnService innService) {
		this.innService = innService;
	}
	
	/**
	 * @return the userInfoService
	 */
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	/**
	 * @param userInfoService the userInfoService to set
	 */
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	/**
	 * @return the guestService
	 */
	public GuestService getGuestService() {
		return guestService;
	}

	/**
	 * @param guestService the guestService to set
	 */
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	//评论前查询客栈信息
	public String queryInnInfo(){
		//评论的客栈
		Inn inn=innService.queryInnById(innId);
		ServletActionContext.getRequest().setAttribute("inn", inn);
		return "success";
	}

	// 增加
	public String addEvaluate() {
		
		//评论的旅客
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		Guest guest = guestService.queryGuestByUseInfoId(userInfo.getUserId());
		//评论的客栈
		Inn inn=innService.queryInnById(evaluate.getInn().getInnId());
		evaluate.setGuest(guest);
		evaluate.setInn(inn);
		evaluate.setEvaluateTime(new Date());
		evaluate.setEvaluateState("提交");
		evaluateService.addEvaluate(evaluate);
		return "success";
	}

	// 删除
	public String deleteEvaluate() {
		evaluateService.deleteEvaluateById(evaluateId);
		return "success";
	}

	// 查询Id
	public String queryEvaluateById() {
		List<Evaluate> list = new ArrayList<Evaluate>();
		evaluate = evaluateService.queryEvaluateById(evaluateId);
		list.add(evaluate);
		ServletActionContext.getRequest().setAttribute("evaluates", list);
		return "success";
	}

	// 全查询
	public String queryAllEvaluate() {
		List<Evaluate> list = evaluateService.queryAllEvaluate();
		ServletActionContext.getRequest().setAttribute("evaluates", list);
		return "success";
	}

	// 修改
	public String updateEvaluate() {
		evaluateService.updateEvaluate(evaluate);
		return "success";
	}
	
	//通过审核
	public String passEvaluate() {
		evaluate = evaluateService.queryEvaluateById(evaluateId);
		evaluate.setEvaluateState("通过");
		evaluateService.updateEvaluate(evaluate);
		return "success";
	}
	
	//查询通过审核的评论列表
	public String queryAllPassEvaluate(){
		List<Evaluate> list = evaluateService.queryAllPassEvaluate();
		ServletActionContext.getRequest().setAttribute("evaluates", list);
		return "success";
	}
	
	//查询通过审核的评论列表
	public String queryAllPassEvaluateByContent(){
		List<Evaluate> list = evaluateService.queryAllPassEvaluateByContent(content);
		ServletActionContext.getRequest().setAttribute("evaluates", list);
		return "success";
	}
}
