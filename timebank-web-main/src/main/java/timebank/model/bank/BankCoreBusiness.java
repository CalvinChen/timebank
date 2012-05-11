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

import timebank.model.user.User;

/**
 * bank core business is for depositing and withdrawing.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "bank_core_business")
public class BankCoreBusiness {
	/**
	 * bank core business id 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_core_business_id", nullable = false, unique = true)
	private int bankCoreBusinessId;
	
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
	 * description of the business.
	 */
	@Column(name = "description_column", length = 2000, nullable = false, unique = false)
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
	private BankCompleteRecord linkCompleteRecord;
	
	/**
	 * which mode to match.
	 */
	@OneToOne
	@JoinColumn(name = "match_mode_id", nullable = false, unique = true)
	private BankCoreBusinessMode matchMode;
	
	/**
	 * the display option of the request.
	 */
	@OneToOne
	@JoinColumn(name = "display_id", nullable = false, unique = true)
	private BankCoreBusinessDisplay displayOption;

	public int getBankCoreBusinessId() {
		return bankCoreBusinessId;
	}

	public void setBankCoreBusinessId(int bankCoreBusinessId) {
		this.bankCoreBusinessId = bankCoreBusinessId;
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

	public BankCompleteRecord getLinkCompleteRecord() {
		return linkCompleteRecord;
	}

	public void setLinkCompleteRecord(BankCompleteRecord linkCompleteRecord) {
		this.linkCompleteRecord = linkCompleteRecord;
	}

	public BankCoreBusinessMode getMatchMode() {
		return matchMode;
	}

	public void setMatchMode(BankCoreBusinessMode matchMode) {
		this.matchMode = matchMode;
	}

	public BankCoreBusinessDisplay getDisplayOption() {
		return displayOption;
	}

	public void setDisplayOption(BankCoreBusinessDisplay displayOption) {
		this.displayOption = displayOption;
	}
	
}
