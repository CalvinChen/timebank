package timebank.model;

public class WithdrawRecord {
	private int withdrawId;
	private int userId;
	private String username;
	private String picture;
	private String theDate;
	private int theTime;
	private int zoneWithdraw;
	private int rangeWithdraw;
	private String description;
	private int linkHelpRecordId;
	private String updateTime;
	private String createTime;
	private int status;
	private int mode;
	private int seekNumber;
	private int seekLeft;
	private int toTop;
	private int detailed;
	public int getToTop() {
		return toTop;
	}
	public void setToTop(int toTop) {
		this.toTop = toTop;
	}
	public int getDetailed() {
		return detailed;
	}
	public void setDetailed(int detailed) {
		this.detailed = detailed;
	}
	private String expireDate;
	
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getSeekNumber() {
		return seekNumber;
	}
	public void setSeekNumber(int seekNumber) {
		this.seekNumber = seekNumber;
	}
	public int getSeekLeft() {
		return seekLeft;
	}
	public void setSeekLeft(int seekLeft) {
		this.seekLeft = seekLeft;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getLinkHelpRecordId() {
		return linkHelpRecordId;
	}
	public void setLinkHelpRecordId(int linkHelpRecordId) {
		this.linkHelpRecordId = linkHelpRecordId;
	}
	public int getTheTime() {
		return theTime;
	}
	public void setTheTime(int theTime) {
		this.theTime = theTime;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getBankCoreBusinessId() {
		return withdrawId;
	}
	public void setWithdrawId(int withdrawId) {
		this.withdrawId = withdrawId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTheDate() {
		return theDate;
	}
	public void setTheDate(String withdrawTime) {
		this.theDate = withdrawTime;
	}
	public int getZoneWithdraw() {
		return zoneWithdraw;
	}
	public void setZoneWithdraw(int zoneWithdraw) {
		this.zoneWithdraw = zoneWithdraw;
	}
	public int getRangeWithdraw() {
		return rangeWithdraw;
	}
	public void setRangeWithdraw(int rangeWithdraw) {
		this.rangeWithdraw = rangeWithdraw;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}