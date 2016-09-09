import java.awt.*;

public abstract class Potion extends UsableItem {
	
	@Override
	public abstract void update();

	@Override
	public abstract void draw(Graphics g);
	
	public abstract void effect();

}
