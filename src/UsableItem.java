import java.awt.*;

public abstract class UsableItem extends Item {

	@Override
	public abstract void update();

	@Override
	public abstract void draw(Graphics g);

	public abstract void effect();
}
