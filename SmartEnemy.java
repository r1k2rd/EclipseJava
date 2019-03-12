package game.java;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private GameObject player;

	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		Random r = new Random();
		
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) {
				player = handler.object.get(i);
			}
		}
	
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 12, 12);
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
		
		
		if(x>player.getX())velX=-1;
		  else if(x<player.getX())velX=1;
		  else if(x==player.getX())velX=0;
		  if(y>player.getY())velY=-1;
		  else if(y<player.getY())velY=1;
		  else if(y==player.getY())velY=0;
		
	}

	
	public void render(Graphics g) {
		
		
		
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, 12, 12);
		
	}
	 
	
}
