package com.pokedex.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pokedex.springmvc.model.User;
 
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HibernateTemplate hibernateTemplate;
 
    public User findById(Long id) {
        return hibernateTemplate.get(User.class, id);
    }
    
	public User findByEmail(String email) {
		String hql = "FROM User U WHERE U.email = :email"; // HQL Query
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		return (User) query.uniqueResult();
	}
 
	@Transactional
    public User createUser(User user) {
    	Long id = (Long) hibernateTemplate.save(user);
        user.setId(id);
        return user;
    }
    
    @Transactional
    public int deleteUserById(Long id) {
    	Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM USER WHERE ID = :id");
    	query.setLong("id", id);
    	return query.executeUpdate();
    }
 
    @Transactional
    public int deleteUserByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM USER WHERE EMAIL = :email");
        query.setString("email", email);
        return query.executeUpdate();
    }
 
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
    	Query query = sessionFactory.getCurrentSession().createQuery("FROM User");
    	List<User> uList = query.list();
    	return uList;
    }
 
    public User findUserByEmail(String email) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        return (User) criteria.uniqueResult();
    }
    
    public User findUserByUsername(String username) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }
    
    @Transactional
    public User updateUser(User user) {
    	User u = hibernateTemplate.load(User.class, user.getId());
    	u.setId(user.getId());
    	u.setEmail(user.getEmail());
    	u.setPassword(user.getPassword());
    	u.setSwitchfc(user.getSwitchfc());
    	u.setThreedsfc(user.getThreedsfc());		
    	u.setPokedexes(user.getPokedexes());
    	hibernateTemplate.update(u);
    	return u;
    }
    
    public Boolean isUserExist(User user) {
    	Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :email");
    	query.setParameter("email", user.getEmail());
    	List<?> uList = query.list();
    	if (uList.isEmpty()) {
    		return false;
    	}
    	return true;
    }

}
