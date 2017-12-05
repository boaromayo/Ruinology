package entity;

import java.awt.image.*;

import content.Constants;

public enum MoneyType {
	// show the types of money in-game
	BRONZE_COIN(10, "bronze", Constants.getBronzeCoinImg()), 
	SILVER_COIN(20, "silver", Constants.getSilverCoinImg()), 
	GOLD_COIN(50, "gold", Constants.getGoldCoinImg()),
	CRYSTAL(100, "crystal", Constants.getCrystalImg());
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
	
	private String _name;
	
	private BufferedImage _img;
	
	private MoneyType(int v) {
		_value = v;
		_img = null;
	}
	
	private MoneyType(int v, String name, BufferedImage img) {
		_value = v;
		_name = name;
		_img = img;
	}
	
	public int value() {
		return _value;
	}
	
	public String type() {
		return _name;
	}
	
	public BufferedImage image() {
		return _img;
	}
}
