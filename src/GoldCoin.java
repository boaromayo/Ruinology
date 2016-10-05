
public class GoldCoin extends Money {

	public GoldCoin() {
		super(50);
		
		_img = Constants._goldCoin;	
	
		_width = _img.getWidth();
		_height = _img.getHeight();
	}
}
