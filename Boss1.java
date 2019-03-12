package game.java;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;

public class Boss1 extends GameObject{
	
	private Handler handler;
	
	private int timer = 200;
	
	private Random r = new Random();

	public Boss1(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		Random r = new Random();
		
		this.handler = handler;
		
		velX = -1;
		velY = 0;
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		
		/*if(x <= 0 || x >= Game.WIDTH - 32) {
			velX = velX * (-1);
		}*/
		
		if(x == Game.WIDTH -150) {
			velX = 0;
		}
		
		timer--;
		if(timer == 0) {
			velY = 1;
		}
		
		if(timer < 0) {
			int spawn = r.nextInt(7);
			if(spawn == 0) {
				handler.addObject(new BossBullet((int)x, (int)y+48, ID.BossBullet, handler));
			}
		}
		
		if(y <= 0 || y >= Game.HEIGHT - 132) {
			velY *= (-1);
		}
		
		
		
		
		
		
	}

	
	public void render(Graphics g) {
		
		
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, 96, 96);
		
	}
	 
	
}
