/**
 * @Project TimeBank
 * @CreatedTime 2011-10-20 上午10:00:59 
 * @Author CK
 * @Todo TODO
 */
package tk.business.other;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.WithdrawRecord;
import timebank.model.article.Article;
import timebank.model.bank.SideRecord;
import tk.persistence.DepositDao;
import tk.persistence.WithdrawDao;
import tk.util.bean.Quote;
import tk.util.bean.StatusOfRecord;
import tk.util.bean.Values;

/**
 * @author CK
 *
 */
@Service
public class QuoteManager {

//	@Resource
	private WithdrawDao withdrawDao;
//	@Resource
	private DepositDao depositDao;

	/**
	 * @return the withdrawDao
	 */
	public WithdrawDao getWithdrawDao() {
		return withdrawDao;
	}


	/**
	 * @param withdrawDao the withdrawDao to set
	 */
	public void setWithdrawDao(WithdrawDao withdrawDao) {
		this.withdrawDao = withdrawDao;
	}


	/**
	 * @return the depositDao
	 */
	public DepositDao getDepositDao() {
		return depositDao;
	}


	/**
	 * @param depositDao the depositDao to set
	 */
	public void setDepositDao(DepositDao depositDao) {
		this.depositDao = depositDao;
	}


	/**
	 * @return
	 */
	public ArrayList<Quote> getQuotes() {
		ArrayList<Quote> qL = new ArrayList<Quote>();
		Quote q = null;
		ArrayList<WithdrawRecord> topList = withdrawDao.getDisplayWithdrawsByStatus(StatusOfRecord.UNMATCHED, Values.YES, Values.YES);
		ArrayList<SideRecord> top2List = depositDao.getDisplayDepositsByStatus(StatusOfRecord.UNMATCHED, Values.YES, Values.YES);
		if((topList != null && topList.size() != 0) || (top2List != null && top2List.size() != 0)){
			if(top2List != null){
				for (SideRecord one : top2List) {
					q = new Quote();
					q.setDescription(one.getDescription());
//					q.setUsername(one.getUsername());
//					q.setPicture(one.getPicture());
					q.setRecordId(one.getId());
					q.setType(Values.TYPE_DEPOSIT);
					qL.add(q);
				}	
			}
			if(topList != null){
				for (WithdrawRecord one : topList) {
					q = new Quote();
					q.setDescription(one.getDescription());
					q.setLoginName(one.getLoginName());
					q.setPicture(one.getPicture());
					q.setRecordId(one.getBankCoreBusinessId());
					q.setType(Values.TYPE_WITHDRAW);
					qL.add(q);
				}
			}
		}else{
			ArrayList<SideRecord> dL = depositDao.readSomeByStatusLimit(StatusOfRecord.UNMATCHED, 1);
			if(dL != null){
				for (SideRecord one : dL) {
					q = new Quote();
					q.setDescription(one.getDescription());
//					q.setUsername(one.getUsername());
//					q.setPicture(one.getPicture());
					q.setRecordId(one.getId());
					q.setType(Values.TYPE_DEPOSIT);
					qL.add(q);
				}	
			}
			ArrayList<WithdrawRecord> wL = withdrawDao.readSomeByStatusLimit(StatusOfRecord.UNMATCHED, 1);
			if(wL != null){
				for (WithdrawRecord one : wL) {
					q = new Quote();
					q.setDescription(one.getDescription());
					q.setLoginName(one.getLoginName());
					q.setPicture(one.getPicture());
					q.setRecordId(one.getBankCoreBusinessId());
					q.setType(Values.TYPE_WITHDRAW);
					qL.add(q);
				}	
			}
		}
		Collections.shuffle(qL);
		return qL;
	}

}
