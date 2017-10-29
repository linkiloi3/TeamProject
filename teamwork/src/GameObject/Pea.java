package GameObject;
import java.awt.Graphics;

import Script.Handler;
import Zombie.Enemy;


public class Pea extends GameObject {

	
	public Pea (int x, int y , int velX){
		super(x,y,1);
		//where bullet spawns, id, damage ( bullet that can penetrate has high health)
		this.velX=velX;
	}
	
	
	public int getDamage() {
		return damage;
	}



	public void setDamage(int damage) {
		this.damage = damage;
	}



	public void render(Graphics g){
		
	}
	
	public void tick(){
		x+=velX;
		if (x>1000) Handler.removeObject(this);
		for (int i=0; i<Handler.object.size() ; i++){
			GameObject tempObject = Handler.object.get(i);
			int x=tempObject.getX();
			int y=tempObject.getY();
			if (tempObject instanceof Enemy && (x<this.x+10)
					&& (x>this.x)
					&& (y>this.y-20) 
					&& (y<this.y+50)){
				tempObject.setHealth(tempObject.getHealth()-this.damage);
				this.health--;
				if (this.health==0) Handler.removeObject(this);
			}
		}
	}
	
}
