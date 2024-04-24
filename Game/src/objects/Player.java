package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import core.Window;

public class Player {
	
	public Window w;
	public int width, height;
	public double x, y;
	public double velx, vely; 
	
	public double JumpVelocity = 5;
	public int speed = 2;
	
	public boolean Falling = false;
	
	public Player(Window w, int x, int y, int width, int height)	{
		this.w = w;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void tick()	{
		x += velx;
		y += vely;
		
		if (vely < w.level.Gravity && Falling)	{
			vely += 0.1;
		}
		else if(!Falling && vely > 0)	{
			vely = 0;
		}
		
		Collisions();
		
	}
	
	public void Collisions()	{
		Falling = true;
		for (Item i : w.level.items)	{
			if (i.ID == ObjectIDS.Platform)	{
				Platform p = (Platform) i;
				
				Rectangle playerRect = new Rectangle((int) (x+velx), (int) (y + vely), width, height);
				if (playerRect.intersects(p.x, p.y, p.width, p.height))	{
					
					if (y + height <= p.y + 1)	{
						Falling = false;
						if (vely > 0)	{
							vely = 0;
							y = p.y - height + 1;
							velx = 0;
						}
					}
					else	{
						velx = -1*velx;
						System.out.println(1);
						
					}
				
					// Bounce us off platform
					if (vely < 0 && (x + width > p.x + 1 && x < p.x + p.width - 1))	{
						Falling = true;
						velx = -1*velx;
						y -= (vely+1);
						vely = -1*vely;
					}
				}
			}
		}
	}
	
	public void Render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int) x, (int) y, width, height);
	}
}
