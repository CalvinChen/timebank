package timebank.model.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * display option of a side record.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "display_option")
public class DisplayOption {

	/**
	 * display option id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
