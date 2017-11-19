package Script;
import GameObject.*;
import Plant.Plant;

import java.awt.Color;
import java.awt.Graphics;

public class PlayBoard {
	
	private static final int r=90;
	
	public PlayBoard(){
	}
	
	
	public static boolean getPlanted(int x,int y) {
		x=(x-180)/r*r+180;
		y=(y-180)/r*r+180;
		for (int i = 0;i<Handler.object.size();i++){
			GameObject temp = Handler.object.get(i);
			if ((temp instanceof Plant)
					&& (x== temp.getX())
					&& (y== temp.getY())){
				return true;
			}
		}
		return false;
	}


	public static void render(Graphics g){
		g.setColor(Color.white);
		for (int i=1;i<=6;i++){
			for (int j=-2;j<=4;j++){
				int x,y;
				x=(7-i+1)*r+2*r*j;
				y=i*r;
				if ((x>=100)&&(x<=100+9*r)&&(y>=100)&&(y<=100+7*r)){
					g.drawRect(x,y, r , r);
					g.setColor(Color.blue);
					g.fillRect(x, y, r, r);
				}
			}
		}
		g.setColor(Color.white);
		for (int i=1;i<=6;i++){
			for (int j=-2;j<=4;j++){
				int x,y;
				x=(7-i+1)*r+2*r*j-r;
				y=i*r;
				if ((x>=100)&&(x<=100+9*r)&&(y>=100)&&(y<=100+7*r)){
				g.drawRect(x,y, r , r);
				g.setColor(Color.cyan);
				g.fillRect(x, y, r, r);
				}
			}
		}
		
	}
}
