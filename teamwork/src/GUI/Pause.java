package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameObject.Utility;


public class Pause extends MouseAdapter implements screenImp{
	Utility utility = Utility.getInstance();
	public void mousePressed(MouseEvent e){
		int mx=e.getX();
		int my=e.getY();
		if (utility.mouseOver(mx,my,450,300,200,64) && State.getGameState()==ID.Pause){
			State.setGameState(ID.Game);
		}
		if (utility.mouseOver(mx,my,1000,10,100,50) && State.getGameState()==ID.Game){
			State.setGameState(ID.Pause);
		}
	}
	
	public void render(Graphics g){
		
		if (State.getGameState()==ID.Pause){
			Font fnt = new Font("arial",1,50);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Pause", 480, 50);
			utility.draw(ObjType.ResumeButton, 480,330, g);
		}
		if (State.getGameState()==ID.Game){
			utility.draw(ObjType.PauseButton, 1000, 10, g);
//			g.setColor(Color.white);
//			g.drawRect(1000, 10, 100, 50);
//			Font fnt = new Font("arial",1,20);
//			g.setFont(fnt);
//			g.setColor(Color.white);
//			g.drawString("Pause", 1000, 30);
		}
	}
}
