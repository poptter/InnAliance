package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import po.BdMap;
import po.Inn;
import po.Role;
import po.UserInfo;
import service.BdMapService;
import service.InnService;
import service.RoleService;
import service.UserInfoService;
import util.Md5Util;
import util.QRCodeUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BdMapAction extends ActionSupport implements ServletContextAware{
	
	private int mapId;
	private int innId;
	private String userNo;
	private String innName;
	private String innIdCard;
	private String innPrimitId;
	private String innAddress;
	private String innIntroduction;
	private BdMap bdMap;
	private BdMapService bdMapService;
	private UserInfoService userInfoService;
	private RoleService roleService;
	private InnService innService;
	
	private File[] photos;// 实际上传文件
	private String[] photosFileName; // 上传文件名
	private File innPhoto;// 实际上传文件
	private String innPhotoFileName; // 上传文件名
	private ServletContext context;
	

	/**
	 * @return the mapId
	 */
	public int getMapId() {
		return mapId;
	}

	/**
	 * @param mapId the mapId to set
	 */
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	
	/**
	 * @return the bdMap
	 */
	public BdMap getBdMap() {
		return bdMap;
	}

	/**
	 * @param bdMap the bdMap to set
	 */
	public void setBdMap(BdMap bdMap) {
		this.bdMap = bdMap;
	}
	
	/**
	 * @return the bdMapService
	 */
	public BdMapService getBdMapService() {
		return bdMapService;
	}

	/**
	 * @param bdMapService
	 *            the bdMapService to set
	 */
	public void setBdMapService(BdMapService bdMapService) {
		this.bdMapService = bdMapService;
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

	/**
	 * @return the innIdCard
	 */
	public String getInnIdCard() {
		return innIdCard;
	}

	/**
	 * @param innIdCard the innIdCard to set
	 */
	public void setInnIdCard(String innIdCard) {
		this.innIdCard = innIdCard;
	}

	/**
	 * @return the innPrimitId
	 */
	public String getInnPrimitId() {
		return innPrimitId;
	}

	/**
	 * @param innPrimitId the innPrimitId to set
	 */
	public void setInnPrimitId(String innPrimitId) {
		this.innPrimitId = innPrimitId;
	}

	/**
	 * @return the innAddress
	 */
	public String getInnAddress() {
		return innAddress;
	}

	/**
	 * @param innAddress the innAddress to set
	 */
	public void setInnAddress(String innAddress) {
		this.innAddress = innAddress;
	}

	/**
	 * @return the innIntroduction
	 */
	public String getInnIntroduction() {
		return innIntroduction;
	}

	/**
	 * @param innIntroduction the innIntroduction to set
	 */
	public void setInnIntroduction(String innIntroduction) {
		this.innIntroduction = innIntroduction;
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
	 * @return the photos
	 */
	public File[] getPhotos() {
		return photos;
	}

	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(File[] photos) {
		this.photos = photos;
	}

	/**
	 * @return the photosFileName
	 */
	public String[] getPhotosFileName() {
		return photosFileName;
	}

	/**
	 * @param photosFileName the photosFileName to set
	 */
	public void setPhotosFileName(String[] photosFileName) {
		this.photosFileName = photosFileName;
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
	
	/**
	 * @return the innPhoto
	 */
	public File getInnPhoto() {
		return innPhoto;
	}

	/**
	 * @param innPhoto the innPhoto to set
	 */
	public void setInnPhoto(File innPhoto) {
		this.innPhoto = innPhoto;
	}

	/**
	 * @return the innPhotoFileName
	 */
	public String getInnPhotoFileName() {
		return innPhotoFileName;
	}

	/**
	 * @param innPhotoFileName the innPhotoFileName to set
	 */
	public void setInnPhotoFileName(String innPhotoFileName) {
		this.innPhotoFileName = innPhotoFileName;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context=context;
	}
	
	//验证用户是否存在
	public String cheakInnUserNo(){
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
	
	// 增加
	public String addBdMap() {
		//设置角色
		Role role=roleService.queryRoleById(2);
		bdMap.getInn().getUserInfo().setRole(role);
		
		if(photos[0]!=null){
			
			// 上传路径
			try {
				String targetDirectory = context.getRealPath("/userPhoto");
				String targetFileName = photosFileName[0];
				targetFileName = bdMap.getInn().getUserInfo().getUserNo()+ targetFileName.substring(targetFileName.lastIndexOf("."));
				File target = new File(targetDirectory, targetFileName);
				FileUtils.copyFile(photos[0], target);// 保存文件
				bdMap.getInn().getUserInfo().setUserPhoto(target.getPath());
				//生成对应的二维码
				String RQCodeStr=bdMap.getInn().getInnName()+"\t"+bdMap.getInn().getUserInfo().getUserName()+"\n Tel:"+bdMap.getInn().getUserInfo().getUserPhone();
				String RQCodeDir=target.getParent()+"/RQCode/"+targetFileName;
				QRCodeUtil.encode(RQCodeStr, target.getPath(), RQCodeDir, true);
			} catch (Exception e) {
				addActionError(e.getMessage());
			}			
		}
		
		//保存用户
		userInfoService.addUserInfo(bdMap.getInn().getUserInfo());
		
		//初始评价为“5”
		bdMap.getInn().setInnValuation("5");
		bdMap.getInn().setState("已提交");
		
		if(photos[1]!=null){
			// 上传图片
			try {
				String targetDirectory = context.getRealPath("/innPhoto");
				String targetFileName = photosFileName[1];
				targetFileName = bdMap.getInn().getUserInfo().getUserNo()+ targetFileName.substring(targetFileName.lastIndexOf("."));
				File target = new File(targetDirectory, targetFileName);
				FileUtils.copyFile(photos[1], target);// 保存文件
				bdMap.getInn().setInnPhoto(target.getPath());
			} catch (Exception e) {
				addActionError(e.getMessage());
			}			
		}
		
		//保存客栈
		innService.addInn(bdMap.getInn());
		
		//保存地图
		bdMapService.addBdMap(bdMap);
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script language = javascript> alert('注册成功！请等待管理员审核短信通知！'); </script>");
			response.getWriter().write("<script language = javascript> top.location='index.jsp'; </script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除
	public String deleteBdMap() {
		bdMapService.deleteBdMapById(mapId);
		return "success";
	}

	// 查询Id
	public String queryBdMapById() {
		List<BdMap> list = new ArrayList<BdMap>();
		bdMap = bdMapService.queryBdMapById(mapId);
		list.add(bdMap);
		ActionContext.getContext().getSession().put("bdMaps", list);
		return "success";
	}

	// 全查询
	public String queryAllBdMap() {
		List<BdMap> list = bdMapService.queryAllBdMap();
		ActionContext.getContext().getSession().put("bdMaps", list);
		return "success";
	}

	// 修改
	public String updateBdMap() {
		bdMap=bdMapService.queryBdMapByInnId(innId);
		bdMap.getInn().setInnIdCard(innIdCard);
		bdMap.getInn().setInnPrimitId(innPrimitId);
		bdMap.getInn().setInnAddress(innAddress);
		bdMap.getInn().setInnIntroduction(innIntroduction);
		if(innPhoto!=null){
			// 上传图片
			try {
				String targetDirectory = context.getRealPath("/innPhoto");
				String targetFileName = innPhotoFileName;
				targetFileName = bdMap.getInn().getUserInfo().getUserNo()+ targetFileName.substring(targetFileName.lastIndexOf("."));
				File target = new File(targetDirectory, targetFileName);
				FileUtils.copyFile(innPhoto, target);// 保存文件
				bdMap.getInn().setInnPhoto(target.getPath());
			} catch (Exception e) {
				addActionError(e.getMessage());
			}			
		}
		bdMapService.updateBdMap(bdMap);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write("<script language = javascript> alert('您的客栈信息修改成功！'); </script>");
			response.getWriter().write("<script language = javascript> top.location='index.jsp'; </script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//通过客栈ID查询
	public String queryBdMapByInnId(){
		bdMap=bdMapService.queryBdMapByInnId(innId);
		ActionContext.getContext().getSession().put("bdMap", bdMap);
		return "success";
	}
	
	//查询当前用户的客栈地图信息
	public String queryBdMapByUserInfoId(){
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		Inn inn=innService.queryInnByUserInfoId(userInfo.getUserId());
		bdMap=bdMapService.queryBdMapByInnId(inn.getInnId());
		ActionContext.getContext().getSession().put("bdMap", bdMap);
		return "success";
	}

}
