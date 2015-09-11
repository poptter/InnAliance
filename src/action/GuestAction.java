package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import po.Guest;
import po.Role;
import po.UserInfo;
import service.GuestService;
import service.RoleService;
import service.UserInfoService;
import util.Md5Util;
import util.QRCodeUtil;
import util.SpringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GuestAction  extends ActionSupport implements ServletContextAware{

	private int guestId;
	private String userNo;
	private Guest guest;
	private GuestService guestService;
	private UserInfoService userInfoService;
	private RoleService roleService;
	private File userPhoto;// ʵ���ϴ��ļ�
	private String userPhotoFileName; // �ϴ��ļ���
	private ServletContext context;
	/**
	 * @return the guestId
	 */
	public int getGuestId() {
		return guestId;
	}

	/**
	 * @param guestId
	 *            the guestId to set
	 */
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	/**
	 * @return the guest
	 */
	public Guest getGuest() {
		return guest;
	}

	/**
	 * @param guest
	 *            the guest to set
	 */
	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	/**
	 * @return the guestService
	 */
	public GuestService getGuestService() {
		return guestService;
	}

	/**
	 * @param guestService
	 *            the guestService to set
	 */
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}
	
	/**
	 * @return the roleService
	 */
	public RoleService getRoleService() {
		return roleService;
	}

	/**
	 * @param roleService the roleService to set
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
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
	
	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	//��֤�û����Ƿ����
	public String cheakUserNo(){
		UserInfo userInfo=userInfoService.queryUserInfoByNo(userNo);
		if(userInfo!=null){
			PrintWriter out;
			try {
				out = ServletActionContext.getResponse().getWriter();
				out.write("err");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ����
	public String addGuest() {
		//���ý�ɫ
		Role role=roleService.queryRoleById(3);
		guest.getUserInfo().setRole(role);
		// ����
		guest.getUserInfo().setUserPwd(Md5Util.enCode2(guest.getUserInfo().getUserPwd()));
		if(userPhoto!=null){
			// �ϴ�·��
			try {
				String targetDirectory = context.getRealPath("/userPhoto");
				String targetFileName = userPhotoFileName;
				targetFileName = guest.getUserInfo().getUserNo()+ targetFileName.substring(targetFileName.lastIndexOf("."));
				File target = new File(targetDirectory, targetFileName);
				FileUtils.copyFile(userPhoto, target);// �����ļ�
				guest.getUserInfo().setUserPhoto(target.getPath());
				//���ɶ�Ӧ�Ķ�ά��
				String RQCodeStr=guest.getUserInfo().getUserName()+"\t Tel:"+guest.getUserInfo().getUserPhone();
				String RQCodeDir=target.getParent()+"/RQCode/"+targetFileName;
				QRCodeUtil.encode(RQCodeStr, target.getPath(), RQCodeDir, true);
			} catch (Exception e) {
				addActionError(e.getMessage());
			}			
		}
		guest.setGuestCredit("0");
		guest.setGuestCreateDate(new Date());
		guestService.addGuest(guest);
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script language = javascript> alert('ע��ɹ�����ص���ҳ��¼��'); </script>");
			response.getWriter().write("<script language = javascript> top.location='index.jsp'; </script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ɾ��
	public String deleteGuest() {
		System.out.println("id : " + guestId);
		guestService.deleteGuestById(guestId);
		return "success";
	}

	// ��ѯId
	public String queryGuestById() {
		List<Guest> list = new ArrayList<Guest>();
		guest = guestService.queryGuestById(guestId);
		list.add(guest);
		ActionContext.getContext().getSession().put("guests", list);
		return "success";
	}

	// ȫ��ѯ
	public String queryAllGuest() {
		List<Guest> list = guestService.queryAllGuest();
		ActionContext.getContext().getSession().put("guests", list);
		return "success";
	}

	// �޸�
	public String updateGuest() {
		guestService.updateGuest(guest);
		return "success";
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

}
