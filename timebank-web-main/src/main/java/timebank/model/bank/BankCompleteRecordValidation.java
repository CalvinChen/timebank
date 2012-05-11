package timebank.model.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import timebank.model.admin.Admin;

/**
 * validation information of a record.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "bank_complete_record_validation")
public class BankCompleteRecordValidation {
	
	/**
	 * validation id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_complete_record_validation_id", nullable = false, unique = true)
	private int validationId;
	
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
	private String validateTime;
	
	/**
	 * why validate failure? the reason is? 
	 * can be null if not failed.
	 */
	@Column(name = "why_validate_failure", nullable = true, unique = false)
	private String whyValidateFailure;

	public int getValidationId() {
		return validationId;
	}

	public void setValidationId(int validationId) {
		this.validationId = validationId;
	}

	public Admin getValidator() {
		return validator;
	}

	public void setValidator(Admin validator) {
		this.validator = validator;
	}

	public String getValidateTime() {
		return validateTime;
	}

	public void setValidateTime(String validateTime) {
		this.validateTime = validateTime;
	}

	public String getWhyValidateFailure() {
		return whyValidateFailure;
	}

	public void setWhyValidateFailure(String whyValidateFailure) {
		this.whyValidateFailure = whyValidateFailure;
	}
}
