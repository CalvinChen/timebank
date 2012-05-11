package timebank.model.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * display option of a business.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "bank_core_business_display")
public class BankCoreBusinessDisplay {

	/**
	 * display id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_core_business_display_id", nullable = false, unique = true)
	private int bankCoreBusinessDisplayId;
	
	/**
	 * when display in the list, whether fix it to the top of the list.
	 * default value is false.
	 */
	@Column(name = "is_to_top", nullable = false, unique = false)
	private Boolean toTop = false;
	
	/**
	 * when display in the list, whether show all information.
	 * often use to our own event.
	 * default value is false.
	 */
	@Column(name = "is_detailed", nullable = false, unique = false)
	private Boolean detailed = false;

	public int getBankCoreBusinessDisplayId() {
		return bankCoreBusinessDisplayId;
	}

	public void setBankCoreBusinessDisplayId(int bankCoreBusinessDisplayId) {
		this.bankCoreBusinessDisplayId = bankCoreBusinessDisplayId;
	}

	public Boolean getToTop() {
		return toTop;
	}

	public void setToTop(Boolean toTop) {
		this.toTop = toTop;
	}

	public Boolean getDetailed() {
		return detailed;
	}

	public void setDetailed(Boolean detailed) {
		this.detailed = detailed;
	}
}
