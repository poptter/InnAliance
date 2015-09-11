package po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Guest entity. @author MyEclipse Persistence Tools
 */

public class Guest implements java.io.Serializable {

	// Fields

	private Integer guestId;		//旅客编号
	private UserInfo userInfo;		//旅客对应的用户
	private String guestCredit;		//旅客信誉等级
	private Date guestCreateDate;	//旅客注册日期
	private Set evaluates = new HashSet(0);
	private Set orderRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Guest() {
	}

	/** minimal constructor */
	public Guest(Integer guestId, String guestCredit, Date guestCreateDate) {
		this.guestId = guestId;
		this.guestCredit = guestCredit;
		this.guestCreateDate = guestCreateDate;
	}

	/** full constructor */
	public Guest(Integer guestId, UserInfo userInfo, String guestCredit,
			Date guestCreateDate, Set evaluates, Set orderRooms) {
		this.guestId = guestId;
		this.userInfo = userInfo;
		this.guestCredit = guestCredit;
		this.guestCreateDate = guestCreateDate;
		this.evaluates = evaluates;
		this.orderRooms = orderRooms;
	}

	// Property accessors

	public Integer getGuestId() {
		return this.guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getGuestCredit() {
		return this.guestCredit;
	}

	public void setGuestCredit(String guestCredit) {
		this.guestCredit = guestCredit;
	}

	public Date getGuestCreateDate() {
		return this.guestCreateDate;
	}

	public void setGuestCreateDate(Date guestCreateDate) {
		this.guestCreateDate = guestCreateDate;
	}

	public Set getEvaluates() {
		return this.evaluates;
	}

	public void setEvaluates(Set evaluates) {
		this.evaluates = evaluates;
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
		return "Guest [guestId=" + guestId + ", userInfo=" + userInfo
				+ ", guestCredit=" + guestCredit + ", guestCreateDate="
				+ guestCreateDate + "]";
	}

}