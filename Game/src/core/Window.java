package core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import inputs.KeyboardHandler;
import level.LevelHandler;
import objects.Player;

public class Window extends Canvas implements Runnable {
	
	// Variables
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	
	private KeyboardHandler Klistener = new KeyboardHandler(this);
	
	public LevelHandler level = new LevelHandler(this);
	// Variables

	
	// Run when a new window is created
	public Window(String Title)	{
		JFrame frame = new JFrame(Title);
		
		// Set size
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set logic 
		frame.setResizable(true);
		frame.setVisible(true);
		frame.add(this);
	
	}
	
	// Start the game logic 
	public void start()	{
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	// Stop the game logic
	public void stop()	{
		running = false;
		try {
			thread.join();
		}
		catch (InterruptedException e)	{
			e.printStackTrace();
		}
		
	}
	public void run()	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		while(running)	{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta > -1)	{
				tick();
				updates++;
				delta--;
			}
			Render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000)	{
				timer += 1000;
//				System.out.println("FPS: " + frames + " TICKS " + updates);
				frames = 0;
				updates = 0;
			}
		}
		
		stop();
	}
	
	// Update window
	public void tick() {
//		player.tick();
		level.tick();
	}
	
	// Paint onto the window
	public void Render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)	{
			this.createBufferStrategy(2);
			bs = this.getBufferStrategy();
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
//		player.Render(g);
		level.Render(g);
		
		
		
		bs.show();
		g.dispose();
	}
}








