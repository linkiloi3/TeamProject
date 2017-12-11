package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameObject.Utility;


public class Menu extends MouseAdapter implements screenImp{
	private Utility utility = Utility.getInstance();
	public void mousePressed(MouseEvent e){
		int mx=e.getX();
		int my=e.getY();
		if (utility.mouseOver(mx,my,450,300,200,64) && State.getGameState()==ID.Menu){
			Anou.setAnou("Can you survive for 4 minutes");
			Victory.setStartTime(System.currentTimeMillis());
			State.setGameState(ID.Game);
		}
	}
	
	
	public void render(Graphics g){
		
	}
}
