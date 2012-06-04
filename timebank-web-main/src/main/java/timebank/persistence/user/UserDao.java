package timebank.persistence.user;

import java.util.List;

import org.hibernate.criterion.Criterion;

import timebank.model.user.User;
import timebank.persistence.BaseDao;
import timebank.util.web.paging.Paging;


public interface UserDao extends BaseDao<User>{

	public abstract List<User> select(Paging paging, Criterion... criteria);
	
	public abstract List<User> select(Criterion... criteria);
	
	public abstract List<User> select(Criterion criterion);
	
	public abstract int getCount(Criterion... criteria);
	
	public abstract int getCount(Criterion criterion);

}