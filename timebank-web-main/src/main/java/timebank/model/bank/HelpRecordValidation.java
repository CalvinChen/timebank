package timebank.model.bank;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import timebank.model.Values;
import timebank.model.admin.Admin;

/**
 * validation information of a help record.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "help_record_validation")
public class HelpRecordValidation {
	
	/**
	 * validation id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * which admin validate this record?
	 */
	@ManyToOne
	@JoinColumn(name = "validate_admin_id", nullable = false, unique = false)
	private Admin validator;
	
	/**
	 * when validate?
	 */
	@Column(name = "validate_time", nullable = false, unique = false)
	private Date validateTime;
	
	/**
	 * why validate failure? the reason is? 
	 * can be null if not failed.
	 */
	@Column(name = "why_validate_failure", length = Values.SMALL_CONTENT_LENGTH,
			nullable = true, unique = false)
	private String whyValidateFailure;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Admin getValidator() {
		return validator;
	}

	public void setValidator(Admin validator) {
		this.validator = validator;
	}

	public Date getValidateTime() {
		return validateTime;
	}

	public void setValidateTime(Date validateTime) {
		this.validateTime = validateTime;
	}

	public String getWhyValidateFailure() {
		return whyValidateFailure;
	}

	public void setWhyValidateFailure(String whyValidateFailure) {
		this.whyValidateFailure = whyValidateFailure;
	}
}
