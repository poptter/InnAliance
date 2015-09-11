package action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import po.RoomType;
import service.RoomTypeService;

public class RoomTypeAction {

	private int roomTypeId;
	private RoomType roomType;
	private RoomTypeService roomTypeService;
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
	 * @return the roomType
	 */
	public RoomType getRoomType() {
		return roomType;
	}
	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
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

	// 增加
	public String addRoomType() {
		roomTypeService.addRoomType(roomType);
		return "success";
	}

	// 删除
	public String deleteRoomType() {
		System.out.println("id : " + roomTypeId);
		roomTypeService.deleteRoomTypeById(roomTypeId);
		return "success";
	}

	// 查询Id
	public String queryRoomTypeById() {
		List<RoomType> list = new ArrayList<RoomType>();
		roomType = roomTypeService.queryRoomTypeById(roomTypeId);
		list.add(roomType);
		ServletActionContext.getRequest().setAttribute("roomTypes", list);
		return "success";
	}

	// 全查询
	public String queryAllRoomType() {
		List<RoomType> list = roomTypeService.queryAllRoomType();
		ServletActionContext.getRequest().setAttribute("roomTypes", list);
		return "success";
	}

	// 修改
	public String updateRoomType() {
		roomTypeService.updateRoomType(roomType);
		return "success";
	}

}
