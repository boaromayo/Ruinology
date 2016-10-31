import java.awt.*;

public abstract class Scene {

	public Scene() { init(); }
	
	public abstract void init();
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
}
