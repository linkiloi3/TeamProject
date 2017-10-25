package Script;
import GameObject.*;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import GUI.*;

public class Game extends Canvas implements Runnable{ /**
	 * 
	 */
	private static final long serialVersionUID = -6568339445379875062L;
	
	private long startTime;
	private static final int WIDTH = 1200, HEIGHT = 750; 
	private Thread thread;
	private boolean running = false;
	public SpawnBot spawnbot;
	public PlayBoard playboard;
	public Menu menu;
	public Defeat defeat;
	public Victory victory;
	public Pause pause;
	
	public static BufferedImage sprite_Sheet;
	
	public Game(){
		menu = new Menu();
		
		pause = new Pause();
		
		defeat = new Defeat();
		
		victory = new Victory();
		this.addMouseListener(menu);
		new Window(WIDTH, HEIGHT, "Plant vs Zombie mini v1.0.0.0e", this);
				
		
		this.addMouseListener(defeat);
		this.addMouseListener(victory);
		this.addMouseListener(pause);
		
		//if (State.getGameState()==ID.Game)
			//this.removeMouseListener(menu);
			
		this.addMouseListener(new MouseInput());
		
		spawnbot=new SpawnBot();
		
		
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while ( running ){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while ( delta >= 1){
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000 ){
				timer += 1000;
				//System.out.println("FPS: " + frames );
				frames = 0 ;
			}
		}
		stop();
	}
	
	private void tick(){
		
		if ( State.getGameState()==ID.Game){
			Handler.tick();
			PlantOption.tick();
			SpawnBot.tick();
			if (System.currentTimeMillis()-startTime>1000*240){
				while (Handler.object.size()>0){
					Handler.object.remove(0);
					Player.setSunCredit(50);
				}
				State.setGameState(ID.Victory);
			}
		}
		if ( State.getGameState()==ID.Menu){
			menu.tick();
			startTime=System.currentTimeMillis();
		}
		if ( State.getGameState()==ID.Defeat){
			defeat.tick();
			startTime=System.currentTimeMillis();
		}
		if ( State.getGameState()==ID.Victory){
			victory.tick();
			startTime=System.currentTimeMillis();
		}
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0 , WIDTH , HEIGHT);
		if (State.getGameState()==ID.Game){
			Anou.render(g);
			Player.render(g);
			TreeRemover.render(g);
			Handler.render(g);
			PlayBoard.render(g);
			PlantOption.render(g);
			SpawnBot.render(g);
			Pause.render(g);
		}
		

		if (State.getGameState()==ID.Menu) {
			menu.render(g);
		}
		if ( State.getGameState()==ID.Defeat){
			defeat.render(g);
			spawnbot.setPower(0);
		}
		if ( State.getGameState()==ID.Victory){
			victory.render(g);
			spawnbot.setPower(0);
		}
		if (State.getGameState()==ID.Pause){
			pause.render(g);
		}
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
