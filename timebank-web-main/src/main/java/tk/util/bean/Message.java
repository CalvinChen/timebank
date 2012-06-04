package tk.util.bean;

/**
 * message use to send message to browser.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
public class Message {
	/**
	 * status, indicate success or failure
	 */
	private Boolean status = true;
	
	/**
	 * more string info can be read in info.
	 */
	private String info;

	public Message(){
	}
	
	/**
	 * @param status
	 * @param info
	 */
	public Message(Boolean status, String info) {
		super();
		this.status = status;
		this.info = info;
	}

	/**
	 * @param info
	 */
	public Message(String info) {
		super();
		this.status = true;
		this.info = info;
	}

	/* override to return a json string.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"status\": " + status + ", \"info\": \"" + info + "\"}";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
