package timebank.model.bank;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import timebank.model.Values;
import timebank.model.user.User;

/**
 * side record is for depositing and withdrawing.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "side_record")
public class SideRecord {
	/**
	 * side record id 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * the type of this business, can be deposit or withdraw.
	 */
	@Column(name = "business_type", nullable = false, unique = false)
	private short businessType;

	/**
	 * what's the status of the request.
	 */
	@Column(name = "status_type", nullable = false, unique = false)
	private short status;
	
	/**
	 * user who request this business.
	 */
	@ManyToOne
	@JoinColumn(name = "request_user_id", nullable = false, unique = false)
	private User requester;
	
	/**
	 * when did the user accept.
	 */
	@Column(name = "acceptable_date", nullable = false, unique = false)
	private short date;
	
	/**
	 * acceptable time to help or to be help.
	 */
	@Column(name = "acceptable_time", nullable = false, unique = false)
	private short time;
	
	/**
	 * acceptable zone to help or to be help.
	 */
	@Column(name = "acceptable_zone", nullable = false, unique = false)
	private short zone;
	
	/**
	 * acceptable range to help or to be help.
	 */
	@Column(name = "acceptable_range", nullable = false, unique = false)
	private short range;
	
	/**
	 * the title of this record.
	 */
	@Column(name = "record_title", length = Values.NORMAL_TITLE_LENGTH, nullable = false, unique = false)
	private String title;
	
	/**
	 * description of the business.
	 */
	@Column(name = "description_column", length = Values.NORMAL_CONTENT_LENGTH,
			nullable = false, unique = false)
	private String description;

	/**
	 * when did the user post this request.
	 */
	@Column(name = "post_time", nullable = false, unique = false)
	private Date postTime;
	
	/**
	 * link to bank complete record.
	 * can be null if this business have become complete yet.
	 */
	@ManyToOne
	@JoinColumn(name = "link_complete_record_id", nullable = true, unique = false)
	private HelpRecord linkCompleteRecord;
	
	/**
	 * which mode to match.
	 */
	@OneToOne
	@JoinColumn(name = "match_mode_id", nullable = false, unique = true)
	private MatchMode matchMode;
	
	/**
	 * the display option of the request.
	 */
	@OneToOne
	@JoinColumn(name = "display_id", nullable = false, unique = true)
	private DisplayOption displayOption;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getBusinessType() {
		return businessType;
	}

	public void setBusinessType(short businessType) {
		this.businessType = businessType;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public short getDate() {
		return date;
	}

	public void setDate(short date) {
		this.date = date;
	}

	public short getTime() {
		return time;
	}

	public void setTime(short time) {
		this.time = time;
	}

	public short getZone() {
		return zone;
	}

	public void setZone(short zone) {
		this.zone = zone;
	}

	public short getRange() {
		return range;
	}

	public void setRange(short range) {
		this.range = range;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public HelpRecord getLinkCompleteRecord() {
		return linkCompleteRecord;
	}

	public void setLinkCompleteRecord(HelpRecord linkCompleteRecord) {
		this.linkCompleteRecord = linkCompleteRecord;
	}

	public MatchMode getMatchMode() {
		return matchMode;
	}

	public void setMatchMode(MatchMode matchMode) {
		this.matchMode = matchMode;
	}

	public DisplayOption getDisplayOption() {
		return displayOption;
	}

	public void setDisplayOption(DisplayOption displayOption) {
		this.displayOption = displayOption;
	}
	
}
