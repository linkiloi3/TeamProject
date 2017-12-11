package GUI;
import GameObject.*;
import Script.Handler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Victory extends MouseAdapter implements screenImp{
	private static long startTime;
	private Utility utility = Utility.getInstance();
	public static long getStartTime() {
		return startTime;
	}
	public static void setStartTime(long startTime) {
		Victory.startTime = startTime;
	}
	public static void check(){
		if (System.currentTimeMillis()-startTime>1000*240){
			while (Handler.object.size()>0){
				Handler.object.remove(0);
				Player.setSunCredit(50);
			}
			State.setGameState(ID.Victory);
		}
	}
	public void mousePressed(MouseEvent e){
		int mx=e.getX();
		int my=e.getY();
		if (utility.mouseOver(mx,my,450,300,200,64) && State.getGameState()==ID.Victory){
			while (Handler.object.size()>0){
				Handler.object.remove(0);
				Player.setSunCredit(50);
			}
			State.setGameState(ID.Game);
			Victory.setStartTime(System.currentTimeMillis());
			Anou.setAnou("Can you survive for 4 minutes");
		}
	}
	
	public void render(Graphics g){
		
		Font fnt = new Font("arial",1,50);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Victory", 480, 50);
		
		utility.draw(ObjType.RetryButton, 480, 330, g);
	}
}
