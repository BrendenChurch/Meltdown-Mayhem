package me.brendenchurch.meltdownmayhem;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
	
	private int hp;
	private int armor;
	private int energy;
	
	private PlayerClass playerClass;
	private Sprite sprite;
	
	public Player(PlayerClass playerClass, Sprite sprite) {
		this.playerClass = playerClass;
		this.sprite	= sprite;
	}
	
	public void draw(Batch batch) {
		sprite.draw(batch);
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}	
	
	public Sprite getSprite() {
		return sprite;
	}
	
}