
public class BronzeCoin extends Money {
	
	public BronzeCoin() {
		super(10);
		
		_img = Constants._bronzeCoin;
		
		_width = _img.getWidth();
		_height = _img.getHeight();
	}
}
