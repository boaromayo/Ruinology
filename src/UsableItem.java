
public abstract class UsableItem extends Item {
	
	@Override
	public void effect(Player p) {
		p.addItem(this);
	}
	
	public abstract void use(Player p);
	
}
