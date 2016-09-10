
public class GoldCoin extends Money {

	public GoldCoin() {
		_img = Constants._goldCoin;	
	
		_width = _img.getWidth();
		_height = _img.getHeight();
		
		setValue(50);
	}
}
