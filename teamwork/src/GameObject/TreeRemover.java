package GameObject;

import Plant.Plant;
import Script.Handler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TreeRemover {
	private static final int r=90;
	public static boolean onTreeRemover(int x,int y){
		if (x>10 && x<100 && y>90 && y<180) return true;
		return false;
	}
	public static void removeTree(int x, int y){
		for (int i = 0 ; i < Handler.object.size(); i++){
			x=(x-180)/r*r+180;
			y=(y-180)/r*r+180;
			GameObject temp;
			temp=Handler.object.get(i);
			if (temp instanceof Plant && x==temp.getX() && y==temp.getY()) {
				
				Handler.object.remove(i);
			}
		}
	}
	public static void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(10, 90, 90, 90);
		Font fnt=new Font("arial", 1, 20);
		g.setFont(fnt);
		g.drawString("remover", 10, 90);
	}
}
