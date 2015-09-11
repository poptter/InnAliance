package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.ServletContextAware;

import po.UserInfo;
import service.UserInfoService;
import util.Md5Util;
import util.MyJFreeChartUtil;
import util.QRCodeUtil;
import util.SmsUtil;
import util.StringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware , ServletContextAware{

	// Struts2��Map���͵�session
	private Map<String, Object> session;
	// ���տͻ��˴�������֤��
	private String securityCode;

	private int userId;
	private String userNo;
	private String userPhone;
	private String userEmail;
	private String userQq;
	private String userWeixin;
	private String oldPassword;
	private String newPassword;
	private File userPhoto;// ʵ���ϴ��ļ�
	private String userPhotoFileName; // �ϴ��ļ���
	private ServletContext context;

	private UserInfo userInfo;
	private UserInfoService userInfoService;

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return the securityCode
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * @param securityCode
	 *            the securityCode to set
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo
	 *            the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * @param userPhone
	 *            the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userQq
	 */
	public String getUserQq() {
		return userQq;
	}

	/**
	 * @param userQq
	 *            the userQq to set
	 */
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	/**
	 * @return the userWeinxin
	 */
	public String getUserWeixin() {
		return userWeixin;
	}

	/**
	 * @param userWeixin
	 *            the userWeixin to set
	 */
	public void setUserWeixin(String userWeixin) {
		this.userWeixin = userWeixin;
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo
	 *            the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @return the userInfoService
	 */
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	/**
	 * @param userInfoService
	 *            the userInfoService to set
	 */
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword
	 *            the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword
	 *            the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	/**
	 * @return the userPhoto
	 */
	public File getUserPhoto() {
		return userPhoto;
	}

	/**
	 * @param userPhoto the userPhoto to set
	 */
	public void setUserPhoto(File userPhoto) {
		this.userPhoto = userPhoto;
	}

	/**
	 * @return the userPhotoFileName
	 */
	public String getUserPhotoFileName() {
		return userPhotoFileName;
	}

	/**
	 * @param userPhotoFileName the userPhotoFileName to set
	 */
	public void setUserPhotoFileName(String userPhotoFileName) {
		this.userPhotoFileName = userPhotoFileName;
	}

	/**
	 * @return the context
	 */
	public ServletContext getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Override
	public void setServletContext(ServletContext context) {
		this.context=context;
	}
	
	// ����
	public String addUserInfo() {
		userInfoService.addUserInfo(userInfo);
		return "success";
	}

	// ɾ��
	public String deleteUserInfo() {
		userInfoService.deleteUserInfoById(userId);
		return "success";
	}

	// ��ѯId
	public String queryUserInfoById() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		userInfo = userInfoService.queryUserInfoById(userId);
		list.add(userInfo);
		ActionContext.getContext().getSession().put("userInfos", list);
		return "success";
	}

	// �޸ĵ�ǰ�û���Ϣ
	public String updateUserInfoBise(){
		userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		userInfo.setUserPhone(userPhone);
		userInfo.setUserEmail(userEmail);
		userInfo.setUserQq(userQq);
		userInfo.setUserWeixin(userWeixin);
		if(userPhoto!=null){
			// �ϴ�·��
				String targetDirectory = context.getRealPath("/userPhoto");
				String targetFileName = userPhotoFileName;
				targetFileName = userInfo.getUserNo()+ targetFileName.substring(targetFileName.lastIndexOf("."));
				File target = new File(targetDirectory, targetFileName);
				try {
					FileUtils.copyFile(userPhoto, target);
					// �����ļ�
					userInfo.setUserPhoto(target.getPath());
					//���ɶ�Ӧ�Ķ�ά��
					String RQCodeStr=userInfo.getUserName()+"\t Tel:"+userInfo.getUserPhone();
					String RQCodeDir=target.getParent()+"/RQCode/"+targetFileName;
					QRCodeUtil.encode(RQCodeStr, target.getPath(), RQCodeDir, true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		userInfoService.updateUserInfo(userInfo);
		
		try {
			ActionContext.getContext().getSession().put("loginUser", userInfo);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script language = javascript> alert('������Ϣ�޸ĳɹ���'); </script>");
			response.getWriter().write("<script language = javascript> top.location='index.jsp'; </script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ��ѯNo
	public String queryUserInfoByNo() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		userInfo = userInfoService.queryUserInfoByNo(userNo);
		list.add(userInfo);
		ActionContext.getContext().getSession().put("userInfos", list);
		return "success";
	}

	// ȫ��ѯ
	public String queryAllUserInfo() {
		List<UserInfo> list = userInfoService.queryAllUserInfo();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("userInfos", list);
		//�����û����״̬�ֲ�ͼ
		String title="ϵͳ�û���ɫ����";
		String fileDir=request.getRealPath("/JFreeChatr") + "\\userManager.png";
		String[] part={"����Ա","��ջ���","�ÿ�","����"};
		int[] temp=userInfoService.queryUserState();
		int[] value=new int[4];
		for (int i = 0; i < value.length-1; i++) {
			value[i]=temp[i];
		}
		value[3]=0;
		MyJFreeChartUtil.getPieChart(part, value, title, fileDir);
		return "success";
	}

	// �޸��û���Ϣ
	public String updateUserInfo() {
		userInfoService.updateUserInfo(userInfo);
		return "success";
	}

	// �޸��û�����
	public String updateUserPassword() {
		userInfo = (UserInfo) ActionContext.getContext().getSession()
				.get("loginUser");
		oldPassword = Md5Util.enCode2(oldPassword);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (!oldPassword.equals(userInfo.getUserPwd())) {
			System.out.println("err!");
			try {
				response.getWriter().write("<script language = javascript> alert('����ԭ����������������룡'); </script>");
				response.getWriter().write("<script language = javascript> window.history.back(-1); </script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				userInfo.setUserPwd(Md5Util.enCode2(newPassword));
				userInfoService.updateUserInfo(userInfo);
				ActionContext.getContext().getSession().remove("loginUser");
				response.getWriter().write("<script language = javascript> alert('���������޸ĳɹ��������µ�¼��'); </script>");
				response.getWriter().write("<script language = javascript> top.location='index.jsp'; </script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ��¼
	public String login() {
		String serverCode = (String) session.get("SESSION_SECURITY_CODE");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж���֤��
		if (!serverCode.equals(securityCode)) {
			try {
				response.getWriter().write("<script language = javascript> alert('���������֤�����'); </script>");
				response.getWriter().write("<script language = javascript> top.location='index.jsp#menu1/menu1_2'; </script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// �����ж��û���������
			String account = userInfo.getUserNo();
			String password = Md5Util.enCode2(userInfo.getUserPwd());
			userInfo = userInfoService.queryUserInfoByNo(account);
			if (userInfo == null) {
				try {
					response.getWriter().write("<script language = javascript> alert('���û������ڣ�'); </script>");
					response.getWriter().write("<script language = javascript> top.location='index.jsp#menu1/menu1_2'; </script>");
					return null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (password.equals(userInfo.getUserPwd())) {
				try {
					ActionContext.getContext().getSession().put("loginUser", userInfo);
					response.getWriter().write("<script language = javascript> top.location='index.jsp'; </script>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					response.getWriter().write("<script language = javascript> alert('������������µ�¼��'); </script>");
					response.getWriter().write("<script language = javascript> top.location='index.jsp#menu1/menu1_2'; </script>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		return null;
	}

	// �˳�
	public String loginOut() {
		try {
			ActionContext.getContext().getSession().remove("loginUser");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script language = javascript> top.location='index.jsp'; </script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// �һ�����
	public String forgerPwd() {
		userInfo = userInfoService.queryUserInfoByNo(userNo);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (userInfo == null) {
			try {
				response.getWriter().write("<script language = javascript> alert('���û������ڣ�'); </script>");
				response.getWriter().write("<script language = javascript> top.location='index.jsp#menu1/menu1_3'; </script>");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!userPhone.equals(userInfo.getUserPhone())) {
			try {
				response.getWriter().write("<script language = javascript> alert('�������ע���ֻ������������������룡'); </script>");
				response.getWriter().write("<script language = javascript> top.location='index.jsp#menu1/menu1_3'; </script>");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// �����������
		String newPwd = StringUtil.getRandomString(6);
		System.out.println("newPwd : " + newPwd);
		// ����
		String enCodePwd = Md5Util.enCode2(newPwd);
		// ��������
		userInfo.setUserPwd(enCodePwd);
		userInfoService.updateUserInfo(userInfo);
		// ���Ͷ���
		SmsUtil.sendNewPwd(userInfo.getUserPhone(), newPwd);
		try {
			response.getWriter().write("<script language = javascript> alert('ϵͳ�ѽ����������޸ģ��Ժ������յ�����������Ķ��ţ�'); </script>");
			response.getWriter().write("<script language = javascript> top.location='index.jsp#menu1/menu1_2'; </script>");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
