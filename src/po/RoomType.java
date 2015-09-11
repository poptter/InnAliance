package po;

import java.util.HashSet;
import java.util.Set;

/**
 * RoomType entity. @author MyEclipse Persistence Tools
 */

public class RoomType implements java.io.Serializable {

	// Fields

	private Integer roomTypeId;			//客房类型编号
	private String roomTypeName;		//客房类型名称
	private String roomTypeStandard;	//客房类型价位
	private Integer roonTypeBedNumber;	//客房类型入住人数
	private Set rooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public RoomType() {
	}

	/** minimal constructor */
	public RoomType(Integer roomTypeId, String roomTypeName,
			String roomTypeStandard, Integer roonTypeBedNumber) {
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.roomTypeStandard = roomTypeStandard;
		this.roonTypeBedNumber = roonTypeBedNumber;
	}

	/** full constructor */
	public RoomType(Integer roomTypeId, String roomTypeName,
			String roomTypeStandard, Integer roonTypeBedNumber, Set rooms) {
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.roomTypeStandard = roomTypeStandard;
		this.roonTypeBedNumber = roonTypeBedNumber;
		this.rooms = rooms;
	}

	// Property accessors

	public Integer getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return this.roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public String getRoomTypeStandard() {
		return this.roomTypeStandard;
	}

	public void setRoomTypeStandard(String roomTypeStandard) {
		this.roomTypeStandard = roomTypeStandard;
	}

	public Integer getRoonTypeBedNumber() {
		return this.roonTypeBedNumber;
	}

	public void setRoonTypeBedNumber(Integer roonTypeBedNumber) {
		this.roonTypeBedNumber = roonTypeBedNumber;
	}

	public Set getRooms() {
		return this.rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoomType [roomTypeId=" + roomTypeId + ", roomTypeName="
				+ roomTypeName + ", roomTypeStandard=" + roomTypeStandard
				+ ", roonTypeBedNumber=" + roonTypeBedNumber+"]";
	}

}