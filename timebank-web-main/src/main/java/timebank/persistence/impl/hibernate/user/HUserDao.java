package timebank.persistence.impl.hibernate.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import timebank.model.user.User;
import timebank.persistence.impl.hibernate.HBaseDao;
import timebank.persistence.user.UserDao;
import timebank.util.web.paging.Paging;

@Repository
public class HUserDao extends HBaseDao<User> implements UserDao {

	public User select(int id) {
		getSession();
		User user = (User)session.get(User.class, id);
		return user;
	}
	
	public List<User> select(Criterion criterion) {
		Criterion[] cri = new Criterion[1];
		cri[0] = criterion;
		return select(cri);
	}
	
	public List<User> select(Criterion... criteria){
		return select(null, criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> select(Paging paging, Criterion... criteria) {
		getSession();
		Criteria cri = session.createCriteria(User.class);
		for (int i = 0; i < criteria.length; i++) {
			cri.add(criteria[i]);
		}
		if(null != paging){
			cri.setFirstResult(paging.getFirstResult());
			cri.setMaxResults(paging.getMaxResults());
		}
		return cri.list();
	}

	public void delete(int id) {
		getSession();
		User user = new User();
		user.setId(id);
		session.delete(user);
	}

	public int getCount(Criterion... criteria) {
		getSession();
		Criteria cri = session.createCriteria(User.class);
		for (int i = 0; i < criteria.length; i++) {
			cri.add(criteria[i]);
		}
		cri.setProjection(Projections.rowCount());
		return (Integer) cri.uniqueResult();
	}

	public int getCount(Criterion criterion) {
		Criterion[] cri = new Criterion[1];
		cri[0] = criterion;
		return getCount(cri);
	}

}
