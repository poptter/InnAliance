package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import po.Inn;
import po.UserInfo;
import service.InnService;
import util.MyJFreeChartUtil;
import util.SmsUtil;

import com.opensymphony.xwork2.ActionContext;

public class InnAction{

	private int innId;
	private Inn inn;
	private String innName;
	private InnService innService;
	
	/**
	 * @return the innId
	 */
	public int getInnId() {
		return innId;
	}

	/**
	 * @param innId
	 *            the innId to set
	 */
	public void setInnId(int innId) {
		this.innId = innId;
	}

	/**
	 * @return the inn
	 */
	public Inn getInn() {
		return inn;
	}

	/**
	 * @param inn
	 *            the inn to set
	 */
	public void setInn(Inn inn) {
		this.inn = inn;
	}

	/**
	 * @return the innService
	 */
	public InnService getInnService() {
		return innService;
	}

	/**
	 * @param innService
	 *            the innService to set
	 */
	public void setInnService(InnService innService) {
		this.innService = innService;
	}

	/**
	 * @return the innName
	 */
	public String getInnName() {
		return innName;
	}

	/**
	 * @param innName the innName to set
	 */
	public void setInnName(String innName) {
		this.innName = innName;
	}

	// 增加
	public String addInn() {
		return "success";
	}

	// 删除
	public String deleteInn() {
		innService.deleteInnById(innId);
		return "success";
	}

	// 查询Id
	public String queryInnById() {
		inn = innService.queryInnById(innId);
		ServletActionContext.getRequest().setAttribute("inn", inn);
		return "success";
	}

	// 全查询
	public String queryAllInn() {
		List<Inn> list = innService.queryInnInExamine();
		ServletActionContext.getRequest().setAttribute("inns", list);
		return "success";
	}
	
	// 条件查询
	public String queryAllInnByName() {
		List<Inn> list = innService.queryInnInExamineByInnName(innName);
		System.out.println("查询到 ： "+list.size());
		ServletActionContext.getRequest().setAttribute("inns", list);
		return "success";
	}

	// 修改
	public String updateInn() {
		innService.updateInn(inn);
		return "success";
	}
	
	//管理客栈信息
	public String innManager() {
		List<Inn> list = innService.queryAllInn();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("inns", list);
		//绘制客栈店家状态分布图
		String title="客栈店家状态分布图";
		String fileDir=request.getRealPath("/JFreeChatr") + "\\innManager.png";
		String[] part={"已提交","已审核","黑名单","报停"};
		int[] temp=innService.queryInnsState();
		int[] value=new int[4];
		for (int i = 0; i < value.length-1; i++) {
			value[i]=temp[i];
		}
		value[3]=0;
		MyJFreeChartUtil.getPieChart(part, value, title, fileDir);
		return "success";
	}
	
	//通过用户Id查询客栈信息
	public String queryInnByUserInfoId(){
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		inn=innService.queryInnByUserInfoId(userInfo.getUserId());
		ServletActionContext.getRequest().setAttribute("inn", inn);
		return "success";
	}
	
	//通过审核
	public String passExamine(){
		inn = innService.queryInnById(innId);
		inn.setState("已审核");
		innService.updateInn(inn);
		//发送审核短信提示
		SmsUtil.sendPassExamine(inn.getUserInfo().getUserPhone(), inn.getInnName());
		return "success";
	}
	
	//将店家加入“黑名单”
	public String addInnBlacklist(){
		inn = innService.queryInnById(innId);
		inn.setState("黑名单");
		innService.updateInn(inn);
		return "success";
	}
	
	//查询未通过审核的店家
	public String queryInnInNotExamine(){
		List<Inn> list = innService.queryInnInNotExamine();
		ServletActionContext.getRequest().setAttribute("inns", list);
		return "success";
	}
}
