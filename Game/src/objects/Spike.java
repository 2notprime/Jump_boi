package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Spike extends Item{

	public int x, y, width, height;
	public Color c;
	
	public Spike(byte ID, int x, int y, int width, int height, Color c)	{
		super(ID);

		this.c = c;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void Render(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, width, height);
	}

	public void tick() {
		
	}

}
