package GUI;
import GameObject.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Anou  {
	
	private static String anou="";
	private static int anouTime=0;
	
	public void tick(){
		
	}
	
	public static void setAnou(String str){
		Anou.anou=str;
		anouTime=250;
	}
	
	public static void render(Graphics g){
		Font fnt = new Font("arial",1,20);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString(anou, 500, 50);
		if (anouTime==0) anou="";
		else anouTime--;
	}
	
}
