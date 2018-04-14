package com.mypack.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypack.model.User;
@Repository
public class UserServicesImpl implements UserService{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int getUser() {
		Session session = getSessionFactory().openSession();
		User u = (User) session.get(User.class, 1);
		System.out.println(u.getName());
		/*String hql = "select id,name,email from usermaster";
		Query query = (Query) getSessionFactory().openSession().createSQLQuery(hql);
		ResultSet r = (ResultSet) query.getResultList();
		try {
			while(r.next()) {
				System.out.println(r.getInt(1));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return 1;
	}
	
}
