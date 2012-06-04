/**
 * @Project TimeBank
 * @CreatedTime 2011-11-5 下午02:14:25 
 * @Author CK
 * @Todo TODO
 */
package tk.util.timetasks;

import java.util.TimerTask;

import tk.business.bank.DepositManager;
import tk.business.bank.WithdrawManager;

/**
 * @author CK
 *
 */
public class ExpirerTask extends TimerTask{

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		new DepositManager().updateExpired();
		new WithdrawManager().updateExpired();
	}
	
}
