package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import core.Window;

public class KeyboardHandler implements KeyListener{
	
	private Window w;
	private long start_time;
	private long stop_time;
	private long pressed_time;
	
	public KeyboardHandler(Window w)	{
		this.w = w;
		w.addKeyListener(this);
	}
	
	public void keyTyped(KeyEvent e)	{
		
	}
	private boolean MovingLeft = false;
	private boolean holding_key = false;
	private int direction = 1; // left = -1, right = 1
	private boolean Jumping;
	public void keyPressed(KeyEvent e)	{
		int key = e.getKeyCode();
		
		if (w.level.player.vely == 0)	{
			if (key == KeyEvent.VK_SPACE && holding_key == false)	{
				start_time = System.currentTimeMillis();
				holding_key = true;
			}
			if (key == KeyEvent.VK_D)	{
				w.level.player.velx = w.level.player.speed;
				MovingLeft = false;
				direction = 1;
			}
			if (key == KeyEvent.VK_A)	{
				w.level.player.velx = - w.level.player.speed;
				MovingLeft = true;
				direction = -1;
			}
			if (key == KeyEvent.VK_W)	{
				if (w.level.player.vely == 0)	{
					w.level.player.vely = - w.level.player.JumpVelocity;
				}
			}
		}
	}

	public void keyReleased(KeyEvent e)	{
		int key = e.getKeyCode();
		
		if (w.level.player.vely == 0)	{
			if (key == KeyEvent.VK_D)	{
				w.level.player.velx = 0;
			}
			if (key == KeyEvent.VK_A && MovingLeft)	{
				w.level.player.velx = 0;
			}
			
			if (key == KeyEvent.VK_SPACE && holding_key == true)	{
				stop_time = System.currentTimeMillis();
				pressed_time = Math.min((stop_time - start_time), 1000);
				w.level.player.vely = - (double) pressed_time * 0.005;
				w.level.player.velx = direction * pressed_time * 0.002;
				Jumping = true;
				holding_key = false;
			
		}
	}
		
			
		
		
	}

}
