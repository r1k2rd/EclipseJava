package game.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	@Override
	public void tick() {
		
		
			y+= velY;
			x+= velX;
		
			x = Game.clamp((int)x, 0, Game.WIDTH - 48);
			y = Game.clamp((int)y, 0, Game.HEIGHT - 72);
		
			collision();
		
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy 
					||tempObject.getId() == ID.SmartEnemy 
					|| tempObject.getId() == ID.Boss1
					|| tempObject.getId() == ID.BossBullet) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH --;
					HUD.HEALTH --;
				}
			}
			if(tempObject.getId() == ID.SlowEnemy) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH --;
					HUD.HEALTH --;
					HUD.HEALTH --;
					HUD.HEALTH --;
					HUD.HEALTH --;
					
				}
			}
			if(tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.Boss1) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH --;
					HUD.HEALTH --;
					
					
				}
			}
			
			
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect((int)x,(int) y, 32, 32);
	}
	
	

}
