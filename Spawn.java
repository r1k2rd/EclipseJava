package game.java;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int scorekeep = 0;
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scorekeep++;
		
		if(scorekeep == 100) {
			hud.setLevel(hud.getLevel()+1);
			handler.addObject(new Boss1(Game.WIDTH +10, (Game.HEIGHT/2)-50, ID.Boss1, handler));
		}
		if(scorekeep % 500 == 0) {
			hud.setLevel(hud.getLevel()+1);
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		}
		if(scorekeep % 1000 == 0) {
			hud.setLevel(hud.getLevel()+1);
			handler.addObject(new SlowEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SlowEnemy, handler));
		}
		if(scorekeep % 1500 == 0) {
			hud.setLevel(hud.getLevel()+1);
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
		}
		/*if(scorekeep % 1000 == 0) {
			hud.setLevel(hud.getLevel()+1);
			for(int i = 0; i < handler.object.size(); i++) {
				handler.object.remove(i);
			}
			handler.addObject(new Boss1(Game.WIDTH +10, (Game.HEIGHT/2)-50, ID.Boss1, handler));
		}*/
		
	}
	
}
