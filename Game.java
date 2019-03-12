package game.java;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8241416756976939623L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	
	private boolean running = false;
	
	private Handler handler;
	
	private Random r;
	
	HUD hud;
	
	private Spawn spawner;

	
	public Game() {
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Game", this);
		
		
		r = new Random();
		
		
		handler.addObject(new Player(32, 32, ID.Player, handler));
		
		for(int i = 0; i < 2; i++) {
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		}
		hud = new HUD();
		
		spawner = new Spawn(handler, hud);
		
		
		
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames ++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
		
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
		
		
		
	}
	
	public synchronized void start() {
		
		Thread thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	
	public synchronized void stop() {
			
			try {
			thread.join();
			running = false;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	public static float clamp(float var, float min, float max) {
		if(var >= max) {
			return var = max;
		}
		if(var <= min) {
			return var = min;
		}
		else {return var;}
	}

	public static void main(String[] args) {
		
		new Game();
	}

	

}
