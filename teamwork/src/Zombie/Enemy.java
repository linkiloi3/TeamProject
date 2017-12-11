package Zombie;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GUI.ID;
import GUI.State;
import GameObject.*;
import GameObject.Object;
import Plant.Plant;
import Script.Handler;

public class Enemy extends GameObject{
	
	protected int step,power;
	private long now=System.currentTimeMillis();
	private long lastatt=System.currentTimeMillis();
	private long delay=20;
	private long duration=0;
	private Utility utility=Utility.getInstance();
	protected BufferedImage zombie_image;
	
	
	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	public Enemy(int x , int y ,int health,int step,int power){
		super(x,y,health);
		// where zombie spawns and health
		this.damage=2;
		this.step=step;
		velX=-step;
	}
	public void eat(){
		for (int i=0; i<Handler.object.size() ; i++){
			GameObject tempObject = Handler.object.get(i);
			if (utility.checkNearby(Object.Plant, tempObject, this.x, this.y)
				&& (System.currentTimeMillis()-lastatt)>500){
			
				if (tempObject.getHealth()>0) 
				this.setVelX(0);
			
				lastatt=System.currentTimeMillis();
			
				tempObject.setHealth(tempObject.getHealth()-this.getDamage());
				if (tempObject.getHealth()<=0){
					for (int j=0; j<Handler.object.size() ; j++){
						GameObject temp=Handler.object.get(j);
						if (utility.checkNearby(Object.Zombie, temp, this.x, this.y)
						
						){
							Enemy enemy=(Enemy)temp;
							enemy.setVelX(-enemy.step);
						}
					}
				}
			}
		}
		for (int i=0; i<Handler.object.size() ; i++){
			GameObject tempObject = Handler.object.get(i);
			if ((tempObject instanceof Plant)&&(tempObject.getHealth()<=0)){
				Handler.removeObject(tempObject);
			}
		}
	}
	public void tick(){
		if (System.currentTimeMillis()-now>delay){
			if (duration==0) {
				delay=20;
			}
			else duration--;
			x+=velX;
			now=System.currentTimeMillis();
		
		}
		//collision();
		if (health<=0) Handler.object.remove(this);
		eat();
	}
	
	public void render(Graphics g){
		
	}
	
}
