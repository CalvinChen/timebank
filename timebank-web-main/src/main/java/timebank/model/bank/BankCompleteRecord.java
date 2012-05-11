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
 * bank complete record, not only success but also failure.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "bank_complete_record")
public class BankCompleteRecord {
	
	/**
	 * bank complete record id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_complete_record_id", nullable = false, unique = true)
	private int bankCompleteRecordId;

	/**
	 * what's the status of the record.
	 */
	@Column(name = "status_type", nullable = false, unique = false)
	private short status;
	
	/**
	 * the user who offer help.
	 */
	@ManyToOne
	@JoinColumn(name = "user_to_help_id", nullable = false, unique = false)
	private User userToHelp;
	
	/**
	 * the user who receive help.
	 */
	@ManyToOne
	@JoinColumn(name = "user_be_helped", nullable = false, unique = false)
	private User userBeHelped;
	
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
	 * when did the user post this request.
	 */
	@Column(name = "post_time", nullable = false, unique = false)
	private Date postTime;

	/**
	 * description from the to-help.
	 */
	@Column(name = "description_by_to_help", length = 2000, nullable = false, unique = false)
	private String descriptionByToHelp;
	
	/**
	 * description from the helped.
	 */
	@Column(name = "description_by_helped", length = 2000, nullable = false, unique = false)
	private String descriptionByHelped;

	/**
	 * feedback given by the to-help.
	 * can be null if not give yet.
	 */
	@OneToOne
	@JoinColumn(name = "feedback_by_to_help_id", nullable = true, unique = false)
	private BankCompleteRecordFeedback feedbackByToHelp;

	/**
	 * feedback given by the helped.
	 * can be null if not give yet.
	 */
	@OneToOne
	@JoinColumn(name = "feedback_by_helped_id", nullable = true, unique = false)
	private BankCompleteRecordFeedback feedbackByHelped;
	
	/**
	 * the user who complete this record.
	 */
	@ManyToOne
	@JoinColumn(name = "require_user_id", nullable = false, unique = false)
	private User requireUser;
	
	/**
	 * validation information.
	 * can be null if admin have not validate yet.
	 */
	@OneToOne
	@JoinColumn(name = "validation_info_id", nullable = true, unique = false)
	private BankCompleteRecordValidation validationInfo;
	
	/**
	 * linked to-help business.
	 * can be null if not from to-help business.
	 */
	@ManyToOne
	@JoinColumn(name = "link_to_help_business_id", nullable = true, unique = false)
	private BankCoreBusiness linkToHelpBusiness;
	
	/**
	 * linked helped business.
	 * can be null if not from helped business.
	 */
	@ManyToOne
	@JoinColumn(name = "link_helped_business_id", nullable = true, unique = false)
	private BankCoreBusiness linkHelpedBusiness;

	public int getBankCompleteRecordId() {
		return bankCompleteRecordId;
	}

	public void setBankCompleteRecordId(int bankCompleteRecordId) {
		this.bankCompleteRecordId = bankCompleteRecordId;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public User getUserToHelp() {
		return userToHelp;
	}

	public void setUserToHelp(User userToHelp) {
		this.userToHelp = userToHelp;
	}

	public User getUserBeHelped() {
		return userBeHelped;
	}

	public void setUserBeHelped(User userBeHelped) {
		this.userBeHelped = userBeHelped;
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

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getDescriptionByToHelp() {
		return descriptionByToHelp;
	}

	public void setDescriptionByToHelp(String descriptionByToHelp) {
		this.descriptionByToHelp = descriptionByToHelp;
	}

	public String getDescriptionByHelped() {
		return descriptionByHelped;
	}

	public void setDescriptionByHelped(String descriptionByHelped) {
		this.descriptionByHelped = descriptionByHelped;
	}

	public BankCompleteRecordFeedback getFeedbackByToHelp() {
		return feedbackByToHelp;
	}

	public void setFeedbackByToHelp(BankCompleteRecordFeedback feedbackByToHelp) {
		this.feedbackByToHelp = feedbackByToHelp;
	}

	public BankCompleteRecordFeedback getFeedbackByHelped() {
		return feedbackByHelped;
	}

	public void setFeedbackByHelped(BankCompleteRecordFeedback feedbackByHelped) {
		this.feedbackByHelped = feedbackByHelped;
	}

	public User getRequireUser() {
		return requireUser;
	}

	public void setRequireUser(User requireUser) {
		this.requireUser = requireUser;
	}

	public BankCompleteRecordValidation getValidationInfo() {
		return validationInfo;
	}

	public void setValidationInfo(BankCompleteRecordValidation validationInfo) {
		this.validationInfo = validationInfo;
	}

	public BankCoreBusiness getLinkToHelpBusiness() {
		return linkToHelpBusiness;
	}

	public void setLinkToHelpBusiness(BankCoreBusiness linkToHelpBusiness) {
		this.linkToHelpBusiness = linkToHelpBusiness;
	}

	public BankCoreBusiness getLinkHelpedBusiness() {
		return linkHelpedBusiness;
	}

	public void setLinkHelpedBusiness(BankCoreBusiness linkHelpedBusiness) {
		this.linkHelpedBusiness = linkHelpedBusiness;
	}
	
}
