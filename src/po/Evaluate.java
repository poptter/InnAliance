package po;

import java.util.Date;

/**
 * Evaluate entity. @author MyEclipse Persistence Tools
 */

public class Evaluate implements java.io.Serializable {

	// Fields

	private Integer evaluateId;		//���۱��
	private Inn inn;				//���ۿ�ջ
	private Guest guest;			//�����ÿ�
	private String evaluateContent;	//��������
	private Date evaluateTime;		//����ʱ��
	private String evaluateState;	//����״̬

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