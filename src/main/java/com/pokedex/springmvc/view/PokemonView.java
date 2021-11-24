package com.pokedex.springmvc.view;

public interface PokemonView {
	
	public Integer getNumber();
	
	public void setNumber(Integer number);
	
	public String getName();
	
	public void setName(String name);
	
	public String getTypeOne();
	
	public void setTypeOne(String typeOne);
	
	public String getTypeTwo();
	
	public void setTypeTwo(String typeTwo);
	
	public Integer getTotal();
	
	public void setTotal(Integer total);
	
	public Integer getHP();
	
	public void setHP(Integer hp);
	
	public Integer getAttack();
	
	public void setAttack(Integer attack);
	
	public Integer getDefense();
	
	public void setDefense(Integer defense);
	 
	public Integer getSpAttack();
	
	public void setSpAttack(Integer spattack);
	
	public Integer getSpDefense();
	
	public void setSpDefense(Integer spdefense);
	
	public Integer getSpeed();
	
	public void setSpeed(Integer speed);
	
	public Integer getGeneration();
	
	public void setGeneration(Integer generation);
	
	public String getLegendary();
	
	public void SetLegendary(String legendary);
}
