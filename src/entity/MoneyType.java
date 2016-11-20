package entity;

import java.awt.image.*;

import content.Constants;

public enum MoneyType {
	// show the types of money in-game
	BRONZE_COIN(10), 
	SILVER_COIN(20), 
	GOLD_COIN(50); 
	/*DIAMOND(200), 
	PEARL(1000), 
	EMERALD(2500), 
	RUBY(2500), 
	SAPPHIRE(2500), 
	TOPAZ(2500),
	IDOL(3000), 
	GOLD_DIAMOND(5000),
	PINK_DIAMOND(10000);*/
	
	private int _value;
	
	private BufferedImage _img;
	
	private MoneyType(int v) {
		_value = v;
		_img = null;
	}
	
	private MoneyType(int v, BufferedImage img) {
		_value = v;
		_img = img;
	}
	
	public int value() {
		return _value;
	}
	
	public BufferedImage image() {
		return _img;
	}
}
