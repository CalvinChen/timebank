/**
 * @Project TimeBank
 * @CreatedTime 2011-10-9 下午04:19:08 
 * @Author CK
 */
package timebank.model.message;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import timebank.model.user.User;

/**
 * message of user
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "user_message_from_system")
public class UserMessageFromSystem {
	
	/**
	 * message id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * message type.
	 */
	@Column(name = "message_type", nullable = false, unique = false)
	private Short type;
	
	/**
	 * owner, a user.
	 */
	@ManyToOne
	@JoinColumn(name = "owner_user_id", nullable = false, unique = false)
	private User owner;
	
	/**
	 * title of the message.
	 */
	@Column(name = "message_title", length = 40, nullable = false, unique = false)
	private String title;
	
	/**
	 * content of the message.
	 */
	@Column(name = "message_content", length = 2000, nullable = false, unique = false)
	private String content;
	
	/**
	 * when did the message send?
	 */
	@Column(name = "send_time", nullable = false, unique = false)
	private Date sendTime;

	/**
	 * when did the message being read?
	 * can be null if not read yet.
	 */
	@Column(name = "read_time", nullable = true, unique = false)
	private Date readTime;

	/**
	 * is this message read by user yet?
	 * default value is false.
	 */
	@Column(name = "is_read", nullable = false, unique = false)
	private Boolean isRead = false;

	public int getId() {
		return id;
	}

	public void setId(int messageId) {
		this.id = messageId;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}
}
