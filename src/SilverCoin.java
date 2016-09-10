
public class SilverCoin extends Money {

	public SilverCoin() {
		// TODO Auto-generated constructor stub
		_imgPath = "../img/coin_silver.gif";
		
		_img = Game._imageBank.loadImage(_imgPath);
		
		_width = _img.getWidth();
		_height = _img.getHeight();
		
		setValue(20);
	}

	
}
