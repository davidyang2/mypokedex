package com.pokedex.springmvc.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonViewImpl implements PokemonView {
	
	@JsonProperty("number")
	private Integer number;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("typeOne")
	private String typeOne;
	
	@JsonProperty("typeTwo")
	private String typeTwo;
	
	@JsonProperty("total")
	private Integer total;
	
	@JsonProperty("hp")
	private Integer hp;
	
	@JsonProperty("attack")
	private Integer attack;
	
	@JsonProperty("defense")
	private Integer defense;
	
	@JsonProperty("spattack")
	private Integer spattack;
	
	@JsonProperty("spdefense")
	private Integer spdefense;
	
	@JsonProperty("speed")
	private Integer speed;
	
	@JsonProperty("generation")
	private Integer generation;
	
	@JsonProperty("legendary")
	private String legendary;
	
	public PokemonViewImpl() {}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTypeOne() {
		return typeOne;
	}
	
	public void setTypeOne(String typeOne) {
		this.typeOne = typeOne;
	}
	
	public String getTypeTwo() {
		return typeTwo;
	}
	
	public void setTypeTwo(String typeTwo) {
		this.typeTwo = typeTwo;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getHP() {
		return hp;
	}
	
	public void setHP(Integer hp) {
		this.hp = hp;
	}
	
	public Integer getAttack() {
		return attack;
	}
	
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	
	public Integer getDefense() {
		return defense;
	}
	
	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	 
	public Integer getSpAttack() {
		return spattack;
	}
	
	public void setSpAttack(Integer spattack) {
		this.spattack = spattack;
	}
	
	public Integer getSpDefense() {
		return spdefense;
	}
	
	public void setSpDefense(Integer spdefense) {
		this.spdefense = spdefense;
	}
	
	public Integer getSpeed() {
		return speed;
	}
	
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	
	public Integer getGeneration() {
		return generation;
	}
	
	public void setGeneration(Integer generation) {
		this.generation = generation;
	}
	
	public String getLegendary() {
		return legendary;
	}
	
	public void SetLegendary(String legendary) {
		this.legendary = legendary;
	}
	
	@Override
	public String toString() {
		return "Pokemon [number= " + number + "name=" + name + "]";
	}
}
