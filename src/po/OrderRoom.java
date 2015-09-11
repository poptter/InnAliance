package po;

import java.util.Date;

/**
 * OrderRoom entity. @author MyEclipse Persistence Tools
 */

public class OrderRoom implements java.io.Serializable {

	// Fields

	private Integer orderRoomId;			//预定编号
	private Inn inn;						//预定客栈
	private Guest guest;					//预定旅客
	private Room room;						//预定客房
	private Integer orderRoomPeopleNumber;	//预定入住人数
	private Date orderRoomBeginTime;		//预定开始时间
	private Date orderRoomEndTime;			//预定结束时间
	private Double orderRoomPrice;			//预定报价/实价
	private String orderRoomState;			//预定状态

	// Constructors

	/** default constructor */
	public OrderRoom() {
	}

	/** minimal constructor */
	public OrderRoom(Integer orderRoomId, Integer orderRoomPeopleNumber,
			Date orderRoomBeginTime, Date orderRoomEndTime,
			String orderRoomState) {
		this.orderRoomId = orderRoomId;
		this.orderRoomPeopleNumber = orderRoomPeopleNumber;
		this.orderRoomBeginTime = orderRoomBeginTime;
		this.orderRoomEndTime = orderRoomEndTime;
		this.orderRoomState = orderRoomState;
	}

	/** full constructor */
	public OrderRoom(Integer orderRoomId, Inn inn, Guest guest, Room room,
			Integer orderRoomPeopleNumber, Date orderRoomBeginTime,
			Date orderRoomEndTime, Double orderRoomPrice, String orderRoomState) {
		this.orderRoomId = orderRoomId;
		this.inn = inn;
		this.guest = guest;
		this.room = room;
		this.orderRoomPeopleNumber = orderRoomPeopleNumber;
		this.orderRoomBeginTime = orderRoomBeginTime;
		this.orderRoomEndTime = orderRoomEndTime;
		this.orderRoomPrice = orderRoomPrice;
		this.orderRoomState = orderRoomState;
	}

	// Property accessors

	public Integer getOrderRoomId() {
		return this.orderRoomId;
	}

	public void setOrderRoomId(Integer orderRoomId) {
		this.orderRoomId = orderRoomId;
	}

	public Inn getInn() {
		return this.inn;
	}

	public void setInn(Inn inn) {
		this.inn = inn;
	}

	public Guest getGuest() {
		return this.guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getOrderRoomPeopleNumber() {
		return this.orderRoomPeopleNumber;
	}

	public void setOrderRoomPeopleNumber(Integer orderRoomPeopleNumber) {
		this.orderRoomPeopleNumber = orderRoomPeopleNumber;
	}

	/**
	 * @return the orderRoomBeginTime
	 */
	public Date getOrderRoomBeginTime() {
		return orderRoomBeginTime;
	}

	/**
	 * @param orderRoomBeginTime
	 *            the orderRoomBeginTime to set
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
	 * @param orderRoomEndTime
	 *            the orderRoomEndTime to set
	 */
	public void setOrderRoomEndTime(Date orderRoomEndTime) {
		this.orderRoomEndTime = orderRoomEndTime;
	}

	public Double getOrderRoomPrice() {
		return this.orderRoomPrice;
	}

	public void setOrderRoomFronyMoney(Double orderRoomPrice) {
		this.orderRoomPrice = orderRoomPrice;
	}

	public String getOrderRoomState() {
		return this.orderRoomState;
	}

	public void setOrderRoomState(String orderRoomState) {
		this.orderRoomState = orderRoomState;
	}

	public void setOrderRoomPrice(Double orderRoomPrice) {
		this.orderRoomPrice = orderRoomPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderRoom [orderRoomId=" + orderRoomId + ", inn=" + inn
				+ ", guest=" + guest + ", room=" + room
				+ ", orderRoomPeopleNumber=" + orderRoomPeopleNumber
				+ ", orderRoomBeginTime=" + orderRoomBeginTime
				+ ", orderRoomEndTime=" + orderRoomEndTime
				+ ", orderRoomPrice=" + orderRoomPrice + ", orderRoomState="
				+ orderRoomState + "]";
	}

}