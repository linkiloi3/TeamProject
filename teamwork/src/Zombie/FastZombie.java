package Zombie;

import java.awt.Color;
import java.awt.Graphics;

public class Fastzombie extends Enemy {
	public Fastzombie(int x,int y){
		super(x,y,7,3,10);
}
	public void render(Graphics g){
		g.setColor(Color.gray);
 		g.fillRect(x, y+30, 30, 50);
	}
}