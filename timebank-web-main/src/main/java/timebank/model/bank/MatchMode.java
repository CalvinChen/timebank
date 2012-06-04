package timebank.model.bank;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * side record match mode.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "side_record_match_mode")
public class MatchMode {

	/**
	 * bank core business mode id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * what mode of the business.
	 */
	@Column(name = "match_mode", nullable = false, unique = false)
	private short mode;
	
	/**
	 * total seek number.
	 * default value is 1.
	 */
	@Column(name = "seek_number", nullable = false, unique = false)
	private int seekNumber = 1;
	
	/**
	 * left seek number.
	 * default value is 1.
	 */
	@Column(name = "seek_left", nullable = false, unique = false)
	private int seekLeft = 1;
	
	/**
	 * when to expire this request.
	 * can be null, if not in date mode.
	 */
	@Column(name = "expire_date", nullable = true, unique = false)
	private Date expireDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getMode() {
		return mode;
	}

	public void setMode(short mode) {
		this.mode = mode;
	}

	public int getSeekNumber() {
		return seekNumber;
	}

	public void setSeekNumber(int seekNumber) {
		this.seekNumber = seekNumber;
	}

	public int getSeekLeft() {
		return seekLeft;
	}

	public void setSeekLeft(int seekLeft) {
		this.seekLeft = seekLeft;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
}
