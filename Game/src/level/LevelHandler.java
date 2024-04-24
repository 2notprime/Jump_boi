package level;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import core.Window;
import objects.Item;
import objects.ObjectIDS;
import objects.Platform;
import objects.Player;
import objects.Spike;

public class LevelHandler {
	
	// Variables
	private Window w;
	
	public double Gravity = 10;
	
	public LinkedList<Item> items = new LinkedList<Item>();
	
	public int seed;
	
	public int CameraX = 0, CameraY = 0;
	
	// Game Objects
	public Player player = null;
	// Game Objects
	
	// Run when a new level is created
	public LevelHandler(Window w)	{
		this.w = w;
		
		// Set random
		Random r = new Random();
		seed = r.nextInt();
		
		// Add in player
		player = new Player(w, -16, -16, 32, 32);
		
		// Generate level
		items.add(new Platform(ObjectIDS.Platform, 200, 250, 200, 10, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 400, 150, 200, 10, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 200, 50, 200, 10, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 400, -50, 200, 10, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 200, -150, 200, 10, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 400, -250, 200, 10, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 200, -350, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 400, -450, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 200, -550, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 400, -650, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 200, -750, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 400, -850, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 200, -950, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 400, -1050, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 200, -1150, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 400, -1250, 200, 2, Color.black));
		items.add(new Platform(ObjectIDS.Platform, 0, 300 + 31, 2000, 2, Color.black));
	}
	
	public void Render(Graphics g)	{
		g.translate( - CameraX, - CameraY);
		for(Item i : items)	{
			i.Render(g);
		}
		player.Render(g);
		g.translate(CameraX, CameraY);
	}
	
	public void tick()	{
		// cập nhật camera
		if (player.y < CameraY) CameraY -= 800;
		else if (player.y > CameraY + 800) CameraY += 800;
		for (Item i : items)	{
			i.tick();
		}
		player.tick();
	}
}
