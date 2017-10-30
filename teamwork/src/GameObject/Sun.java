package GameObject;


import java.awt.Color;
import java.awt.Graphics;

public class Sun extends GameObject{
	
	private int tempY;
	
	public Sun(int x,int y){
		super(x,y,0);
		tempY=y;
		velY=1;
	}
	
	public void render(Graphics g){
		g.setColor(Color.orange);
		g.fillOval(x, y, 40, 40);
	}
	
	public void tick(){
		y+=velY;
		if (y>tempY+80) velY=0; 
	}
}
