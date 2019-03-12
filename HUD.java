package game.java;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	
	private int score = 0;
	
	private int level = 1;
	
	
	public HUD() {
		
	}

	public void tick() {
		

		HEALTH = Game.clamp(HEALTH, -170, 100);
		
		score++;
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillRect(170, 10, 270, 11);
		g.setColor(Color.GREEN);
		g.fillRect(170, 10, 170 + (int)HEALTH, 11);
		
		g.drawString("Score :" + score, 10, 20);
		g.drawString("Level :" + level, 10, 30);
	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	
}
