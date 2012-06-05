package timebank.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import timebank.model.Values;

/**
 * common used user's information
 * @author Calvin Chen
 * @createTime Apr 11, 2012
 */
@Entity
@Table(name = "user_info")
public class UserInfo {

	/**
	 * user information id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * email
	 */
	@Column(name = "email_address", length = Values.LARGE_NAME_LENGTH,
			nullable = true, unique = false)
	private String email;

	/**
	 * true name
	 */
	@Column(name = "true_name", length = Values.NORMAL_NAME_LENGTH,
			nullable = true, unique = false)
	private String trueName;
	
	/**
	 * qq id
	 */
	@Column(name = "qq_id", length = Values.NORMAL_NAME_LENGTH,
			nullable = true, unique = false)
	private String qqId;
	
	/**
	 * weibo url
	 */
	@Column(name = "weibo_url", length = Values.LARGE_NAME_LENGTH,
			nullable = true, unique = false)
	private String weiboUrl;
	
	/**
	 * blog url
	 */
	@Column(name = "blog_url", length = Values.LARGE_NAME_LENGTH,
			nullable = true, unique = false)
	private String blogUrl;
	
	/**
	 * sex
	 */
	@Column(name = "sex_column", length = Values.NORMAL_NAME_LENGTH,
			nullable = true, unique = false)
	private String sex;
	
	/**
	 * address
	 */
	@Column(name = "live_address", length = Values.LARGE_NAME_LENGTH,
			nullable = true, unique = false)
	private String address;
	
	/**
	 * phone long number.
	 */
	@Column(name = "phone_long", length = Values.NORMAL_NAME_LENGTH,
			nullable = true, unique = false)
	private String phoneLong;
	
	/**
	 * phone short number
	 */
	@Column(name = "phone_short", length = Values.NORMAL_NAME_LENGTH,
			nullable = true, unique = false)
	private String phoneShort;
	
	/**
	 * user's photo
	 */
	@Column(name = "user_photo", length = Values.NORMAL_PICTURE_URL_LENGTH,
			nullable = true, unique = false)
	private String userPhoto;

	public int getId() {
		return id;
	}

	public void setId(int userInfoId) {
		this.id = userInfoId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public String getWeiboUrl() {
		return weiboUrl;
	}

	public void setWeiboUrl(String weiboUrl) {
		this.weiboUrl = weiboUrl;
	}

	public String getBlogUrl() {
		return blogUrl;
	}

	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneLong() {
		return phoneLong;
	}

	public void setPhoneLong(String phoneLong) {
		this.phoneLong = phoneLong;
	}

	public String getPhoneShort() {
		return phoneShort;
	}

	public void setPhoneShort(String phoneShort) {
		this.phoneShort = phoneShort;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
}
