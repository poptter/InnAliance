package po;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userId;		//�û����
	private Role role;			//�û���Ӧ��ɫ���
	private String userNo;		//�û���
	private String userPwd;		//�û�����
	private String userName;	//�û���������
	private String userPhone;	//�û���ϵ�绰
	private String userEmail;	//�û�����
	private String userQq;		//�û�QQ
	private String userWeixin;	//�û�΢��
	private String userPhoto;	//�û�ͷ��
	private Set inns = new HashSet(0);
	private Set guests = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(Integer userId, String userNo, String userPwd,
			String userName, String userPhone) {
		this.userId = userId;
		this.userNo = userNo;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	/** full constructor */
	public UserInfo(Integer userId, Role role, String userNo, String userPwd,
			String userName, String userPhone, String userEmail, String userQq,
			String userWeixin, String userPhoto, Set inns, Set guests) {
		this.userId = userId;
		this.role = role;
		this.userNo = userNo;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userQq = userQq;
		this.userWeixin = userWeixin;
		this.userPhoto = userPhoto;
		this.inns = inns;
		this.guests = guests;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserQq() {
		return this.userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserWeixin() {
		return this.userWeixin;
	}

	public void setUserWeixin(String userWeixin) {
		this.userWeixin = userWeixin;
	}

	public String getUserPhoto() {
		return this.userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Set getInns() {
		return this.inns;
	}

	public void setInns(Set inns) {
		this.inns = inns;
	}

	public Set getGuests() {
		return this.guests;
	}

	public void setGuests(Set guests) {
		this.guests = guests;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", role=" + role + ", userNo="
				+ userNo + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", userQq=" + userQq + ", userWeixin=" + userWeixin
				+ ", userPhoto=" + userPhoto + "]";
	}

}