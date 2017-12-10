package GUI;
import GameObject.*;
import Script.Handler;
import Zombie.Enemy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Defeat extends MouseAdapter implements screenImp{
	private Utility utility = Utility.getInstance();
	public static void check(){
		for (int i=0;i<Handler.object.size();i++){
			GameObject temp;
			temp=Handler.object.get(i);
			if (temp instanceof Enemy){
				if (temp.getX()<150){
					Handler.removeObject(temp);
					State.setGameState(ID.Defeat);
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e){
		int mx=e.getX();
		int my=e.getY();
		if(utility.mouseOver(mx,my,480,300,200,64) && State.getGameState()==ID.Defeat){
			while (Handler.object.size()>0){
				Handler.object.remove(0);
			}
			Player.setSunCredit(50);
			State.setGameState(ID.Game);
			Victory.setStartTime(System.currentTimeMillis());
			Anou.setAnou("Can you survive for 4 minutes");
		}
	}
	public void render(Graphics g){
		utility.draw(ObjType.RetryButton, 480-15, 300, g);
		Font fnt = new Font("arial",1,50);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Defeat", 500, 50);
//		
//		g.setFont(fnt);
//		g.setColor(Color.white);
//		g.drawString("Retry", 525, 350);
//		
//		g.setColor(Color.white);
//		g.drawRect(480, 300, 200, 64);
	}
}
