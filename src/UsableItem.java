import java.awt.*;

public abstract class UsableItem extends Item {

	public UsableItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void update();

	@Override
	public abstract void draw(Graphics g);

	public abstract void effect();
}
