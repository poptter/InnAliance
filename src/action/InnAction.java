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

	// ����
	public String addInn() {
		return "success";
	}

	// ɾ��
	public String deleteInn() {
		innService.deleteInnById(innId);
		return "success";
	}

	// ��ѯId
	public String queryInnById() {
		inn = innService.queryInnById(innId);
		ServletActionContext.getRequest().setAttribute("inn", inn);
		return "success";
	}

	// ȫ��ѯ
	public String queryAllInn() {
		List<Inn> list = innService.queryInnInExamine();
		ServletActionContext.getRequest().setAttribute("inns", list);
		return "success";
	}
	
	// ������ѯ
	public String queryAllInnByName() {
		List<Inn> list = innService.queryInnInExamineByInnName(innName);
		System.out.println("��ѯ�� �� "+list.size());
		ServletActionContext.getRequest().setAttribute("inns", list);
		return "success";
	}

	// �޸�
	public String updateInn() {
		innService.updateInn(inn);
		return "success";
	}
	
	//�����ջ��Ϣ
	public String innManager() {
		List<Inn> list = innService.queryAllInn();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("inns", list);
		//���ƿ�ջ���״̬�ֲ�ͼ
		String title="��ջ���״̬�ֲ�ͼ";
		String fileDir=request.getRealPath("/JFreeChatr") + "\\innManager.png";
		String[] part={"���ύ","�����","������","��ͣ"};
		int[] temp=innService.queryInnsState();
		int[] value=new int[4];
		for (int i = 0; i < value.length-1; i++) {
			value[i]=temp[i];
		}
		value[3]=0;
		MyJFreeChartUtil.getPieChart(part, value, title, fileDir);
		return "success";
	}
	
	//ͨ���û�Id��ѯ��ջ��Ϣ
	public String queryInnByUserInfoId(){
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		inn=innService.queryInnByUserInfoId(userInfo.getUserId());
		ServletActionContext.getRequest().setAttribute("inn", inn);
		return "success";
	}
	
	//ͨ�����
	public String passExamine(){
		inn = innService.queryInnById(innId);
		inn.setState("�����");
		innService.updateInn(inn);
		//������˶�����ʾ
		SmsUtil.sendPassExamine(inn.getUserInfo().getUserPhone(), inn.getInnName());
		return "success";
	}
	
	//����Ҽ��롰��������
	public String addInnBlacklist(){
		inn = innService.queryInnById(innId);
		inn.setState("������");
		innService.updateInn(inn);
		return "success";
	}
	
	//��ѯδͨ����˵ĵ��
	public String queryInnInNotExamine(){
		List<Inn> list = innService.queryInnInNotExamine();
		ServletActionContext.getRequest().setAttribute("inns", list);
		return "success";
	}
}
