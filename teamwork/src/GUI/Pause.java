package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Pause extends MouseAdapter{
	
	
	public void mousePressed(MouseEvent e){
		int mx=e.getX();
		int my=e.getY();
		if (mouseOver(mx,my,450,300,200,64) && State.getGameState()==ID.Pause){
			State.setGameState(ID.Game);
		}
		if (mouseOver(mx,my,1000,10,100,50) && State.getGameState()==ID.Game){
			State.setGameState(ID.Pause);
		}
	}
	public void mouseRelease(MouseEvent e){
		
	}
	
	public void tick(){

	}
	
	private boolean mouseOver(int mx,int my,int x, int y, int width , int height){
		if (mx>x && mx < x + width){
			if (my > y && my< y + height){
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public static void render(Graphics g){
		
		if (State.getGameState()==ID.Pause){
			Font fnt = new Font("arial",1,50);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Pause", 450, 50);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Resume", 450, 350);
			
			g.setColor(Color.white);
			g.drawRect(450, 300, 200, 64);
		}
		if (State.getGameState()==ID.Game){
			g.setColor(Color.white);
			g.drawRect(1000, 10, 100, 50);
			Font fnt = new Font("arial",1,20);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Pause", 1000, 30);
		}
	}
}
