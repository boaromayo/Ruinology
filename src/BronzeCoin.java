
public class BronzeCoin extends Money {
	
	public BronzeCoin() {
		_imgPath = "../img/coin_bronze.gif";
		
		_img = ImageBank.loadImage(_imgPath);
		
		_width = _img.getWidth();
		_height = _img.getHeight();
		
		setValue(10);
	}
}
