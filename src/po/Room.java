package po;

import java.util.HashSet;
import java.util.Set;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields

	private Integer roomId;		//客房编号
	private Inn inn;			//客房对应的客栈
	private RoomType roomType;	//客房对应的客房类型
	private String roomName;	//客房名称
	private Double roomRates;	//客房价位
	private String roomState;	//客房状态
	private Set orderRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(Integer roomId, String roomName, Double roomRates,
			String roomState) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomRates = roomRates;
		this.roomState = roomState;
	}

	/** full constructor */
	public Room(Integer roomId, Inn inn, RoomType roomType, String roomName,
			Double roomRates, String roomState, Set orderRooms) {
		this.roomId = roomId;
		this.inn = inn;
		this.roomType = roomType;
		this.roomName = roomName;
		this.roomRates = roomRates;
		this.roomState = roomState;
		this.orderRooms = orderRooms;
	}

	// Property accessors

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Inn getInn() {
		return this.inn;
	}

	public void setInn(Inn inn) {
		this.inn = inn;
	}

	public RoomType getRoomType() {
		return this.roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Double getRoomRates() {
		return this.roomRates;
	}

	public void setRoomRates(Double roomRates) {
		this.roomRates = roomRates;
	}

	public String getRoomState() {
		return this.roomState;
	}

	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}

	public Set getOrderRooms() {
		return this.orderRooms;
	}

	public void setOrderRooms(Set orderRooms) {
		this.orderRooms = orderRooms;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", inn=" + inn + ", roomType="
				+ roomType + ", roomName=" + roomName + ", roomRates="
				+ roomRates + ", roomState=" + roomState + "]";
	}

}