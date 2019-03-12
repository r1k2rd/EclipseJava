package game.java;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject{
	
	private Handler handler;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		Random r = new Random();
		
		this.handler = handler;
		
		velX = r.nextInt(5)+1;
		velY = r.nextInt(5)+1;
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 48) {
			velY = velY * (-1);
		}
		if(x <= 0 || x >= Game.WIDTH - 32) {
			velX = velX * (-1);
		}
		
		
		
	}

	
	public void render(Graphics g) {
		
		
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}
	 
	
}
