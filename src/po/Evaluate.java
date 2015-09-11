package po;

import java.util.Date;

/**
 * Evaluate entity. @author MyEclipse Persistence Tools
 */

public class Evaluate implements java.io.Serializable {

	// Fields

	private Integer evaluateId;		//评论编号
	private Inn inn;				//评论客栈
	private Guest guest;			//评论旅客
	private String evaluateContent;	//评论内容
	private Date evaluateTime;		//评论时间
	private String evaluateState;	//评论状态

	// Constructors

	/** default constructor */
	public Evaluate() {
	}

	/** minimal constructor */
	public Evaluate(Integer evaluateId, String evaluateContent,
			String evaluateState) {
		this.evaluateId = evaluateId;
		this.evaluateContent = evaluateContent;
		this.evaluateState = evaluateState;
	}

	/** full constructor */
	public Evaluate(Integer evaluateId, Inn inn, Guest guest,
			String evaluateContent, String evaluateState) {
		this.evaluateId = evaluateId;
		this.inn = inn;
		this.guest = guest;
		this.evaluateContent = evaluateContent;
		this.evaluateState = evaluateState;
	}

	// Property accessors

	public Integer getEvaluateId() {
		return this.evaluateId;
	}

	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
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

	public String getEvaluateContent() {
		return this.evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	public Date getEvaluateTime() {
		return evaluateTime;
	}

	public void setEvaluateTime(Date evaluateTime) {
		this.evaluateTime = evaluateTime;
	}
	
	public String getEvaluateState() {
		return this.evaluateState;
	}

	public void setEvaluateState(String evaluateState) {
		this.evaluateState = evaluateState;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Evaluate [evaluateId=" + evaluateId + ", inn=" + inn
				+ ", guest=" + guest + ", evaluateContent=" + evaluateContent
				+ ", evaluateTime=" + evaluateTime + ", evaluateState="
				+ evaluateState + "]";
	}
}