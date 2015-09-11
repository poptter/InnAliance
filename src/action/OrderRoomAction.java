package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import po.Guest;
import po.Inn;
import po.OrderRoom;
import po.Room;
import po.UserInfo;
import service.GuestService;
import service.InnService;
import service.OrderRoomService;
import service.RoomService;
import util.MyJFreeChartUtil;
import util.SmsUtil;

import com.opensymphony.xwork2.ActionContext;

public class OrderRoomAction {
	
	private int orderRoomId;
	private double orderRoomPrice;
	private int orderRoomPeopleNumber;
	private int roomId;
	private Inn inn;
	private Guest guest;
	private Room room;
	private OrderRoom orderRoom;
	
	private InnService innService;
	private GuestService guestService;
	private RoomService roomService;
	private OrderRoomService orderRoomService;
	private Date orderRoomBeginTime;
	private Date orderRoomEndTime;
	/**
	 * @return the orderRoomId
	 */
	public int getOrderRoomId() {
		return orderRoomId;
	}

	/**
	 * @param orderRoomId the orderRoomId to set
	 */
	public void setOrderRoomId(int orderRoomId) {
		this.orderRoomId = orderRoomId;
	}

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
	 * @return the inn
	 */
	public Inn getInn() {
		return inn;
	}

	/**
	 * @param inn the inn to set
	 */
	public void setInn(Inn inn) {
		this.inn = inn;
	}

	/**
	 * @return the guest
	 */
	public Guest getGuest() {
		return guest;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(Guest guest) {
		this.guest = guest;
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
	 * @return the orderRoom
	 */
	public OrderRoom getOrderRoom() {
		return orderRoom;
	}

	/**
	 * @param orderRoom the orderRoom to set
	 */
	public void setOrderRoom(OrderRoom orderRoom) {
		this.orderRoom = orderRoom;
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
	 * @return the orderRoomService
	 */
	public OrderRoomService getOrderRoomService() {
		return orderRoomService;
	}

	/**
	 * @param orderRoomService the orderRoomService to set
	 */
	public void setOrderRoomService(OrderRoomService orderRoomService) {
		this.orderRoomService = orderRoomService;
	}
	
	/**
	 * @return the orderRoomPrice
	 */
	public double getOrderRoomPrice() {
		return orderRoomPrice;
	}

	/**
	 * @param orderRoomPrice the orderRoomPrice to set
	 */
	public void setOrderRoomPrice(double orderRoomPrice) {
		this.orderRoomPrice = orderRoomPrice;
	}

	/**
	 * @return the orderRoomPeopleNumber
	 */
	public int getOrderRoomPeopleNumber() {
		return orderRoomPeopleNumber;
	}

	/**
	 * @param orderRoomPeopleNumber the orderRoomPeopleNumber to set
	 */
	public void setOrderRoomPeopleNumber(int orderRoomPeopleNumber) {
		this.orderRoomPeopleNumber = orderRoomPeopleNumber;
	}
	
	/**
	 * @return the orderRoomBeginTime
	 */
	public Date getOrderRoomBeginTime() {
		return orderRoomBeginTime;
	}

	/**
	 * @param orderRoomBeginTime the orderRoomBeginTime to set
	 */
	public void setOrderRoomBeginTime(Date orderRoomBeginTime) {
		this.orderRoomBeginTime = orderRoomBeginTime;
	}

	/**
	 * @return the orderRoomEndTime
	 */
	public Date getOrderRoomEndTime() {
		return orderRoomEndTime;
	}

	/**
	 * @param orderRoomEndTime the orderRoomEndTime to set
	 */
	public void setOrderRoomEndTime(Date orderRoomEndTime) {
		this.orderRoomEndTime = orderRoomEndTime;
	}
	
	// 增加
	public String addOrderRoom() {
		//订房旅客
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		Guest guest = guestService.queryGuestByUseInfoId(userInfo.getUserId());
		//预定的客栈
		inn=innService.queryInnById(orderRoom.getInn().getInnId());
		//预定的客房
		room=roomService.queryRoomById(orderRoom.getRoom().getRoomId());
		room.setRoomState("预定");
		orderRoom.setGuest(guest);
		orderRoom.setInn(inn);
		orderRoom.setRoom(room);
		orderRoom.setOrderRoomState("预定");
		orderRoom.setOrderRoomBeginTime(orderRoomBeginTime);
		orderRoom.setOrderRoomEndTime(orderRoomEndTime);
		orderRoomService.addOrderRoom(orderRoom);
		SmsUtil.sendOrderMsg(userInfo.getUserPhone(), orderRoom);
		return "success";
	}

	// 删除
	public String deleteOrderRoom() {
		orderRoomService.deleteOrderRoomById(orderRoomId);
		return "success";
	}

	// 查询Id
	public String queryOrderRoomById() {
		List<OrderRoom> list = new ArrayList<OrderRoom>();
		orderRoom = orderRoomService.queryOrderRoomById(orderRoomId);
		list.add(orderRoom);
		ServletActionContext.getRequest().setAttribute("orderRooms", list);
		return "success";
	}

	// 查询所有自己的“预定”状态的订单
	public String queryAllOrderRoom() {
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		List<OrderRoom> list = orderRoomService.queryAllScheduleOrderRoomByUserInfoId(userInfo.getUserId());
		ServletActionContext.getRequest().setAttribute("orderRooms", list);
		return "success";
	}

	// 修改
	public String updateOrderRoom() {
		orderRoom=orderRoomService.queryOrderRoomById(orderRoomId);
		orderRoom.setOrderRoomPrice(orderRoomPrice);
		orderRoom.setOrderRoomPeopleNumber(orderRoomPeopleNumber);
		orderRoomService.updateOrderRoom(orderRoom);
		return "success";
	}
	
	//通过客房ID查询客房信息，并传到新增订单页面
	public String queryRoomByRoomIdForAddOrder(){
		room=roomService.queryRoomById(roomId);
		ServletActionContext.getRequest().setAttribute("room", room);
		return "success";
	}
	
	//查看待修改的订单
	public String queryAllOrderRoomByInnId() {
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("loginUser");
		Inn inn=innService.queryInnByUserInfoId(userInfo.getUserId());
		List<OrderRoom> list = orderRoomService.queryAllOrderRoomByInnId(inn.getInnId());
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("orderRooms", list);
		String title="客房预定走势";
		String fileDir=request.getRealPath("/JFreeChatr") + "\\innOrder.jpg";
		List<Map<String, Object>> list2=orderRoomService.OrderMonthlyReportByInnId(inn.getInnId());
		MyJFreeChartUtil.getLineChart(list2, fileDir, inn.getInnName());
		return "success";
	}
	
	//查看需要修改的订单信息
	public String queryNeedUpdateOrder(){
		orderRoom = orderRoomService.queryOrderRoomById(orderRoomId);
		ServletActionContext.getRequest().setAttribute("orderRoom", orderRoom);
		return "success";
	}

	//订单管理
	public String queryAllOrderRoomForManager() {
		List<OrderRoom> list = orderRoomService.queryAllOrderRoom();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("orderRooms", list);
		String title="客栈店家状态分布图";
		String fileDir=request.getRealPath("/JFreeChatr") + "\\orderManager.jpg";
		List<Map<String, Object>> list2=orderRoomService.OrderMonthlyReport();
		MyJFreeChartUtil.getBarChart3D(list2, fileDir);
		return "success";
	}
	
	//退订
	public String unsubscribe(){
		orderRoom = orderRoomService.queryOrderRoomById(orderRoomId);
		orderRoom.setOrderRoomState("退订");
		orderRoom.getRoom().setRoomState("可用");
		orderRoomService.updateOrderRoom(orderRoom);
		return "success";
	}
}
