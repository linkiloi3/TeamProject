package Zombie;

import java.awt.Color;
import java.awt.Graphics;

public class Normal extends Enemy{
	
	public Normal(int x,int y){
		super(x,y,7,1,10);
	}
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(x, y, 30, 80);
		
	}
}
