package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.data.category.DefaultCategoryDataset;

import po.Inn;
import po.Room;
import po.RoomType;
import po.UserInfo;
import service.InnService;
import service.RoomService;
import service.RoomTypeService;
import util.JFreeChartUtil1;

import com.opensymphony.xwork2.ActionContext;

public class RoomAction {

	private int roomId;
	private int innId;
	private String roomName;
	private int roomTypeId;
	private Double roomRates;
	private String roomState;
	private Room room;
	private InnService innService;
	private RoomService roomService;
	private RoomTypeService roomTypeService;
	
	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	/**
	 * @return the roomService
	 */
	public RoomService getRoomService() {
		return roomService;
	}
	/**
	 * @param roomService the roomService to set
	 */
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
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
	 * @return the roomTypeService
	 */
	public RoomTypeService getRoomTypeService() {
		return roomTypeService;
	}
	/**
	 * @param roomTypeService the roomTypeService to set
	 */
	public void setRoomTypeService(RoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	
	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	/**
	 * @return the roomTypeId
	 */
	public int getRoomTypeId() {
		return roomTypeId;
	}
	
	/**
	 * @param roomTypeId the roomTypeId to set
	 */
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	
	/**
	 * @return the roomRates
	 */
	public Double getRoomRates() {
		return roomRates;
	}
	
	/**
	 * @param roomRates the roomRates to set
	 */
	public void setRoomRates(Double roomRates) {
		this.roomRates = roomRates;
	}
	
	/**
	 * @return the roomState
	 */
	public String getRoomState() {
		return roomState;
	}
	
	/**
	 * @param roomState the roomState to set
	 */
	public void setRoomState(String roomState) {
		this.roomState = roomState;
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
	
	// 增加
	public String addRoom() {
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		Inn inn=innService.queryInnByUserInfoId(userInfo.getUserId());
		room.setInn(inn);
		roomService.addRoom(room);
		return "success";
	}

	// 删除
	public String deleteRoom() {
		roomService.deleteRoomById(roomId);
		return "success";
	}

	// 查询Id
	public String queryRoomById() {
		List<Room> list = new ArrayList<Room>();
		room = roomService.queryRoomById(roomId);
		list.add(room);
		ActionContext.getContext().getSession().put("rooms", list);
		return "success";
	}

	// 全查询（通过已登录的用户Id）
	public String queryAllRoom() {
		//List<Room> list = roomService.queryAllRoom();
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		List<Room> list = roomService.queryAllRoomByUserInfoId(userInfo.getUserId());
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("rooms", list);
		//绘制条形图
		String fileDir=request.getRealPath("/JFreeChatr") + "\\roomManager.jpg";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<String[]> list2=roomService.queryRoomUseState(userInfo.getUserId());
		for (String[] str : list2) {
			dataset.addValue(Integer.valueOf(str[0]), str[2], str[1]);
		}
		JFreeChartUtil1.getBarChart(dataset, fileDir);
		return "success";
	}

	// 修改
	public String updateRoom() {
		room=roomService.queryRoomById(roomId);
		room.setRoomName(roomName);
		room.setRoomType(roomTypeService.queryRoomTypeById(roomTypeId));
		room.setRoomRates(roomRates);
		room.setRoomState(roomState);
		roomService.updateRoom(room);
		return "success";
	}
	
	//查询待修改的客房信息
	public String queryUpdateRoomById() {
		room = roomService.queryRoomById(roomId);
		ActionContext.getContext().getSession().put("room", room);
		List<RoomType> list = roomTypeService.queryAllRoomType();
		ServletActionContext.getRequest().setAttribute("roomTypes", list);
		return "success";
	}
	
	//查看可用的客房信息
	public String queryAllAvailableRoom(){
		List<Room> list = roomService.queryAllAvailableRoom();
		ServletActionContext.getRequest().setAttribute("rooms", list);
		List<Inn> inns=innService.queryInnInExamine();
		ServletActionContext.getRequest().setAttribute("inns", inns);
		return "success";
	}
	
	//通过客栈ID查询可用的客房信息
	public String queryAllAvailableRoomByInnId(){
		List<Room> list = roomService.queryAllAvailableRoomByInnId(innId);
		ServletActionContext.getRequest().setAttribute("rooms", list);
		List<Inn> inns=innService.queryInnInExamine();
		ServletActionContext.getRequest().setAttribute("inns", inns);
		return "success";
	}
	
}
