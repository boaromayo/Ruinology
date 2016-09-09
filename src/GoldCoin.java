
public class GoldCoin extends Money {

	public GoldCoin() {
		_imgPath = "../img/coin_gold.gif";
		
		_img = ImageBank.loadImage(_imgPath);	
	
		_width = _img.getWidth();
		_height = _img.getHeight();
		
		setValue(50);
	}
}
