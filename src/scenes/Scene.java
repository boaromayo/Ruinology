package scenes;
import java.awt.*;

import content.*;

public abstract class Scene {

	public Scene() { init(_sb); }
	
	protected SceneBank _sb;
	
	public abstract void init(SceneBank sb);
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
}
