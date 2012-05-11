/**
 * @Project TimeBank
 * @CreatedTime 2011-10-20 上午09:58:58 
 * @Author CK
 * @Todo TODO
 */
package timebank.util.bean;

/**
 * @author CK
 *
 */
public class Quote {
	private String description;
	private String username;
	private String picture;
	private int type;
	private int recordId;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
