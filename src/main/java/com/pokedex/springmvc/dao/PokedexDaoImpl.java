package com.pokedex.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pokedex.springmvc.model.Pokedex;

@Repository("pokedexDao")
public class PokedexDaoImpl implements PokedexDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public Pokedex findById(Integer id) {
		return hibernateTemplate.get(Pokedex.class, id);
	}

	public Pokedex findByName(String name) {
		String hql = "SELECT FROM POKEDEX WHERE NAME = :name"; // HQL Query
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		return (Pokedex) query.uniqueResult();
	}

	@Transactional
	public Pokedex createPokedex(Pokedex pokedex) {
		Integer id = (Integer) hibernateTemplate.save(pokedex);
		pokedex.setId(id);
		return pokedex;
	}

	@Transactional
	public int deletePokedexByName(String name) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM POKEDEX WHERE NAME = :name");
        query.setString("name", name);
        return query.executeUpdate();
	}
	
	@Transactional
	public int deletePokedexById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM POKEDEX WHERE id = :id");
		query.setInteger("id", id);
		return query.executeUpdate();
	}
	
	@Transactional
	public Pokedex updatePokedex(Pokedex pokedex) {
		Pokedex p = hibernateTemplate.load(Pokedex.class, pokedex.getId());
		p.setId(pokedex.getId());
		p.setName(pokedex.getName());
		p.setGame(pokedex.getGame());
		p.setRegionality(pokedex.getRegionality());
		p.setShiny(pokedex.getShiny());
		p.setUser(pokedex.getUser());
		hibernateTemplate.update(p);
		return p;
	}

    @SuppressWarnings("unchecked")
	public List<Pokedex> findAllPokedexes() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pokedex.class); // Criteria Query
        return (List<Pokedex>) criteria.list();
	}
    
    @SuppressWarnings("unchecked")
	public List<Pokedex> findAllPokedexesByUsername(String pUser) {
    	Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT FROM POKEDEX WHERE pokedex_user = :pUser");
    	query.setString("pUser", pUser);
    	List<Pokedex> results = query.list();
    	return results;
    }
    
    public Boolean isPokedexExist(Pokedex pokedex) {
    	Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT FROM POKEDEX WHERE pokedex_user = :pUser");
    	query.setString("pUser", pokedex.getName());
    	List<?> pList = query.list();
    	if (pList.isEmpty()) {
    		return false;
    	}
    	return true;
    }

}
