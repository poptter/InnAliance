package po;

import java.util.HashSet;
import java.util.Set;

/**
 * Inn entity. @author MyEclipse Persistence Tools
 */

public class Inn implements java.io.Serializable {

	// Fields

	private Integer innId;			//客栈编号
	private UserInfo userInfo;		//客栈对应的用户（店家）
	private String state;			//客栈状态
	private String innName;			//客栈名称
	private String innIdCard;		//客栈负责任身份证号
	private String innPrimitId;		//客栈营业执照编号
	private String innAddress;		//客栈地址
	private String innIntroduction;	//客栈简介
	private String innValuation;	//客栈评论等级
	private String innPhoto;		//客栈照片
	private Set rooms = new HashSet(0);
	private Set orderRooms = new HashSet(0);
	private Set evaluates = new HashSet(0);
	private Set bdMaps = new HashSet(0);

	// Constructors

	/** default constructor */
	public Inn() {
	}

	/** minimal constructor */
	public Inn(Integer innId, String innName, String innIdCard,
			String innPrimitId, String innAddress) {
		this.innId = innId;
		this.innName = innName;
		this.innIdCard = innIdCard;
		this.innPrimitId = innPrimitId;
		this.innAddress = innAddress;
	}

	/** full constructor */
	public Inn(Integer innId, UserInfo userInfo, String state, String innName,
			String innIdCard, String innPrimitId, String innAddress,
			String innIntroduction, String innValuation, String innPhoto,
			Set rooms, Set orderRooms, Set evaluates, Set bdMaps) {
		this.innId = innId;
		this.userInfo = userInfo;
		this.state = state;
		this.innName = innName;
		this.innIdCard = innIdCard;
		this.innPrimitId = innPrimitId;
		this.innAddress = innAddress;
		this.innIntroduction = innIntroduction;
		this.innValuation = innValuation;
		this.innPhoto = innPhoto;
		this.rooms = rooms;
		this.orderRooms = orderRooms;
		this.evaluates = evaluates;
		this.bdMaps = bdMaps;
	}

	// Property accessors

	public Integer getInnId() {
		return this.innId;
	}

	public void setInnId(Integer innId) {
		this.innId = innId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getInnName() {
		return this.innName;
	}

	public void setInnName(String innName) {
		this.innName = innName;
	}

	public String getInnIdCard() {
		return this.innIdCard;
	}

	public void setInnIdCard(String innIdCard) {
		this.innIdCard = innIdCard;
	}

	public String getInnPrimitId() {
		return this.innPrimitId;
	}

	public void setInnPrimitId(String innPrimitId) {
		this.innPrimitId = innPrimitId;
	}

	public String getInnAddress() {
		return this.innAddress;
	}

	public void setInnAddress(String innAddress) {
		this.innAddress = innAddress;
	}

	public String getInnIntroduction() {
		return this.innIntroduction;
	}

	public void setInnIntroduction(String innIntroduction) {
		this.innIntroduction = innIntroduction;
	}

	public String getInnValuation() {
		return this.innValuation;
	}

	public void setInnValuation(String innValuation) {
		this.innValuation = innValuation;
	}

	public String getInnPhoto() {
		return this.innPhoto;
	}

	public void setInnPhoto(String innPhoto) {
		this.innPhoto = innPhoto;
	}

	public Set getRooms() {
		return this.rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

	public Set getOrderRooms() {
		return this.orderRooms;
	}

	public void setOrderRooms(Set orderRooms) {
		this.orderRooms = orderRooms;
	}

	public Set getEvaluates() {
		return this.evaluates;
	}

	public void setEvaluates(Set evaluates) {
		this.evaluates = evaluates;
	}

	public Set getBdMaps() {
		return this.bdMaps;
	}

	public void setBdMaps(Set bdMaps) {
		this.bdMaps = bdMaps;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Inn [innId=" + innId + ", userInfo=" + userInfo + ", state="
				+ state + ", innName=" + innName + ", innIdCard=" + innIdCard
				+ ", innPrimitId=" + innPrimitId + ", innAddress=" + innAddress
				+ ", innIntroduction=" + innIntroduction + ", innValuation="
				+ innValuation + ", innPhoto=" + innPhoto + "]";
	}

}