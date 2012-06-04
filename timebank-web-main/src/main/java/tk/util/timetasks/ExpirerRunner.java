/**
 * @Project TimeBank
 * @CreatedTime 2011-11-5 下午02:34:10 
 * @Author CK
 * @Todo TODO
 */
package tk.util.timetasks;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * @author CK
 *
 */
public class ExpirerRunner implements ServletContextListener{
	private Timer timer = null;
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		if(timer != null){
			timer.cancel();	
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		
		timer = new Timer();
		Calendar now = Calendar.getInstance();
		Calendar then = Calendar.getInstance();
		then.set(Calendar.YEAR, now.get(Calendar.YEAR));
		then.set(Calendar.MONTH, now.get(Calendar.MONTH));
		then.set(Calendar.DATE, now.get(Calendar.DATE));
//		then.set(Calendar.DATE, 30);
		then.set(Calendar.HOUR_OF_DAY, 0);
		then.set(Calendar.MINUTE, 0);
		then.set(Calendar.SECOND, 0);
		then.add(Calendar.DATE, 1);
//		then.add(Calendar.MINUTE, 1);
		timer.schedule(new ExpirerTask(), new Date(then.getTimeInMillis()), 1000 * 60 * 60 * 24 * 1);
	}
}
