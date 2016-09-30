package pers.liujunyi.tally.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TCoreAttachment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_core_attachment")
public class TCoreAttachment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String attachCode;
	private String attachParent;
	private Integer attachLevel;
	private String userId;
	private String projectId;
	private String itemId;
	private String bid;
	private String attachOriginalName;
	private String attachNewName;
	private String attachRelativePaths;
	private String absolutePath;
	private String voiceUrl;
	private Float attachSize;
	private Float voiceLength;
	private String attachSuffix;
	private String attachType;
	private String attachData;
	private String createDate;

	// Constructors

	/** default constructor */
	public TCoreAttachment() {
	}

	/** minimal constructor */
	public TCoreAttachment(String attachOriginalName, String attachNewName,
			String attachRelativePaths, String absolutePath,
			String attachSuffix, String attachType) {
		this.attachOriginalName = attachOriginalName;
		this.attachNewName = attachNewName;
		this.attachRelativePaths = attachRelativePaths;
		this.absolutePath = absolutePath;
		this.attachSuffix = attachSuffix;
		this.attachType = attachType;
	}

	/** full constructor */
	public TCoreAttachment(String attachCode, String attachParent,
			Integer attachLevel, String userId, String projectId,
			String itemId, String bid, String attachOriginalName,String createDate,
			String attachNewName, String attachRelativePaths,Float voiceLength,
			String absolutePath, Float attachSize, String attachSuffix,
			String attachType, String attachData,String voiceUrl) {
		this.attachCode = attachCode;
		this.attachParent = attachParent;
		this.attachLevel = attachLevel;
		this.userId = userId;
		this.projectId = projectId;
		this.itemId = itemId;
		this.bid = bid;
		this.attachOriginalName = attachOriginalName;
		this.attachNewName = attachNewName;
		this.attachRelativePaths = attachRelativePaths;
		this.absolutePath = absolutePath;
		this.attachSize = attachSize;
		this.attachSuffix = attachSuffix;
		this.attachType = attachType;
		this.attachData = attachData;
		this.voiceUrl = voiceUrl;
		this.voiceLength = voiceLength;
		this.createDate = createDate;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ATTACH_CODE", length = 32)
	public String getAttachCode() {
		return this.attachCode;
	}

	public void setAttachCode(String attachCode) {
		this.attachCode = attachCode;
	}

	@Column(name = "ATTACH_PARENT", length = 32)
	public String getAttachParent() {
		return this.attachParent;
	}

	public void setAttachParent(String attachParent) {
		this.attachParent = attachParent;
	}

	@Column(name = "ATTACH_LEVEL")
	public Integer getAttachLevel() {
		return this.attachLevel;
	}

	public void setAttachLevel(Integer attachLevel) {
		this.attachLevel = attachLevel;
	}
	
	@Column(name = "USER_ID", length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PROJECT_ID", length = 32)
	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "ITEM_ID", length = 32)
	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Column(name = "BID", length = 20)
	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	@Column(name = "ATTACH_ORIGINAL_NAME", nullable = false, length = 100)
	public String getAttachOriginalName() {
		return this.attachOriginalName;
	}

	public void setAttachOriginalName(String attachOriginalName) {
		this.attachOriginalName = attachOriginalName;
	}

	@Column(name = "ATTACH_NEW_NAME", nullable = false, length = 100)
	public String getAttachNewName() {
		return this.attachNewName;
	}

	public void setAttachNewName(String attachNewName) {
		this.attachNewName = attachNewName;
	}

	@Column(name = "ATTACH_RELATIVE_PATHS", nullable = false, length = 255)
	public String getAttachRelativePaths() {
		return this.attachRelativePaths;
	}

	public void setAttachRelativePaths(String attachRelativePaths) {
		this.attachRelativePaths = attachRelativePaths;
	}

	@Column(name = "ABSOLUTE_PATH", nullable = false, length = 255)
	public String getAbsolutePath() {
		return this.absolutePath;
	}

	
	@Column(name = "VOICE_URL", nullable = false, length = 255)
	public String getVoiceUrl() {
		return voiceUrl;
	}

	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	@Column(name = "ATTACH_SIZE", precision = 12, scale = 0)
	public Float getAttachSize() {
		return this.attachSize;
	}

	public void setAttachSize(Float attachSize) {
		this.attachSize = attachSize;
	}

	
	@Column(name = "VOICE_LENGTH", precision = 12, scale = 0)
	public Float getVoiceLength() {
		return voiceLength;
	}

	public void setVoiceLength(Float voiceLength) {
		this.voiceLength = voiceLength;
	}

	@Column(name = "ATTACH_SUFFIX", nullable = false, length = 10)
	public String getAttachSuffix() {
		return this.attachSuffix;
	}

	public void setAttachSuffix(String attachSuffix) {
		this.attachSuffix = attachSuffix;
	}

	@Column(name = "ATTACH_TYPE", nullable = false, length = 4)
	public String getAttachType() {
		return this.attachType;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

	@Column(name = "ATTACH_DATA")
	public String getAttachData() {
		return this.attachData;
	}

	public void setAttachData(String attachData) {
		this.attachData = attachData;
	}

	@Column(name = "CREATE_DATE", nullable = false, length = 19)
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	

}