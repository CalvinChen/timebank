package timebank.persistence.impl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import timebank.model.article.Article;
import timebank.persistence.ArticleDao;


@Repository
public class ArticleDaoHibernate implements ArticleDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	public Article get(int id) {
//		return (Article)sessionFactory.getCurrentSession().get(Article.class, id);
//	}
	
	private Session getSession(){
//		if(sessionFactory.getCurrentSession() == null){
			return sessionFactory.openSession();
//		}else{
//			return sessionFactory.getCurrentSession();
//		}
	}

	@Override
	public String insert(Article one) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List selectAll() {
//		return (ArrayList<Article>)getHibernateTemplate().find("from Article");
		session = getSession();
		List list = session.createCriteria(Article.class).list();
		session.close();
		return list;
	}

	@Override
	public ArrayList<Article> selectListByType(int articleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Article one) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article select(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
