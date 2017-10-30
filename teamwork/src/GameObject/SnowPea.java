package GameObject;

import Script.Handler;
import Zombie.Enemy;

import java.awt.Color;
import java.awt.Graphics;

public class SnowPea extends Pea {
	
	private static int slot=3;
	
	public SnowPea(int x , int y){
		super(x,y,5);
		this.damage=1;
	}
	
	public void render(Graphics g){
		g.setColor(Color.blue);
		g.fillOval(x, y, 30, 20);
	}
	
	public void tick(){
		super.tick();
		for (int i=0; i<Handler.object.size() ; i++){
			GameObject tempObject = Handler.object.get(i);
			int x=tempObject.getX();
			int y=tempObject.getY();
			if (tempObject instanceof Enemy && (x<this.x+10)
					&& (x>this.x)
					&& (y>this.y-20) 
					&& (y<this.y+50)){
				Enemy temp=(Enemy) tempObject;
				temp.setDelay(40);
				temp.setDuration(100);
			}
		}
	}

}
