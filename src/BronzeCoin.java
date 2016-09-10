
public class BronzeCoin extends Money {
	
	public BronzeCoin() {		
		_img = Constants._bronzeCoin;
		
		_width = _img.getWidth();
		_height = _img.getHeight();
		
		setValue(10);
	}
}
