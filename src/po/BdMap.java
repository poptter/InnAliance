package po;

/**
 * BdMap entity. @author MyEclipse Persistence Tools
 */

public class BdMap implements java.io.Serializable {

	// Fields

	private Integer mapId;	//��ͼ���
	private Inn inn;		//��ͼ��Ӧ��ջ
	private String mapX;	//��ͼ������Ϣ
	private String mapY;	//��ͼγ����Ϣ

	// Constructors

	/** default constructor */
	public BdMap() {
	}

	/** minimal constructor */
	public BdMap(Integer mapId, String mapX) {
		this.mapId = mapId;
		this.mapX = mapX;
		this.mapY = mapY;
	}

	/** full constructor */
	public BdMap(Integer mapId, Inn inn, String mapX, String mapY) {
		this.mapId = mapId;
		this.inn = inn;
		this.mapX = mapX;
		this.mapY = mapY;
	}

	// Property accessors

	public Integer getMapId() {
		return this.mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Inn getInn() {
		return this.inn;
	}

	public void setInn(Inn inn) {
		this.inn = inn;
	}

	public String getMapX() {
		return this.mapX;
	}

	public void setMapX(String mapX) {
		this.mapX = mapX;
	}

	public String getMapY() {
		return this.mapY;
	}

	public void setMapY(String mapY) {
		this.mapY = mapY;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BdMap [mapId=" + mapId + ", inn=" + inn + ", mapX=" + mapX + ", mapY=" + mapY + "]";
	}

}