import java.awt.*;

public class Hourglass extends Item {

	// TIME VALUE.
	private int _time;
	
	public Hourglass() {
		// TODO Auto-generated constructor stub
		// set time value based on difficulty and map size
		_time = 30;
		
		_imgPath = "../img/hourglass.png";
		
		_img = ImageBank.loadImage(_imgPath);
		
		_width = _img.getWidth();
		_height = _img.getHeight();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(_img, _x, _y, _width, _height, null);
	}

	public int addTime() {
		return _time;
	}
}
