package com.pokedex.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pokedex.springmvc.model.Pokemon;
import com.pokedex.springmvc.model.PokemonId;

@Repository("pokemonDao")
public class PokemonDaoImpl implements PokemonDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public Pokemon findByName(String name) {
		String hql = "FROM Pokemon P WHERE P.name =: name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		return (Pokemon) query.uniqueResult();
	}

	@Transactional
	@Override
	public int deletePokemonByName(String name) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM POKEMON WHERE NAME = :name");
		query.setString("name", name);
		return query.executeUpdate();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> findAllPokemon() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pokemon.class); // Criteria Query
        return criteria.list();
	}

	@Transactional
	@Override
	public Pokemon updatePokemon(Pokemon pokemon) {
		Pokemon p = hibernateTemplate.load(Pokemon.class, PokemonId.class);
		p.setNumber(pokemon.getNumber());
		p.setName(pokemon.getName());
		p.setTypeOne(pokemon.getTypeOne());
		p.setTypeTwo(pokemon.getTypeTwo());
		p.setTotal(pokemon.getTotal());
		p.setHP(pokemon.getHP());
		p.setAttack(pokemon.getAttack());
		p.setDefense(pokemon.getDefense());
		p.setSpAttack(pokemon.getSpAttack());
		p.setSpDefense(pokemon.getSpDefense());
		p.setSpeed(pokemon.getSpeed());
		p.setGeneration(pokemon.getGeneration());
		p.SetLegendary(pokemon.getLegendary());
		hibernateTemplate.update(p);
		return p;
	}

}
