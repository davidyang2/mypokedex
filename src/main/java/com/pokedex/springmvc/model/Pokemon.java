package com.pokedex.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@IdClass(PokemonId.class)
@Table(name="pokemon")
public class Pokemon {

	@Id
	private Integer number;
	
	@Id
	private String name;
	
	@Size(max=20)
	@Column(name="TYPE 1")
	private String typeOne;
	
	@Size(max=20)
	@Column(name="TYPE 2")
	private String typeTwo;
	
	@Column(name="TOTAL")
	private Integer total;
	
	@Column(name="HP")
	private Integer hp;
	
	@Column(name="ATTACK")
	private Integer attack;
	
	@Column(name="DEFENSE")
	private Integer defense;
	
	@Column(name="SPATTACK")
	private Integer spattack;
	
	@Column(name="SPDEF")
	private Integer spdefense;
	
	@Column(name="SPEED")
	private Integer speed;
	
	@Column(name="GENERATION")
	private Integer generation;
	
	@Size(max=10)
	@Column(name="LEGENDARY")
	private String legendary;
	
	public Pokemon() {}
	
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
