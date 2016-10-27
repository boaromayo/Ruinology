import java.awt.*;

public class SceneMapMenu extends Scene {

	// CURSOR.
	private Cursor _cursor;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		// Initialize settings
		
		_cursor = new Cursor(180,140);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (InputBank.keyDown(InputBank._W) || 
				InputBank.keyDown(InputBank._UP)) {
			
		} else if (InputBank.keyDown(InputBank._S) ||
				InputBank.keyDown(InputBank._DOWN)) {
			
		} else if (InputBank.keyDown(InputBank._ENTER)) {
			
		} else if (InputBank.keyDown(InputBank._ESC)) {
			
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT_FINAL);
	}

}
