package objects;

import java.awt.Graphics;

public abstract class Item {
		
	protected byte ID;
	
	public Item(byte ID) {
		this.ID = ID;
	}
	
	public abstract void Render(Graphics g);
	
	public abstract void tick();
}
